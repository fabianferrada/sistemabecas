USE sistemabecas;

CREATE TABLE Estudiante (
	Id INT NOT NULL,
	Nombres VARCHAR(255) NOT NULL,
	Apellidos VARCHAR(255) NOT NULL,
	Rut INT NOT NULL,
	Email VARCHAR(255) NOT NULL,
	Contrasena VARCHAR(255) NOT NULL,
	PRIMARY KEY (Id)
);

CREATE TABLE Postulacion (
	Id INT NOT NULL,
	Estado VARCHAR(32) NOT NULL,
	Comentario VARCHAR(255) NOT NULL,
	PRIMARY KEY (Id)
);

CREATE TABLE EstudianteRealizaPostulacion (
	Id INT NOT NULL,
	IdEstudiante INT NOT NULL,
	IdPostulacion INT NOT NULL,
	PRIMARY KEY (Id),
	FOREIGN KEY (IdEstudiante) REFERENCES Estudiante(Id),
	FOREIGN KEY (IdPostulacion) REFERENCES Postulacion(Id)
);

CREATE TABLE Apelacion (
	Id INT NOT NULL,
	Titulo VARCHAR(255) NOT NULL,
	Descripcion VARCHAR(255) NOT NULL,
	PRIMARY KEY (Id)
);

CREATE TABLE EstudianteRealizaApelacion (
	Id INT NOT NULL,
	IdEstudiante INT NOT NULL,
	IdApelacion INT NOT NULL,
	PRIMARY KEY (Id),
	FOREIGN KEY (IdEstudiante) REFERENCES Estudiante(Id),
	FOREIGN KEY (IdApelacion) REFERENCES Apelacion(Id)
);

CREATE TABLE ApelacionSobrePostulacion (
	Id INT NOT NULL,
	IdApelacion INT NOT NULL,
	IdPostulacion INT NOT NULL,
	PRIMARY KEY (Id),
	FOREIGN KEY (IdApelacion) REFERENCES Apelacion(Id),
	FOREIGN KEY (IdPostulacion) REFERENCES Postulacion(Id)
);

CREATE TABLE DocumentosDePostulacion (
	Id INT NOT NULL,
	UrlArchivo VARCHAR(2048),
	PRIMARY KEY (Id)
);

CREATE TABLE PostulacionEnviaDocumentosDePostulacion (
	Id INT NOT NULL,
	IdPostulacion INT NOT NULL,
	IdDocumento INT NOT NULL,
	PRIMARY KEY (Id),
	FOREIGN KEY (IdPostulacion) REFERENCES Postulacion(Id),
	FOREIGN KEY (IdDocumento) REFERENCES DocumentosDePostulacion(Id)
);

CREATE TABLE Administrador (
	Id INT NOT NULL,
	Nombres VARCHAR(255) NOT NULL,
	Apellidos VARCHAR(255) NOT NULL,
	Email VARCHAR(255) NOT NULL,
	Contrasena VARCHAR(255) NOT NULL,
	PRIMARY KEY (Id)
);

CREATE TABLE Beca (
	Id INT NOT NULL,
	Nombre VARCHAR(255) NOT NULL,
	Descripcion VARCHAR(2048) NOT NULL,
	FechaMinimaPostulacion DATETIME NOT NULL,
	FechaMaximaPostulacion DATETIME NOT NULL,
	PRIMARY KEY (Id)
);

CREATE TABLE AdministradorGestionaBeca (
	Id INT NOT NULL,
	IdAdministrador INT NOT NULL,
	IdBeca INT NOT NULL,
	PRIMARY KEY (Id),
	FOREIGN KEY (IdAdministrador) REFERENCES Administrador(Id),
	FOREIGN KEY (IdBeca) REFERENCES Beca(Id)
);

CREATE TABLE PostulacionAsociadaABeca (
	Id INT NOT NULL,
	IdPostulacion INT NOT NULL,
	IdBeca INT NOT NULL,
	PRIMARY KEY (Id),
	FOREIGN KEY (IdPostulacion) REFERENCES Postulacion(Id),
	FOREIGN KEY (IdBeca) REFERENCES Beca(Id)
);

CREATE TABLE Documentos (
	Id INT NOT NULL,
	Nombre VARCHAR(255),
	Descripcion VARCHAR(255),
	PRIMARY KEY (Id)
);

CREATE TABLE BecaRequiereDocumentos (
	Id INT NOT NULL,
	IdBeca INT NOT NULL,
	IdDocumento INT NOT NULL,
	PRIMARY KEY (Id),
	FOREIGN KEY (IdBeca) REFERENCES Beca(Id),
	FOREIGN KEY (IdDocumento) REFERENCES Documentos(Id)
);

CREATE TABLE DocumentosDePostulacionAsociadosABeca (
	Id INT NOT NULL,
	IdDocumentoPostulacion INT NOT NULL,
	IdBeca INT NOT NULL,
	PRIMARY KEY (Id),
	FOREIGN KEY (IdDocumentoPostulacion) REFERENCES DocumentosDePostulacion(Id),
	FOREIGN KEY (IdBeca) REFERENCES Beca(Id)
);
