
CREATE TABLE public.accounts (
    number text NOT NULL,
    sum numeric NOT NULL,
    CONSTRAINT sum_not_negative CHECK ((sum >= (0)::numeric))
);


ALTER TABLE public.accounts OWNER TO postgres_user;

CREATE TABLE public.report (
    id integer NOT NULL,
    "time" timestamp(0) without time zone NOT NULL,
    file_name text NOT NULL,
    transfer text NOT NULL,
    status text NOT NULL
);


ALTER TABLE public.report OWNER TO postgres_user;

ALTER TABLE public.report ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.report_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);



ALTER TABLE ONLY public.accounts
    ADD CONSTRAINT accounts_pkey PRIMARY KEY (number);


ALTER TABLE ONLY public.report
    ADD CONSTRAINT report_pkey PRIMARY KEY (id);

