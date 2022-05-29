CREATE TABLE IF NOT EXISTS `agencia_virtual`.`usuario` (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `nome` VARCHAR(250) NOT NULL,
    `cpf` VARCHAR(50) UNIQUE NOT NULL,
    `senha` VARCHAR(300) NOT NULL,
    `email` VARCHAR(150) NOT NULL,
    `data_criacao` DATETIME DEFAULT NOW(),
    `tentativa_login` INT DEFAULT 0,
    PRIMARY KEY (`id`)
)