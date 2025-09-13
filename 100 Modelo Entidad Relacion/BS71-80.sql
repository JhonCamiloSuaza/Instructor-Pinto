
-- BD71: Librería con libros, autores y préstamos
-- Enunciado: Una librería administra libros, autores y los 
-- préstamos realizados a los usuarios.

IF DB_ID('BD71_Libreria') IS NOT NULL
    DROP DATABASE BD71_Libreria;
GO
CREATE DATABASE BD71_Libreria;
GO
USE BD71_Libreria;
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



-- BD72: Empresa de Transporte con clientes y viajes
-- Enunciado: Una empresa de transporte registra clientes, 
-- destinos y los viajes realizados.

IF DB_ID('BD72_Transporte') IS NOT NULL
    DROP DATABASE BD72_Transporte;
GO
CREATE DATABASE BD72_Transporte;
GO
USE BD72_Transporte;
GO

CREATE TABLE Cliente3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50)
);

CREATE TABLE Destino3FN (
    ID INT PRIMARY KEY,
    Ciudad NVARCHAR(50),
    Pais NVARCHAR(50)
);

CREATE TABLE Transporte3FN (
    ID INT PRIMARY KEY,
    Tipo NVARCHAR(50)
);

CREATE TABLE Viaje3FN (
    ID INT PRIMARY KEY,
    ClienteID INT,
    DestinoID INT,
    TransporteID INT,
    Fecha DATE,
    FOREIGN KEY (ClienteID) REFERENCES Cliente3FN(ID),
    FOREIGN KEY (DestinoID) REFERENCES Destino3FN(ID),
    FOREIGN KEY (TransporteID) REFERENCES Transporte3FN(ID)
);
GO



-- BD73: Tienda de Electrónica con productos y ventas
-- Enunciado: Una tienda de electrónica registra productos, 
-- clientes y ventas realizadas.

IF DB_ID('BD73_Electronica') IS NOT NULL
    DROP DATABASE BD73_Electronica;
GO
CREATE DATABASE BD73_Electronica;
GO
USE BD73_Electronica;
GO

CREATE TABLE Cliente3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50)
);

CREATE TABLE Producto3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50),
    Precio DECIMAL(10,2)
);

CREATE TABLE Venta3FN (
    ID INT PRIMARY KEY,
    ClienteID INT,
    ProductoID INT,
    Fecha DATE,
    Cantidad INT,
    FOREIGN KEY (ClienteID) REFERENCES Cliente3FN(ID),
    FOREIGN KEY (ProductoID) REFERENCES Producto3FN(ID)
);
GO



-- BD74: Colegio con estudiantes, cursos y matrículas
-- Enunciado: Un colegio administra estudiantes, cursos y 
-- las matrículas de estudiantes en cursos.

IF DB_ID('BD74_Colegio') IS NOT NULL
    DROP DATABASE BD74_Colegio;
GO
CREATE DATABASE BD74_Colegio;
GO
USE BD74_Colegio;
GO

CREATE TABLE Estudiante3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50)
);

CREATE TABLE Curso3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50),
    Creditos INT
);

CREATE TABLE Matricula3FN (
    EstudianteID INT,
    CursoID INT,
    PRIMARY KEY (EstudianteID, CursoID),
    FOREIGN KEY (EstudianteID) REFERENCES Estudiante3FN(ID),
    FOREIGN KEY (CursoID) REFERENCES Curso3FN(ID)
);
GO



-- BD75: Hotel con clientes, habitaciones y reservas
-- Enunciado: Un hotel gestiona clientes, habitaciones y las 
-- reservas que realizan.

IF DB_ID('BD75_Hotel') IS NOT NULL
    DROP DATABASE BD75_Hotel;
GO
CREATE DATABASE BD75_Hotel;
GO
USE BD75_Hotel;
GO

CREATE TABLE Cliente3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50)
);

