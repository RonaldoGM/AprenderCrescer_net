--https://jdbc.postgresql.org/download.html


--DROP TABLE USUARIO
CREATE TABLE usuario
(
  idusuario integer NOT NULL,
  idgrupo integer NOT NULL,
  login character varying(10) NOT NULL DEFAULT NULL::character varying,
  senhausuario character varying(20) NOT NULL DEFAULT NULL::character varying,
  nomeusuario character varying(40) NOT NULL DEFAULT NULL::character varying,
  dtalteracao timestamp with time zone,
  flaginativo character varying(1) NOT NULL DEFAULT NULL::character varying,
  CONSTRAINT usuario_pkey PRIMARY KEY (idusuario )
);



--drop table grupo
CREATE TABLE grupo
(
  idgrupo integer NOT NULL,
  tipousuario character varying(1) DEFAULT NULL::character varying,
  descricaogrupo character varying(40) DEFAULT NULL::character varying,
  CONSTRAINT grupo_pkey PRIMARY KEY (idgrupo )
);


INSERT INTO USUARIO (IDUSUARIO, IDGRUPO,LOGIN, SENHAUSUARIO, NOMEUSUARIO,DTALTERACAO,FLAGINATIVO) VALUES (1, 1,'ADMIN', '123', 'Administrador do Sistema', now(),'F');
INSERT INTO USUARIO (IDUSUARIO, IDGRUPO,LOGIN, SENHAUSUARIO, NOMEUSUARIO,DTALTERACAO,FLAGINATIVO) VALUES (2, 2,'OPERADOR', '1', 'Operador do Sistema', now(),'F');

INSERT INTO GRUPO (IDGRUPO,TIPOUSUARIO, DESCRICAOGRUPO) VALUES (1,'A', 'ADMINISTRADORES');
INSERT INTO GRUPO (IDGRUPO,TIPOUSUARIO, DESCRICAOGRUPO) VALUES (2,'O', 'OPERADORES');



SELECT  IDUSUARIO, IDGRUPO,LOGIN, SENHAUSUARIO, NOMEUSUARIO,DTALTERACAO,FLAGINATIVO FROM USUARIO 


--UPDATE USUARIO SET NOMEUSUARIO = 'CALUAN' WHERE IDUSUARIO = 1

CREATE TABLE conta
(
  idconta integer NOT NULL,
  descricao character varying(100) NOT NULL DEFAULT NULL::character varying,
  tipoconta character varying(20) NOT NULL DEFAULT NULL::character varying,
  valor numeric(12,2) DEFAULT 0,
  CONSTRAINT conta_pkey PRIMARY KEY (idconta )
)
