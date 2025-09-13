/* 
   BD21 - Biblioteca Digital
   Enunciado: Registrar usuarios, libros digitales y descargas.
    */
USE master;
GO
IF DB_ID('BD21_BibliotecaDigital') IS NOT NULL
BEGIN
    ALTER DATABASE BD21_BibliotecaDigital SET SINGLE_USER WITH ROLLBACK IMMEDIATE;
    DROP DATABASE BD21_BibliotecaDigital;
END
GO
CREATE DATABASE BD21_BibliotecaDigital;
GO
USE BD21_BibliotecaDigital;
GO

-- 1FN
CREATE TABLE Descarga1FN (
    ID INT PRIMARY KEY,
    UsuarioNombre NVARCHAR(50),
    UsuarioEmail NVARCHAR(50),
    Libro1 NVARCHAR(100),
    Libro2 NVARCHAR(100),
    Fecha DATE
);

-- 2FN
CREATE TABLE Usuario2FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50),
    Email NVARCHAR(50)
);
CREATE TABLE Libro2FN (
    ISBN CHAR(13) PRIMARY KEY,
    Titulo NVARCHAR(100),
    Autor NVARCHAR(50)
);
CREATE TABLE Descarga2FN (
    ID INT PRIMARY KEY,
    ID_Usuario INT,
    ISBN CHAR(13),
    Fecha DATE,
    FOREIGN KEY (ID_Usuario) REFERENCES Usuario2FN(ID),
    FOREIGN KEY (ISBN) REFERENCES Libro2FN(ISBN)
);

-- 3FN
CREATE TABLE Usuario3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50),
    Email NVARCHAR(50)
);
CREATE TABLE Libro3FN (
    ISBN CHAR(13) PRIMARY KEY,
    Titulo NVARCHAR(100),
    Autor NVARCHAR(50)
);
CREATE TABLE Descarga3FN (
    ID INT PRIMARY KEY,
    ID_Usuario INT,
    ISBN CHAR(13),
    Fecha DATE,
    FOREIGN KEY (ID_Usuario) REFERENCES Usuario3FN(ID),
    FOREIGN KEY (ISBN) REFERENCES Libro3FN(ISBN)
);


/* 
   BD22 - Transporte Público
  */
USE master;
GO
IF DB_ID('BD22_TransportePublico') IS NOT NULL
BEGIN
    ALTER DATABASE BD22_TransportePublico SET SINGLE_USER WITH ROLLBACK IMMEDIATE;
    DROP DATABASE BD22_TransportePublico;
END
GO
CREATE DATABASE BD22_TransportePublico;
GO
USE BD22_TransportePublico;
GO

-- 1FN
CREATE TABLE Viaje1FN (
    ID INT PRIMARY KEY,
    PasajeroNombre NVARCHAR(50),
    BusPlaca NVARCHAR(20),
    BusRuta NVARCHAR(50),
    Fecha DATE,
    Hora NVARCHAR(10)
);

-- 2FN
CREATE TABLE Pasajero2FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50)
);
CREATE TABLE Bus2FN (
    Placa NVARCHAR(20) PRIMARY KEY,
    Ruta NVARCHAR(50)
);
CREATE TABLE Viaje2FN (
    ID INT PRIMARY KEY,
    ID_Pasajero INT,
    Placa NVARCHAR(20),
    Fecha DATE,
    Hora NVARCHAR(10),
    FOREIGN KEY (ID_Pasajero) REFERENCES Pasajero2FN(ID),
    FOREIGN KEY (Placa) REFERENCES Bus2FN(Placa)
);

-- 3FN
CREATE TABLE Pasajero3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50)
);
CREATE TABLE Bus3FN (
    Placa NVARCHAR(20) PRIMARY KEY,
    Ruta NVARCHAR(50)
);
CREATE TABLE Viaje3FN (
    ID INT PRIMARY KEY,
    ID_Pasajero INT,
    Placa NVARCHAR(20),
    Fecha DATE,
    Hora NVARCHAR(10),
    FOREIGN KEY (ID_Pasajero) REFERENCES Pasajero3FN(ID),
    FOREIGN KEY (Placa) REFERENCES Bus3FN(Placa)
);


