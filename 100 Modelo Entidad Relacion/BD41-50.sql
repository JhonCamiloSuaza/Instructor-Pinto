
-- BD41 - Real Estate
-- Enunciado: Registrar clientes, propiedades y ventas/alquileres.

USE master;
GO
IF DB_ID('BD41_RealEstate') IS NOT NULL
BEGIN
    ALTER DATABASE BD41_RealEstate SET SINGLE_USER WITH ROLLBACK IMMEDIATE;
    DROP DATABASE BD41_RealEstate;
END
GO
CREATE DATABASE BD41_RealEstate;
GO
USE BD41_RealEstate;
GO

-- 1FN: Todo en una tabla: cliente y propiedad en la misma fila (repetición)
CREATE TABLE Operacion1FN (
    ID INT PRIMARY KEY,
    ClienteNombre NVARCHAR(100),
    ClienteTelefono NVARCHAR(30),
    Prop1_Direccion NVARCHAR(200),
    Prop1_Precio DECIMAL(18,2),
    Prop2_Direccion NVARCHAR(200),
    Prop2_Precio DECIMAL(18,2),
    TipoOperacion NVARCHAR(20), -- venta / alquiler
    Fecha DATE
);
GO

-- 2FN: Separar Cliente y Propiedad; Operacion referencia ambos
CREATE TABLE Cliente2FN_Real (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(100),
    Telefono NVARCHAR(30)
);
GO
CREATE TABLE Propiedad2FN (
    ID INT PRIMARY KEY,
    Direccion NVARCHAR(200),
    Precio DECIMAL(18,2),
    Tipo NVARCHAR(50)
);
GO
CREATE TABLE Operacion2FN (
    ID INT PRIMARY KEY,
    ID_Cliente INT,
    ID_Propiedad INT,
    TipoOperacion NVARCHAR(20),
    Fecha DATE,
    CONSTRAINT FK_Oper2_Cliente FOREIGN KEY (ID_Cliente) REFERENCES Cliente2FN_Real(ID),
    CONSTRAINT FK_Oper2_Prop FOREIGN KEY (ID_Propiedad) REFERENCES Propiedad2FN(ID)
);
GO

-- 3FN: Normalizado (Operación solo tiene llaves y datos propios)
CREATE TABLE Cliente3FN_Real (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(100),
    Telefono NVARCHAR(30),
    Email NVARCHAR(100)
);
GO
CREATE TABLE Propiedad3FN (
    ID INT PRIMARY KEY,
    Direccion NVARCHAR(200),
    Precio DECIMAL(18,2),
    Tipo NVARCHAR(50),
    Sup_M2 DECIMAL(10,2)
);
GO
CREATE TABLE Operacion3FN (
    ID INT PRIMARY KEY,
    ID_Cliente INT NOT NULL,
    ID_Propiedad INT NOT NULL,
    TipoOperacion NVARCHAR(20),
    Fecha DATE,
    CONSTRAINT FK_Oper3_Cliente FOREIGN KEY (ID_Cliente) REFERENCES Cliente3FN_Real(ID),
    CONSTRAINT FK_Oper3_Prop FOREIGN KEY (ID_Propiedad) REFERENCES Propiedad3FN(ID)
);
GO


-- BD42 - Gym
-- Enunciado: Registrar socios, entrenadores y clases.

USE master;
GO
IF DB_ID('BD42_Gym') IS NOT NULL
BEGIN
    ALTER DATABASE BD42_Gym SET SINGLE_USER WITH ROLLBACK IMMEDIATE;
    DROP DATABASE BD42_Gym;
END
GO
CREATE DATABASE BD42_Gym;
GO
USE BD42_Gym;
GO

-- 1FN: socio y clases repetidas en una fila
CREATE TABLE Inscripcion1FN (
    ID INT PRIMARY KEY,
    SocioNombre NVARCHAR(100),
    SocioEmail NVARCHAR(100),
    Clase1 NVARCHAR(100),
    Clase2 NVARCHAR(100),
    FechaInicio DATE
);
GO

