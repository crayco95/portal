-- public.rol definition

-- Drop table

-- DROP TABLE public.rol;

CREATE TABLE public.rol (
	rolid int4 NOT NULL DEFAULT nextval('rol_id_seq'::regclass),
	rolname varchar NOT NULL,
	CONSTRAINT rol_pkey PRIMARY KEY (rolid)
);

-- Permissions

ALTER TABLE public.rol OWNER TO postgres;
GRANT ALL ON TABLE public.rol TO postgres;

--INSERTAR DATOS

INSERT INTO public.rol
(rolname)
VALUES('ROLE_ADMIN'),
('ROLE_USER');
