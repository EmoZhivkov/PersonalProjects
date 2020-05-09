--USERNAME: root
--PASSWORD: 123456

CREATE DATABASE IF NOT EXISTS `62215_Emil_Zhivkov` CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

USE `62215_Emil_Zhivkov`;

CREATE TABLE Users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(20)
);

INSERT INTO
    Users (
        first_name
    )
VALUES
    (
        'Emil'
    );