-- 2FN: Separar Socio y Clase; Inscripcion referencia
CREATE TABLE Socio2FN_Gym (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(100),
    Email NVARCHAR(100)
);
GO
CREATE TABLE Clase2FN_Gym (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(100),
    Horario NVARCHAR(50)
);
GO
CREATE TABLE Inscripcion2FN (
    ID INT PRIMARY KEY,
    ID_Socio INT,
    ID_Clase INT,
    FechaInicio DATE,
    CONSTRAINT FK_Ins2_Socio FOREIGN KEY (ID_Socio) REFERENCES Socio2FN_Gym(ID),
    CONSTRAINT FK_Ins2_Clase FOREIGN KEY (ID_Clase) REFERENCES Clase2FN_Gym(ID)
);
GO

-- 3FN: Normalizado: tablas con atributos dependientes solo de su PK
CREATE TABLE Socio3FN_Gym (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(100),
    Email NVARCHAR(100),
    FechaRegistro DATE
);
GO
CREATE TABLE Clase3FN_Gym (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(100),
    Horario NVARCHAR(50),
    Instructor NVARCHAR(100)
);
GO
CREATE TABLE Inscripcion3FN (
    ID INT PRIMARY KEY,
    ID_Socio INT NOT NULL,
    ID_Clase INT NOT NULL,
    FechaInicio DATE,
    Estado NVARCHAR(50),
    CONSTRAINT FK_Ins3_Socio FOREIGN KEY (ID_Socio) REFERENCES Socio3FN_Gym(ID),
    CONSTRAINT FK_Ins3_Clase FOREIGN KEY (ID_Clase) REFERENCES Clase3FN_Gym(ID)
);
GO


-- BD43 - Music Festival
-- Enunciado: Registrar asistentes, artistas y entradas vendidas.

USE master;
GO
IF DB_ID('BD43_MusicFest') IS NOT NULL
BEGIN
    ALTER DATABASE BD43_MusicFest SET SINGLE_USER WITH ROLLBACK IMMEDIATE;
    DROP DATABASE BD43_MusicFest;
END
GO
CREATE DATABASE BD43_MusicFest;
GO
USE BD43_MusicFest;
GO

-- 1FN
CREATE TABLE Ticket1FN (
    ID INT PRIMARY KEY,
    AsistenteNombre NVARCHAR(100),
    AsistenteEmail NVARCHAR(100),
    Artista1 NVARCHAR(100),
    Artista2 NVARCHAR(100),
    FechaEvento DATE
);
GO

-- 2FN
CREATE TABLE Asistente2FN_Fest (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(100),
    Email NVARCHAR(100)
);
GO
CREATE TABLE Artista2FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(100),
    Genero NVARCHAR(50)
);
GO
CREATE TABLE Ticket2FN (
    ID INT PRIMARY KEY,
    ID_Asistente INT,
    ID_Artista INT,
    FechaEvento DATE,
    CONSTRAINT FK_Tic2_Asistente FOREIGN KEY (ID_Asistente) REFERENCES Asistente2FN_Fest(ID),
    CONSTRAINT FK_Tic2_Artista FOREIGN KEY (ID_Artista) REFERENCES Artista2FN(ID)
);
GO

-- 3FN
CREATE TABLE Asistente3FN_Fest (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(100),
    Email NVARCHAR(100),
    Telefono NVARCHAR(20)
);
GO
CREATE TABLE Artista3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(100),
    Genero NVARCHAR(50),
    PaisOrigen NVARCHAR(50)
);
GO
CREATE TABLE Ticket3FN (
    ID INT PRIMARY KEY,
    ID_Asistente INT NOT NULL,
    ID_Artista INT NOT NULL,
    FechaEvento DATE,
    TipoEntrada NVARCHAR(50),
    CONSTRAINT FK_Tic3_Asistente FOREIGN KEY (ID_Asistente) REFERENCES Asistente3FN_Fest(ID),
    CONSTRAINT FK_Tic3_Artista FOREIGN KEY (ID_Artista) REFERENCES Artista3FN(ID)
);
GO


-- BD44 - Logística
-- Enunciado: Registrar almacenes, transportes y envíos.

USE master;
GO
IF DB_ID('BD44_Logistica') IS NOT NULL
BEGIN
    ALTER DATABASE BD44_Logistica SET SINGLE_USER WITH ROLLBACK IMMEDIATE;
    DROP DATABASE BD44_Logistica;
END
GO
CREATE DATABASE BD44_Logistica;
GO
USE BD44_Logistica;
GO

