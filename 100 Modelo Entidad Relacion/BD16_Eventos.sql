-- Registrar asistentes, eventos y entradas vendidas.

USE master;
GO
IF DB_ID('BD16_Eventos') IS NOT NULL
BEGIN
    ALTER DATABASE BD16_Eventos SET SINGLE_USER WITH ROLLBACK IMMEDIATE;
    DROP DATABASE BD16_Eventos;
END
GO
CREATE DATABASE BD16_Eventos;
GO
USE BD16_Eventos;
GO

-- 1FN: entrada con datos del asistente y evento juntos
CREATE TABLE Entrada1FN (
    ID INT PRIMARY KEY,
    AsistenteNombre NVARCHAR(100),
    AsistenteEmail NVARCHAR(100),
    EventoNombre NVARCHAR(200),
    FechaEvento DATE,
    Precio DECIMAL(10,2)
);
GO

-- 2FN: separar Asistente y Evento
CREATE TABLE Asistente2FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(100),
    Email NVARCHAR(100)
);
GO
CREATE TABLE Evento2FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(200),
    Fecha DATE,
    Lugar NVARCHAR(200)
);
GO
CREATE TABLE Entrada2FN (
    ID INT PRIMARY KEY,
    ID_Asistente INT,
    ID_Evento INT,
    Precio DECIMAL(10,2),
    CONSTRAINT FK_Ent2_Asistente FOREIGN KEY (ID_Asistente) REFERENCES Asistente2FN(ID),
    CONSTRAINT FK_Ent2_Evento FOREIGN KEY (ID_Evento) REFERENCES Evento2FN(ID)
);
GO

-- 3FN: normalizado
CREATE TABLE Asistente3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(100),
    Email NVARCHAR(100),
    Telefono NVARCHAR(20)
);
GO
CREATE TABLE Evento3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(200),
    Fecha DATE,
    Lugar NVARCHAR(200),
    Capacidad INT
);
GO
CREATE TABLE Entrada3FN (
    ID INT PRIMARY KEY,
    ID_Asistente INT NOT NULL,
    ID_Evento INT NOT NULL,
    Precio DECIMAL(10,2),
    FechaCompra DATE,
    CONSTRAINT FK_Ent3_Asistente FOREIGN KEY (ID_Asistente) REFERENCES Asistente3FN(ID),
    CONSTRAINT FK_Ent3_Evento FOREIGN KEY (ID_Evento) REFERENCES Evento3FN(ID)
);
GO
