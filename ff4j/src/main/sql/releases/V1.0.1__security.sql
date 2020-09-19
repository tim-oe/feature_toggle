-- https://www.websparrow.org/spring/spring-security-jdbc-authentication-with-spring-boot
-- users table structure
CREATE TABLE `users`
(
    `username` VARCHAR(64)  NOT NULL,
    `password` VARCHAR(120) NOT NULL,
    `enabled`  TINYINT(1)   NOT NULL,
    PRIMARY KEY (`username`)
);
-- authorities table structure
CREATE TABLE `authorities`
(
    `username`  VARCHAR(64) NOT NULL,
    `authority` VARCHAR(50) NOT NULL,
    KEY `username` (`username`),
    unique(`username`,`authority`),
    CONSTRAINT `username_a_fk` FOREIGN KEY (`username`)
        REFERENCES `users` (`username`)
);