-- 1FN
CREATE TABLE Envio1FN (
    ID INT PRIMARY KEY,
    AlmacenNombre NVARCHAR(100),
    Destino NVARCHAR(200),
    Producto1 NVARCHAR(100),
    Producto2 NVARCHAR(100),
    FechaEnvio DATE
);
GO

-- 2FN
CREATE TABLE Almacen2FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(100),
    Ubicacion NVARCHAR(200)
);
GO
CREATE TABLE Transporte2FN (
    ID INT PRIMARY KEY,
    Tipo NVARCHAR(50),
    Placa NVARCHAR(20)
);
GO
CREATE TABLE Envio2FN (
    ID INT PRIMARY KEY,
    ID_Almacen INT,
    ID_Transporte INT,
    Destino NVARCHAR(200),
    FechaEnvio DATE,
    CONSTRAINT FK_Env2_Almacen FOREIGN KEY (ID_Almacen) REFERENCES Almacen2FN(ID),
    CONSTRAINT FK_Env2_Transporte FOREIGN KEY (ID_Transporte) REFERENCES Transporte2FN(ID)
);
GO

-- 3FN
CREATE TABLE Almacen3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(100),
    Ubicacion NVARCHAR(200),
    Responsable NVARCHAR(100)
);
GO
CREATE TABLE Transporte3FN (
    ID INT PRIMARY KEY,
    Tipo NVARCHAR(50),
    Placa NVARCHAR(20),
    Capacidad DECIMAL(10,2)
);
GO
CREATE TABLE Envio3FN (
    ID INT PRIMARY KEY,
    ID_Almacen INT NOT NULL,
    ID_Transporte INT NOT NULL,
    Destino NVARCHAR(200),
    FechaEnvio DATE,
    Estado NVARCHAR(50),
    CONSTRAINT FK_Env3_Almacen FOREIGN KEY (ID_Almacen) REFERENCES Almacen3FN(ID),
    CONSTRAINT FK_Env3_Transporte FOREIGN KEY (ID_Transporte) REFERENCES Transporte3FN(ID)
);
GO


-- BD45 - Recursos Humanos (RRHH)
-- Enunciado: Registrar empleados, cargos y nómina.

USE master;
GO
IF DB_ID('BD45_RRHH') IS NOT NULL
BEGIN
    ALTER DATABASE BD45_RRHH SET SINGLE_USER WITH ROLLBACK IMMEDIATE;
    DROP DATABASE BD45_RRHH;
END
GO
CREATE DATABASE BD45_RRHH;
GO
USE BD45_RRHH;
GO

-- 1FN
CREATE TABLE Nomina1FN (
    ID INT PRIMARY KEY,
    EmpleadoNombre NVARCHAR(100),
    Cargo NVARCHAR(100),
    Salario DECIMAL(18,2),
    FechaPago DATE
);
GO

-- 2FN
CREATE TABLE Empleado2FN_RRHH (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(100),
    Documento NVARCHAR(50)
);
GO
CREATE TABLE Cargo2FN (
    ID INT PRIMARY KEY,
    Titulo NVARCHAR(100),
    Nivel NVARCHAR(50)
);
GO
CREATE TABLE Nomina2FN (
    ID INT PRIMARY KEY,
    ID_Empleado INT,
    ID_Cargo INT,
    Salario DECIMAL(18,2),
    FechaPago DATE,
    CONSTRAINT FK_Nom2_Empleado FOREIGN KEY (ID_Empleado) REFERENCES Empleado2FN_RRHH(ID),
    CONSTRAINT FK_Nom2_Cargo FOREIGN KEY (ID_Cargo) REFERENCES Cargo2FN(ID)
);
GO

-- 3FN
CREATE TABLE Empleado3FN_RRHH (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(100),
    Documento NVARCHAR(50),
    FechaIngreso DATE
);
GO
CREATE TABLE Cargo3FN (
    ID INT PRIMARY KEY,
    Titulo NVARCHAR(100),
    Nivel NVARCHAR(50),
    Descripcion NVARCHAR(200)
);
GO
CREATE TABLE Nomina3FN (
    ID INT PRIMARY KEY,
    ID_Empleado INT NOT NULL,
    ID_Cargo INT NOT NULL,
    Salario DECIMAL(18,2),
    FechaPago DATE,
    CONSTRAINT FK_Nom3_Empleado FOREIGN KEY (ID_Empleado) REFERENCES Empleado3FN_RRHH(ID),
    CONSTRAINT FK_Nom3_Cargo FOREIGN KEY (ID_Cargo) REFERENCES Cargo3FN(ID)
);
GO


