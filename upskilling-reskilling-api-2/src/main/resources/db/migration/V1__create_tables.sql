CREATE TABLE usuarios (
 id BIGINT PRIMARY KEY AUTO_INCREMENT,
 nome VARCHAR(100) NOT NULL,
 email VARCHAR(150) NOT NULL UNIQUE,
 area_atuacao VARCHAR(100),
 nivel_carreira VARCHAR(50),
 data_cadastro DATE NOT NULL
);

CREATE TABLE trilhas (
 id BIGINT PRIMARY KEY AUTO_INCREMENT,
 nome VARCHAR(150) NOT NULL,
 descricao TEXT,
 nivel VARCHAR(50) NOT NULL,
 carga_horaria INT NOT NULL,
 foco_principal VARCHAR(100)
);
