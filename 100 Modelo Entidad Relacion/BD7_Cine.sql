
-- Registrar películas, salas y reservas de clientes.

USE master;
GO
IF DB_ID('BD7_Cine') IS NOT NULL
BEGIN
    ALTER DATABASE BD7_Cine SET SINGLE_USER WITH ROLLBACK IMMEDIATE;
    DROP DATABASE BD7_Cine;
END
GO
CREATE DATABASE BD7_Cine;
GO
USE BD7_Cine;
GO

-- 1FN: reservas con info repetida de película y cliente
CREATE TABLE Reserva1FN (
    ID INT PRIMARY KEY,
    ClienteNombre NVARCHAR(100),
    ClienteEmail NVARCHAR(100),
    PeliculaTitulo NVARCHAR(200),
    SalaNumero INT,
    Fecha DATE,
    Asientos INT
);
GO

-- 2FN: separar Cliente, Pelicula, Sala
CREATE TABLE Cliente2FN_Cine (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(100),
    Email NVARCHAR(100)
);
GO
CREATE TABLE Pelicula2FN (
    ID INT PRIMARY KEY,
    Titulo NVARCHAR(200),
    Genero NVARCHAR(50)
);
GO
CREATE TABLE Sala2FN (
    ID INT PRIMARY KEY,
    Numero INT,
    Capacidad INT
);
GO
CREATE TABLE Reserva2FN (
    ID INT PRIMARY KEY,
    ID_Cliente INT,
    ID_Pelicula INT,
    ID_Sala INT,
    Fecha DATE,
    Asientos INT,
    CONSTRAINT FK_Res2_Cliente FOREIGN KEY (ID_Cliente) REFERENCES Cliente2FN_Cine(ID),
    CONSTRAINT FK_Res2_Pelicula FOREIGN KEY (ID_Pelicula) REFERENCES Pelicula2FN(ID),
    CONSTRAINT FK_Res2_Sala FOREIGN KEY (ID_Sala) REFERENCES Sala2FN(ID)
);
GO

-- 3FN: tablas normalizadas
CREATE TABLE Cliente3FN_Cine (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(100),
    Email NVARCHAR(100)
);
GO
CREATE TABLE Pelicula3FN (
    ID INT PRIMARY KEY,
    Titulo NVARCHAR(200),
    Genero NVARCHAR(50),
    Duracion INT
);
GO
CREATE TABLE Sala3FN (
    ID INT PRIMARY KEY,
    Numero INT,
    Capacidad INT
);
GO
CREATE TABLE Reserva3FN (
    ID INT PRIMARY KEY,
    ID_Cliente INT NOT NULL,
    ID_Pelicula INT NOT NULL,
    ID_Sala INT NOT NULL,
    Fecha DATE,
    Asientos INT,
    CONSTRAINT FK_Res3_Cliente FOREIGN KEY (ID_Cliente) REFERENCES Cliente3FN_Cine(ID),
    CONSTRAINT FK_Res3_Pelicula FOREIGN KEY (ID_Pelicula) REFERENCES Pelicula3FN(ID),
    CONSTRAINT FK_Res3_Sala FOREIGN KEY (ID_Sala) REFERENCES Sala3FN(ID)
);
GO
