
-- BD61: Banco con clientes, cuentas y transacciones
-- Enunciado: Un banco administra clientes, sus cuentas y 
-- las transacciones realizadas.

IF DB_ID('BD61_Banco') IS NOT NULL
    DROP DATABASE BD61_Banco;
GO
CREATE DATABASE BD61_Banco;
GO
USE BD61_Banco;
GO

CREATE TABLE Cliente3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50),
    Documento NVARCHAR(20)
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



-- BD62: Supermercado con productos, proveedores y ventas
-- Enunciado: Un supermercado gestiona productos, 
-- proveedores y ventas a clientes.

IF DB_ID('BD62_Supermercado') IS NOT NULL
    DROP DATABASE BD62_Supermercado;
GO
CREATE DATABASE BD62_Supermercado;
GO
USE BD62_Supermercado;
GO

CREATE TABLE Proveedor3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50),
    Telefono NVARCHAR(20)
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



-- BD63: Editorial con autores, libros y publicaciones
-- Enunciado: Una editorial gestiona autores, libros y sus 
-- publicaciones.

IF DB_ID('BD63_Editorial') IS NOT NULL
    DROP DATABASE BD63_Editorial;
GO
CREATE DATABASE BD63_Editorial;
GO
USE BD63_Editorial;
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

CREATE TABLE Publicacion3FN (
    ID INT PRIMARY KEY,
    LibroISBN CHAR(13),
    Fecha DATE,
    Tiraje INT,
    FOREIGN KEY (LibroISBN) REFERENCES Libro3FN(ISBN)
);
GO



-- BD64: Farmacia con medicamentos, clientes y recetas
-- Enunciado: Una farmacia vende medicamentos a clientes y 
-- gestiona las recetas médicas.

IF DB_ID('BD64_Farmacia') IS NOT NULL
    DROP DATABASE BD64_Farmacia;
GO
CREATE DATABASE BD64_Farmacia;
GO
USE BD64_Farmacia;
GO

CREATE TABLE Medicamento3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50),
    Precio DECIMAL(10,2)
);

CREATE TABLE Cliente3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50)
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



-- BD65: Colegio con estudiantes, profesores y asignaturas
-- Enunciado: Un colegio administra estudiantes, profesores 
-- y las asignaturas que se dictan.

IF DB_ID('BD65_Colegio') IS NOT NULL
    DROP DATABASE BD65_Colegio;
GO
CREATE DATABASE BD65_Colegio;
GO
USE BD65_Colegio;
GO

CREATE TABLE Profesor3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50)
);

CREATE TABLE Asignatura3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50),
    ProfesorID INT,
    FOREIGN KEY (ProfesorID) REFERENCES Profesor3FN(ID)
);

CREATE TABLE Estudiante3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50),
    Grado NVARCHAR(20)
);

CREATE TABLE Matricula3FN (
    EstudianteID INT,
    AsignaturaID INT,
    PRIMARY KEY (EstudianteID, AsignaturaID),
    FOREIGN KEY (EstudianteID) REFERENCES Estudiante3FN(ID),
    FOREIGN KEY (AsignaturaID) REFERENCES Asignatura3FN(ID)
);
GO



-- BD66: Empresa de Envíos con paquetes, clientes y envíos
-- Enunciado: Una empresa gestiona clientes, paquetes y los 
-- envíos realizados.

IF DB_ID('BD66_Envios') IS NOT NULL
    DROP DATABASE BD66_Envios;
GO
CREATE DATABASE BD66_Envios;
GO
USE BD66_Envios;
GO

CREATE TABLE Cliente3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50)
);

CREATE TABLE Paquete3FN (
    ID INT PRIMARY KEY,
    Descripcion NVARCHAR(100),
    Peso DECIMAL(10,2)
);

CREATE TABLE Envio3FN (
    ID INT PRIMARY KEY,
    ClienteID INT,
    PaqueteID INT,
    Origen NVARCHAR(50),
    Destino NVARCHAR(50),
    Fecha DATE,
    FOREIGN KEY (ClienteID) REFERENCES Cliente3FN(ID),
    FOREIGN KEY (PaqueteID) REFERENCES Paquete3FN(ID)
);
GO



-- BD67: Museo con obras, artistas y exposiciones
-- Enunciado: Un museo organiza artistas, obras y exposiciones.

IF DB_ID('BD67_Museo') IS NOT NULL
    DROP DATABASE BD67_Museo;
GO
CREATE DATABASE BD67_Museo;
GO
USE BD67_Museo;
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



-- BD68: Compañía de Seguros con clientes, pólizas y siniestros
-- Enunciado: Una aseguradora maneja clientes, pólizas y 
-- siniestros registrados.

IF DB_ID('BD68_Seguros') IS NOT NULL
    DROP DATABASE BD68_Seguros;
GO
CREATE DATABASE BD68_Seguros;
GO
USE BD68_Seguros;
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



-- BD69: Plataforma de Streaming con usuarios, películas y reproducciones
-- Enunciado: Una plataforma gestiona usuarios, películas y 
-- las reproducciones hechas.

IF DB_ID('BD69_Streaming') IS NOT NULL
    DROP DATABASE BD69_Streaming;
GO
CREATE DATABASE BD69_Streaming;
GO
USE BD69_Streaming;
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



-- BD70: Gimnasio con socios, entrenadores y rutinas
-- Enunciado: Un gimnasio administra sus socios, entrenadores 
-- y rutinas de entrenamiento.

IF DB_ID('BD70_Gimnasio') IS NOT NULL
    DROP DATABASE BD70_Gimnasio;
GO
CREATE DATABASE BD70_Gimnasio;
GO
USE BD70_Gimnasio;
GO

CREATE TABLE Socio3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50)
);

CREATE TABLE Entrenador3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50),
    Especialidad NVARCHAR(50)
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
