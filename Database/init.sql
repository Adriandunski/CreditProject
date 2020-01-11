CREATE TABLE `creditproject`.`creditdb` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `credit_name` VARCHAR(45) NOT NULL,
  UNIQUE INDEX `idcreditdb_UNIQUE` (`id` ASC));
  
  CREATE TABLE `creditproject`.`customerdb` (
  `credit_id` INT NOT NULL,
  `first_name` VARCHAR(44) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  `pesel` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`credit_id`));
  
  CREATE TABLE `creditproject`.`productdb` (
  `credit_id` INT NOT NULL,
  `product_name` VARCHAR(45) NOT NULL,
  `value` INT NOT NULL,
  PRIMARY KEY (`credit_id`));
  
  INSERT INTO creditdb (id, credit_name) values (000000001, 'Kredyt1');
  INSERT INTO customerdb (credit_id, first_name, surname, pesel) values (000000001, 'Jan', 'Kowalski', '35269854124');
  INSERT INTO productdb (credit_id, product_name, value) values (000000001, 'Product1', 10000);
  
  INSERT INTO creditdb (id, credit_name) values (000000002, 'Kredyt2');
  INSERT INTO customerdb (credit_id, first_name, surname, pesel) values (000000002, 'Marek', 'Makowski', '54892158436');
  INSERT INTO productdb (credit_id, product_name, value) values (000000002, 'Product2', 25000);
  
  INSERT INTO creditdb (id, credit_name) values (000000003, 'Kredyt3');
  INSERT INTO customerdb (credit_id, first_name, surname, pesel) values (000000003, 'Mariusz', 'Bielecki', '87513528915');
  INSERT INTO productdb (credit_id, product_name, value) values (000000003, 'Product3', 150000);
  
  INSERT INTO creditdb (id, credit_name) values (000000004, 'Kredyt4');
  INSERT INTO customerdb (credit_id, first_name, surname, pesel) values (000000004, 'Patrycja', 'Fesz', '52169853215');
  INSERT INTO productdb (credit_id, product_name, value) values (000000004, 'Product4', 25000);
  
  INSERT INTO creditdb (id, credit_name) values (000000005, 'Kredyt5');
  INSERT INTO customerdb (credit_id, first_name, surname, pesel) values (000000005, 'Paulina', 'Stanko', '9785521565');
  INSERT INTO productdb (credit_id, product_name, value) values (000000005, 'Product5', 1750);
  
  