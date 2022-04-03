CREATE TABLE IF NOT EXISTS lesson (
    lesson_id BIGSERIAL NOT NULL PRIMARY KEY ,
    number INT NOT NULL ,
    name varchar(100) NOT NULL ,
    description varchar(250) ,
    date DATE not null ,
    person_id BIGSERIAL NOT NULL ,
    course_id BIGSERIAL NOT NULL ,
    CONSTRAINT fk_person
        FOREIGN KEY (person_id)
            REFERENCES person(person_id) ,
    CONSTRAINT fk_course
        FOREIGN KEY (course_id)
            REFERENCES course(course_id)
);