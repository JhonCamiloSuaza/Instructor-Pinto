-- Registrar almacenes, productos y movimientos de stock.

USE master;
GO
IF DB_ID('BD17_Inventario') IS NOT NULL
BEGIN
    ALTER DATABASE BD17_Inventario SET SINGLE_USER WITH ROLLBACK IMMEDIATE;
    DROP DATABASE BD17_Inventario;
END
GO
CREATE DATABASE BD17_Inventario;
GO
USE BD17_Inventario;
GO

-- 1FN: movimiento con datos mezclados
CREATE TABLE Movimiento1FN (
    ID INT PRIMARY KEY,
    AlmacenNombre NVARCHAR(100),
    ProductoNombre NVARCHAR(100),
    Cantidad INT,
    Fecha DATE,
    Tipo NVARCHAR(20) -- "entrada"/"salida"
);
GO

-- 2FN: separar Almacen y Producto
CREATE TABLE Almacen2FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(100),
    Ubicacion NVARCHAR(200)
);
GO
CREATE TABLE Producto2FN_Inv (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(100),
    SKU NVARCHAR(50)
);
GO
CREATE TABLE Movimiento2FN (
    ID INT PRIMARY KEY,
    ID_Almacen INT,
    ID_Producto INT,
    Cantidad INT,
    Fecha DATE,
    Tipo NVARCHAR(20),
    CONSTRAINT FK_Mov2_Almacen FOREIGN KEY (ID_Almacen) REFERENCES Almacen2FN(ID),
    CONSTRAINT FK_Mov2_Producto FOREIGN KEY (ID_Producto) REFERENCES Producto2FN_Inv(ID)
);
GO

-- 3FN: normalizado
CREATE TABLE Almacen3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(100),
    Ubicacion NVARCHAR(200),
    Responsable NVARCHAR(100)
);
GO
CREATE TABLE Producto3FN_Inv (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(100),
    SKU NVARCHAR(50),
    Precio DECIMAL(10,2)
);
GO
CREATE TABLE Movimiento3FN (
    ID INT PRIMARY KEY,
    ID_Almacen INT NOT NULL,
    ID_Producto INT NOT NULL,
    Cantidad INT,
    Fecha DATE,
    Tipo NVARCHAR(20),
    CONSTRAINT FK_Mov3_Almacen FOREIGN KEY (ID_Almacen) REFERENCES Almacen3FN(ID),
    CONSTRAINT FK_Mov3_Producto FOREIGN KEY (ID_Producto) REFERENCES Producto3FN_Inv(ID)
);
GO
