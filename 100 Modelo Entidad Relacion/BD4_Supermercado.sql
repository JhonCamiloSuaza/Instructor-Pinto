/* ENUNCIADO 4: Supermercado
   Registrar clientes, productos y ventas. */

IF DB_ID('BD4_Supermercado') IS NOT NULL
    DROP DATABASE BD4_Supermercado;
GO
CREATE DATABASE BD4_Supermercado;
GO
USE BD4_Supermercado;
GO

/* 1FN */
CREATE TABLE Venta1FN (
    ID INT PRIMARY KEY,
    ClienteNombre NVARCHAR(50),
    Producto1 NVARCHAR(50),
    Producto2 NVARCHAR(50),
    Fecha DATE,
    Total DECIMAL(10,2)
);
GO

/* 2FN */
CREATE TABLE Cliente2FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50)
);
GO
CREATE TABLE Producto2FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50),
    Precio DECIMAL(10,2)
);
GO
CREATE TABLE Venta2FN (
    ID INT PRIMARY KEY,
    ID_Cliente INT,
    ID_Producto INT,
    Fecha DATE,
    Cantidad INT,
    FOREIGN KEY (ID_Cliente) REFERENCES Cliente2FN(ID),
    FOREIGN KEY (ID_Producto) REFERENCES Producto2FN(ID)
);
GO

/* 3FN */
CREATE TABLE Cliente3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50)
);
GO
CREATE TABLE Producto3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50),
    Precio DECIMAL(10,2)
);
GO
CREATE TABLE Venta3FN (
    ID INT PRIMARY KEY,
    ID_Cliente INT,
    ID_Producto INT,
    Fecha DATE,
    Cantidad INT,
    FOREIGN KEY (ID_Cliente) REFERENCES Cliente3FN(ID),
    FOREIGN KEY (ID_Producto) REFERENCES Producto3FN(ID)
);
GO
