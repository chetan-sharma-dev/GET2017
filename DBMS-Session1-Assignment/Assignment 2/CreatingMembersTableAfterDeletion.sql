USE library_information_system;

CREATE TABLE members(
member_id INT AUTO_INCREMENT,
member_name VARCHAR(40) NOT NULL,
addressline1 VARCHAR(40) NOT NULL,
addressline2 VARCHAR(40),
category VARCHAR(20) NOT NULL,
PRIMARY KEY(member_id)
);

SET SQL_SAFE_UPDATES = 0;
ALTER TABLE book_issue
ADD CONSTRAINT book_issue_member_id_constraint
FOREIGN KEY (member_id) REFERENCES members(member_id);


SET SQL_SAFE_UPDATES = 0;
ALTER TABLE book_return
ADD CONSTRAINT book_return_member_id_constraint
FOREIGN KEY (member_id) REFERENCES members(member_id);

