CREATE TABLE IF NOT EXISTS resource (
    resource_id BIGSERIAL NOT NULL PRIMARY KEY ,
    name varchar(100) NOT NULL ,
    type resource_type NOT NULL ,
    data TEXT NOT NULL ,
    lesson_id BIGSERIAL NOT NULL ,
    CONSTRAINT fk_lesson
        FOREIGN KEY (lesson_id)
            REFERENCES lesson(lesson_id)
);