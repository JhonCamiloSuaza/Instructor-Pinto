-- Registrar meseros, mesas y órdenes de clientes.

USE master;
GO
IF DB_ID('BD12_Restaurante') IS NOT NULL
BEGIN
    ALTER DATABASE BD12_Restaurante SET SINGLE_USER WITH ROLLBACK IMMEDIATE;
    DROP DATABASE BD12_Restaurante;
END
GO
CREATE DATABASE BD12_Restaurante;
GO
USE BD12_Restaurante;
GO

-- 1FN: orden con mesero y mesa y platos en la misma fila
CREATE TABLE Orden1FN (
    ID INT PRIMARY KEY,
    ClienteNombre NVARCHAR(100),
    MeseroNombre NVARCHAR(100),
    MesaNumero INT,
    Plato1 NVARCHAR(100),
    Plato2 NVARCHAR(100),
    Fecha DATE
);
GO

-- 2FN: separar Mesero, Mesa y Plato (producto)
CREATE TABLE Mesero2FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(100)
);
GO
CREATE TABLE Mesa2FN (
    Numero INT PRIMARY KEY,
    Capacidad INT
);
GO
CREATE TABLE Plato2FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(100),
    Precio DECIMAL(10,2)
);
GO
CREATE TABLE Orden2FN (
    ID INT PRIMARY KEY,
    ClienteNombre NVARCHAR(100),
    ID_Mesero INT,
    NumeroMesa INT,
    Fecha DATE,
    CONSTRAINT FK_Ord2_Mesero FOREIGN KEY (ID_Mesero) REFERENCES Mesero2FN(ID),
    CONSTRAINT FK_Ord2_Mesa FOREIGN KEY (NumeroMesa) REFERENCES Mesa2FN(Numero)
);
GO

-- 3FN: normalizado con detalle de orden
CREATE TABLE Mesero3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(100),
    Telefono NVARCHAR(20)
);
GO
CREATE TABLE Mesa3FN (
    Numero INT PRIMARY KEY,
    Capacidad INT,
    Ubicacion NVARCHAR(100)
);
GO
CREATE TABLE Plato3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(100),
    Precio DECIMAL(10,2)
);
GO
CREATE TABLE Orden3FN (
    ID INT PRIMARY KEY,
    ID_Mesero INT NOT NULL,
    NumeroMesa INT NOT NULL,
    Fecha DATE,
    CONSTRAINT FK_Ord3_Mesero FOREIGN KEY (ID_Mesero) REFERENCES Mesero3FN(ID),
    CONSTRAINT FK_Ord3_Mesa FOREIGN KEY (NumeroMesa) REFERENCES Mesa3FN(Numero)
);
GO
CREATE TABLE OrdenDetalle3FN (
    ID INT PRIMARY KEY,
    ID_Orden INT NOT NULL,
    ID_Plato INT NOT NULL,
    Cantidad INT,
    PrecioUnitario DECIMAL(10,2),
    CONSTRAINT FK_OrdDet3_Orden FOREIGN KEY (ID_Orden) REFERENCES Orden3FN(ID),
    CONSTRAINT FK_OrdDet3_Plato FOREIGN KEY (ID_Plato) REFERENCES Plato3FN(ID)
);
GO
