CREATE TABLE `book-management`.`users` ( `id` INT NOT NULL AUTO_INCREMENT , `full_name` VARCHAR(255) NOT NULL , `user_name` INT(255) NOT NULL , `user_pass` VARCHAR(255) NOT NULL , `email` VARCHAR(255) NOT NULL , `phone` VARCHAR(255) NOT NULL , PRIMARY KEY (`id`)) ENGINE = InnoDB;
CREATE TABLE `book-management`.`students` ( `id` INT(11) NOT NULL AUTO_INCREMENT , `full_name` VARCHAR(255) NOT NULL , `university_id` INT(11) NOT NULL , `student_address` VARCHAR(255) NOT NULL , `admission_date` TIMESTAMP NOT NULL , `max_book_limit` INT(11) NOT NULL , `accademic_year` VARCHAR(255) NOT NULL , `no_books_issued` INT(11) NOT NULL , PRIMARY KEY (`id`)) ENGINE = InnoDB;
CREATE TABLE `book-management`.`roles` ( `id` INT(11) NOT NULL AUTO_INCREMENT , `role_name` VARCHAR(255) NOT NULL , `role_description` VARCHAR(255) NOT NULL , PRIMARY KEY (`id`)) ENGINE = InnoDB;
CREATE TABLE `book-management`.`book_transaction_history` ( `transaction_id` INT(11) NOT NULL AUTO_INCREMENT , `member_id` INT(11) NOT NULL , `book_id` INT(11) NOT NULL , `date_issue` TIMESTAMP NOT NULL , `returned_date` TIMESTAMP NULL , `due_date` TIMESTAMP NULL , `fine_collected` INT(11)  NULL , `transaction_status` VARCHAR(255)  NULL , PRIMARY KEY (`transaction_id`)) ENGINE = InnoDB;
CREATE TABLE `book-management`.`books` ( `book_id` INT(11) NOT NULL AUTO_INCREMENT , `book_author` VARCHAR(255) NOT NULL , `book_name` VARCHAR(255) NOT NULL , `book_price` VARCHAR(255) NULL , `book_isbn_number` VARCHAR(255) NULL , `status` VARCHAR(255) NULL , `edition` VARCHAR(255) NULL , `date_purchase` TIMESTAMP NULL , `number_copies` INT(11) NOT NULL , PRIMARY KEY (`book_id`)) ENGINE = InnoDB;
ALTER TABLE `users` ADD `role_id` INT(11) NOT NULL AFTER `phone`;
ALTER TABLE `users` CHANGE `user_name` `user_name` VARCHAR(255) NOT NULL;

insert into roles(id,role_name, role_description) values (1,'ADMIN', 'Admin role' );
insert into roles(id,role_name, role_description) values (2,'USER', 'User role' );
insert into users (user_name, user_pass, email, phone, full_name,role_id) values ('admin','admin', 'admin@gmail.com ', '99009090900','Admin',1);
insert into users (user_name, user_pass, email, phone, full_name,role_id) values ('purab','12345', 'purab@gmail.com ', '9988998765','purab',2);
insert into users (user_name, user_pass, email, phone, full_name,role_id) values ('john','123456', 'john@gmail.com ', '9900998778','John',2);
insert into books (book_author, book_name, book_isbn_number, book_price, edition, number_copies, date_purchase, status) values ('Cay S. Horstmann', 'Core Java Fundamentals', '98976366733', 550, '11th Edition', 7, CURDATE(), 'NEW');
insert into books (book_author, book_name, book_isbn_number, book_price, edition, number_copies, date_purchase, status) values ('Joshua Bloch', 'Effective Java', '989745454545', 550, '3rd Edition', 16, CURDATE(), 'NEW');
insert into books (book_author, book_name, book_isbn_number, book_price, edition, number_copies, date_purchase, status) values ('Lasse Koskela', 'TDD Java Developers', '989776764533', 550, '1st Edition', 9, CURDATE(), 'NEW');
insert into books (book_author, book_name, book_isbn_number, book_price, edition, number_copies, date_purchase, status) values ('Anthony Molinaro', 'Programming Algorithms', '9434334323232', 550, '5th Edition', 4, CURDATE(), 'NEW');
insert into books (book_author, book_name, book_isbn_number, book_price, edition, number_copies, date_purchase, status) values ('Chris Fehily', 'SQL Programming', '9834433343434', 550, '4th Edition', 5, CURDATE(), 'NEW');
