-- Registrar fuentes, eventos y registros de eventos.

USE master;
GO
IF DB_ID('BD20_Analytics') IS NOT NULL
BEGIN
    ALTER DATABASE BD20_Analytics SET SINGLE_USER WITH ROLLBACK IMMEDIATE;
    DROP DATABASE BD20_Analytics;
END
GO
CREATE DATABASE BD20_Analytics;
GO
USE BD20_Analytics;
GO

-- 1FN: todo en una tabla de logs (campos repetidos y texto libre)
CREATE TABLE Evento1FN (
    ID INT PRIMARY KEY,
    FuenteNombre NVARCHAR(200),
    EventoTipo NVARCHAR(100),
    Payload NVARCHAR(MAX),
    Fecha DATETIME
);
GO

-- 2FN: separar Fuente y Tipo de Evento
CREATE TABLE Fuente2FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(200),
    Version NVARCHAR(50)
);
GO
CREATE TABLE TipoEvento2FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(100),
    Categoria NVARCHAR(100)
);
GO
CREATE TABLE Registro2FN (
    ID INT PRIMARY KEY,
    ID_Fuente INT,
    ID_TipoEvento INT,
    Payload NVARCHAR(MAX),
    Fecha DATETIME,
    CONSTRAINT FK_Reg2_Fuente FOREIGN KEY (ID_Fuente) REFERENCES Fuente2FN(ID),
    CONSTRAINT FK_Reg2_Tipo FOREIGN KEY (ID_TipoEvento) REFERENCES TipoEvento2FN(ID)
);
GO

-- 3FN: normalizado; registros solo referencian fuentes y tipos
CREATE TABLE Fuente3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(200),
    Version NVARCHAR(50),
    Owner NVARCHAR(100)
);
GO
CREATE TABLE TipoEvento3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(100),
    Categoria NVARCHAR(100),
    Severidad INT
);
GO
CREATE TABLE Registro3FN (
    ID INT PRIMARY KEY,
    ID_Fuente INT NOT NULL,
    ID_TipoEvento INT NOT NULL,
    Payload NVARCHAR(MAX),
    Fecha DATETIME,
    CONSTRAINT FK_Reg3_Fuente FOREIGN KEY (ID_Fuente) REFERENCES Fuente3FN(ID),
    CONSTRAINT FK_Reg3_Tipo FOREIGN KEY (ID_TipoEvento) REFERENCES TipoEvento3FN(ID)
);
GO
