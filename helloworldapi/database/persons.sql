-- Table: public.persons

-- DROP TABLE IF EXISTS public.persons;

CREATE TABLE IF NOT EXISTS public.persons
(
    id integer NOT NULL DEFAULT nextval('persons_id_seq'::regclass),
    designation character varying(50) COLLATE pg_catalog."default",
    name character varying(20) COLLATE pg_catalog."default",
    status boolean,
    created_at timestamp with time zone DEFAULT CURRENT_TIMESTAMP,
    created_by character varying COLLATE pg_catalog."default" DEFAULT CURRENT_USER,
    CONSTRAINT persons_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.persons
    OWNER to postgres;