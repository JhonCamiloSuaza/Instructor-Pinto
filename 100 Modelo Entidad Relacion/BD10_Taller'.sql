-- Registrar clientes, autos y reparaciones.

USE master;
GO
IF DB_ID('BD10_Taller') IS NOT NULL
BEGIN
    ALTER DATABASE BD10_Taller SET SINGLE_USER WITH ROLLBACK IMMEDIATE;
    DROP DATABASE BD10_Taller;
END
GO
CREATE DATABASE BD10_Taller;
GO
USE BD10_Taller;
GO

-- 1FN: reparacion con datos de cliente y auto juntos
CREATE TABLE Reparacion1FN (
    ID INT PRIMARY KEY,
    ClienteNombre NVARCHAR(100),
    ClienteTelefono NVARCHAR(20),
    AutoPlaca NVARCHAR(20),
    AutoModelo NVARCHAR(100),
    Fecha DATE,
    Descripcion NVARCHAR(200)
);
GO

-- 2FN: Cliente y Auto separados
CREATE TABLE Cliente2FN_Taller (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(100),
    Telefono NVARCHAR(20)
);
GO
CREATE TABLE Auto2FN (
    Placa NVARCHAR(20) PRIMARY KEY,
    Modelo NVARCHAR(100),
    Marca NVARCHAR(50)
);
GO
CREATE TABLE Reparacion2FN (
    ID INT PRIMARY KEY,
    ID_Cliente INT,
    PlacaAuto NVARCHAR(20),
    Fecha DATE,
    Descripcion NVARCHAR(200),
    CONSTRAINT FK_Rep2_Cliente FOREIGN KEY (ID_Cliente) REFERENCES Cliente2FN_Taller(ID),
    CONSTRAINT FK_Rep2_Auto FOREIGN KEY (PlacaAuto) REFERENCES Auto2FN(Placa)
);
GO

-- 3FN: normalizado, una reparación apunta a cliente y auto
CREATE TABLE Cliente3FN_Taller (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(100),
    Telefono NVARCHAR(20),
    Email NVARCHAR(100)
);
GO
CREATE TABLE Auto3FN (
    Placa NVARCHAR(20) PRIMARY KEY,
    Modelo NVARCHAR(100),
    Marca NVARCHAR(50),
    Año INT
);
GO
CREATE TABLE Reparacion3FN (
    ID INT PRIMARY KEY,
    ID_Cliente INT NOT NULL,
    PlacaAuto NVARCHAR(20) NOT NULL,
    Fecha DATE,
    Descripcion NVARCHAR(200),
    CONSTRAINT FK_Rep3_Cliente FOREIGN KEY (ID_Cliente) REFERENCES Cliente3FN_Taller(ID),
    CONSTRAINT FK_Rep3_Auto FOREIGN KEY (PlacaAuto) REFERENCES Auto3FN(Placa)
);
GO