-- BD46 - Incubadora (Startup Incubator)
-- Enunciado: Registrar startups, mentores y proyectos.

USE master;
GO
IF DB_ID('BD46_Incubadora') IS NOT NULL
BEGIN
    ALTER DATABASE BD46_Incubadora SET SINGLE_USER WITH ROLLBACK IMMEDIATE;
    DROP DATABASE BD46_Incubadora;
END
GO
CREATE DATABASE BD46_Incubadora;
GO
USE BD46_Incubadora;
GO

-- 1FN
CREATE TABLE Proyecto1FN (
    ID INT PRIMARY KEY,
    StartupNombre NVARCHAR(100),
    MentorNombre NVARCHAR(100),
    ProyectoTitulo NVARCHAR(200),
    Estado NVARCHAR(50)
);
GO

-- 2FN
CREATE TABLE Startup2FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(100),
    Fundadores NVARCHAR(200)
);
GO
CREATE TABLE Mentor2FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(100),
    Especialidad NVARCHAR(100)
);
GO
CREATE TABLE Proyecto2FN (
    ID INT PRIMARY KEY,
    ID_Startup INT,
    ID_Mentor INT,
    Titulo NVARCHAR(200),
    Estado NVARCHAR(50),
    CONSTRAINT FK_Proy2_Startup FOREIGN KEY (ID_Startup) REFERENCES Startup2FN(ID),
    CONSTRAINT FK_Proy2_Mentor FOREIGN KEY (ID_Mentor) REFERENCES Mentor2FN(ID)
);
GO

-- 3FN
CREATE TABLE Startup3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(100),
    Web NVARCHAR(200)
);
GO
CREATE TABLE Mentor3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(100),
    Especialidad NVARCHAR(100),
    Contacto NVARCHAR(100)
);
GO
CREATE TABLE Proyecto3FN (
    ID INT PRIMARY KEY,
    ID_Startup INT NOT NULL,
    ID_Mentor INT NOT NULL,
    Titulo NVARCHAR(200),
    Estado NVARCHAR(50),
    FechaInicio DATE,
    FechaFin DATE,
    CONSTRAINT FK_Proy3_Startup FOREIGN KEY (ID_Startup) REFERENCES Startup3FN(ID),
    CONSTRAINT FK_Proy3_Mentor FOREIGN KEY (ID_Mentor) REFERENCES Mentor3FN(ID)
);
GO


-- BD47 - Parking
-- Enunciado: Registrar vehículos, clientes y tickets de estacionamiento.

USE master;
GO
IF DB_ID('BD47_Parking') IS NOT NULL
BEGIN
    ALTER DATABASE BD47_Parking SET SINGLE_USER WITH ROLLBACK IMMEDIATE;
    DROP DATABASE BD47_Parking;
END
GO
CREATE DATABASE BD47_Parking;
GO
USE BD47_Parking;
GO

-- 1FN
CREATE TABLE Ticket1FN (
    ID INT PRIMARY KEY,
    ClienteNombre NVARCHAR(100),
    VehiculoPlaca NVARCHAR(20),
    HoraEntrada NVARCHAR(20),
    HoraSalida NVARCHAR(20)
);
GO

-- 2FN
CREATE TABLE Cliente2FN_Park (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(100),
    Telefono NVARCHAR(20)
);
GO
CREATE TABLE Vehiculo2FN (
    Placa NVARCHAR(20) PRIMARY KEY,
    Modelo NVARCHAR(100)
);
GO
CREATE TABLE Ticket2FN (
    ID INT PRIMARY KEY,
    ID_Cliente INT,
    Placa NVARCHAR(20),
    HoraEntrada DATETIME,
    HoraSalida DATETIME,
    CONSTRAINT FK_Tic2_Cliente FOREIGN KEY (ID_Cliente) REFERENCES Cliente2FN_Park(ID),
    CONSTRAINT FK_Tic2_Vehiculo FOREIGN KEY (Placa) REFERENCES Vehiculo2FN(Placa)
);
GO

