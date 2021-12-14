CREATE DATABASE "SisEstoque"
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    CONNECTION LIMIT = -1;

/** =========================================== **/

CREATE SEQUENCE public.tbl_produto_seq;

CREATE TABLE IF NOT EXISTS public.tbl_produto (
  pk_pro_id INT NOT NULL DEFAULT NEXTVAL ('tbl_produto_seq'),
  pro_descricao VARCHAR(200) NOT NULL,
  pro_quantidade INT NOT NULL,
  pro_valor DOUBLE PRECISION NOT NULL,
  PRIMARY KEY (pk_pro_id));
 
ALTER TABLE public.tbl_produto OWNER to postgres;
  
/** =========================================== **/
 
CREATE SEQUENCE public.tbl_usuario_seq;

CREATE TABLE IF NOT EXISTS public.tbl_usuario (
  pk_usu_id INT NOT NULL DEFAULT NEXTVAL ('tbl_usuario_seq'),
  usu_nome VARCHAR(150) NOT NULL,
  usu_login VARCHAR(45) NOT NULL,
  usu_senha VARCHAR(45) NOT NULL,
  PRIMARY KEY (pk_usu_id));
  
ALTER TABLE public.tbl_usuario OWNER to postgres;
  
/** =========================================== **/ 
 
CREATE SEQUENCE public.tbl_estoque_seq;

CREATE TABLE IF NOT EXISTS public.tbl_estoque (
  pk_est_id INT NOT NULL DEFAULT NEXTVAL ('tbl_estoque_seq'),
  est_quantidade INT NULL,
  est_preco DOUBLE PRECISION NULL,
  fk_uso_id INT NOT NULL,
  fk_pro_id INT NOT NULL,
  est_data DATE NOT NULL,
  est_tipo_mov INT NOT NULL,
  PRIMARY KEY (pk_est_id, fk_uso_id, fk_pro_id),
  CONSTRAINT fk_tbl_estoque_tbl_usuario
    FOREIGN KEY (fk_uso_id)
    REFERENCES public.tbl_usuario (pk_usu_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_tbl_estoque_tbl_produto1
    FOREIGN KEY (fk_pro_id)
    REFERENCES public.tbl_produto (pk_pro_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE INDEX fk_tbl_estoque_tbl_usuario_idx ON tbl_estoque (fk_uso_id ASC);
CREATE INDEX fk_tbl_estoque_tbl_produto1_idx ON tbl_estoque (fk_pro_id ASC);

ALTER TABLE public.tbl_estoque OWNER to postgres;

/** =========================================== **/

CREATE OR REPLACE FUNCTION valida_estoque()
RETURNS TRIGGER AS $$
BEGIN
	IF NEW.est_tipo_mov = '1' THEN	
		UPDATE tbl_produto SET pro_quantidade = pro_quantidade - NEW.est_quantidade
		WHERE pk_pro_id = NEW.fk_pro_id;
	ELSE
		UPDATE tbl_produto SET pro_quantidade = pro_quantidade + NEW.est_quantidade
		WHERE pk_pro_id = NEW.fk_pro_id;
	END IF;
	RETURN NEW;
END;
$$ LANGUAGE plpgsql;

/** =========================================== **/

CREATE TRIGGER atualiza_estoque
AFTER INSERT OR UPDATE ON tbl_estoque
FOR EACH ROW
EXECUTE PROCEDURE valida_estoque();
