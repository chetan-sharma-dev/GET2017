package com.metacube.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.metacube.dbpojos.Titles;
import com.metacube.jdbc.JdbcMysqlConnection;
import com.mysql.cj.jdbc.PreparedStatement;
/**
 * @class 
 * class doing database related functionalities 
 * */
public class MysqlDao {
	Connection connectionObject;
	PreparedStatement preparedStatementObject;
	Statement statementObject;
	
	public MysqlDao(){
		JdbcMysqlConnection jdbcConnectionObject=new JdbcMysqlConnection();
		connectionObject=jdbcConnectionObject.getConnection();
	}
	
	/**
	 * @method getBooksTitlesPublishedByGivenAuthor
	 * method returning books titles published by given authors 
	 * */
	public List<Titles> getBooksTitlesPublishedByGivenAuthor(String authorName){
		List<Titles> titlesDetailsList=new ArrayList<Titles>();
		try{
				Titles titleObject;
				String sql="SELECT DISTINCT(T.title_id),T.title_name,T.subject_id,T.publisher_id "
						+ " FROM BOOKS AS B"
						+ " JOIN titles AS T"
						+ " ON B.title_id=T.title_id"
						+ " JOIN title_author AS TA "
						+ " ON T.title_id =TA.title_id "
						+ " JOIN authors AS A "
						+ " ON TA.author_id=A.author_id  AND A.author_name=?;";
				
				/**
				 * creating preparedStatement object and using that, setting parameters
				 * running the query using prepared statement 
				 * finally adding the titleObject in list 
				 * at last returning list of titles
				 * */
				preparedStatementObject=(PreparedStatement) connectionObject.prepareStatement(sql);
				preparedStatementObject.setString(1, authorName);
				
				ResultSet resultSetObject=preparedStatementObject.executeQuery();
				while (resultSetObject.next()) {
					titleObject=new Titles(resultSetObject.getInt("title_id"), resultSetObject.getString("title_name"), resultSetObject.getInt("subject_id"), resultSetObject.getInt("publisher_id"));
					titlesDetailsList.add(titleObject);
				}
		}catch(SQLException e){
			System.out.println(e);
		}
		return titlesDetailsList;
	}

	/**
	 * @method getBookAvailabilityStatus()
	 * method to get book availability status 
	 * */
	public String getBookAvailabilityStatus(String book_title){
		try{
			String sql="SELECT if(COUNT(B.status)>0,'Available','Not Available') AS BookAvailability "
					+"FROM books AS B "
					+"JOIN titles AS T "
					+"ON B.title_id=T.title_id AND T.title_name=? "
					+"WHERE status='Available'";

			preparedStatementObject=(PreparedStatement) connectionObject.prepareStatement(sql);
			preparedStatementObject.setString(1, book_title);

			ResultSet resultSetObject=preparedStatementObject.executeQuery();
			resultSetObject.next();
			return resultSetObject.getString("BookAvailability");
		}catch(SQLException e){
			System.out.println(e);
			return "invalid Sql query entered";
		}
	}
	
	/**
	 * @method deleteDataFromBooksTableNotIssuedInLastOneYear()
	 * method to delete Data From Books Table which are Not Issued In Last One Year
	 * */
	public int deleteDataFromBooksTableNotIssuedInLastOneYear(){
		try{
				String sql="DELETE "
						+ "FROM books "
						+ "WHERE accession_no IN "
						+ "(SELECT DISTINCT(accession_no) "
						+ "FROM book_issue "
						+ "WHERE TIMESTAMPDIFF(YEAR,issue_date,CURRENT_TIMESTAMP)>1);";
				statementObject=connectionObject.createStatement();
				int resultStatus=statementObject.executeUpdate(sql);
				return resultStatus;
		}catch(SQLException e){
			System.out.println(e);
			return -1;
		}
	}
	
}
