drop database folgasdb;

create database folgasdb;

use folgasdb;

CREATE TABLE IF NOT EXISTS funcionario(
    cod_funcionario INT(11) primary key NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NULL DEFAULT NULL,
	login VARCHAR(100) NULL DEFAULT NULL,
    perfil VARCHAR(100) NULL DEFAULT NULL,
    senha VARCHAR(100) NULL DEFAULT NULL
);


CREATE TABLE IF NOT EXISTS agenda (
   id iNT(11) primary key NOT NULL AUTO_INCREMENT,
  title VARCHAR(220) NULL DEFAULT NULL,
  color VARCHAR(10) NULL DEFAULT NULL,
  start_event DATE NULL DEFAULT NULL,
  end_event DATE NULL DEFAULT NULL,
  data_agendamento TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP(),
  Id_colaborador INT(11) NULL DEFAULT NULL,
  FOREIGN KEY (Id_colaborador) REFERENCES funcionario(cod_funcionario)
  );

