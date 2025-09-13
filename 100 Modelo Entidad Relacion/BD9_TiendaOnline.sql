-- Registrar usuarios, productos y pedidos.

USE master;
GO
IF DB_ID('BD9_TiendaOnline') IS NOT NULL
BEGIN
    ALTER DATABASE BD9_TiendaOnline SET SINGLE_USER WITH ROLLBACK IMMEDIATE;
    DROP DATABASE BD9_TiendaOnline;
END
GO
CREATE DATABASE BD9_TiendaOnline;
GO
USE BD9_TiendaOnline;
GO

-- 1FN: pedido con productos repetidos en columnas
CREATE TABLE Pedido1FN (
    ID INT PRIMARY KEY,
    UsuarioNombre NVARCHAR(100),
    Producto1 NVARCHAR(100),
    Producto2 NVARCHAR(100),
    Fecha DATE,
    Total DECIMAL(10,2)
);
GO

-- 2FN: separar Usuario y Producto; Pedido referencia productos (simplificado)
CREATE TABLE Usuario2FN_Tienda (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(100),
    Email NVARCHAR(100)
);
GO
CREATE TABLE Producto2FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(100),
    Precio DECIMAL(10,2)
);
GO
CREATE TABLE Pedido2FN (
    ID INT PRIMARY KEY,
    ID_Usuario INT,
    ID_Producto INT,
    Fecha DATE,
    Cantidad INT,
    CONSTRAINT FK_Ped2_Usuario FOREIGN KEY (ID_Usuario) REFERENCES Usuario2FN_Tienda(ID),
    CONSTRAINT FK_Ped2_Producto FOREIGN KEY (ID_Producto) REFERENCES Producto2FN(ID)
);
GO

-- 3FN: normalizado; si un pedido tiene varios productos se usaría detallePedido
CREATE TABLE Usuario3FN_Tienda (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(100),
    Email NVARCHAR(100)
);
GO
CREATE TABLE Producto3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(100),
    Precio DECIMAL(10,2),
    Stock INT
);
GO
CREATE TABLE Pedido3FN (
    ID INT PRIMARY KEY,
    ID_Usuario INT NOT NULL,
    Fecha DATE,
    Total DECIMAL(10,2),
    CONSTRAINT FK_Ped3_Usuario FOREIGN KEY (ID_Usuario) REFERENCES Usuario3FN_Tienda(ID)
);
GO
CREATE TABLE PedidoDetalle3FN (
    ID INT PRIMARY KEY,
    ID_Pedido INT NOT NULL,
    ID_Producto INT NOT NULL,
    Cantidad INT,
    PrecioUnitario DECIMAL(10,2),
    CONSTRAINT FK_Det3_Pedido FOREIGN KEY (ID_Pedido) REFERENCES Pedido3FN(ID),
    CONSTRAINT FK_Det3_Producto FOREIGN KEY (ID_Producto) REFERENCES Producto3FN(ID)
);
GO
