/* 
   Una universidad desea registrar estudiantes,
   materias y las inscripciones de los estudiantes.
    */

IF DB_ID('BD2_Universidad') IS NOT NULL
    DROP DATABASE BD2_Universidad;
GO
CREATE DATABASE BD2_Universidad;
GO
USE BD2_Universidad;
GO

/* 
   1FN: PRIMERA FORMA NORMAL
   - Todo está en una sola tabla.
   - Varias materias guardadas en la misma fila.
   - Problema: redundancia y atributos no atómicos.
    */
CREATE TABLE Inscripcion1FN (
    ID INT PRIMARY KEY,
    EstudianteNombre NVARCHAR(50),
    EstudianteEmail NVARCHAR(50),
    Materia1 NVARCHAR(50),
    Materia2 NVARCHAR(50),
    Semestre NVARCHAR(20)
);
GO

/* 
   2FN: SEGUNDA FORMA NORMAL
   - Se crean tablas separadas para Estudiante y Materia.
   - Inscripción referencia a Estudiante y Materia.
   - Relación: Estudiante (1:N) Inscripción, Materia (1:N) Inscripción.
    */
CREATE TABLE Estudiante2FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50),
    Email NVARCHAR(50)
);
GO
CREATE TABLE Materia2FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50),
    Creditos INT
);
GO
CREATE TABLE Inscripcion2FN (
    ID INT PRIMARY KEY,
    ID_Estudiante INT,
    ID_Materia INT,
    Semestre NVARCHAR(20),
    FOREIGN KEY (ID_Estudiante) REFERENCES Estudiante2FN(ID),
    FOREIGN KEY (ID_Materia) REFERENCES Materia2FN(ID)
);
GO
/* 
   3FN: TERCERA FORMA NORMAL
   - Eliminamos dependencias transitivas.
   - Inscripción solo guarda llaves y datos propios.
   - Relación final: Estudiante (1:N) Inscripción, Materia (1:N) Inscripción.
    */
CREATE TABLE Estudiante3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50),
    Email NVARCHAR(50)
);
GO
CREATE TABLE Materia3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50),
    Creditos INT
);
GO
CREATE TABLE Inscripcion3FN (
    ID INT PRIMARY KEY,
    ID_Estudiante INT,
    ID_Materia INT,
    Semestre NVARCHAR(20),
    FOREIGN KEY (ID_Estudiante) REFERENCES Estudiante3FN(ID),
    FOREIGN KEY (ID_Materia) REFERENCES Materia3FN(ID)
);
GO
