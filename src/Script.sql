CREATE ROLE prog_admin WITH LOGIN PASSWORD '123456';

CREATE DATABASE library_management WITH OWNER = prog_admin;

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
    ('L’Éducation sentimentale', 1, 300, 'ROMANCE', '1979-02-02'),
    ('Orgueil et Préjugés', 2, 250, 'COMEDY', '1923-12-01'),
    ('Autant en Emporte le Vent',3, 200, 'OTHER', '1939-06-20');


CREATE TABLE IF NOT EXISTS admin (
                                     admin_id SERIAL PRIMARY KEY,
                                     admin_name VARCHAR(255) NOT NULL,
                                     admin_email VARCHAR(255) NOT NULL,
                                     admin_phoneNumber VARCHAR(255) not null ,
                                     admin_password VARCHAR(255) NOT NULL
);

-- add three sample rows
INSERT INTO admin (admin_name, admin_email, admin_phoneNumber, admin_password) VALUES
                                      ('Clark', 'admin1@example.com', '321681981' ,'adminpassword1'),
                                      ('Miren', 'admin2@example.com', '985461981','adminpassword2'),
                                      ('Claude', 'admin3@example.com','15984586198' , 'adminpassword3');

-- create_table_subscribers.sql
CREATE TABLE IF NOT EXISTS subscribers (
                                           subscriber_id SERIAL PRIMARY KEY,
                                           subscriber_name VARCHAR(255) NOT NULL,
                                           email VARCHAR(255) UNIQUE,
                                           phone_number VARCHAR(20) UNIQUE,
                                           reference VARCHAR(255) UNIQUE
);
-- Add three sample rows
INSERT INTO subscribers (subscriber_name, email, phone_number, reference)
VALUES
    ('Ulirch Rugger', 'ulirch@rugger.com', '123456789', 'REF001'),
    ('Steeve Samson', 'steeve@samson.com', '987654321', 'REF002'),
    ('Sancoeur', 'sancoeur@eric.com', '65488968', 'REF003');


