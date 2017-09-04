/*deleting all data from publishers (all dependent entries will be deleted automatically)*/
 delete from publishers;
 
 SET @publisher_id_common_string="PUB/";
/*inserting back data in publishers table*/
INSERT INTO publishers  VALUES (@publisher_id_common_string+"1","SANJIV");