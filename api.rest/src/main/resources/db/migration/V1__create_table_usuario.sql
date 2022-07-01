CREATE TABLE IF NOT EXISTS `api_rest`.`usuario` (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `cpf` VARCHAR(50) UNIQUE NOT NULL,
    `senha` VARCHAR(300) NOT NULL,
    `data_criacao` DATETIME DEFAULT NOW(),
    `tentativa_login` INT DEFAULT 0,
    PRIMARY KEY (`id`)
)