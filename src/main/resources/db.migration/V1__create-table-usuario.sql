CREATE TABLE usuario{
    id CHAR(36) PRIMARY KEY UUID(),
    nome_completo VARCHAR(150) NOT NULL,
    email VARCHAR(250) NOT NULL UNIQUE,
    senha VARCHAR(250) NOT NULL,
    tipo INT NOT NULL,
    create_at DATETIME() NOT NULL.
    update_at DATETIME() NOT NULL
}
CREATE TABLE evento{
    id CHAR(36) PRIMARY KEY UUID()
    titulo VARCHAR(250) NOT NULL,
    descricao VARCHAR(250) NOT NULL,
    data_inicio DATETIME() NOT NULL,
    data_fim DATETIME() NOT NULL,
    evento_privado INT NOT NULL,
    local BOOLEAN VARCHAR(250) NOT NULL
    }
