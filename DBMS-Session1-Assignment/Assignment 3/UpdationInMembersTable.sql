

/*update address line 2 as Jaipur in members table*/
SET SQL_SAFE_UPDATES = 0;
 UPDATE members SET addressline2="Jaipur";

/*updating address line 1 in members table where category is F*/
SET SQL_SAFE_UPDATES = 0;
UPDATE members SET addressline1="EPIP,Sitapura" WHERE category="F";