/* 
   BD23 - Cine
    */
USE master;
GO
IF DB_ID('BD23_Cine') IS NOT NULL
BEGIN
    ALTER DATABASE BD23_Cine SET SINGLE_USER WITH ROLLBACK IMMEDIATE;
    DROP DATABASE BD23_Cine;
END
GO
CREATE DATABASE BD23_Cine;
GO
USE BD23_Cine;
GO

-- 1FN
CREATE TABLE Boleto1FN (
    ID INT PRIMARY KEY,
    ClienteNombre NVARCHAR(50),
    Pelicula1 NVARCHAR(100),
    Pelicula2 NVARCHAR(100),
    Fecha DATE
);

-- 2FN
CREATE TABLE Cliente2FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50)
);
CREATE TABLE Pelicula2FN (
    ID INT PRIMARY KEY,
    Titulo NVARCHAR(100),
    Genero NVARCHAR(50)
);
CREATE TABLE Boleto2FN (
    ID INT PRIMARY KEY,
    ID_Cliente INT,
    ID_Pelicula INT,
    Fecha DATE,
    FOREIGN KEY (ID_Cliente) REFERENCES Cliente2FN(ID),
    FOREIGN KEY (ID_Pelicula) REFERENCES Pelicula2FN(ID)
);

-- 3FN
CREATE TABLE Cliente3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50)
);
CREATE TABLE Pelicula3FN (
    ID INT PRIMARY KEY,
    Titulo NVARCHAR(100),
    Genero NVARCHAR(50)
);
CREATE TABLE Boleto3FN (
    ID INT PRIMARY KEY,
    ID_Cliente INT,
    ID_Pelicula INT,
    Fecha DATE,
    FOREIGN KEY (ID_Cliente) REFERENCES Cliente3FN(ID),
    FOREIGN KEY (ID_Pelicula) REFERENCES Pelicula3FN(ID)
);


/* 
   BD24 - Hotel
    */
USE master;
GO
IF DB_ID('BD24_Hotel') IS NOT NULL
BEGIN
    ALTER DATABASE BD24_Hotel SET SINGLE_USER WITH ROLLBACK IMMEDIATE;
    DROP DATABASE BD24_Hotel;
END
GO
CREATE DATABASE BD24_Hotel;
GO
USE BD24_Hotel;
GO

-- 1FN
CREATE TABLE Reserva1FN (
    ID INT PRIMARY KEY,
    HuespedNombre NVARCHAR(50),
    HuespedEmail NVARCHAR(50),
    Habitacion1 NVARCHAR(10),
    Habitacion2 NVARCHAR(10),
    FechaInicio DATE,
    FechaFin DATE
);

-- 2FN
CREATE TABLE Huesped2FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50),
    Email NVARCHAR(50)
);
CREATE TABLE Habitacion2FN (
    Numero NVARCHAR(10) PRIMARY KEY,
    Tipo NVARCHAR(50),
    Precio DECIMAL(10,2)
);
CREATE TABLE Reserva2FN (
    ID INT PRIMARY KEY,
    ID_Huesped INT,
    Numero NVARCHAR(10),
    FechaInicio DATE,
    FechaFin DATE,
    FOREIGN KEY (ID_Huesped) REFERENCES Huesped2FN(ID),
    FOREIGN KEY (Numero) REFERENCES Habitacion2FN(Numero)
);

-- 3FN
CREATE TABLE Huesped3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50),
    Email NVARCHAR(50)
);
CREATE TABLE Habitacion3FN (
    Numero NVARCHAR(10) PRIMARY KEY,
    Tipo NVARCHAR(50),
    Precio DECIMAL(10,2)
);
CREATE TABLE Reserva3FN (
    ID INT PRIMARY KEY,
    ID_Huesped INT,
    Numero NVARCHAR(10),
    FechaInicio DATE,
    FechaFin DATE,
    FOREIGN KEY (ID_Huesped) REFERENCES Huesped3FN(ID),
    FOREIGN KEY (Numero) REFERENCES Habitacion3FN(Numero)
);


