--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.1
-- Dumped by pg_dump version 9.5.1

-- Started on 2021-02-27 16:45:42

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

DROP DATABASE bcaitworks;
--
-- TOC entry 2134 (class 1262 OID 59798)
-- Name: bcaitworks; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE bcaitworks WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'English_United States.1252' LC_CTYPE = 'English_United States.1252';


ALTER DATABASE bcaitworks OWNER TO postgres;

\connect bcaitworks

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 7 (class 2615 OID 2200)
-- Name: public; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA public;


ALTER SCHEMA public OWNER TO postgres;

--
-- TOC entry 2135 (class 0 OID 0)
-- Dependencies: 7
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON SCHEMA public IS 'standard public schema';


--
-- TOC entry 1 (class 3079 OID 12355)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2137 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


--
-- TOC entry 2 (class 3079 OID 59827)
-- Name: uuid-ossp; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS "uuid-ossp" WITH SCHEMA public;


--
-- TOC entry 2138 (class 0 OID 0)
-- Dependencies: 2
-- Name: EXTENSION "uuid-ossp"; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION "uuid-ossp" IS 'generate universally unique identifiers (UUIDs)';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 182 (class 1259 OID 59799)
-- Name: book; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE book (
    id uuid NOT NULL,
    title character varying NOT NULL,
    created_by character varying NOT NULL,
    created_date timestamp without time zone DEFAULT now() NOT NULL,
    modified_by character varying,
    modified_date timestamp without time zone,
    is_deleted boolean DEFAULT false NOT NULL
);


ALTER TABLE book OWNER TO postgres;

--
-- TOC entry 184 (class 1259 OID 59819)
-- Name: login; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE login (
    sessionid character varying NOT NULL,
    user_id character varying NOT NULL,
    created_date timestamp without time zone DEFAULT now() NOT NULL,
    is_valid boolean DEFAULT false NOT NULL,
    updated_date timestamp without time zone
);


ALTER TABLE login OWNER TO postgres;

--
-- TOC entry 183 (class 1259 OID 59807)
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE users (
    id uuid NOT NULL,
    username character varying NOT NULL,
    name character varying NOT NULL,
    hash_password character varying NOT NULL
);


ALTER TABLE users OWNER TO postgres;



--
-- TOC entry 2006 (class 2606 OID 59818)
-- Name: book_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY book
    ADD CONSTRAINT book_pk PRIMARY KEY (id);


--
-- TOC entry 2012 (class 2606 OID 59845)
-- Name: login_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY login
    ADD CONSTRAINT login_pk PRIMARY KEY (sessionid);


--
-- TOC entry 2008 (class 2606 OID 59814)
-- Name: user_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY users
    ADD CONSTRAINT user_pk PRIMARY KEY (id);


--
-- TOC entry 2010 (class 2606 OID 59816)
-- Name: user_un; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY users
    ADD CONSTRAINT user_un UNIQUE (username);


--
-- TOC entry 2127 (class 0 OID 59799)
-- Dependencies: 182
-- Data for Name: book; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO book (id, title, created_by, created_date, modified_by, modified_date, is_deleted) VALUES ('6d2276e9-4d10-4013-9444-2482a967e356', 'test1', '1f4db1a8-ab11-4172-8b0e-7da0b239d7a6', '2021-02-25 14:12:04.610783', NULL, NULL, false);
INSERT INTO book (id, title, created_by, created_date, modified_by, modified_date, is_deleted) VALUES ('899d5ba3-12ae-4d73-ab60-d5bfdc19e591', 'test2', '1f4db1a8-ab11-4172-8b0e-7da0b239d7a6', '2021-02-25 14:12:07.581978', NULL, NULL, false);
INSERT INTO book (id, title, created_by, created_date, modified_by, modified_date, is_deleted) VALUES ('49c4974f-2d67-408c-947a-b14ab3b6520a', 'test3', '1f4db1a8-ab11-4172-8b0e-7da0b239d7a6', '2021-02-25 15:41:08.228', NULL, NULL, false);


--
-- TOC entry 2129 (class 0 OID 59819)
-- Dependencies: 184
-- Data for Name: login; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO login (sessionid, user_id, created_date, is_valid, updated_date) VALUES ('c2cd811b33a84c1ba418d202d76f3425', '1f4db1a8-ab11-4172-8b0e-7da0b239d7a6', '2021-02-25 17:35:00.071', false, '2021-02-26 13:48:16.374357');
INSERT INTO login (sessionid, user_id, created_date, is_valid, updated_date) VALUES ('60a4c9c5c82f407f944d4c04fbe39889', '1f4db1a8-ab11-4172-8b0e-7da0b239d7a6', '2021-02-25 17:38:15.945', false, '2021-02-26 13:48:16.374357');
INSERT INTO login (sessionid, user_id, created_date, is_valid, updated_date) VALUES ('e51ba4ea03a14ec488d82ab62b838444', '1f4db1a8-ab11-4172-8b0e-7da0b239d7a6', '2021-02-25 17:40:20.268', false, '2021-02-26 13:48:16.374357');
INSERT INTO login (sessionid, user_id, created_date, is_valid, updated_date) VALUES ('ee51e183c37d496d9032d6d204f67ef3', '1f4db1a8-ab11-4172-8b0e-7da0b239d7a6', '2021-02-26 13:46:42.129', false, '2021-02-26 13:48:16.374357');


--
-- TOC entry 2128 (class 0 OID 59807)
-- Dependencies: 183
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO users (id, username, name, hash_password) VALUES ('1f4db1a8-ab11-4172-8b0e-7da0b239d7a6', 'cwa', 'chandra', '9AA6E5F2256C17D2D430B100032B997C');


--
-- TOC entry 2136 (class 0 OID 0)
-- Dependencies: 7
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2021-02-27 16:45:42

--
-- PostgreSQL database dump complete
--

