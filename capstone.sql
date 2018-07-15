--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.9
-- Dumped by pg_dump version 10.3

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

DROP TABLE public.order_menu_item;
DROP SEQUENCE public.order_menu_item_id_seq;
DROP TABLE public."order";
DROP SEQUENCE public.order_id_seq;
DROP TABLE public.menu_item;
DROP SEQUENCE public.menu_item_id_seq;
DROP TABLE public.menu;
DROP SEQUENCE public.menu_id_seq;
DROP TABLE public.customer;
DROP SEQUENCE public.customer_id_seq;
DROP EXTENSION plpgsql;
DROP SCHEMA public;
--
-- Name: public; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA public;


ALTER SCHEMA public OWNER TO postgres;

--
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON SCHEMA public IS 'standard public schema';


--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


--
-- Name: customer_id_seq; Type: SEQUENCE; Schema: public; Owner: capstone
--

CREATE SEQUENCE public.customer_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.customer_id_seq OWNER TO capstone;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: customer; Type: TABLE; Schema: public; Owner: capstone
--

CREATE TABLE public.customer (
    customer_id bigint DEFAULT nextval('public.customer_id_seq'::regclass),
    first_name text,
    last_name text,
    email text
);


ALTER TABLE public.customer OWNER TO capstone;

--
-- Name: menu_id_seq; Type: SEQUENCE; Schema: public; Owner: capstone
--

CREATE SEQUENCE public.menu_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.menu_id_seq OWNER TO capstone;

--
-- Name: menu; Type: TABLE; Schema: public; Owner: capstone
--

CREATE TABLE public.menu (
    menu_id bigint DEFAULT nextval('public.menu_id_seq'::regclass),
    name text
);


ALTER TABLE public.menu OWNER TO capstone;

--
-- Name: menu_item_id_seq; Type: SEQUENCE; Schema: public; Owner: capstone
--

CREATE SEQUENCE public.menu_item_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.menu_item_id_seq OWNER TO capstone;

--
-- Name: menu_item; Type: TABLE; Schema: public; Owner: capstone
--

CREATE TABLE public.menu_item (
    menu_item_id bigint DEFAULT nextval('public.menu_item_id_seq'::regclass),
    name text,
    description text,
    img text,
    quantity integer,
    price numeric,
    menu_id bigint
);


ALTER TABLE public.menu_item OWNER TO capstone;

--
-- Name: order_id_seq; Type: SEQUENCE; Schema: public; Owner: capstone
--

CREATE SEQUENCE public.order_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.order_id_seq OWNER TO capstone;

--
-- Name: order; Type: TABLE; Schema: public; Owner: capstone
--

CREATE TABLE public."order" (
    order_id bigint DEFAULT nextval('public.order_id_seq'::regclass),
    customer_id bigint,
    status text,
    company_id bigint
);


ALTER TABLE public."order" OWNER TO capstone;

--
-- Name: order_menu_item_id_seq; Type: SEQUENCE; Schema: public; Owner: capstone
--

CREATE SEQUENCE public.order_menu_item_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.order_menu_item_id_seq OWNER TO capstone;

--
-- Name: order_menu_item; Type: TABLE; Schema: public; Owner: capstone
--

CREATE TABLE public.order_menu_item (
    order_menu_item_id bigint DEFAULT nextval('public.order_menu_item_id_seq'::regclass),
    menu_item_id bigint,
    quantity text,
    price numeric,
    img text,
    description text
);


ALTER TABLE public.order_menu_item OWNER TO capstone;

--
-- Data for Name: customer; Type: TABLE DATA; Schema: public; Owner: capstone
--

COPY public.customer (customer_id, first_name, last_name, email) FROM stdin;
1	Maggie	Mutt	maggie.mutt@gmail.com
\.


--
-- Data for Name: menu; Type: TABLE DATA; Schema: public; Owner: capstone
--

COPY public.menu (menu_id, name) FROM stdin;
1	Food Truck
\.


--
-- Data for Name: menu_item; Type: TABLE DATA; Schema: public; Owner: capstone
--

COPY public.menu_item (menu_item_id, name, description, img, quantity, price, menu_id) FROM stdin;
1	Burger	A tasty fucking burger	https://i.imgur.com/eTuCPxM.jpg	15	14.99	1
2	Fried Ramen	Crunchy ramen noodz	https://i.imgur.com/eTuCPxM.jpg	50	5.99	1
3	PB & J	White bread, peanut butter and jelly	https://i.imgur.com/eTuCPxM.jpg	50	3	1
\.


--
-- Data for Name: order; Type: TABLE DATA; Schema: public; Owner: capstone
--

COPY public."order" (order_id, customer_id, status, company_id) FROM stdin;
\.


--
-- Data for Name: order_menu_item; Type: TABLE DATA; Schema: public; Owner: capstone
--

COPY public.order_menu_item (order_menu_item_id, menu_item_id, quantity, price, img, description) FROM stdin;
\.


--
-- Name: customer_id_seq; Type: SEQUENCE SET; Schema: public; Owner: capstone
--

SELECT pg_catalog.setval('public.customer_id_seq', 1, true);


--
-- Name: menu_id_seq; Type: SEQUENCE SET; Schema: public; Owner: capstone
--

SELECT pg_catalog.setval('public.menu_id_seq', 1, true);


--
-- Name: menu_item_id_seq; Type: SEQUENCE SET; Schema: public; Owner: capstone
--

SELECT pg_catalog.setval('public.menu_item_id_seq', 3, true);


--
-- Name: order_id_seq; Type: SEQUENCE SET; Schema: public; Owner: capstone
--

SELECT pg_catalog.setval('public.order_id_seq', 1, false);


--
-- Name: order_menu_item_id_seq; Type: SEQUENCE SET; Schema: public; Owner: capstone
--

SELECT pg_catalog.setval('public.order_menu_item_id_seq', 1, false);


--
-- Name: SCHEMA public; Type: ACL; Schema: -; Owner: postgres
--

GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

