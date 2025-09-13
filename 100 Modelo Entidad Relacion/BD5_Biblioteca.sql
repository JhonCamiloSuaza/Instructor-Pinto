-- ENUNCIADO 5: Biblioteca
-- Registrar usuarios, libros y préstamos.

USE master;
GO
IF DB_ID('BD5_Biblioteca') IS NOT NULL
BEGIN
    ALTER DATABASE BD5_Biblioteca SET SINGLE_USER WITH ROLLBACK IMMEDIATE;
    DROP DATABASE BD5_Biblioteca;
END
GO
CREATE DATABASE BD5_Biblioteca;
GO
USE BD5_Biblioteca;
GO

-- 1FN: todo en una tabla con libros repetidos en la misma fila
CREATE TABLE Prestamo1FN (
    ID INT PRIMARY KEY,
    UsuarioNombre NVARCHAR(100),
    UsuarioEmail NVARCHAR(100),
    Libro1_Titulo NVARCHAR(200),
    Libro2_Titulo NVARCHAR(200),
    FechaInicio DATE,
    FechaFin DATE
);
GO

-- 2FN: separar Usuario y Libro, préstamo referencia ambos
CREATE TABLE Usuario2FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(100),
    Email NVARCHAR(100)
);
GO
CREATE TABLE Libro2FN (
    ISBN CHAR(13) PRIMARY KEY,
    Titulo NVARCHAR(200),
    Autor NVARCHAR(100)
);
GO
CREATE TABLE Prestamo2FN (
    ID INT PRIMARY KEY,
    ID_Usuario INT,
    ISBN CHAR(13),
    FechaInicio DATE,
    FechaFin DATE,
    CONSTRAINT FK_Prestamo2FN_Usuario FOREIGN KEY (ID_Usuario) REFERENCES Usuario2FN(ID),
    CONSTRAINT FK_Prestamo2FN_Libro FOREIGN KEY (ISBN) REFERENCES Libro2FN(ISBN)
);
GO

-- 3FN: igual que 2FN pero enfatizando que Prestamo solo guarda llaves y fechas
CREATE TABLE Usuario3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(100),
    Email NVARCHAR(100)
);
GO
CREATE TABLE Libro3FN (
    ISBN CHAR(13) PRIMARY KEY,
    Titulo NVARCHAR(200),
    Autor NVARCHAR(100),
    Editorial NVARCHAR(100)
);
GO
CREATE TABLE Prestamo3FN (
    ID INT PRIMARY KEY,
    ID_Usuario INT NOT NULL,
    ISBN CHAR(13) NOT NULL,
    FechaInicio DATE,
    FechaFin DATE,
    CONSTRAINT FK_Prestamo3FN_Usuario FOREIGN KEY (ID_Usuario) REFERENCES Usuario3FN(ID),
    CONSTRAINT FK_Prestamo3FN_Libro FOREIGN KEY (ISBN) REFERENCES Libro3FN(ISBN)
);
GO
