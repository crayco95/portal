-- public.student definition

-- Drop table

-- DROP TABLE public.student;

CREATE TABLE public.student (
	id int8 NOT NULL DEFAULT nextval('students_id_seq'::regclass),
	"name" varchar NOT NULL,
	grade varchar NOT NULL,
	email varchar NOT NULL,
	CONSTRAINT students_pkey PRIMARY KEY (id)
);

-- Permissions

ALTER TABLE public.student OWNER TO postgres;
GRANT ALL ON TABLE public.student TO postgres;