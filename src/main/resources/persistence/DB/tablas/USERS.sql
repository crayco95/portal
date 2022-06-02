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

-- INSERTAR DATOS

INSERT INTO public.users
(username, "password")
VALUES('admin', '$2a$10$XPY6QT03OqBVhOaWnsaGfulCM7JM08wFub5FTL6NAV4UUesKu8UpW'),
('cesar', '$2a$10$dp/FzqCKgg2oRAAj4xN/JOt9Z2bClVyFWutqFtMHa8UyVdMNa3qsi'),
('lucas', '$2a$10$AshuTqmCnC52MR2cZ6yZAOv2qL836P/03KLD78DqAbvCBRb3J8gQK');