-- 3FN
CREATE TABLE Cliente3FN_Park (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(100),
    Telefono NVARCHAR(20),
    Email NVARCHAR(100)
);
GO
CREATE TABLE Vehiculo3FN (
    Placa NVARCHAR(20) PRIMARY KEY,
    Modelo NVARCHAR(100),
    Color NVARCHAR(50)
);
GO
CREATE TABLE Ticket3FN (
    ID INT PRIMARY KEY,
    ID_Cliente INT NOT NULL,
    Placa NVARCHAR(20) NOT NULL,
    HoraEntrada DATETIME,
    HoraSalida DATETIME,
    Tarifa DECIMAL(10,2),
    CONSTRAINT FK_Tic3_Cliente FOREIGN KEY (ID_Cliente) REFERENCES Cliente3FN_Park(ID),
    CONSTRAINT FK_Tic3_Vehiculo FOREIGN KEY (Placa) REFERENCES Vehiculo3FN(Placa)
);
GO


-- BD48 - Lavandería (Laundry)
-- Enunciado: Registrar clientes, prendas y órdenes de lavado.

USE master;
GO
IF DB_ID('BD48_Lavanderia') IS NOT NULL
BEGIN
    ALTER DATABASE BD48_Lavanderia SET SINGLE_USER WITH ROLLBACK IMMEDIATE;
    DROP DATABASE BD48_Lavanderia;
END
GO
CREATE DATABASE BD48_Lavanderia;
GO
USE BD48_Lavanderia;
GO

-- 1FN
CREATE TABLE Orden1FN (
    ID INT PRIMARY KEY,
    ClienteNombre NVARCHAR(100),
    Prenda1 NVARCHAR(100),
    Prenda2 NVARCHAR(100),
    FechaIngreso DATE
);
GO

-- 2FN
CREATE TABLE Cliente2FN_Lav (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(100),
    Telefono NVARCHAR(20)
);
GO
CREATE TABLE Prenda2FN (
    ID INT PRIMARY KEY,
    Tipo NVARCHAR(100),
    Instrucciones NVARCHAR(200)
);
GO
CREATE TABLE Orden2FN (
    ID INT PRIMARY KEY,
    ID_Cliente INT,
    ID_Prenda INT,
    FechaIngreso DATE,
    Estado NVARCHAR(50),
    CONSTRAINT FK_Ord2_Cliente FOREIGN KEY (ID_Cliente) REFERENCES Cliente2FN_Lav(ID),
    CONSTRAINT FK_Ord2_Prenda FOREIGN KEY (ID_Prenda) REFERENCES Prenda2FN(ID)
);
GO

-- 3FN
CREATE TABLE Cliente3FN_Lav (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(100),
    Telefono NVARCHAR(20),
    Email NVARCHAR(100)
);
GO
CREATE TABLE Prenda3FN (
    ID INT PRIMARY KEY,
    Tipo NVARCHAR(100),
    Material NVARCHAR(100),
    Instrucciones NVARCHAR(200)
);
GO
CREATE TABLE Orden3FN (
    ID INT PRIMARY KEY,
    ID_Cliente INT NOT NULL,
    ID_Prenda INT NOT NULL,
    FechaIngreso DATE,
    FechaEntrega DATE,
    Estado NVARCHAR(50),
    CONSTRAINT FK_Ord3_Cliente FOREIGN KEY (ID_Cliente) REFERENCES Cliente3FN_Lav(ID),
    CONSTRAINT FK_Ord3_Prenda FOREIGN KEY (ID_Prenda) REFERENCES Prenda3FN(ID)
);
GO


-- BD49 - Pet Shop
-- Enunciado: Registrar dueños, mascotas y ventas de productos.

USE master;
GO
IF DB_ID('BD49_PetShop') IS NOT NULL
BEGIN
    ALTER DATABASE BD49_PetShop SET SINGLE_USER WITH ROLLBACK IMMEDIATE;
    DROP DATABASE BD49_PetShop;
END
GO
CREATE DATABASE BD49_PetShop;
GO
USE BD49_PetShop;
GO

-- 1FN
CREATE TABLE Venta1FN (
    ID INT PRIMARY KEY,
    DuenoNombre NVARCHAR(100),
    MascotaNombre NVARCHAR(100),
    Producto1 NVARCHAR(100),
    Producto2 NVARCHAR(100),
    Fecha DATE
);
GO

