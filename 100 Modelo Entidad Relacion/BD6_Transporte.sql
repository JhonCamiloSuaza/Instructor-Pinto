-- Empresa de Transporte
-- Registrar choferes, buses y rutas asignadas.

USE master;
GO
IF DB_ID('BD6_Transporte') IS NOT NULL
BEGIN
    ALTER DATABASE BD6_Transporte SET SINGLE_USER WITH ROLLBACK IMMEDIATE;
    DROP DATABASE BD6_Transporte;
END
GO
CREATE DATABASE BD6_Transporte;
GO
USE BD6_Transporte;
GO

-- 1FN: todo en una tabla (datos repetidos)
CREATE TABLE Ruta1FN (
    ID INT PRIMARY KEY,
    ChoferNombre NVARCHAR(100),
    ChoferLicencia NVARCHAR(50),
    BusPlaca NVARCHAR(20),
    BusModelo NVARCHAR(50),
    RutaNombre NVARCHAR(100),
    Horario NVARCHAR(50)
);
GO

-- 2FN: separar Chofer y Bus y Ruta como entidad
CREATE TABLE Chofer2FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(100),
    Licencia NVARCHAR(50)
);
GO
CREATE TABLE Bus2FN (
    Placa NVARCHAR(20) PRIMARY KEY,
    Modelo NVARCHAR(50),
    Capacidad INT
);
GO
CREATE TABLE Ruta2FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(100),
    Horario NVARCHAR(50)
);
GO
CREATE TABLE Asignacion2FN (
    ID INT PRIMARY KEY,
    ID_Chofer INT,
    PlacaBus NVARCHAR(20),
    ID_Ruta INT,
    CONSTRAINT FK_Asign2_Chofer FOREIGN KEY (ID_Chofer) REFERENCES Chofer2FN(ID),
    CONSTRAINT FK_Asign2_Bus FOREIGN KEY (PlacaBus) REFERENCES Bus2FN(Placa),
    CONSTRAINT FK_Asign2_Ruta FOREIGN KEY (ID_Ruta) REFERENCES Ruta2FN(ID)
);
GO

-- 3FN: cada tabla con atributos que dependen solo de su PK
CREATE TABLE Chofer3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(100),
    Licencia NVARCHAR(50)
);
GO
CREATE TABLE Bus3FN (
    Placa NVARCHAR(20) PRIMARY KEY,
    Modelo NVARCHAR(50),
    Capacidad INT
);
GO
CREATE TABLE Ruta3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(100),
    Horario NVARCHAR(50)
);
GO
CREATE TABLE Asignacion3FN (
    ID INT PRIMARY KEY,
    ID_Chofer INT NOT NULL,
    PlacaBus NVARCHAR(20) NOT NULL,
    ID_Ruta INT NOT NULL,
    CONSTRAINT FK_Asign3_Chofer FOREIGN KEY (ID_Chofer) REFERENCES Chofer3FN(ID),
    CONSTRAINT FK_Asign3_Bus FOREIGN KEY (PlacaBus) REFERENCES Bus3FN(Placa),
    CONSTRAINT FK_Asign3_Ruta FOREIGN KEY (ID_Ruta) REFERENCES Ruta3FN(ID)
);
GO
