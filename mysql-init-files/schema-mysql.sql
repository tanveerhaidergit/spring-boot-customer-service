use demo;

DROP TABLE IF EXISTS CUSTOMER;

/*create table IF NOT EXISTS CUSTOMER (
	id INT NOT NULL AUTO_INCREMENT,
	first_name VARCHAR(50) ,
	last_name VARCHAR(50),
	cell_phone VARCHAR(50),
	email_id VARCHAR(50) NOT NULL,
	PRIMARY KEY (id)
) ENGINE=InnoDB;*/

create table IF NOT EXISTS CUSTOMER (
	id INT NOT NULL AUTO_INCREMENT,
	first_name VARCHAR(50) ,
	last_name VARCHAR(50),
	cell_phone VARCHAR(50),
	email_id VARCHAR(50) NOT NULL,
	PRIMARY KEY (id)
) ;



insert into CUSTOMER (id, first_name, last_name, cell_phone, email_id) values (1, 'Ailee', 'Greatex', '315-465-8391', 'agreatex0@virginia.edu');
insert into CUSTOMER (id, first_name, last_name, cell_phone, email_id) values (2, 'Maxine', 'Gounot', '954-903-5527', 'mgounot1@facebook.com');
insert into CUSTOMER (id, first_name, last_name, cell_phone, email_id) values (3, 'Hildegarde', 'MacGovern', '837-238-1497', 'hmacgovern2@mashable.com');
insert into CUSTOMER (id, first_name, last_name, cell_phone, email_id) values (4, 'Kelby', 'Dedrick', '571-538-4134', 'kdedrick3@xing.com');
insert into CUSTOMER (id, first_name, last_name, cell_phone, email_id) values (5, 'Wilhelmine', 'Cassimer', '411-195-4654', 'wcassimer4@elegantthemes.com');
insert into CUSTOMER (id, first_name, last_name, cell_phone, email_id) values (6, 'Kissiah', 'Nozzolinii', '658-490-6372', 'knozzolinii5@soup.io');
insert into CUSTOMER (id, first_name, last_name, cell_phone, email_id) values (7, 'Raleigh', 'Sanson', '904-703-1903', 'rsanson6@arstechnica.com');
insert into CUSTOMER (id, first_name, last_name, cell_phone, email_id) values (8, 'Farly', 'Akroyd', '971-885-2757', 'fakroyd7@ezinearticles.com');
insert into CUSTOMER (id, first_name, last_name, cell_phone, email_id) values (9, 'Matthew', 'Peters', '777-241-2125', 'mpeters8@diigo.com');
insert into CUSTOMER (id, first_name, last_name, cell_phone, email_id) values (10, 'Kerk', 'Giddy', '549-291-0863', 'kgiddy9@fda.gov');


commit;


