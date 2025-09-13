
-- Registrar huéspedes, habitaciones y reservas.

USE master;
GO
IF DB_ID('BD8_Hotel') IS NOT NULL
BEGIN
    ALTER DATABASE BD8_Hotel SET SINGLE_USER WITH ROLLBACK IMMEDIATE;
    DROP DATABASE BD8_Hotel;
END
GO
CREATE DATABASE BD8_Hotel;
GO
USE BD8_Hotel;
GO

-- 1FN: reserva con datos del huésped y habitación en la misma fila
CREATE TABLE Reserva1FN_Hotel (
    ID INT PRIMARY KEY,
    HuéspedNombre NVARCHAR(100),
    HuéspedDocumento NVARCHAR(50),
    Hab_Numero INT,
    Hab_Tipo NVARCHAR(50),
    FechaInicio DATE,
    FechaFin DATE
);
GO

-- 2FN: separar Huesped y Habitacion
CREATE TABLE Huesped2FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(100),
    Documento NVARCHAR(50)
);
GO
CREATE TABLE Habitacion2FN (
    Numero INT PRIMARY KEY,
    Tipo NVARCHAR(50),
    Precio DECIMAL(10,2)
);
GO
CREATE TABLE Reserva2FN_Hotel (
    ID INT PRIMARY KEY,
    ID_Huesped INT,
    NumeroHab INT,
    FechaInicio DATE,
    FechaFin DATE,
    CONSTRAINT FK_Res2_Huesped FOREIGN KEY (ID_Huesped) REFERENCES Huesped2FN(ID),
    CONSTRAINT FK_Res2_Habitacion FOREIGN KEY (NumeroHab) REFERENCES Habitacion2FN(Numero)
);
GO

-- 3FN: normalizado
CREATE TABLE Huesped3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(100),
    Documento NVARCHAR(50),
    Telefono NVARCHAR(20)
);
GO
CREATE TABLE Habitacion3FN (
    Numero INT PRIMARY KEY,
    Tipo NVARCHAR(50),
    Precio DECIMAL(10,2),
    Piso INT
);
GO
CREATE TABLE Reserva3FN_Hotel (
    ID INT PRIMARY KEY,
    ID_Huesped INT NOT NULL,
    NumeroHab INT NOT NULL,
    FechaInicio DATE,
    FechaFin DATE,
    CONSTRAINT FK_Res3_Huesped FOREIGN KEY (ID_Huesped) REFERENCES Huesped3FN(ID),
    CONSTRAINT FK_Res3_Habitacion FOREIGN KEY (NumeroHab) REFERENCES Habitacion3FN(Numero)
);
GO
