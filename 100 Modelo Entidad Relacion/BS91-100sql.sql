
-- BD91: Biblioteca Digital con usuarios, libros y préstamos
-- Enunciado: Una biblioteca digital gestiona usuarios, libros 
-- y los préstamos realizados.

IF DB_ID('BD91_BibliotecaDigital') IS NOT NULL
    DROP DATABASE BD91_BibliotecaDigital;
GO
CREATE DATABASE BD91_BibliotecaDigital;
GO
USE BD91_BibliotecaDigital;
GO

CREATE TABLE Usuario3FN (
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
    UsuarioID INT,
    LibroID INT,
    FechaPrestamo DATE,
    FechaDevolucion DATE,
    FOREIGN KEY (UsuarioID) REFERENCES Usuario3FN(ID),
    FOREIGN KEY (LibroID) REFERENCES Libro3FN(ID)
);
GO



-- BD92: Empresa de Transporte con buses, conductores y rutas
-- Enunciado: Una empresa de transporte gestiona buses, 
-- conductores y las rutas asignadas.

IF DB_ID('BD92_Transporte') IS NOT NULL
    DROP DATABASE BD92_Transporte;
GO
CREATE DATABASE BD92_Transporte;
GO
USE BD92_Transporte;
GO

CREATE TABLE Conductor3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50)
);

CREATE TABLE Bus3FN (
    ID INT PRIMARY KEY,
    Placa NVARCHAR(10),
    Modelo NVARCHAR(50)
);

CREATE TABLE Ruta3FN (
    ID INT PRIMARY KEY,
    Origen NVARCHAR(50),
    Destino NVARCHAR(50)
);

CREATE TABLE BusRuta3FN (
    BusID INT,
    RutaID INT,
    ConductorID INT,
    PRIMARY KEY (BusID, RutaID),
    FOREIGN KEY (BusID) REFERENCES Bus3FN(ID),
    FOREIGN KEY (RutaID) REFERENCES Ruta3FN(ID),
    FOREIGN KEY (ConductorID) REFERENCES Conductor3FN(ID)
);
GO



-- BD93: Aerolínea con vuelos, pasajeros y boletos
-- Enunciado: Una aerolínea maneja pasajeros, vuelos y los 
-- boletos vendidos.

IF DB_ID('BD93_Aerolinea') IS NOT NULL
    DROP DATABASE BD93_Aerolinea;
GO
CREATE DATABASE BD93_Aerolinea;
GO
USE BD93_Aerolinea;
GO

CREATE TABLE Pasajero3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50)
);

CREATE TABLE Vuelo3FN (
    ID INT PRIMARY KEY,
    Codigo NVARCHAR(20),
    Origen NVARCHAR(50),
    Destino NVARCHAR(50),
    Fecha DATETIME
);

CREATE TABLE Boleto3FN (
    ID INT PRIMARY KEY,
    PasajeroID INT,
    VueloID INT,
    Asiento NVARCHAR(5),
    FOREIGN KEY (PasajeroID) REFERENCES Pasajero3FN(ID),
    FOREIGN KEY (VueloID) REFERENCES Vuelo3FN(ID)
);
GO



-- BD94: Restaurante con clientes, menús y pedidos
-- Enunciado: Un restaurante gestiona clientes, menús y 
-- pedidos realizados.

IF DB_ID('BD94_Restaurante') IS NOT NULL
    DROP DATABASE BD94_Restaurante;
GO
CREATE DATABASE BD94_Restaurante;
GO
USE BD94_Restaurante;
GO

CREATE TABLE Cliente3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50)
);

CREATE TABLE Menu3FN (
    ID INT PRIMARY KEY,
    Plato NVARCHAR(100),
    Precio DECIMAL(10,2)
);

CREATE TABLE Pedido3FN (
    ID INT PRIMARY KEY,
    ClienteID INT,
    Fecha DATE,
    FOREIGN KEY (ClienteID) REFERENCES Cliente3FN(ID)
);

CREATE TABLE DetallePedido3FN (
    PedidoID INT,
    MenuID INT,
    Cantidad INT,
    PRIMARY KEY (PedidoID, MenuID),
    FOREIGN KEY (PedidoID) REFERENCES Pedido3FN(ID),
    FOREIGN KEY (MenuID) REFERENCES Menu3FN(ID)
);
GO



-- BD95: Plataforma de Cursos con instructores y estudiantes
-- Enunciado: Una plataforma de educación maneja estudiantes, 
-- instructores y los cursos inscritos.

IF DB_ID('BD95_Cursos') IS NOT NULL
    DROP DATABASE BD95_Cursos;
GO
CREATE DATABASE BD95_Cursos;
GO
USE BD95_Cursos;
GO

CREATE TABLE Instructor3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50)
);

CREATE TABLE Curso3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(100),
    InstructorID INT,
    FOREIGN KEY (InstructorID) REFERENCES Instructor3FN(ID)
);

CREATE TABLE Estudiante3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50)
);

