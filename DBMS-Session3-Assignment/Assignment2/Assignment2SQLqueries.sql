USE library_information_system;
/*1*/
SELECT S.subject_name, COUNT(subject_name) AS NO_Of_Books_Purchased
FROM books AS B
JOIN titles AS T
ON B.title_id=T.title_id
JOIN subjects AS S
ON T.subject_id=S.subject_id
GROUP BY subject_name;

/*2*/
SELECT * 
FROM book_issue
WHERE TIMESTAMPDIFF(MONTH,issue_date,due_date)>=2;

SELECT * 
FROM book_issue
WHERE TIMESTAMPDIFF(MONTH,issue_date,due_date)>=2 AND due_date>CURRENT_TIMESTAMP;

/*3*/
SELECT * 
FROM books
WHERE books.price>(SELECT MIN(price) FROM books);
