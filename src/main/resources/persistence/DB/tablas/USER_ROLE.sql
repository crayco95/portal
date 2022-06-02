-- public.user_role definition

-- Drop table

-- DROP TABLE public.user_role;

CREATE TABLE public.user_role (
	userid int4 NOT NULL,
	roleid int4 NOT NULL,
	CONSTRAINT user_role_pkey PRIMARY KEY (userid, roleid) INCLUDE (userid, roleid)
);

-- Permissions

ALTER TABLE public.user_role OWNER TO postgres;
GRANT ALL ON TABLE public.user_role TO postgres;


-- public.user_role foreign keys

ALTER TABLE public.user_role ADD CONSTRAINT roleid_fkey FOREIGN KEY (roleid) REFERENCES public.rol(rolid) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE public.user_role ADD CONSTRAINT userid_fkey FOREIGN KEY (userid) REFERENCES public.users(id) ON DELETE CASCADE ON UPDATE CASCADE;

-- INSERTAR DATOS

INSERT INTO public.user_role
(userid, roleid)
VALUES(1, 1),
(1,2),
(2,2),
(3,2);
