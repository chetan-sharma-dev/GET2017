USE library_information_system;

/*1*/
/*creating view*/
CREATE VIEW MembersDetailsView
AS
SELECT M.member_id,M.member_name,BI.accession_no,BI.issue_date,BI.due_date
FROM book_issue AS BI
JOIN members AS M
ON BI.member_id=M.member_id;

# using view
SELECT * 
FROM MembersDetailsView
ORDER BY member_id ;

/*2*/
/*creating view*/
CREATE VIEW MemberCategoryView
AS
SELECT member_name,member_id,if(category='F','FACULTY',if(category='S','STUDENT','OTHERS')) AS category
FROM members;

# using view
SELECT * 
FROM MemberCategoryView
ORDER BY member_id ;

/*2*/
/*creating view*/
CREATE OR REPLACE VIEW AllInformation
AS
SELECT M.member_id,M.member_name,S.subject_name,T.title_id,T.title_name,M.category,BI.issue_date,BI.due_date,BR.return_date
FROM book_issue AS BI
JOIN members As M
ON BI.member_id=M.member_id
LEFT JOIN book_return AS BR
ON BI.accession_no=BR.accession_no AND BI.member_id=BR.member_id AND BI.issue_date=BR.issue_date
JOIN books AS B
ON BI.accession_no=B.accession_no
JOIN titles AS T
ON B.title_id=T.title_id
JOIN subjects AS S
ON T.subject_id=S.subject_id;

# using view
SELECT * 
FROM AllInformation
ORDER BY member_id ;

