DROP TABLE IF EXISTS phones;
DROP TABLE IF EXISTS users;

CREATE TABLE users (
  id VARCHAR(250) PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  email VARCHAR(250) NOT NULL,
  password VARCHAR(250) NOT NULL,
  token VARCHAR(250) NOT NULL,
  created DATE NOT NULL,
  modified DATE DEFAULT NULL,
  last_login DATE NOT NULL,
  is_active CHAR NOT NULL
);

CREATE TABLE phones (
  id INT AUTO_INCREMENT PRIMARY KEY,
  number INT NOT NULL,
  city_code INT NOT NULL,
  country_code INT DEFAULT NULL,
  user_id VARCHAR(250) NOT NULL,
  foreign key (user_id) references users(id)
);

INSERT INTO users (id, name, email, password, token, created, modified, last_login, is_active)
    values ('01eb08e8-523b-1878-866d-33aa1cce6a27','Juan Carlos','jfuyo@gmail.com','ER23ds23+','ASfvds2453SGDAG44252gDSgsd3453',
        '2020-10-08',null,'2020-10-08','S');
INSERT INTO phones (number, city_code, country_code, user_id)
    values (1234567,1,57,'01eb08e8-523b-1878-866d-33aa1cce6a27');
INSERT INTO phones (number, city_code, country_code, user_id)
    values (7654321,2,57,'01eb08e8-523b-1878-866d-33aa1cce6a27');
