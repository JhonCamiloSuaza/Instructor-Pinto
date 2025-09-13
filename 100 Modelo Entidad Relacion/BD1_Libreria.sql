/* 
   Una librería quiere registrar clientes,
   libros y las compras realizadas.
    */

IF DB_ID('BD1_Libreria') IS NOT NULL
    DROP DATABASE BD1_Libreria;
GO
CREATE DATABASE BD1_Libreria;
GO
USE BD1_Libreria;
GO

/* 
   1FN: PRIMERA FORMA NORMAL
   - Todo está en una sola tabla.
   - Libros repetidos dentro de la misma fila.
   - Problema: datos redundantes y no atómicos.
    */
CREATE TABLE Compra1FN (
    ID_Compra INT PRIMARY KEY,
    ClienteNombre NVARCHAR(50),
    ClienteEmail NVARCHAR(50),
    Libro1_Titulo NVARCHAR(100),
    Libro1_Autor NVARCHAR(50),
    Libro2_Titulo NVARCHAR(100),
    Libro2_Autor NVARCHAR(50),
    Fecha DATE
);
GO

/* 
   2FN: SEGUNDA FORMA NORMAL
   - Se separan Cliente y Libro en tablas propias.
   - Compra hace referencia a Cliente y a Libro.
   - Relación: Cliente (1:N) Compra, Libro (1:N) Compra.
    */
CREATE TABLE Cliente2FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50),
    Email NVARCHAR(50)
);
GO
CREATE TABLE Libro2FN (
    ISBN CHAR(13) PRIMARY KEY,
    Titulo NVARCHAR(100),
    Autor NVARCHAR(50)
);
GO
CREATE TABLE Compra2FN (
    ID INT PRIMARY KEY,
    ID_Cliente INT,
    ISBN CHAR(13),
    Fecha DATE,
    Cantidad INT,
    FOREIGN KEY (ID_Cliente) REFERENCES Cliente2FN(ID),
    FOREIGN KEY (ISBN) REFERENCES Libro2FN(ISBN)
);
GO

/* 
   3FN: TERCERA FORMA NORMAL
   - Eliminamos cualquier dependencia transitiva.
   - Solo se guardan llaves en Compra.
   - Relación final: Cliente (1:N) Compra, Libro (1:N) Compra.
    */
CREATE TABLE Cliente3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50),
    Email NVARCHAR(50)
);
GO
CREATE TABLE Libro3FN (
    ISBN CHAR(13) PRIMARY KEY,
    Titulo NVARCHAR(100),
    Autor NVARCHAR(50)
);
GO
CREATE TABLE Compra3FN (
    ID INT PRIMARY KEY,
    ID_Cliente INT,
    ISBN CHAR(13),
    Fecha DATE,
    Cantidad INT,
    FOREIGN KEY (ID_Cliente) REFERENCES Cliente3FN(ID),
    FOREIGN KEY (ISBN) REFERENCES Libro3FN(ISBN)
);
GO
