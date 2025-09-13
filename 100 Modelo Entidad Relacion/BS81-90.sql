
-- BD81: Farmacia con medicamentos, clientes y recetas
-- Enunciado: Una farmacia gestiona clientes, medicamentos y 
-- las recetas médicas con los medicamentos recetados.

IF DB_ID('BD81_Farmacia') IS NOT NULL
    DROP DATABASE BD81_Farmacia;
GO
CREATE DATABASE BD81_Farmacia;
GO
USE BD81_Farmacia;
GO

CREATE TABLE Cliente3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50)
);

CREATE TABLE Medicamento3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50),
    Precio DECIMAL(10,2)
);

CREATE TABLE Receta3FN (
    ID INT PRIMARY KEY,
    ClienteID INT,
    Fecha DATE,
    FOREIGN KEY (ClienteID) REFERENCES Cliente3FN(ID)
);

CREATE TABLE DetalleReceta3FN (
    RecetaID INT,
    MedicamentoID INT,
    Cantidad INT,
    PRIMARY KEY (RecetaID, MedicamentoID),
    FOREIGN KEY (RecetaID) REFERENCES Receta3FN(ID),
    FOREIGN KEY (MedicamentoID) REFERENCES Medicamento3FN(ID)
);
GO



-- BD82: Banco con clientes, cuentas y transacciones
-- Enunciado: Un banco administra clientes, sus cuentas y 
-- las transacciones realizadas.

IF DB_ID('BD82_Banco') IS NOT NULL
    DROP DATABASE BD82_Banco;
GO
CREATE DATABASE BD82_Banco;
GO
USE BD82_Banco;
GO

CREATE TABLE Cliente3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50)
);

CREATE TABLE Cuenta3FN (
    ID INT PRIMARY KEY,
    NumeroCuenta NVARCHAR(20),
    Tipo NVARCHAR(20),
    Saldo DECIMAL(18,2),
    ClienteID INT,
    FOREIGN KEY (ClienteID) REFERENCES Cliente3FN(ID)
);

CREATE TABLE Transaccion3FN (
    ID INT PRIMARY KEY,
    CuentaID INT,
    Fecha DATETIME,
    Monto DECIMAL(18,2),
    Tipo NVARCHAR(20),
    FOREIGN KEY (CuentaID) REFERENCES Cuenta3FN(ID)
);
GO



-- BD83: Supermercado con productos, proveedores y ventas
-- Enunciado: Un supermercado gestiona productos, proveedores 
-- y ventas a clientes.

IF DB_ID('BD83_Supermercado') IS NOT NULL
    DROP DATABASE BD83_Supermercado;
GO
CREATE DATABASE BD83_Supermercado;
GO
USE BD83_Supermercado;
GO

CREATE TABLE Proveedor3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50)
);

CREATE TABLE Producto3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50),
    Precio DECIMAL(10,2),
    ProveedorID INT,
    FOREIGN KEY (ProveedorID) REFERENCES Proveedor3FN(ID)
);

CREATE TABLE Cliente3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50)
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



-- BD84: Universidad con estudiantes, cursos y matrículas
-- Enunciado: Una universidad gestiona estudiantes, cursos y 
-- matrículas de estudiantes en cursos.

IF DB_ID('BD84_Universidad') IS NOT NULL
    DROP DATABASE BD84_Universidad;
GO
CREATE DATABASE BD84_Universidad;
GO
USE BD84_Universidad;
GO

CREATE TABLE Estudiante3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50)
);

CREATE TABLE Curso3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(100),
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



-- BD85: Hotel con clientes, habitaciones y reservas
-- Enunciado: Un hotel gestiona clientes, habitaciones y las 
-- reservas realizadas.

IF DB_ID('BD85_Hotel') IS NOT NULL
    DROP DATABASE BD85_Hotel;
GO
CREATE DATABASE BD85_Hotel;
GO
USE BD85_Hotel;
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



-- BD86: Gimnasio con socios, entrenadores y rutinas
-- Enunciado: Un gimnasio gestiona socios, entrenadores y 
-- rutinas asignadas.

IF DB_ID('BD86_Gimnasio') IS NOT NULL
    DROP DATABASE BD86_Gimnasio;
GO
CREATE DATABASE BD86_Gimnasio;
GO
USE BD86_Gimnasio;
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



-- BD87: Clínica Veterinaria con mascotas, dueños y citas
-- Enunciado: Una clínica veterinaria gestiona mascotas, sus 
-- dueños y las citas veterinarias
------------------------------------------------------------
IF DB_ID('BD87_Veterinaria') IS NOT NULL
    DROP DATABASE BD87_Veterinaria;
GO
CREATE DATABASE BD87_Veterinaria;
GO
USE BD87_Veterinaria;
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



-- BD88: Museo con obras, artistas y exposiciones
-- Enunciado: Un museo organiza artistas, obras y exposiciones.

IF DB_ID('BD88_Museo') IS NOT NULL
    DROP DATABASE BD88_Museo;
GO
CREATE DATABASE BD88_Museo;
GO
USE BD88_Museo;
GO

CREATE TABLE Artista3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50)
);

CREATE TABLE Obra3FN (
    ID INT PRIMARY KEY,
    Titulo NVARCHAR(100),
    ArtistaID INT,
    FOREIGN KEY (ArtistaID) REFERENCES Artista3FN(ID)
);

CREATE TABLE Exposicion3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(100),
    FechaInicio DATE,
    FechaFin DATE
);

CREATE TABLE ObraExposicion3FN (
    ObraID INT,
    ExposicionID INT,
    PRIMARY KEY (ObraID, ExposicionID),
    FOREIGN KEY (ObraID) REFERENCES Obra3FN(ID),
    FOREIGN KEY (ExposicionID) REFERENCES Exposicion3FN(ID)
);
GO

-- BD89: Plataforma de Streaming con usuarios y reproducciones
-- Enunciado: Una plataforma gestiona usuarios, películas y 
-- las reproducciones realizadas.

IF DB_ID('BD89_Streaming') IS NOT NULL
    DROP DATABASE BD89_Streaming;
GO
CREATE DATABASE BD89_Streaming;
GO
USE BD89_Streaming;
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



-- BD90: Compañía de Seguros con clientes, pólizas y siniestros
-- Enunciado: Una aseguradora maneja clientes, pólizas y los 
-- siniestros reportados.

IF DB_ID('BD90_Seguros') IS NOT NULL
    DROP DATABASE BD90_Seguros;
GO
CREATE DATABASE BD90_Seguros;
GO
USE BD90_Seguros;
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
