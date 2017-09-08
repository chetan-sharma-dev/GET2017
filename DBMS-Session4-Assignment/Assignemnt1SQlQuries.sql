USE library_information_system;

/*1*/
SELECT member_name
FROM members
WHERE category=(SELECT category FROM members WHERE member_name="Chetan");

/*2*/
SELECT BI.issue_date,T.title_name,M.member_name,BI.due_date
FROM book_issue AS BI 
JOIN members AS M 
ON M.member_id=BI.member_id
JOIN books AS B 
ON B.accession_no=BI.accession_no
JOIN titles AS T
ON T.title_id=B.title_id
WHERE (BI.member_id,BI.accession_no,BI.issue_date) 
NOT IN(SELECT BI.member_id,BI.accession_no,BI.issue_date
FROM book_return AS BR
WHERE BI.member_id=BR.member_id AND BI.accession_no=BR.accession_no AND BI.issue_date=BR.issue_date);

/*3*/
SELECT BI.issue_date,T.title_name,M.member_name,BI.due_date
FROM book_issue AS BI 
JOIN members AS M 
ON M.member_id=BI.member_id
JOIN books AS B 
ON B.accession_no=BI.accession_no
JOIN titles AS T
ON T.title_id=B.title_id
WHERE (BI.member_id,BI.accession_no,BI.issue_date) 
IN(SELECT BI.member_id,BI.accession_no,BI.issue_date
FROM book_return AS BR
WHERE BI.member_id=BR.member_id AND BI.accession_no=BR.accession_no AND BI.issue_date=BR.issue_date AND BR.return_date>BI.due_date);

/*4*/
SELECT B.accession_no,T.title_name
FROM books AS B 
JOIN titles AS T
ON T.title_id=B.title_id
WHERE B.price=(SELECT MAX(price) FROM books);

/*5*/
SELECT MAX(price) AS SecondMaximumPrice
FROM books
WHERE price < (SELECT MAX(price) FROM books);
 
