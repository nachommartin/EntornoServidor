create table carnet (
num_carnet   VARCHAR2(8),
antiguedad   NUMBER(2) NOT NULL,
CONSTRAINT pk_carnet PRIMARY KEY (num_carnet)
);
create table persona (
dni          VARCHAR2(9),
nombre       VARCHAR2(20) NOT NULL,
edad         NUMBER(2),
num_carnet   VARCHAR2(8),
CONSTRAINT pk_persona PRIMARY KEY (dni),
CONSTRAINT fk_persona FOREIGN KEY (num_carnet) REFERENCES carnet(num_carnet) ON DELETE CASCADE 
);
create table biblioteca (
cod_biblio   VARCHAR2(8),
nombre       VARCHAR2(12) NOT NULL,
CONSTRAINT pk_biblio PRIMARY KEY (cod_biblio)
);
create table libro (
ISBN         VARCHAR2(11),
volumen      NUMBER(2),
autor        VARCHAR2(20) NOT NULL,
titulo       VARCHAR2(30) NOT NULL,
fecha_pres   DATE,
fecha_dev    DATE,
dni          VARCHAR2(9),
cod_biblio   VARCHAR2(8),
CONSTRAINT pk_libro PRIMARY KEY (ISBN,volumen),
CONSTRAINT fk_libro FOREIGN KEY (dni) REFERENCES persona(dni) 
CONSTRAINT fk_libro2 FOREIGN KEY (cod_biblio) REFERENCES biblioteca(cod_biblio)
);
create table comic (
ISBN         VARCHAR2(11),
volumen      NUMBER(2),
autor        VARCHAR2(20) NOT NULL,
titulo       VARCHAR2(30) NOT NULL,
editorial    VARCHAR2(20) NOT NULL,
CONSTRAINT pk_comic PRIMARY KEY (ISBN,volumen)
);
create table libro_normal (
ISBN         VARCHAR2(11),
volumen      NUMBER(2),
autor        VARCHAR2(20) NOT NULL,
titulo       VARCHAR2(30) NOT NULL,
genero       VARCHAR2(15) NOT NULL,
CONSTRAINT pk_normal PRIMARY KEY (ISBN,volumen)
);
create table audiolibro (
ISBN         VARCHAR2(11),
volumen      NUMBER(2),
autor        VARCHAR2(20) NOT NULL,
titulo       VARCHAR2(30) NOT NULL,
duracion     NUMBER(3) NOT NULL,
CONSTRAINT pk_audio PRIMARY KEY (ISBN,volumen)
);

--Hasta aquí la creación. Ahora la parte de inserción de datos, actualización y borrado--
INSERT INTO biblioteca 
VALUES ('1243', 'Prado');
INSERT INTO biblioteca 
VALUES ('1234', 'Centro');
INSERT INTO carnet 
VALUES ('0001', 4);
INSERT INTO carnet 
VALUES ('0002', 1);
INSERT INTO persona 
VALUES ('30250132A', 'Nacho Martín', 35, '0001');
INSERT INTO persona 
VALUES ('30250133H', 'Hugo Mateo', 30, '0002');
INSERT INTO persona 
VALUES ('30250134F', 'Fernando Campos', 23, '0003');
INSERT INTO libro 
VALUES '112233', 1, 'Nacho Martín', 'No disparen al balón', TO_DATE ('2021/09/24','yyyy/mm//dd'), TO_DATE ('2021/10/04','yyyy/mm//dd'), '1243', '30250132A');
INSERT INTO libro 
VALUES ('332211', 3, 'Rumiko Takahashi', 'Ranma 1/2', TO_DATE ('2021/09/22','yyyy/mm//dd'), TO_DATE ('2021/10/02','yyyy/mm//dd'), '1234', '30250132A');
INSERT INTO libro 
VALUES ('221133', 2, 'Andrew Marshall', 'Cómo dormir bien', TO_DATE ('2021/09/26','yyyy/mm//dd'), TO_DATE ('2021/10/06','yyyy/mm//dd'), '1243', '30250133H');
INSERT INTO libro_normal 
VALUES '112233', 1, 'Nacho Martín', 'No disparen al balón', 'No ficción');
INSERT INTO comic 
VALUES ('332211', 3, 'Rumiko Takahashi', 'Ranma 1/2', 'Glenat');
INSERT INTO audiolibro 
VALUES ('221133', 2, 'Andrew Marshall', 'Cómo dormir bien',23);
INSERT INTO libro 
VALUES ('445511', 2, 'Bob Kane', 'Batman', TO_DATE ('2021/09/22','yyyy/mm//dd'), TO_DATE ('2021/10/02','yyyy/mm//dd'), '1243', '30250134F');
INSERT INTO comic 
VALUES ('445511', 2, 'Bob Kane', 'Batman', TO_DATE ('2021/09/22','yyyy/mm//dd'), 'Marvel');
UPDATE comic
SET editoral = 'DC'
WHERE ISBN = '445511';
DELETE FROM libro 
WHERE ISBN LIKE '445511' AND volumen=2;
SELECT autor, titulo
FROM libro
WHERE ISBN LIKE '445511';
SELECT autor, titulo 
FROM libro
WHERE dni LIKE  (SELECT dni
     FROM persona
     WHERE nombre LIKE 'Nacho Martín');
SELECT edad , COUNT(*) AS usuarios
FROM persona
GROUP BY edad;
SELECT nombre, titulo, autor, editorial
FROM biblioteca b, libro l, comic c 
WHERE b.cod_biblio = l.cod_biblio AND l.ISBN = c.ISBN AND editorial LIKE 'Gl%' 