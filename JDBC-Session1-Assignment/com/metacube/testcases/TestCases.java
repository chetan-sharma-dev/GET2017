package com.metacube.testcases;

import static org.junit.Assert.*;

import java.sql.Connection;
import org.junit.Test;

import com.metacube.jdbc.JdbcMysqlConnection;

public class TestCases {
	
	Connection connetionObject;

	@Test
	public void positiveTestCaseForGetConnection() {
		JdbcMysqlConnection JMCObject=new JdbcMysqlConnection();
		connetionObject=JMCObject.getConnection();
		assertNotNull(connetionObject);
	}
	
	
}
