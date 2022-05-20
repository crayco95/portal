-- public.users definition

-- Drop table

-- DROP TABLE public.users;

CREATE TABLE public.users (
	id bigserial NOT NULL,
	username varchar NOT NULL,
	"password" varchar(60) NOT NULL,
	CONSTRAINT username_unique UNIQUE (username),
	CONSTRAINT users_pkey PRIMARY KEY (id)
);

-- Permissions

ALTER TABLE public.users OWNER TO postgres;
GRANT ALL ON TABLE public.users TO postgres;