-- 2FN
CREATE TABLE Dueno2FN_Pet (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(100),
    Telefono NVARCHAR(20)
);
GO
CREATE TABLE Mascota2FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(100),
    Especie NVARCHAR(50)
);
GO
CREATE TABLE Producto2FN_Pet (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(100),
    Precio DECIMAL(10,2)
);
GO
CREATE TABLE Venta2FN (
    ID INT PRIMARY KEY,
    ID_Dueno INT,
    ID_Mascota INT,
    ID_Producto INT,
    Fecha DATE,
    CONSTRAINT FK_Ven2_Dueno FOREIGN KEY (ID_Dueno) REFERENCES Dueno2FN_Pet(ID),
    CONSTRAINT FK_Ven2_Mascota FOREIGN KEY (ID_Mascota) REFERENCES Mascota2FN(ID),
    CONSTRAINT FK_Ven2_Producto FOREIGN KEY (ID_Producto) REFERENCES Producto2FN_Pet(ID)
);
GO

-- 3FN
CREATE TABLE Dueno3FN_Pet (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(100),
    Telefono NVARCHAR(20),
    Email NVARCHAR(100)
);
GO
CREATE TABLE Mascota3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(100),
    Especie NVARCHAR(50),
    Raza NVARCHAR(50)
);
GO
CREATE TABLE Producto3FN_Pet (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(100),
    Precio DECIMAL(10,2),
    Stock INT
);
GO
CREATE TABLE Venta3FN (
    ID INT PRIMARY KEY,
    ID_Dueno INT NOT NULL,
    ID_Mascota INT NOT NULL,
    ID_Producto INT NOT NULL,
    Fecha DATE,
    Cantidad INT,
    CONSTRAINT FK_Ven3_Dueno FOREIGN KEY (ID_Dueno) REFERENCES Dueno3FN_Pet(ID),
    CONSTRAINT FK_Ven3_Mascota FOREIGN KEY (ID_Mascota) REFERENCES Mascota3FN(ID),
    CONSTRAINT FK_Ven3_Producto FOREIGN KEY (ID_Producto) REFERENCES Producto3FN_Pet(ID)
);
GO


-- BD50 - E-Learning
-- Enunciado: Registrar estudiantes, cursos y matrículas.

USE master;
GO
IF DB_ID('BD50_Elearning') IS NOT NULL
BEGIN
    ALTER DATABASE BD50_Elearning SET SINGLE_USER WITH ROLLBACK IMMEDIATE;
    DROP DATABASE BD50_Elearning;
END
GO
CREATE DATABASE BD50_Elearning;
GO
USE BD50_Elearning;
GO

-- 1FN
CREATE TABLE Matricula1FN (
    ID INT PRIMARY KEY,
    EstudianteNombre NVARCHAR(100),
    Curso1 NVARCHAR(200),
    Curso2 NVARCHAR(200),
    FechaInscripcion DATE
);
GO

-- 2FN
CREATE TABLE Estudiante2FN_E (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(100),
    Email NVARCHAR(100)
);
GO
CREATE TABLE Curso2FN (
    ID INT PRIMARY KEY,
    Titulo NVARCHAR(200),
    DuracionHoras INT
);
GO
CREATE TABLE Matricula2FN (
    ID INT PRIMARY KEY,
    ID_Estudiante INT,
    ID_Curso INT,
    FechaInscripcion DATE,
    CONSTRAINT FK_Mat2_Estudiante FOREIGN KEY (ID_Estudiante) REFERENCES Estudiante2FN_E(ID),
    CONSTRAINT FK_Mat2_Curso FOREIGN KEY (ID_Curso) REFERENCES Curso2FN(ID)
);
GO

-- 3FN
CREATE TABLE Estudiante3FN_E (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(100),
    Email NVARCHAR(100),
    FechaRegistro DATE
);
GO
CREATE TABLE Curso3FN (
    ID INT PRIMARY KEY,
    Titulo NVARCHAR(200),
    DuracionHoras INT,
    Categoria NVARCHAR(100)
);
GO
CREATE TABLE Matricula3FN (
    ID INT PRIMARY KEY,
    ID_Estudiante INT NOT NULL,
    ID_Curso INT NOT NULL,
    FechaInscripcion DATE,
    Estado NVARCHAR(50),
    CONSTRAINT FK_Mat3_Estudiante FOREIGN KEY (ID_Estudiante) REFERENCES Estudiante3FN_E(ID),
    CONSTRAINT FK_Mat3_Curso FOREIGN KEY (ID_Curso) REFERENCES Curso3FN(ID)
);
GO