/* 
   BD25 - Tienda Online
    */
USE master;
GO
IF DB_ID('BD25_TiendaOnline') IS NOT NULL
BEGIN
    ALTER DATABASE BD25_TiendaOnline SET SINGLE_USER WITH ROLLBACK IMMEDIATE;
    DROP DATABASE BD25_TiendaOnline;
END
GO
CREATE DATABASE BD25_TiendaOnline;
GO
USE BD25_TiendaOnline;
GO

-- 1FN
CREATE TABLE Pedido1FN (
    ID INT PRIMARY KEY,
    UsuarioNombre NVARCHAR(50),
    Producto1 NVARCHAR(100),
    Producto2 NVARCHAR(100),
    Fecha DATE
);

-- 2FN
CREATE TABLE Usuario2FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50)
);
CREATE TABLE Producto2FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(100),
    Precio DECIMAL(10,2)
);
CREATE TABLE Pedido2FN (
    ID INT PRIMARY KEY,
    ID_Usuario INT,
    ID_Producto INT,
    Fecha DATE,
    Cantidad INT,
    FOREIGN KEY (ID_Usuario) REFERENCES Usuario2FN(ID),
    FOREIGN KEY (ID_Producto) REFERENCES Producto2FN(ID)
);

-- 3FN
CREATE TABLE Usuario3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50)
);
CREATE TABLE Producto3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(100),
    Precio DECIMAL(10,2)
);
CREATE TABLE Pedido3FN (
    ID INT PRIMARY KEY,
    ID_Usuario INT,
    ID_Producto INT,
    Fecha DATE,
    Cantidad INT,
    FOREIGN KEY (ID_Usuario) REFERENCES Usuario3FN(ID),
    FOREIGN KEY (ID_Producto) REFERENCES Producto3FN(ID)
);


/* 
   BD26 - Taller Mecánico
    */
USE master;
GO
IF DB_ID('BD26_TallerMecanico') IS NOT NULL
BEGIN
    ALTER DATABASE BD26_TallerMecanico SET SINGLE_USER WITH ROLLBACK IMMEDIATE;
    DROP DATABASE BD26_TallerMecanico;
END
GO
CREATE DATABASE BD26_TallerMecanico;
GO
USE BD26_TallerMecanico;
GO

-- 1FN
CREATE TABLE Reparacion1FN (
    ID INT PRIMARY KEY,
    ClienteNombre NVARCHAR(50),
    AutoPlaca NVARCHAR(20),
    AutoModelo NVARCHAR(50),
    Servicio1 NVARCHAR(50),
    Servicio2 NVARCHAR(50),
    Fecha DATE
);

-- 2FN
CREATE TABLE Cliente2FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50)
);
CREATE TABLE Auto2FN (
    Placa NVARCHAR(20) PRIMARY KEY,
    Modelo NVARCHAR(50)
);
CREATE TABLE Reparacion2FN (
    ID INT PRIMARY KEY,
    ID_Cliente INT,
    Placa NVARCHAR(20),
    Servicio NVARCHAR(50),
    Fecha DATE,
    FOREIGN KEY (ID_Cliente) REFERENCES Cliente2FN(ID),
    FOREIGN KEY (Placa) REFERENCES Auto2FN(Placa)
);

-- 3FN
CREATE TABLE Cliente3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50)
);
CREATE TABLE Auto3FN (
    Placa NVARCHAR(20) PRIMARY KEY,
    Modelo NVARCHAR(50)
);
CREATE TABLE Reparacion3FN (
    ID INT PRIMARY KEY,
    ID_Cliente INT,
    Placa NVARCHAR(20),
    Servicio NVARCHAR(50),
    Fecha DATE,
    FOREIGN KEY (ID_Cliente) REFERENCES Cliente3FN(ID),
    FOREIGN KEY (Placa) REFERENCES Auto3FN(Placa)
);


