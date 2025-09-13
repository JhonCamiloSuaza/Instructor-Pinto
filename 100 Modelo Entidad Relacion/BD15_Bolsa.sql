-- Registrar postulantes, empresas y postulaciones a ofertas.

USE master;
GO
IF DB_ID('BD15_Bolsa') IS NOT NULL
BEGIN
    ALTER DATABASE BD15_Bolsa SET SINGLE_USER WITH ROLLBACK IMMEDIATE;
    DROP DATABASE BD15_Bolsa;
END
GO
CREATE DATABASE BD15_Bolsa;
GO
USE BD15_Bolsa;
GO

-- 1FN: postulación con datos repetidos
CREATE TABLE Postulacion1FN (
    ID INT PRIMARY KEY,
    PostulanteNombre NVARCHAR(100),
    EmpresaNombre NVARCHAR(100),
    OfertaTitulo NVARCHAR(200),
    Fecha DATE,
    Estado NVARCHAR(50)
);
GO

-- 2FN: separar Postulante, Empresa, Oferta
CREATE TABLE Postulante2FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(100),
    Email NVARCHAR(100)
);
GO
CREATE TABLE Empresa2FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(100),
    Industria NVARCHAR(100)
);
GO
CREATE TABLE Oferta2FN (
    ID INT PRIMARY KEY,
    ID_Empresa INT,
    Titulo NVARCHAR(200),
    Salario DECIMAL(12,2),
    CONSTRAINT FK_Oferta2_Empresa FOREIGN KEY (ID_Empresa) REFERENCES Empresa2FN(ID)
);
GO
CREATE TABLE Postulacion2FN (
    ID INT PRIMARY KEY,
    ID_Postulante INT,
    ID_Oferta INT,
    Fecha DATE,
    Estado NVARCHAR(50),
    CONSTRAINT FK_Post2_Postulante FOREIGN KEY (ID_Postulante) REFERENCES Postulante2FN(ID),
    CONSTRAINT FK_Post2_Oferta FOREIGN KEY (ID_Oferta) REFERENCES Oferta2FN(ID)
);
GO

-- 3FN: normalizado
CREATE TABLE Postulante3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(100),
    Email NVARCHAR(100),
    Telefono NVARCHAR(20)
);
GO
CREATE TABLE Empresa3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(100),
    Industria NVARCHAR(100),
    Direccion NVARCHAR(200)
);
GO
CREATE TABLE Oferta3FN (
    ID INT PRIMARY KEY,
    ID_Empresa INT NOT NULL,
    Titulo NVARCHAR(200),
    Salario DECIMAL(12,2),
    FechaPublicacion DATE,
    CONSTRAINT FK_Oferta3_Empresa FOREIGN KEY (ID_Empresa) REFERENCES Empresa3FN(ID)
);
GO
CREATE TABLE Postulacion3FN (
    ID INT PRIMARY KEY,
    ID_Postulante INT NOT NULL,
    ID_Oferta INT NOT NULL,
    Fecha DATE,
    Estado NVARCHAR(50),
    CONSTRAINT FK_Post3_Postulante FOREIGN KEY (ID_Postulante) REFERENCES Postulante3FN(ID),
    CONSTRAINT FK_Post3_Oferta FOREIGN KEY (ID_Oferta) REFERENCES Oferta3FN(ID)
);
GO