CREATE TABLE Inscripcion3FN (
    EstudianteID INT,
    CursoID INT,
    PRIMARY KEY (EstudianteID, CursoID),
    FOREIGN KEY (EstudianteID) REFERENCES Estudiante3FN(ID),
    FOREIGN KEY (CursoID) REFERENCES Curso3FN(ID)
);
GO



-- BD96: Tienda Online con usuarios, productos y compras
-- Enunciado: Una tienda online administra usuarios, productos 
-- y las compras realizadas.

IF DB_ID('BD96_TiendaOnline') IS NOT NULL
    DROP DATABASE BD96_TiendaOnline;
GO
CREATE DATABASE BD96_TiendaOnline;
GO
USE BD96_TiendaOnline;
GO

CREATE TABLE Usuario3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50)
);

CREATE TABLE Producto3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(100),
    Precio DECIMAL(10,2)
);

CREATE TABLE Compra3FN (
    ID INT PRIMARY KEY,
    UsuarioID INT,
    Fecha DATE,
    FOREIGN KEY (UsuarioID) REFERENCES Usuario3FN(ID)
);

CREATE TABLE DetalleCompra3FN (
    CompraID INT,
    ProductoID INT,
    Cantidad INT,
    PRIMARY KEY (CompraID, ProductoID),
    FOREIGN KEY (CompraID) REFERENCES Compra3FN(ID),
    FOREIGN KEY (ProductoID) REFERENCES Producto3FN(ID)
);
GO



-- BD97: Hospital con médicos, pacientes y consultas
-- Enunciado: Un hospital administra médicos, pacientes y 
-- consultas médicas.

IF DB_ID('BD97_Hospital') IS NOT NULL
    DROP DATABASE BD97_Hospital;
GO
CREATE DATABASE BD97_Hospital;
GO
USE BD97_Hospital;
GO

CREATE TABLE Medico3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50),
    Especialidad NVARCHAR(50)
);

CREATE TABLE Paciente3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50)
);

CREATE TABLE Consulta3FN (
    ID INT PRIMARY KEY,
    MedicoID INT,
    PacienteID INT,
    Fecha DATETIME,
    Diagnostico NVARCHAR(200),
    FOREIGN KEY (MedicoID) REFERENCES Medico3FN(ID),
    FOREIGN KEY (PacienteID) REFERENCES Paciente3FN(ID)
);
GO



-- BD98: Empresa de Música con artistas, álbumes y canciones
-- Enunciado: Una empresa discográfica gestiona artistas, 
-- álbumes y canciones.

IF DB_ID('BD98_Musica') IS NOT NULL
    DROP DATABASE BD98_Musica;
GO
CREATE DATABASE BD98_Musica;
GO
USE BD98_Musica;
GO

CREATE TABLE Artista3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50)
);

CREATE TABLE Album3FN (
    ID INT PRIMARY KEY,
    Titulo NVARCHAR(100),
    Anio INT,
    ArtistaID INT,
    FOREIGN KEY (ArtistaID) REFERENCES Artista3FN(ID)
);

CREATE TABLE Cancion3FN (
    ID INT PRIMARY KEY,
    Titulo NVARCHAR(100),
    Duracion INT,
    AlbumID INT,
    FOREIGN KEY (AlbumID) REFERENCES Album3FN(ID)
);
GO



-- BD99: Empresa de Logística con envíos y clientes
-- Enunciado: Una empresa de logística maneja clientes y 
-- envíos de paquetes.

IF DB_ID('BD99_Logistica') IS NOT NULL
    DROP DATABASE BD99_Logistica;
GO
CREATE DATABASE BD99_Logistica;
GO
USE BD99_Logistica;
GO

CREATE TABLE Cliente3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50)
);

CREATE TABLE Envio3FN (
    ID INT PRIMARY KEY,
    ClienteID INT,
    Origen NVARCHAR(50),
    Destino NVARCHAR(50),
    Fecha DATE,
    FOREIGN KEY (ClienteID) REFERENCES Cliente3FN(ID)
);
GO



-- BD100: Agencia de Turismo con clientes, destinos y reservas
-- Enunciado: Una agencia de turismo gestiona clientes, 
-- destinos turísticos y las reservas realizadas.


USE master;
GO
IF DB_ID(N'BD100_Turismo') IS NOT NULL
BEGIN
    ALTER DATABASE BD101_Turismo SET SINGLE_USER WITH ROLLBACK IMMEDIATE;
    DROP DATABASE BD101_Turismo;
END
GO

-- Crear la base de datos
CREATE DATABASE BD101_Turismo;
GO
USE BD101_Turismo;
GO

-- Tabla Cliente
CREATE TABLE Cliente3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50),
    Email NVARCHAR(100)
);
GO

-- Tabla Destino
CREATE TABLE Destino3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(100),
    Pais NVARCHAR(50)
);
GO

-- Tabla Reserva
CREATE TABLE Reserva3FN (
    ID INT PRIMARY KEY,
    ClienteID INT NOT NULL,
    DestinoID INT NOT NULL,
    FechaReserva DATE,
    CantidadPersonas INT,
    FOREIGN KEY (ClienteID) REFERENCES Cliente3FN(ID),
    FOREIGN KEY (DestinoID) REFERENCES Destino3FN(ID)
);
GO
