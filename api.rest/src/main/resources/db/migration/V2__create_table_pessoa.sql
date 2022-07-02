CREATE TABLE IF NOT EXISTS `api_rest`.`pessoa` (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `nome` VARCHAR(250) NOT NULL,
    `sobrenome` VARCHAR(250) NOT NULL,
    `email` VARCHAR(250) UNIQUE NOT NULL,
    `telefone` VARCHAR(20),
    `celular` VARCHAR(20),
    `data_nascimento` DATETIME NOT NULL,
    `sexo` VARCHAR(1) NOT NULL,
    `id_usuario` BIGINT NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT FK_PESSOA_ID_USUARIO FOREIGN KEY (`id_usuario`) REFERENCES usuario (`id`)
)