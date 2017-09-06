USE library_information_system;

/* showing all columns from members tables*/
 SELECT * 
 FROM members;
 
 /*2*/
 SELECT member_id,member_name,category 
 FROM members;
 
 /*3*/
 SELECT member_name,member_id,category 
 FROM members 
 WHERE category="F";
 
 /*4*/
 SELECT DISTINCT(category) 
 FROM members;
 
 /*5*/
SELECT member_name,category 
FROM members 
ORDER BY member_name DESC;

/*6*/
SELECT DISTINCT title_name,subject_name,publisher_name 
FROM titles AS t ,publishers AS p ,subjects AS s 
WHERE t.subject_id=s.subject_id AND t.publisher_id=p.publisher_id;

/*7*/
SELECT category , COUNT(member_id) as Number_OF_members 
FROM members 
GROUP BY category;

/*8*/
SELECT m1.member_name 
FROM members AS m1 
INNER JOIN members m2
ON m1.category=m2.category
WHERE m2.member_name="Chetan Sharma";

/*9*/
SELECT bi.issue_date,bi.accession_no,bi.member_id,br.return_date
FROM book_issue AS bi
LEFT JOIN book_return as br
ON bi.issue_date=br.issue_date AND bi.accession_no=br.accession_no AND bi.member_id=br.member_id;