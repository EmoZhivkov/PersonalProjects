/*
    USERNAME: root
    PASSWORD: 123456
*/

DROP DATABASE `62215_Emil_Zhivkov`;

CREATE DATABASE IF NOT EXISTS `62215_Emil_Zhivkov` CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

USE `62215_Emil_Zhivkov`;

CREATE TABLE Users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(20),
    second_name VARCHAR(20),
    course_year INT,
    course_name VARCHAR(60),
    fn INT,
    group_number INT,
    birth_date DATE,
    zodiac_sign VARCHAR(20),
    link VARCHAR(255),
    picture VARCHAR(20),
    motivation VARCHAR(255)
);

INSERT INTO
    Users (
        first_name,
        second_name,
        course_year,
        course_name,
        fn,
        group_number,
        birth_date,
        zodiac_sign,
        link,
        picture,
        motivation
    )
VALUES
    (
        'Emil',
        'Zhivkov',
        2018,
        'Software Engineering',
        62215,
        3,
        '1998-07-31',
        'leo',
        'www.facebook.com',
        'img/emo.png',
        'aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa'
    );
