CREATE TABLE IF NOT EXISTS `api_rest`.`endereco_pessoa` (
    `id_pessoa` BIGINT NOT NULL,
    `id_endereco` BIGINT NOT NULL,
    PRIMARY KEY (`id_pessoa`, `id_endereco`),
    CONSTRAINT FK_EP_ID_PESSOA FOREIGN KEY (`id_pessoa`) REFERENCES `api_rest`.`pessoa` (`id`),
    CONSTRAINT FK_EP_ID_END FOREIGN KEY (`id_endereco`) REFERENCES `api_rest`.`endereco` (`id`)
);