CREATE TABLE Habitacion3FN (
    ID INT PRIMARY KEY,
    Numero INT,
    Tipo NVARCHAR(50)
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



-- BD76: Gimnasio con socios, entrenadores y rutinas
-- Enunciado: Un gimnasio registra socios, entrenadores y 
-- rutinas asignadas a los socios.

IF DB_ID('BD76_Gimnasio') IS NOT NULL
    DROP DATABASE BD76_Gimnasio;
GO
CREATE DATABASE BD76_Gimnasio;
GO
USE BD76_Gimnasio;
GO

CREATE TABLE Socio3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50)
);

CREATE TABLE Entrenador3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50)
);

CREATE TABLE Rutina3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50),
    EntrenadorID INT,
    FOREIGN KEY (EntrenadorID) REFERENCES Entrenador3FN(ID)
);

CREATE TABLE SocioRutina3FN (
    SocioID INT,
    RutinaID INT,
    PRIMARY KEY (SocioID, RutinaID),
    FOREIGN KEY (SocioID) REFERENCES Socio3FN(ID),
    FOREIGN KEY (RutinaID) REFERENCES Rutina3FN(ID)
);
GO



-- BD77: Veterinaria con mascotas, dueños y citas
-- Enunciado: Una clínica veterinaria gestiona mascotas, sus 
-- dueños y las citas veterinarias.

IF DB_ID('BD77_Veterinaria') IS NOT NULL
    DROP DATABASE BD77_Veterinaria;
GO
CREATE DATABASE BD77_Veterinaria;
GO
USE BD77_Veterinaria;
GO

CREATE TABLE Dueno3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50)
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



-- BD78: Empresa de Seguros con clientes, pólizas y siniestros
-- Enunciado: Una aseguradora maneja clientes, pólizas y 
-- los siniestros que ocurren.

IF DB_ID('BD78_Seguros') IS NOT NULL
    DROP DATABASE BD78_Seguros;
GO
CREATE DATABASE BD78_Seguros;
GO
USE BD78_Seguros;
GO

CREATE TABLE Cliente3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50)
);

CREATE TABLE Poliza3FN (
    ID INT PRIMARY KEY,
    Numero NVARCHAR(20),
    Tipo NVARCHAR(50),
    ClienteID INT,
    FOREIGN KEY (ClienteID) REFERENCES Cliente3FN(ID)
);

CREATE TABLE Siniestro3FN (
    ID INT PRIMARY KEY,
    PolizaID INT,
    Fecha DATE,
    Descripcion NVARCHAR(200),
    FOREIGN KEY (PolizaID) REFERENCES Poliza3FN(ID)
);
GO



-- BD79: Plataforma de Streaming con usuarios y películas
-- Enunciado: Una plataforma gestiona usuarios, películas y 
-- las reproducciones realizadas.

IF DB_ID('BD79_Streaming') IS NOT NULL
    DROP DATABASE BD79_Streaming;
GO
CREATE DATABASE BD79_Streaming;
GO
USE BD79_Streaming;
GO

CREATE TABLE Usuario3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50)
);

CREATE TABLE Pelicula3FN (
    ID INT PRIMARY KEY,
    Titulo NVARCHAR(100),
    Genero NVARCHAR(50)
);

CREATE TABLE Reproduccion3FN (
    ID INT PRIMARY KEY,
    UsuarioID INT,
    PeliculaID INT,
    Fecha DATETIME,
    FOREIGN KEY (UsuarioID) REFERENCES Usuario3FN(ID),
    FOREIGN KEY (PeliculaID) REFERENCES Pelicula3FN(ID)
);
GO



-- BD80: Restaurante con clientes, mesas y reservas
-- Enunciado: Un restaurante gestiona clientes, mesas y las 
-- reservas realizadas por los clientes.

IF DB_ID('BD80_Restaurante') IS NOT NULL
    DROP DATABASE BD80_Restaurante;
GO
CREATE DATABASE BD80_Restaurante;
GO
USE BD80_Restaurante;
GO

CREATE TABLE Cliente3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50)
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
