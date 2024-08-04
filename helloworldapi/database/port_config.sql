-- Table: public.port_config

-- DROP TABLE IF EXISTS public.port_config;

CREATE TABLE IF NOT EXISTS public.port_config
(
    id integer,
    port_no integer,
    status character varying COLLATE pg_catalog."default"
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.port_config
    OWNER to postgres;