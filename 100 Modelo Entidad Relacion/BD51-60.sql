
-- BD51: Hospital con pacientes, doctores y tratamientos
-- Enunciado: Un hospital registra doctores, pacientes y los
-- tratamientos que cada paciente recibe.

IF DB_ID('BD51_Hospital') IS NOT NULL
    DROP DATABASE BD51_Hospital;
GO
CREATE DATABASE BD51_Hospital;
GO
USE BD51_Hospital;
GO
--3Forma
CREATE TABLE Doctor3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50),
    Especialidad NVARCHAR(50)
);

CREATE TABLE Paciente3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50),
    DoctorID INT,
    FOREIGN KEY (DoctorID) REFERENCES Doctor3FN(ID)
);

CREATE TABLE Tratamiento3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50)
);

CREATE TABLE PacienteTratamiento3FN (
    PacienteID INT,
    TratamientoID INT,
    PRIMARY KEY (PacienteID, TratamientoID),
    FOREIGN KEY (PacienteID) REFERENCES Paciente3FN(ID),
    FOREIGN KEY (TratamientoID) REFERENCES Tratamiento3FN(ID)
);
GO



-- BD52: Cine con películas, salas y funciones
-- Enunciado: Un cine maneja salas, películas y funciones 
-- que relacionan películas con salas y horarios.

IF DB_ID('BD52_Cine') IS NOT NULL
    DROP DATABASE BD52_Cine;
GO
CREATE DATABASE BD52_Cine;
GO
USE BD52_Cine;
GO

CREATE TABLE Pelicula3FN (
    ID INT PRIMARY KEY,
    Titulo NVARCHAR(100),
    Genero NVARCHAR(50)
);

CREATE TABLE Sala3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50),
    Capacidad INT
);

CREATE TABLE Funcion3FN (
    ID INT PRIMARY KEY,
    PeliculaID INT,
    SalaID INT,
    Horario DATETIME,
    FOREIGN KEY (PeliculaID) REFERENCES Pelicula3FN(ID),
    FOREIGN KEY (SalaID) REFERENCES Sala3FN(ID)
);
GO



-- BD53: Universidad con estudiantes, cursos y matrículas
-- Enunciado: Una universidad administra estudiantes,
-- cursos y matrículas de estudiantes en cursos.

IF DB_ID('BD53_Universidad') IS NOT NULL
    DROP DATABASE BD53_Universidad;
GO
CREATE DATABASE BD53_Universidad;
GO
USE BD53_Universidad;
GO

CREATE TABLE Estudiante3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50),
    Carrera NVARCHAR(50)
);

CREATE TABLE Curso3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(100),
    Creditos INT
);

CREATE TABLE Matricula3FN (
    EstudianteID INT,
    CursoID INT,
    Fecha DATE,
    PRIMARY KEY (EstudianteID, CursoID),
    FOREIGN KEY (EstudianteID) REFERENCES Estudiante3FN(ID),
    FOREIGN KEY (CursoID) REFERENCES Curso3FN(ID)
);
GO



-- BD54: Restaurante con clientes, mesas y reservas
-- Enunciado: Un restaurante gestiona clientes, mesas y las 
-- reservas que hacen los clientes en determinadas mesas.

IF DB_ID('BD54_Restaurante') IS NOT NULL
    DROP DATABASE BD54_Restaurante;
GO
CREATE DATABASE BD54_Restaurante;
GO
USE BD54_Restaurante;
GO

CREATE TABLE Cliente3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50),
    Telefono NVARCHAR(20)
);

CREATE TABLE Mesa3FN (
    ID INT PRIMARY KEY,
    Numero INT,
    Capacidad INT
);

CREATE TABLE Reserva3FN (
    ID INT PRIMARY KEY,
    ClienteID INT,
    MesaID INT,
    Fecha DATETIME,
    FOREIGN KEY (ClienteID) REFERENCES Cliente3FN(ID),
    FOREIGN KEY (MesaID) REFERENCES Mesa3FN(ID)
);
GO



-- BD55: Biblioteca con libros, autores y préstamos
-- Enunciado: Una biblioteca maneja autores, libros y los 
-- préstamos de libros que hacen los usuarios.

IF DB_ID('BD55_Biblioteca') IS NOT NULL
    DROP DATABASE BD55_Biblioteca;
GO
CREATE DATABASE BD55_Biblioteca;
GO
USE BD55_Biblioteca;
GO

CREATE TABLE Autor3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50)
);

CREATE TABLE Libro3FN (
    ISBN CHAR(13) PRIMARY KEY,
    Titulo NVARCHAR(100),
    AutorID INT,
    FOREIGN KEY (AutorID) REFERENCES Autor3FN(ID)
);

CREATE TABLE Usuario3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50)
);

CREATE TABLE Prestamo3FN (
    ID INT PRIMARY KEY,
    UsuarioID INT,
    LibroISBN CHAR(13),
    Fecha DATE,
    FOREIGN KEY (UsuarioID) REFERENCES Usuario3FN(ID),
    FOREIGN KEY (LibroISBN) REFERENCES Libro3FN(ISBN)
);
GO



-- BD56: Tienda de Ropa con clientes, prendas y ventas
-- Enunciado: Una tienda de ropa vende prendas de distintos 
-- colores y tallas, y registra las ventas a clientes.

