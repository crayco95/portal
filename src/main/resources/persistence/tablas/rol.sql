-- public.rol definition

-- Drop table

-- DROP TABLE public.rol;

CREATE TABLE public.rol (
	id int8 NOT NULL DEFAULT nextval('authorities_id_seq'::regclass),
	userid int4 NOT NULL,
	"name" varchar NOT NULL,
	CONSTRAINT authorities_pkey PRIMARY KEY (id)
);

-- Permissions

ALTER TABLE public.rol OWNER TO postgres;
GRANT ALL ON TABLE public.rol TO postgres;


-- public.rol foreign keys

ALTER TABLE public.rol ADD CONSTRAINT user_id_fkey FOREIGN KEY (userid) REFERENCES public.users(id) ON DELETE CASCADE ON UPDATE CASCADE;