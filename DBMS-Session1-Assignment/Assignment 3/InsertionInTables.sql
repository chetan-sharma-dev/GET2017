/*members table insertion*/
 INSERT INTO members (member_id,member_name,addressline1,category) VALUES ("LIS/123","Chetan Sharma","Shrimadhopur","M");
 INSERT INTO members (member_id,member_name,addressline1,category) VALUES ("LIS/2","MOMINA","Shrimadhopur","F");
 
 /*subjects table insertion*/
 INSERT INTO subjects VALUES ("PHYSICS-1","SHM");
 
/*publishers table insertion*/
 INSERT INTO publishers  VALUES ("PUB/1","SANJIV");
 INSERT INTO publishers  VALUES ("PUB/2","OXFORD");
 
 /*authors table insertion*/
 INSERT INTO authors VALUES ("AUTH/1","Chetan Sharma");
 INSERT INTO authors VALUES ("AUTH/2","Udit");
 INSERT INTO authors VALUES ("AUTH/3","Gaurav");
 INSERT INTO authors VALUES ("AUTH/4","Mahesh");
 
/*titles table values insertion*/ 
 INSERT INTO titles VALUES ("TITLE/1","PHYSICS BOOKS","PHYSICS-1","PUB/1");
 INSERT INTO titles VALUES ("TITLE/2","PHYSICS BOOKS","PHYSICS-1","PUB/1");
 INSERT INTO titles VALUES ("TITLE/3","PHYSICS BOOKS","PHYSICS-1","PUB/1");
 INSERT INTO titles VALUES ("TITLE/4","PHYSICS BOOKS","PHYSICS-1","PUB/1");
 INSERT INTO titles VALUES ("TITLE/5","PHYSICS BOOKS","PHYSICS-1","PUB/2");

 /*Books table values insertion*/
 INSERT INTO books (accession_no,title_id,price,status) VALUES ("ASSION-NO/1","TITLE/1",122.00,"AVAILABLE");
 
 /*Book_issue values insertion*/
  INSERT INTO book_issue (accession_no,member_id) VALUES ("ASSION-NO/1","LIS/123");
  
 /*Books_return values insertion*/
   SET @var=(SELECT issue_date from book_issue where accession_no="ASSION-NO/1" AND member_id="LIS/123");
   INSERT INTO book_return(accession_no,member_id,issue_date) VALUES ("ASSION-NO/1","LIS/123",@var);
  
 /*title_author values insertion*/
 INSERT INTO title_author VALUES ("TITLE/1","AUTH/1");