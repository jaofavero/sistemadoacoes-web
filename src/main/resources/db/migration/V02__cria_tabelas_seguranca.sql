BEGIN;
CREATE TABLE public.usuario
(
    codigo bigserial NOT NULL,
    nome text,
    nome_usuario text,
    senha text,
    ativo boolean,
    PRIMARY KEY (codigo)
);

CREATE TABLE public.papel
(
    codigo bigserial NOT NULL,
    nome text,
    PRIMARY KEY (codigo)
);

CREATE TABLE public.usuario_papel
(
    codigo_usuario bigint NOT NULL,
    codigo_papel bigint NOT NULL
);

ALTER TABLE public.usuario_papel
    ADD FOREIGN KEY (codigo_usuario)
    REFERENCES public.usuario (codigo)
    NOT VALID;


ALTER TABLE public.usuario_papel
    ADD FOREIGN KEY (codigo_papel)
    REFERENCES public.papel (codigo)
    NOT VALID;
    
INSERT INTO public.usuario (codigo, nome, nome_usuario, senha, ativo) VALUES
(1, 'Admin', 'admin', '{noop}12345', true);

INSERT INTO public.papel (codigo, nome) VALUES(1, 'ROLE_ADMIN');
INSERT INTO public.papel (codigo, nome) VALUES(2, 'ROLE_USER');

INSERT INTO public.usuario_papel (codigo_usuario, codigo_papel) VALUES(1, 1);
INSERT INTO public.usuario_papel (codigo_usuario, codigo_papel) VALUES(1, 2);

END;
