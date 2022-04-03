CREATE TABLE IF NOT EXISTS homework (
    homework_id BIGSERIAL NOT NULL PRIMARY KEY ,
    name varchar(100) NOT NULL ,
    task TEXT NOT NULL ,
    deadline DATE ,
    lesson_id BIGSERIAL NOT NULL ,
    CONSTRAINT fk_lesson
        FOREIGN KEY (lesson_id)
            REFERENCES lesson(lesson_id)
);