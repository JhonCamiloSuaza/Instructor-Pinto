-- Registrar clientes, servicios y facturas.

USE master;
GO
IF DB_ID('BD18_Servicios') IS NOT NULL
BEGIN
    ALTER DATABASE BD18_Servicios SET SINGLE_USER WITH ROLLBACK IMMEDIATE;
    DROP DATABASE BD18_Servicios;
END
GO
CREATE DATABASE BD18_Servicios;
GO
USE BD18_Servicios;
GO

-- 1FN: factura con cliente y varios servicios en la misma fila
CREATE TABLE Factura1FN (
    ID INT PRIMARY KEY,
    ClienteNombre NVARCHAR(100),
    ClienteDireccion NVARCHAR(200),
    Servicio1 NVARCHAR(200),
    Servicio2 NVARCHAR(200),
    Fecha DATE,
    Total DECIMAL(12,2)
);
GO

-- 2FN: separar Cliente y Servicio
CREATE TABLE Cliente2FN_Serv (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(100),
    Direccion NVARCHAR(200)
);
GO
CREATE TABLE Servicio2FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(200),
    Precio DECIMAL(12,2)
);
GO
CREATE TABLE Factura2FN (
    ID INT PRIMARY KEY,
    ID_Cliente INT,
    Fecha DATE,
    Total DECIMAL(12,2),
    CONSTRAINT FK_Fac2_Cliente FOREIGN KEY (ID_Cliente) REFERENCES Cliente2FN_Serv(ID)
);
GO
CREATE TABLE FacturaDetalle2FN (
    ID INT PRIMARY KEY,
    ID_Factura INT,
    ID_Servicio INT,
    Cantidad INT,
    CONSTRAINT FK_FacDet2_Fac FOREIGN KEY (ID_Factura) REFERENCES Factura2FN(ID),
    CONSTRAINT FK_FacDet2_Serv FOREIGN KEY (ID_Servicio) REFERENCES Servicio2FN(ID)
);
GO

-- 3FN: normalizado
CREATE TABLE Cliente3FN_Serv (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(100),
    Direccion NVARCHAR(200),
    Telefono NVARCHAR(20)
);
GO
CREATE TABLE Servicio3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(200),
    Precio DECIMAL(12,2),
    DuracionMin INT
);
GO
CREATE TABLE Factura3FN (
    ID INT PRIMARY KEY,
    ID_Cliente INT NOT NULL,
    Fecha DATE,
    Total DECIMAL(12,2),
    CONSTRAINT FK_Fac3_Cliente FOREIGN KEY (ID_Cliente) REFERENCES Cliente3FN_Serv(ID)
);
GO
CREATE TABLE FacturaDetalle3FN (
    ID INT PRIMARY KEY,
    ID_Factura INT NOT NULL,
    ID_Servicio INT NOT NULL,
    Cantidad INT,
    PrecioUnitario DECIMAL(12,2),
    CONSTRAINT FK_FacDet3_Fac FOREIGN KEY (ID_Factura) REFERENCES Factura3FN(ID),
    CONSTRAINT FK_FacDet3_Serv FOREIGN KEY (ID_Servicio) REFERENCES Servicio3FN(ID)
);
GO
