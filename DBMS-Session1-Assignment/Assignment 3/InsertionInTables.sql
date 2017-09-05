/*members table insertion*/
 INSERT INTO members (member_name,addressline1,category) VALUES ("Chetan Sharma","Shrimadhopur","M");
 INSERT INTO members (member_name,addressline1,category) VALUES ("MOMINA","Shrimadhopur","F");
 
 /*subjects table insertion*/
 INSERT INTO subjects (subject_name) VALUES ("SHM");
 
/*publishers table insertion*/
 INSERT INTO publishers (publisher_name) VALUES ("SANJIV");
 INSERT INTO publishers (publisher_name) VALUES ("OXFORD");
 
 /*authors table insertion*/
 INSERT INTO authors (author_name) VALUES ("Chetan Sharma");
 INSERT INTO authors (author_name) VALUES ("Udit");
 INSERT INTO authors (author_name) VALUES ("Gaurav");
 INSERT INTO authors (author_name) VALUES ("Mahesh");
 
/*titles table values insertion*/ 
 INSERT INTO titles (title_name,subject_id,publisher_id) VALUES ("PHYSICS BOOKS",1,1);
 INSERT INTO titles (title_name,subject_id,publisher_id) VALUES ("PHYSICS BOOKS",1,1);
 INSERT INTO titles (title_name,subject_id,publisher_id) VALUES ("PHYSICS BOOKS",1,1);
 INSERT INTO titles (title_name,subject_id,publisher_id) VALUES ("PHYSICS BOOKS",1,1);
 INSERT INTO titles (title_name,subject_id,publisher_id) VALUES ("PHYSICS BOOKS",1,2);

 /*Books table values insertion*/
 INSERT INTO books (title_id,price,status) VALUES (1,122.00,"AVAILABLE");
 
 /*Book_issue values insertion*/
  INSERT INTO book_issue (accession_no,member_id) VALUES (1,1);
  
 /*Books_return values insertion*/
   SET @var=(SELECT issue_date from book_issue where accession_no=1 AND member_id=1);
   INSERT INTO book_return(accession_no,member_id,issue_date) VALUES (1,1,@var);
  
 /*title_author values insertion*/
 INSERT INTO title_author VALUES (1,1);