/* 
   BD27 - Restaurante
    */
USE master;
GO
IF DB_ID('BD27_Restaurante') IS NOT NULL
BEGIN
    ALTER DATABASE BD27_Restaurante SET SINGLE_USER WITH ROLLBACK IMMEDIATE;
    DROP DATABASE BD27_Restaurante;
END
GO
CREATE DATABASE BD27_Restaurante;
GO
USE BD27_Restaurante;
GO

-- 1FN
CREATE TABLE Pedido1FN (
    ID INT PRIMARY KEY,
    ClienteNombre NVARCHAR(50),
    Plato1 NVARCHAR(50),
    Plato2 NVARCHAR(50),
    Fecha DATE
);

-- 2FN
CREATE TABLE Cliente2FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50)
);
CREATE TABLE Plato2FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50),
    Precio DECIMAL(10,2)
);
CREATE TABLE Pedido2FN (
    ID INT PRIMARY KEY,
    ID_Cliente INT,
    ID_Plato INT,
    Fecha DATE,
    Cantidad INT,
    FOREIGN KEY (ID_Cliente) REFERENCES Cliente2FN(ID),
    FOREIGN KEY (ID_Plato) REFERENCES Plato2FN(ID)
);

-- 3FN
CREATE TABLE Cliente3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50)
);
CREATE TABLE Plato3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50),
    Precio DECIMAL(10,2)
);
CREATE TABLE Pedido3FN (
    ID INT PRIMARY KEY,
    ID_Cliente INT,
    ID_Plato INT,
    Fecha DATE,
    Cantidad INT,
    FOREIGN KEY (ID_Cliente) REFERENCES Cliente3FN(ID),
    FOREIGN KEY (ID_Plato) REFERENCES Plato3FN(ID)
);


/* 
   BD28 - Biblioteca Escolar
    */
USE master;
GO
IF DB_ID('BD28_BibliotecaEscolar') IS NOT NULL
BEGIN
    ALTER DATABASE BD28_BibliotecaEscolar SET SINGLE_USER WITH ROLLBACK IMMEDIATE;
    DROP DATABASE BD28_BibliotecaEscolar;
END
GO
CREATE DATABASE BD28_BibliotecaEscolar;
GO
USE BD28_BibliotecaEscolar;
GO

-- 1FN
CREATE TABLE Prestamo1FN (
    ID INT PRIMARY KEY,
    EstudianteNombre NVARCHAR(50),
    Libro1 NVARCHAR(100),
    Libro2 NVARCHAR(100),
    FechaPrestamo DATE
);

-- 2FN
CREATE TABLE Estudiante2FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50)
);
CREATE TABLE Libro2FN (
    ID INT PRIMARY KEY,
    Titulo NVARCHAR(100),
    Autor NVARCHAR(50)
);
CREATE TABLE Prestamo2FN (
    ID INT PRIMARY KEY,
    ID_Estudiante INT,
    ID_Libro INT,
    FechaPrestamo DATE,
    FOREIGN KEY (ID_Estudiante) REFERENCES Estudiante2FN(ID),
    FOREIGN KEY (ID_Libro) REFERENCES Libro2FN(ID)
);

-- 3FN
CREATE TABLE Estudiante3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50)
);
CREATE TABLE Libro3FN (
    ID INT PRIMARY KEY,
    Titulo NVARCHAR(100),
    Autor NVARCHAR(50)
);
CREATE TABLE Prestamo3FN (
    ID INT PRIMARY KEY,
    ID_Estudiante INT,
    ID_Libro INT,
    FechaPrestamo DATE,
    FOREIGN KEY (ID_Estudiante) REFERENCES Estudiante3FN(ID),
    FOREIGN KEY (ID_Libro) REFERENCES Libro3FN(ID)
);


