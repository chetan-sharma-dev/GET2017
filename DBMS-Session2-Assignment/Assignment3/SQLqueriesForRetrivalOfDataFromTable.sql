USE category_database;
/*1*/

#SELECT category_name,parent_category_name FROM category WHERE parent_category_name IS NOT NULL;
SELECT category_name,parent_category_name FROM category WHERE parent_category_name;
/*2*/
#SELECT category_name,parent_category_name FROM category WHERE parent_category_name IS NOT NULL ORDER BY parent_category_name;
SELECT category_name,parent_category_name FROM category ORDER BY parent_category_name;

/*3*/
SELECT category_name,IFNULL(parent_category_name,"Top Category") FROM category ORDER BY parent_category_name;
 /*4*/
 
SELECT category_name AS TOP_CATEGORIES FROM category WHERE parent_category_name IS NULL;
 