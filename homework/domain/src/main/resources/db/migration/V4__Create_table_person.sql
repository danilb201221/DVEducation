CREATE TABLE IF NOT EXISTS person (
    person_id BIGSERIAL NOT NULL PRIMARY KEY ,
    first_name VARCHAR(25) NOT NULL ,
    last_name VARCHAR(25) NOT NULL ,
    email VARCHAR(100) NOT NULL ,
    role person_role NOT NULL
);