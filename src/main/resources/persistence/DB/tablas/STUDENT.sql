-- public.student definition

-- Drop table

-- DROP TABLE public.student;

CREATE TABLE public.student (
	studentid int8 NOT NULL DEFAULT nextval('students_id_seq'::regclass),
	studentname varchar NOT NULL,
	studentgrade varchar NOT NULL,
	studentemail varchar NOT NULL,
	CONSTRAINT students_pkey PRIMARY KEY (studentid)
);

-- Permissions

ALTER TABLE public.student OWNER TO postgres;
GRANT ALL ON TABLE public.student TO postgres;

-- INSERTAR DATOS

INSERT INTO public.student
(studentname, studentgrade, studentemail)
VALUES('Karla','10','karla@mail.com'),
('Pedro','11','pedro@mail.com'),
('Maria','11','maria@mail.com'),
('Susana','7','susana@mail.com'),
('Julio','9','julio@mail.com'),
('Ricardo','8','ricardo@mail.com'),
('Zimba','8','zimba@mail.com'),
('Pepe','6','pepe@mail.com'),
('Luna','6','luna@mail.com'),
('Lala','6','lala@mail.com'),
('Paco','6','paco@mail.com'),
('Ñoño','6','ñoño@mail.com'),
('Juan','6','juan@mail.com');