/* 
   BD29 - Aerolínea
    */
USE master;
GO
IF DB_ID('BD29_Aerolinea') IS NOT NULL
BEGIN
    ALTER DATABASE BD29_Aerolinea SET SINGLE_USER WITH ROLLBACK IMMEDIATE;
    DROP DATABASE BD29_Aerolinea;
END
GO
CREATE DATABASE BD29_Aerolinea;
GO
USE BD29_Aerolinea;
GO

-- 1FN
CREATE TABLE Vuelo1FN (
    ID INT PRIMARY KEY,
    PasajeroNombre NVARCHAR(50),
    Vuelo NVARCHAR(20),
    Origen NVARCHAR(50),
    Destino NVARCHAR(50),
    Fecha DATE
);

-- 2FN
CREATE TABLE Pasajero2FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50)
);
CREATE TABLE Vuelo2FN (
    Codigo NVARCHAR(20) PRIMARY KEY,
    Origen NVARCHAR(50),
    Destino NVARCHAR(50)
);
CREATE TABLE Reserva2FN (
    ID INT PRIMARY KEY,
    ID_Pasajero INT,
    Codigo NVARCHAR(20),
    Fecha DATE,
    FOREIGN KEY (ID_Pasajero) REFERENCES Pasajero2FN(ID),
    FOREIGN KEY (Codigo) REFERENCES Vuelo2FN(Codigo)
);

-- 3FN
CREATE TABLE Pasajero3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50)
);
CREATE TABLE Vuelo3FN (
    Codigo NVARCHAR(20) PRIMARY KEY,
    Origen NVARCHAR(50),
    Destino NVARCHAR(50)
);
CREATE TABLE Reserva3FN (
    ID INT PRIMARY KEY,
    ID_Pasajero INT,
    Codigo NVARCHAR(20),
    Fecha DATE,
    FOREIGN KEY (ID_Pasajero) REFERENCES Pasajero3FN(ID),
    FOREIGN KEY (Codigo) REFERENCES Vuelo3FN(Codigo)
);


/* 
   BD30 - Clínica Veterinaria
    */
USE master;
GO
IF DB_ID('BD30_Veterinaria') IS NOT NULL
BEGIN
    ALTER DATABASE BD30_Veterinaria SET SINGLE_USER WITH ROLLBACK IMMEDIATE;
    DROP DATABASE BD30_Veterinaria;
END
GO
CREATE DATABASE BD30_Veterinaria;
GO
USE BD30_Veterinaria;
GO

-- 1FN
CREATE TABLE Consulta1FN (
    ID INT PRIMARY KEY,
    DuenoNombre NVARCHAR(50),
    MascotaNombre NVARCHAR(50),
    MascotaEspecie NVARCHAR(50),
    Servicio1 NVARCHAR(50),
    Servicio2 NVARCHAR(50),
    Fecha DATE
);

-- 2FN
CREATE TABLE Dueno2FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50)
);
CREATE TABLE Mascota2FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50),
    Especie NVARCHAR(50)
);
CREATE TABLE Consulta2FN (
    ID INT PRIMARY KEY,
    ID_Dueno INT,
    ID_Mascota INT,
    Servicio NVARCHAR(50),
    Fecha DATE,
    FOREIGN KEY (ID_Dueno) REFERENCES Dueno2FN(ID),
    FOREIGN KEY (ID_Mascota) REFERENCES Mascota2FN(ID)
);

-- 3FN
CREATE TABLE Dueno3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50)
);
CREATE TABLE Mascota3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50),
    Especie NVARCHAR(50)
);
CREATE TABLE Consulta3FN (
    ID INT PRIMARY KEY,
    ID_Dueno INT,
    ID_Mascota INT,
    Servicio NVARCHAR(50),
    Fecha DATE,
    FOREIGN KEY (ID_Dueno) REFERENCES Dueno3FN(ID),
    FOREIGN KEY (ID_Mascota) REFERENCES Mascota3FN(ID)
);
