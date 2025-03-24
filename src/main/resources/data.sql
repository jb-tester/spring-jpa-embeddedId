DROP table IF EXISTS person;
CREATE TABLE person (
    passport_number VARCHAR(255) NOT NULL,
    valid_from VARCHAR(255) NOT NULL ,
    valid_until VARCHAR(255) NOT NULL ,
    name VARCHAR(255),
    surname VARCHAR(255)
);
ALTER TABLE person ADD PRIMARY KEY (passport_number, valid_from, valid_until);
INSERT INTO person VALUES ( '111111', '01.01.2000', '01.01.2010', 'ivan', 'ivanov' );
INSERT INTO person VALUES ( '111112', '02.01.2000', '02.01.2010', 'petr', 'petrov' );
INSERT INTO person VALUES ( '333333', '01.03.2010', '01.03.2020', 'maria', 'sidorova');