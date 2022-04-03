CREATE TABLE IF NOT EXISTS course_student (
    course_student_id BIGSERIAL NOT NULL PRIMARY KEY ,
    course_id BIGSERIAL NOT NULL ,
    person_id BIGSERIAL NOT NULL ,
    CONSTRAINT fk_course
        FOREIGN KEY (course_id)
            REFERENCES course(course_id) ,
    CONSTRAINT fk_person
        FOREIGN KEY (person_id)
            REFERENCES person(person_id)
);