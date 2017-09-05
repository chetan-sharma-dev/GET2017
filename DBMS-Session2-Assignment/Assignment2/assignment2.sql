USE library_information_system;
 
SELECT bi.issue_date,bi.accession_no,bi.member_id,br.return_date
FROM book_issue AS bi
LEFT JOIN book_return as br
ON bi.issue_date=br.issue_date AND bi.accession_no=br.accession_no AND bi.member_id=br.member_id
LEFT JOIN members AS M 
ON bi.member_id = M.member_id
ORDER BY  bi.issue_date,M.member_name;

