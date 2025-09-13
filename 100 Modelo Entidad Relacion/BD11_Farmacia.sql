
-- Registrar proveedores, medicamentos y compras a proveedores.

USE master;
GO
IF DB_ID('BD11_Farmacia') IS NOT NULL
BEGIN
    ALTER DATABASE BD11_Farmacia SET SINGLE_USER WITH ROLLBACK IMMEDIATE;
    DROP DATABASE BD11_Farmacia;
END
GO
CREATE DATABASE BD11_Farmacia;
GO
USE BD11_Farmacia;
GO

-- 1FN: compra con datos de proveedor y medicamento juntos
CREATE TABLE Compra1FN_Farmacia (
    ID INT PRIMARY KEY,
    ProveedorNombre NVARCHAR(100),
    ProveedorTelefono NVARCHAR(50),
    MedicamentoNombre NVARCHAR(100),
    Cantidad INT,
    Fecha DATE
);
GO

-- 2FN: separar Proveedor y Medicamento
CREATE TABLE Proveedor2FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(100),
    Telefono NVARCHAR(50)
);
GO
CREATE TABLE Medicamento2FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(100),
    Precio DECIMAL(10,2)
);
GO
CREATE TABLE Compra2FN_Farmacia (
    ID INT PRIMARY KEY,
    ID_Proveedor INT,
    ID_Medicamento INT,
    Cantidad INT,
    Fecha DATE,
    CONSTRAINT FK_Comp2_Prov FOREIGN KEY (ID_Proveedor) REFERENCES Proveedor2FN(ID),
    CONSTRAINT FK_Comp2_Med FOREIGN KEY (ID_Medicamento) REFERENCES Medicamento2FN(ID)
);
GO

-- 3FN: normalizado
CREATE TABLE Proveedor3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(100),
    Telefono NVARCHAR(50),
    Direccion NVARCHAR(200)
);
GO
CREATE TABLE Medicamento3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(100),
    Precio DECIMAL(10,2),
    Presentacion NVARCHAR(100)
);
GO
CREATE TABLE Compra3FN_Farmacia (
    ID INT PRIMARY KEY,
    ID_Proveedor INT NOT NULL,
    ID_Medicamento INT NOT NULL,
    Cantidad INT,
    Fecha DATE,
    CONSTRAINT FK_Comp3_Prov FOREIGN KEY (ID_Proveedor) REFERENCES Proveedor3FN(ID),
    CONSTRAINT FK_Comp3_Med FOREIGN KEY (ID_Medicamento) REFERENCES Medicamento3FN(ID)
);
GO
