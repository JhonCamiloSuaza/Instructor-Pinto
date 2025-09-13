-- Registrar freelancers, clientes y proyectos.

USE master;
GO
IF DB_ID('BD14_Freelance') IS NOT NULL
BEGIN
    ALTER DATABASE BD14_Freelance SET SINGLE_USER WITH ROLLBACK IMMEDIATE;
    DROP DATABASE BD14_Freelance;
END
GO
CREATE DATABASE BD14_Freelance;
GO
USE BD14_Freelance;
GO

-- 1FN: proyecto con datos del freelancer y cliente en la misma fila
CREATE TABLE Proyecto1FN (
    ID INT PRIMARY KEY,
    FreelancerNombre NVARCHAR(100),
    ClienteNombre NVARCHAR(100),
    TituloProyecto NVARCHAR(200),
    Presupuesto DECIMAL(12,2)
);
GO

-- 2FN: separar Freelancer y Cliente y Proyecto como entidad
CREATE TABLE Freelancer2FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(100),
    Habilidades NVARCHAR(200)
);
GO
CREATE TABLE Cliente2FN_F (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(100),
    Empresa NVARCHAR(100)
);
GO
CREATE TABLE Proyecto2FN (
    ID INT PRIMARY KEY,
    ID_Freelancer INT,
    ID_Cliente INT,
    Titulo NVARCHAR(200),
    Presupuesto DECIMAL(12,2),
    CONSTRAINT FK_Proy2_Freelancer FOREIGN KEY (ID_Freelancer) REFERENCES Freelancer2FN(ID),
    CONSTRAINT FK_Proy2_Cliente FOREIGN KEY (ID_Cliente) REFERENCES Cliente2FN_F(ID)
);
GO

-- 3FN: normalizado
CREATE TABLE Freelancer3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(100),
    Habilidades NVARCHAR(200),
    Rating DECIMAL(3,2)
);
GO
CREATE TABLE Cliente3FN_F (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(100),
    Empresa NVARCHAR(100),
    Email NVARCHAR(100)
);
GO
CREATE TABLE Proyecto3FN (
    ID INT PRIMARY KEY,
    ID_Freelancer INT NOT NULL,
    ID_Cliente INT NOT NULL,
    Titulo NVARCHAR(200),
    Presupuesto DECIMAL(12,2),
    FechaInicio DATE,
    FechaFin DATE,
    CONSTRAINT FK_Proy3_Freelancer FOREIGN KEY (ID_Freelancer) REFERENCES Freelancer3FN(ID),
    CONSTRAINT FK_Proy3_Cliente FOREIGN KEY (ID_Cliente) REFERENCES Cliente3FN_F(ID)
);
GO
