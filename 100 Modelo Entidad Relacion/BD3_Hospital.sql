/* 
   Registrar pacientes, doctores y citas médicas. */

IF DB_ID('BD3_Hospital') IS NOT NULL
    DROP DATABASE BD3_Hospital;
GO
CREATE DATABASE BD3_Hospital;
GO
USE BD3_Hospital;
GO

/* 1FN: Todo en una tabla */
CREATE TABLE Cita1FN (
    ID INT PRIMARY KEY,
    PacienteNombre NVARCHAR(50),
    PacienteEdad INT,
    DoctorNombre NVARCHAR(50),
    DoctorEspecialidad NVARCHAR(50),
    Fecha DATE,
    Hora NVARCHAR(10)
);
GO

/* 2FN: Paciente y Doctor separados */
CREATE TABLE Paciente2FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50),
    Edad INT
);
GO
CREATE TABLE Doctor2FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50),
    Especialidad NVARCHAR(50)
);
GO
CREATE TABLE Cita2FN (
    ID INT PRIMARY KEY,
    ID_Paciente INT,
    ID_Doctor INT,
    Fecha DATE,
    Hora NVARCHAR(10),
    FOREIGN KEY (ID_Paciente) REFERENCES Paciente2FN(ID),
    FOREIGN KEY (ID_Doctor) REFERENCES Doctor2FN(ID)
);
GO

/* 3FN: Limpio y normalizado */
CREATE TABLE Paciente3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50),
    Edad INT
);
GO
CREATE TABLE Doctor3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50),
    Especialidad NVARCHAR(50)
);
GO
CREATE TABLE Cita3FN (
    ID INT PRIMARY KEY,
    ID_Paciente INT,
    ID_Doctor INT,
    Fecha DATE,
    Hora NVARCHAR(10),
    FOREIGN KEY (ID_Paciente) REFERENCES Paciente3FN(ID),
    FOREIGN KEY (ID_Doctor) REFERENCES Doctor3FN(ID)
);
GO
