-- Registrar clientes, autos y ventas.

USE master;
GO
IF DB_ID('BD13_EmpresaAutos') IS NOT NULL
BEGIN
    ALTER DATABASE BD13_EmpresaAutos SET SINGLE_USER WITH ROLLBACK IMMEDIATE;
    DROP DATABASE BD13_EmpresaAutos;
END
GO
CREATE DATABASE BD13_EmpresaAutos;
GO
USE BD13_EmpresaAutos;
GO

-- 1FN: venta con cliente y auto en la misma fila
CREATE TABLE Venta1FN_Autos (
    ID INT PRIMARY KEY,
    ClienteNombre NVARCHAR(100),
    ClienteTelefono NVARCHAR(20),
    AutoPlaca NVARCHAR(20),
    AutoModelo NVARCHAR(100),
    Fecha DATE,
    Precio DECIMAL(12,2)
);
GO

-- 2FN: separar Cliente y Auto
CREATE TABLE Cliente2FN_Autos (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(100),
    Telefono NVARCHAR(20)
);
GO
CREATE TABLE Auto2FN_Autos (
    Placa NVARCHAR(20) PRIMARY KEY,
    Marca NVARCHAR(50),
    Modelo NVARCHAR(100),
    Año INT
);
GO
CREATE TABLE Venta2FN_Autos (
    ID INT PRIMARY KEY,
    ID_Cliente INT,
    PlacaAuto NVARCHAR(20),
    Fecha DATE,
    Precio DECIMAL(12,2),
    CONSTRAINT FK_Ven2_Cliente FOREIGN KEY (ID_Cliente) REFERENCES Cliente2FN_Autos(ID),
    CONSTRAINT FK_Ven2_Auto FOREIGN KEY (PlacaAuto) REFERENCES Auto2FN_Autos(Placa)
);
GO

-- 3FN: normalizado
CREATE TABLE Cliente3FN_Autos (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(100),
    Telefono NVARCHAR(20),
    Email NVARCHAR(100)
);
GO
CREATE TABLE Auto3FN_Autos (
    Placa NVARCHAR(20) PRIMARY KEY,
    Marca NVARCHAR(50),
    Modelo NVARCHAR(100),
    Año INT,
    Kilometraje INT
);
GO
CREATE TABLE Venta3FN_Autos (
    ID INT PRIMARY KEY,
    ID_Cliente INT NOT NULL,
    PlacaAuto NVARCHAR(20) NOT NULL,
    Fecha DATE,
    Precio DECIMAL(12,2),
    CONSTRAINT FK_Ven3_Cliente FOREIGN KEY (ID_Cliente) REFERENCES Cliente3FN_Autos(ID),
    CONSTRAINT FK_Ven3_Auto FOREIGN KEY (PlacaAuto) REFERENCES Auto3FN_Autos(Placa)
);
GO
