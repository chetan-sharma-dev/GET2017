USE library_information_system;
/*1*/
SELECT 
 (SELECT COUNT(member_id) 
 FROM members
 WHERE category="F") AS FACULTY,
( SELECT COUNT(member_id)
 FROM members
 WHERE category="S"
)  AS STUDENT,
 (SELECT COUNT(member_id) 
 FROM members
 WHERE category!="F" AND category!="S") AS OTHERS;

 /*2*/
 SELECT T.title_name
FROM book_issue AS BI
JOIN books AS B
ON BI.accession_no=B.accession_no
JOIN titles T
ON B.title_id=T.title_id
GROUP BY BI.accession_no 
HAVING COUNT(BI.accession_no)>2;
 
 /*3*/
 SELECT M.member_id,M.member_name,M.category,BI.accession_no
 FROM book_issue AS BI
 JOIN members AS M
 ON BI.member_id=M.member_id
 WHERE M.category!="F";
 
 /*4*/
 SELECT A.author_name 
 FROM books AS B
 JOIN titles As T
 ON B.title_id=T.title_id
 JOIN title_author AS TA
 ON T.title_id=TA.title_id
 JOIN authors AS A
 ON TA.author_id=A.author_id
 GROUP BY TA.author_id
 HAVING COUNT(TA.author_id)>=1;

 