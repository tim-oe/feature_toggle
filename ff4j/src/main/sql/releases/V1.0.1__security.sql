-- https://www.websparrow.org/spring/spring-security-jdbc-authentication-with-spring-boot
-- users table structure
CREATE TABLE `users`
(
    `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
    `username` VARCHAR(64)  NOT NULL,
    `password` VARCHAR(120) NOT NULL,
    `enabled`  TINYINT(1)   NOT NULL DEFAULT TRUE,
    `created_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `last_updated` timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`),
    unique(`username`)
);

-- role table structure
CREATE TABLE `roles`
(
    `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
    `users_id` bigint(20) unsigned NOT NULL,
    `role` VARCHAR(32) NOT NULL,
    `created_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `last_updated` timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`),
    unique(`users_id`,`role`),
    CONSTRAINT `users_id_r_fk` FOREIGN KEY (`users_id`)
        REFERENCES `users` (`id`)
);