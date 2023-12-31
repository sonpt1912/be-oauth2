create schema `spring_jwt`;

CREATE TABLE `spring_jwt`.`user`
(
    `id`        INT NOT NULL AUTO_INCREMENT,
    `username`  VARCHAR(45) NULL,
    `full_name` VARCHAR(45) NULL,
    `password`  VARCHAR(45) NULL,
    PRIMARY KEY (`id`)
);
