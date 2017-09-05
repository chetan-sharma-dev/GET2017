USE library_information_system;


CREATE TABLE members(
member_id INT AUTO_INCREMENT,
member_name VARCHAR(40) NOT NULL,
addressline1 VARCHAR(40) NOT NULL,
addressline2 VARCHAR(40),
category VARCHAR(20) NOT NULL,
PRIMARY KEY(member_id)
);

CREATE TABLE subjects(
subject_id INT AUTO_INCREMENT,
subject_name VARCHAR(40) NOT NULL,
PRIMARY KEY(subject_id)
);

CREATE TABLE publishers(
publisher_id INT AUTO_INCREMENT,
publisher_name VARCHAR(40) NOT NULL,
PRIMARY KEY(publisher_id)
);

CREATE TABLE authors(
author_id INT AUTO_INCREMENT,
author_name VARCHAR(40) NOT NULL,
PRIMARY KEY(author_id)
);

CREATE TABLE titles(
title_id INT AUTO_INCREMENT,
title_name VARCHAR(40) NOT NULL,
subject_id INT ,
publisher_id INT,
PRIMARY KEY(title_id),
CONSTRAINT titles_subject_id_constraint FOREIGN KEY(subject_id) REFERENCES subjects(subject_id) ON DELETE CASCADE,
CONSTRAINT titles_publisher_id_constraint FOREIGN KEY(publisher_id) REFERENCES publishers(publisher_id) ON DELETE CASCADE 
);

CREATE TABLE books(
accession_no INT AUTO_INCREMENT,
title_id INT ,
purchase_date TIMESTAMP  DEFAULT CURRENT_TIMESTAMP,
price DOUBLE NOT NULL,
status VARCHAR(20) NOT NULL,
PRIMARY KEY(accession_no),
CONSTRAINT books_title_id_constraint FOREIGN KEY(title_id) REFERENCES titles(title_id) ON DELETE CASCADE
);

CREATE TABLE book_issue(
issue_date TIMESTAMP  ,
accession_no INT,
member_id INT ,
due_date TIMESTAMP NOT NULL,
PRIMARY KEY(issue_date,accession_no,member_id),
CONSTRAINT book_issue_accession_no_constraint FOREIGN KEY(accession_no) REFERENCES books(accession_no) ON DELETE CASCADE,
CONSTRAINT book_issue_member_id_constraint FOREIGN KEY(member_id) REFERENCES members(member_id) ON DELETE CASCADE
);

CREATE TABLE book_return(
return_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
accession_no INT ,
member_id INT,
issue_date TIMESTAMP,
PRIMARY KEY(return_date,accession_no,member_id),
CONSTRAINT book_return_member_id_constraint FOREIGN KEY(member_id) REFERENCES members(member_id) ON DELETE CASCADE,
CONSTRAINT book_return_accession_no_constraint FOREIGN KEY(accession_no) REFERENCES books(accession_no) ON DELETE CASCADE,
CONSTRAINT book_return_issue_date_constriant FOREIGN KEY(issue_date) REFERENCES book_issue(issue_date) ON DELETE CASCADE
);

CREATE TABLE title_author(
title_id INT,
author_id INT,
PRIMARY KEY(title_id,author_id),
CONSTRAINT title_author_title_id_constraint FOREIGN KEY(title_id) REFERENCES titles(title_id) ON DELETE CASCADE,
CONSTRAINT title_author_author_id_constraint FOREIGN KEY(author_id) REFERENCES authors(author_id) ON DELETE CASCADE

);
