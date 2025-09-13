-- Registrar usuarios, planes y suscripciones.

USE master;
GO
IF DB_ID('BD19_Suscripciones') IS NOT NULL
BEGIN
    ALTER DATABASE BD19_Suscripciones SET SINGLE_USER WITH ROLLBACK IMMEDIATE;
    DROP DATABASE BD19_Suscripciones;
END
GO
CREATE DATABASE BD19_Suscripciones;
GO
USE BD19_Suscripciones;
GO

-- 1FN: suscripción con datos repetidos
CREATE TABLE Suscripcion1FN (
    ID INT PRIMARY KEY,
    UsuarioNombre NVARCHAR(100),
    UsuarioEmail NVARCHAR(100),
    PlanNombre NVARCHAR(100),
    FechaInicio DATE,
    FechaFin DATE
);
GO

-- 2FN: separar Usuario y Plan
CREATE TABLE Usuario2FN_Sub (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(100),
    Email NVARCHAR(100)
);
GO
CREATE TABLE Plan2FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(100),
    Precio DECIMAL(10,2)
);
GO
CREATE TABLE Suscripcion2FN (
    ID INT PRIMARY KEY,
    ID_Usuario INT,
    ID_Plan INT,
    FechaInicio DATE,
    FechaFin DATE,
    CONSTRAINT FK_Sus2_Usuario FOREIGN KEY (ID_Usuario) REFERENCES Usuario2FN_Sub(ID),
    CONSTRAINT FK_Sus2_Plan FOREIGN KEY (ID_Plan) REFERENCES Plan2FN(ID)
);
GO

-- 3FN: normalizado
CREATE TABLE Usuario3FN_Sub (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(100),
    Email NVARCHAR(100),
    FechaRegistro DATE
);
GO
CREATE TABLE Plan3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(100),
    Precio DECIMAL(10,2),
    DuracionMeses INT
);
GO
CREATE TABLE Suscripcion3FN (
    ID INT PRIMARY KEY,
    ID_Usuario INT NOT NULL,
    ID_Plan INT NOT NULL,
    FechaInicio DATE,
    FechaFin DATE,
    Estado NVARCHAR(50),
    CONSTRAINT FK_Sus3_Usuario FOREIGN KEY (ID_Usuario) REFERENCES Usuario3FN_Sub(ID),
    CONSTRAINT FK_Sus3_Plan FOREIGN KEY (ID_Plan) REFERENCES Plan3FN(ID)
);
GO
