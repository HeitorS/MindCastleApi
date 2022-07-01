CREATE TABLE IF NOT EXISTS `api_rest`.`endereco` (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `cep` VARCHAR(10) NOT NULL,
    `logradouro` VARCHAR(350) NOT NULL,
    `bairro` VARCHAR(250) NOT NULL,
    `estado` VARCHAR(2),
    `cidade` VARCHAR(100),
    `número` INT NOT NULL,
    `complemento` VARCHAR(150),
    PRIMARY KEY (`id`)
)