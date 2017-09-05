USE library_information_system;

SET SQL_SAFE_UPDATES = 0;
DELETE FROM members;


SET SQL_SAFE_UPDATES = 0;
ALTER TABLE book_issue
DROP FOREIGN KEY book_issue_member_id_constraint;

SET SQL_SAFE_UPDATES = 0;
ALTER TABLE book_return
DROP FOREIGN KEY book_return_member_id_constraint;


SET SQL_SAFE_UPDATES = 0;
DROP table library_information_system.members;

/*
SET @@foreign_key_checks = 0;
DROP table library_infromation_system.members;
SET @@foreign_key_checks = 1;
*/