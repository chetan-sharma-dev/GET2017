USE library_information_system;

ALTER TABLE book_issue
MODIFY COLUMN issue_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ;


DELIMITER $$

CREATE TRIGGER dt_15days

BEFORE INSERT ON `book_issue` FOR EACH ROW

BEGIN

   SET NEW.due_date = now() + INTERVAL 15 DAY;

END;

$$

DELIMITER ;




