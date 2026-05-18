USE sistemabecas;

CREATE TABLE administrador (
	id INTEGER NOT NULL,
	apellidos VARCHAR(255),
	contrasena VARCHAR(255),
	email VARCHAR(255),
	nombres VARCHAR(255),
	PRIMARY KEY (id)
);

CREATE TABLE administrador_seq (
	next_val BIGINT
);

INSERT INTO administrador_seq ( next_val ) VALUES ( 1 );

CREATE TABLE apelacion (
	id INTEGER NOT NULL,
	descripcion VARCHAR(255),
	titulo VARCHAR(255),
	id_estudiante INTEGER,
	id_postulacion INTEGER,
	PRIMARY KEY (id)
);

CREATE TABLE apelacion_seq (
	next_val BIGINT
);

INSERT INTO apelacion_seq ( next_val ) VALUES ( 1 );

CREATE TABLE beca (
	id INTEGER NOT NULL,
	descripcion VARCHAR(255),
	fechamaximapostulacion DATETIME(6),
	fechaminimapostulacion DATETIME(6),
	nombre VARCHAR(255),
	PRIMARY KEY (id)
);

CREATE TABLE beca_seq (
	next_val BIGINT
);

INSERT INTO beca_seq ( next_val ) VALUES ( 1 );

CREATE TABLE documento_de_postulacion_seq (
	next_val BIGINT
);

INSERT INTO documento_de_postulacion_seq ( next_val ) VALUES ( 1 );

CREATE TABLE documento_de_postulacion (
	id INTEGER NOT NULL,
	url VARCHAR(255),
	id_documento INTEGER,
	id_postulacion INTEGER,
	PRIMARY KEY (id)
);

CREATE TABLE documentos (
	id INTEGER NOT NULL,
	descripcion VARCHAR(255),
	nombre VARCHAR(255),
	id_beca INTEGER,
	PRIMARY KEY (id)
);

CREATE TABLE documentos_seq (
	next_val BIGINT
);

INSERT INTO documentos_seq ( next_val ) VALUES ( 1 );

CREATE TABLE estudiante (
	id INTEGER NOT NULL,
	apellidos VARCHAR(255),
	contrasena VARCHAR(255),
	email VARCHAR(255),
	nombres VARCHAR(255),
	rut INTEGER NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE estudiante_seq (
	next_val BIGINT
);

INSERT INTO estudiante_seq ( next_val ) VALUES ( 1 );

CREATE TABLE postulacion (
	id INTEGER NOT NULL,
	comentario VARCHAR(255),
	estado VARCHAR(255),
	id_beca INTEGER,
	id_estudiante INTEGER,
	PRIMARY KEY (id)
);

CREATE TABLE postulacion_seq (
	next_val BIGINT
);

INSERT INTO postulacion_seq ( next_val ) VALUES ( 1 );

ALTER TABLE apelacion ADD CONSTRAINT UKk84ody1twdn73whyqoo2ns8qk UNIQUE (id_postulacion);

ALTER TABLE documento_de_postulacion ADD CONSTRAINT UKfg78jw3gbea8p9rdyxd7csh9j UNIQUE (id_documento);

ALTER TABLE postulacion ADD CONSTRAINT UK1ok7beuussj7o2kl6hs93j7lm UNIQUE (id_beca);

ALTER TABLE apelacion ADD CONSTRAINT FKro1fp2rjs79dkfa8fh1vq2jbl FOREIGN KEY (id_estudiante) REFERENCES estudiante (id);

ALTER TABLE apelacion ADD CONSTRAINT FKcfioeex6tinet0b852vc7w3ok FOREIGN KEY (id_postulacion) REFERENCES postulacion (id);

ALTER TABLE documento_de_postulacion ADD CONSTRAINT FK2juouk0265id8mrjuv2hjy4wd FOREIGN KEY (id_documento) REFERENCES documentos (id);

ALTER TABLE documento_de_postulacion ADD CONSTRAINT FKh2kqekfbq8yqm69clflmiqpv8 FOREIGN KEY (id_postulacion) REFERENCES postulacion (id);

ALTER TABLE documentos ADD CONSTRAINT FKmcl5gguwxcob01kgrt0er8dhg FOREIGN KEY (id_beca) REFERENCES beca (id);

ALTER TABLE postulacion ADD CONSTRAINT FK6cij4g58bbjkf90dtdtbffkg8 FOREIGN KEY (id_beca) REFERENCES beca (id);

ALTER TABLE postulacion ADD CONSTRAINT FKs9gsh6te2nfe1vaaxmkil4jhh FOREIGN KEY (id_estudiante) REFERENCES estudiante (id);
