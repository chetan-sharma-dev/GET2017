USE library_information_system;


CREATE TABLE members(
member_id VARCHAR(20),
member_name VARCHAR(40) NOT NULL,
addressline1 VARCHAR(40) NOT NULL,
addressline2 VARCHAR(40),
category VARCHAR(20) NOT NULL,
PRIMARY KEY(member_id)
);

CREATE TABLE subjects(
subject_id VARCHAR(20),
subject_name VARCHAR(40) NOT NULL,
PRIMARY KEY(subject_id)
);

CREATE TABLE publishers(
publisher_id VARCHAR(20),
publisher_name VARCHAR(40) NOT NULL,
PRIMARY KEY(publisher_id)
);

CREATE TABLE authors(
author_id VARCHAR(20),
author_name VARCHAR(40) NOT NULL,
PRIMARY KEY(author_id)
);

CREATE TABLE titles(
title_id VARCHAR(20),
title_name VARCHAR(40) NOT NULL,
subject_id VARCHAR(20) ,
publisher_id VARCHAR(20) ,
PRIMARY KEY(title_id),
CONSTRAINT titles_subject_id_constraint FOREIGN KEY(subject_id) REFERENCES subjects(subject_id) ON DELETE CASCADE ON UPDATE CASCADE,
CONSTRAINT titles_publisher_id_constraint FOREIGN KEY(publisher_id) REFERENCES publishers(publisher_id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE books(
accession_no VARCHAR(20),
title_id VARCHAR(20) ,
purchase_date TIMESTAMP  DEFAULT CURRENT_TIMESTAMP,
price DOUBLE NOT NULL,
status VARCHAR(20) NOT NULL,
PRIMARY KEY(accession_no),
CONSTRAINT books_title_id_constraint FOREIGN KEY(title_id) REFERENCES titles(title_id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE book_issue(
issue_date TIMESTAMP  ,
accession_no VARCHAR(20),
member_id VARCHAR(20) ,
due_date TIMESTAMP NOT NULL,
PRIMARY KEY(issue_date,accession_no,member_id),
CONSTRAINT book_issue_accession_no_constraint FOREIGN KEY(accession_no) REFERENCES books(accession_no) ON DELETE CASCADE ON UPDATE CASCADE,
CONSTRAINT book_issue_member_id_constraint FOREIGN KEY(member_id) REFERENCES members(member_id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE book_return(
return_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
accession_no VARCHAR(20) ,
member_id VARCHAR(20),
issue_date TIMESTAMP,
PRIMARY KEY(return_date,accession_no,member_id),
CONSTRAINT book_return_member_id_constraint FOREIGN KEY(member_id) REFERENCES members(member_id) ON DELETE CASCADE ON UPDATE CASCADE,
CONSTRAINT book_return_accession_no_constraint FOREIGN KEY(accession_no) REFERENCES books(accession_no) ON DELETE CASCADE ON UPDATE CASCADE,
CONSTRAINT book_return_issue_date_constriant FOREIGN KEY(issue_date) REFERENCES book_issue(issue_date) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE title_author(
title_id VARCHAR(20),
author_id VARCHAR(20),
PRIMARY KEY(title_id,author_id),
CONSTRAINT title_author_title_id_constraint FOREIGN KEY(title_id) REFERENCES titles(title_id) ON DELETE CASCADE ON UPDATE CASCADE,
CONSTRAINT title_author_author_id_constraint FOREIGN KEY(author_id) REFERENCES authors(author_id) ON DELETE CASCADE ON UPDATE CASCADE

);