IF DB_ID('BD56_TiendaRopa') IS NOT NULL
    DROP DATABASE BD56_TiendaRopa;
GO
CREATE DATABASE BD56_TiendaRopa;
GO
USE BD56_TiendaRopa;
GO

CREATE TABLE Cliente3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50),
    Email NVARCHAR(50)
);

CREATE TABLE Talla3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(10)
);

CREATE TABLE Color3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(20)
);

CREATE TABLE Prenda3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50),
    TallaID INT,
    ColorID INT,
    FOREIGN KEY (TallaID) REFERENCES Talla3FN(ID),
    FOREIGN KEY (ColorID) REFERENCES Color3FN(ID)
);

CREATE TABLE Venta3FN (
    ID INT PRIMARY KEY,
    ClienteID INT,
    PrendaID INT,
    Fecha DATE,
    FOREIGN KEY (ClienteID) REFERENCES Cliente3FN(ID),
    FOREIGN KEY (PrendaID) REFERENCES Prenda3FN(ID)
);
GO



-- BD57: Aerolínea con vuelos, aviones y pasajeros
-- Enunciado: Una aerolínea administra sus aviones, vuelos y
-- los pasajeros que reservan esos vuelos.

IF DB_ID('BD57_Aerolinea') IS NOT NULL
    DROP DATABASE BD57_Aerolinea;
GO
CREATE DATABASE BD57_Aerolinea;
GO
USE BD57_Aerolinea;
GO

CREATE TABLE Avion3FN (
    ID INT PRIMARY KEY,
    Modelo NVARCHAR(50),
    Capacidad INT
);

CREATE TABLE Vuelo3FN (
    ID INT PRIMARY KEY,
    Origen NVARCHAR(50),
    Destino NVARCHAR(50),
    AvionID INT,
    Fecha DATETIME,
    FOREIGN KEY (AvionID) REFERENCES Avion3FN(ID)
);

CREATE TABLE Pasajero3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50),
    Documento NVARCHAR(20)
);

CREATE TABLE Reserva3FN (
    ID INT PRIMARY KEY,
    PasajeroID INT,
    VueloID INT,
    FOREIGN KEY (PasajeroID) REFERENCES Pasajero3FN(ID),
    FOREIGN KEY (VueloID) REFERENCES Vuelo3FN(ID)
);
GO



-- BD58: Hotel con clientes, habitaciones y reservas
-- Enunciado: Un hotel registra clientes, habitaciones y las 
-- reservas que hacen los clientes.

IF DB_ID('BD58_Hotel') IS NOT NULL
    DROP DATABASE BD58_Hotel;
GO
CREATE DATABASE BD58_Hotel;
GO
USE BD58_Hotel;
GO

CREATE TABLE Cliente3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50),
    Telefono NVARCHAR(20)
);

CREATE TABLE Habitacion3FN (
    ID INT PRIMARY KEY,
    Numero INT,
    Tipo NVARCHAR(50),
    Precio DECIMAL(10,2)
);

CREATE TABLE Reserva3FN (
    ID INT PRIMARY KEY,
    ClienteID INT,
    HabitacionID INT,
    FechaInicio DATE,
    FechaFin DATE,
    FOREIGN KEY (ClienteID) REFERENCES Cliente3FN(ID),
    FOREIGN KEY (HabitacionID) REFERENCES Habitacion3FN(ID)
);
GO



-- BD59: Clínica Veterinaria con mascotas, dueños y citas
-- Enunciado: Una clínica veterinaria lleva control de las
-- mascotas, sus dueños y las citas veterinarias.

IF DB_ID('BD59_Veterinaria') IS NOT NULL
    DROP DATABASE BD59_Veterinaria;
GO
CREATE DATABASE BD59_Veterinaria;
GO
USE BD59_Veterinaria;
GO

CREATE TABLE Dueno3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50),
    Telefono NVARCHAR(20)
);

CREATE TABLE Mascota3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50),
    Especie NVARCHAR(50),
    DuenoID INT,
    FOREIGN KEY (DuenoID) REFERENCES Dueno3FN(ID)
);

CREATE TABLE Cita3FN (
    ID INT PRIMARY KEY,
    MascotaID INT,
    Fecha DATETIME,
    Motivo NVARCHAR(100),
    FOREIGN KEY (MascotaID) REFERENCES Mascota3FN(ID)
);
GO



-- BD60: Universidad con profesores, asignaturas y horarios
-- Enunciado: Una universidad administra profesores, 
-- asignaturas y los horarios en que se imparten.

IF DB_ID('BD60_Universidad') IS NOT NULL
    DROP DATABASE BD60_Universidad;
GO
CREATE DATABASE BD60_Universidad;
GO
USE BD60_Universidad;
GO

CREATE TABLE Profesor3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50),
    Departamento NVARCHAR(50)
);

CREATE TABLE Asignatura3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(100),
    Creditos INT
);

CREATE TABLE Horario3FN (
    ID INT PRIMARY KEY,
    ProfesorID INT,
    AsignaturaID INT,
    Dia NVARCHAR(20),
    HoraInicio TIME,
    HoraFin TIME,
    FOREIGN KEY (ProfesorID) REFERENCES Profesor3FN(ID),
    FOREIGN KEY (AsignaturaID) REFERENCES Asignatura3FN(ID)
);
GO
