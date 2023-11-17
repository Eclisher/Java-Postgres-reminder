\c library_management;

-- create_table_author.sql
CREATE TABLE IF NOT EXISTS author (
                                      author_id SERIAL PRIMARY KEY,
                                      author_name VARCHAR(255) NOT NULL,
                                      sex CHAR(1) CHECK (sex IN ('M', 'F'))
);

-- Add three sample rows
INSERT INTO author (author_name, sex)
VALUES
    ('Gustave Flaubert', 'M'),
    ('Jane Austen', 'F'),
    ('Margaret Mitchell', 'F');

-- create_enum_topic.sql
CREATE TYPE Topic AS ENUM ('COMEDY', 'ROMANCE', 'OTHER');

-- create_table_book.sql
CREATE TABLE IF NOT EXISTS book (
                                    book_id SERIAL PRIMARY KEY,
                                    book_name VARCHAR(255) NOT NULL,
                                    author_id INT REFERENCES author(author_id)  ,
                                    page_numbers INT,
                                    topic Topic,
                                    release_date DATE
);
-- Add three sample rows
INSERT INTO book (book_name, author_id, page_numbers, topic, release_date)
VALUES
    ('L’Éducation sentimentale', 4, 300, 'ROMANCE', '1979-02-02'),
    ('Orgueil et Préjugés', 5, 250, 'COMEDY', '1923-12-01'),
    ('Autant en Emporte le Vent',6, 200, 'OTHER', '1939-06-20');


-- create_table_subscribers.sql
CREATE TABLE IF NOT EXISTS subscribers (
                                           subscriber_id SERIAL PRIMARY KEY,
                                           subscriber_name VARCHAR(255) NOT NULL,
                                           reference VARCHAR(255) UNIQUE
);

-- Add three sample rows
INSERT INTO subscribers (subscriber_name, reference)
VALUES
    ('Ulirch Rugger', 'REF001'),
    ('Steeve Samson', 'REF002'),
    ('Sancoeur', 'REF003');

