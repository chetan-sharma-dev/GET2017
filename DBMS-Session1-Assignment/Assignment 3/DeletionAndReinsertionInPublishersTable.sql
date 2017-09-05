/*deleting all data from publishers (all dependent entries will be deleted automatically)*/
 delete from publishers;
 
 SET @publisher_name="SANJIV";
/*inserting back data in publishers table*/
INSERT INTO publishers  VALUES (@publisher_name);