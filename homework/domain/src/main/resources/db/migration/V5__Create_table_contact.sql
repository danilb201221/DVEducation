CREATE TABLE IF NOT EXISTS contact (
    contact_id BIGSERIAL NOT NULL PRIMARY KEY ,
    contact VARCHAR(200) NOT NULL ,
    person_id BIGSERIAL NOT NULL ,
    CONSTRAINT fk_person
        FOREIGN KEY (person_id)
            REFERENCES person(person_id)
);