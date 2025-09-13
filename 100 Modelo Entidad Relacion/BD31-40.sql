/* 
   BD31 - Restaurante
   Enunciado: Registrar clientes, mesas y reservas.
    */
USE master;
GO
IF DB_ID('BD31_Restaurante') IS NOT NULL
BEGIN
    ALTER DATABASE BD31_Restaurante SET SINGLE_USER WITH ROLLBACK IMMEDIATE;
    DROP DATABASE BD31_Restaurante;
END
GO
CREATE DATABASE BD31_Restaurante;
GO
USE BD31_Restaurante;
GO

-- 1FN
CREATE TABLE Reserva1FN (
    ID INT PRIMARY KEY,
    ClienteNombre NVARCHAR(50),
    Mesa1 NVARCHAR(10),
    Mesa2 NVARCHAR(10),
    Fecha DATE
);

-- 2FN
CREATE TABLE Cliente2FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50)
);
CREATE TABLE Mesa2FN (
    Numero NVARCHAR(10) PRIMARY KEY,
    Capacidad INT
);
CREATE TABLE Reserva2FN (
    ID INT PRIMARY KEY,
    ID_Cliente INT,
    Numero NVARCHAR(10),
    Fecha DATE,
    FOREIGN KEY (ID_Cliente) REFERENCES Cliente2FN(ID),
    FOREIGN KEY (Numero) REFERENCES Mesa2FN(Numero)
);

-- 3FN
CREATE TABLE Cliente3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50)
);
CREATE TABLE Mesa3FN (
    Numero NVARCHAR(10) PRIMARY KEY,
    Capacidad INT
);
CREATE TABLE Reserva3FN (
    ID INT PRIMARY KEY,
    ID_Cliente INT,
    Numero NVARCHAR(10),
    Fecha DATE,
    FOREIGN KEY (ID_Cliente) REFERENCES Cliente3FN(ID),
    FOREIGN KEY (Numero) REFERENCES Mesa3FN(Numero)
);


/* 
   BD32 - Universidad
   Enunciado: Registrar estudiantes, materias y matrículas.
    */
USE master;
GO
IF DB_ID('BD32_Universidad') IS NOT NULL
BEGIN
    ALTER DATABASE BD32_Universidad SET SINGLE_USER WITH ROLLBACK IMMEDIATE;
    DROP DATABASE BD32_Universidad;
END
GO
CREATE DATABASE BD32_Universidad;
GO
USE BD32_Universidad;
GO

-- 1FN
CREATE TABLE Matricula1FN (
    ID INT PRIMARY KEY,
    EstudianteNombre NVARCHAR(50),
    Materia1 NVARCHAR(50),
    Materia2 NVARCHAR(50),
    Semestre NVARCHAR(20)
);

-- 2FN
CREATE TABLE Estudiante2FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50)
);
CREATE TABLE Materia2FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50),
    Creditos INT
);
CREATE TABLE Matricula2FN (
    ID INT PRIMARY KEY,
    ID_Estudiante INT,
    ID_Materia INT,
    Semestre NVARCHAR(20),
    FOREIGN KEY (ID_Estudiante) REFERENCES Estudiante2FN(ID),
    FOREIGN KEY (ID_Materia) REFERENCES Materia2FN(ID)
);

-- 3FN
CREATE TABLE Estudiante3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50)
);
CREATE TABLE Materia3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50),
    Creditos INT
);
CREATE TABLE Matricula3FN (
    ID INT PRIMARY KEY,
    ID_Estudiante INT,
    ID_Materia INT,
    Semestre NVARCHAR(20),
    FOREIGN KEY (ID_Estudiante) REFERENCES Estudiante3FN(ID),
    FOREIGN KEY (ID_Materia) REFERENCES Materia3FN(ID)
);


/* 
   BD33 - Supermercado
   Enunciado: Registrar clientes, productos y compras.
    */
USE master;
GO
IF DB_ID('BD33_Supermercado') IS NOT NULL
BEGIN
    ALTER DATABASE BD33_Supermercado SET SINGLE_USER WITH ROLLBACK IMMEDIATE;
    DROP DATABASE BD33_Supermercado;
END
GO
CREATE DATABASE BD33_Supermercado;
GO
USE BD33_Supermercado;
GO

-- 1FN
CREATE TABLE Compra1FN (
    ID INT PRIMARY KEY,
    ClienteNombre NVARCHAR(50),
    Producto1 NVARCHAR(50),
    Producto2 NVARCHAR(50),
    Fecha DATE
);

-- 2FN
CREATE TABLE Cliente2FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50)
);
CREATE TABLE Producto2FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50),
    Precio DECIMAL(10,2)
);
CREATE TABLE Compra2FN (
    ID INT PRIMARY KEY,
    ID_Cliente INT,
    ID_Producto INT,
    Fecha DATE,
    FOREIGN KEY (ID_Cliente) REFERENCES Cliente2FN(ID),
    FOREIGN KEY (ID_Producto) REFERENCES Producto2FN(ID)
);

-- 3FN
CREATE TABLE Cliente3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50)
);
CREATE TABLE Producto3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50),
    Precio DECIMAL(10,2)
);
CREATE TABLE Compra3FN (
    ID INT PRIMARY KEY,
    ID_Cliente INT,
    ID_Producto INT,
    Fecha DATE,
    FOREIGN KEY (ID_Cliente) REFERENCES Cliente3FN(ID),
    FOREIGN KEY (ID_Producto) REFERENCES Producto3FN(ID)
);


/* 
   BD34 - Clínica
   Enunciado: Registrar pacientes, médicos y citas médicas.
    */
USE master;
GO
IF DB_ID('BD34_Clinica') IS NOT NULL
BEGIN
    ALTER DATABASE BD34_Clinica SET SINGLE_USER WITH ROLLBACK IMMEDIATE;
    DROP DATABASE BD34_Clinica;
END
GO
CREATE DATABASE BD34_Clinica;
GO
USE BD34_Clinica;
GO

-- 1FN
CREATE TABLE Cita1FN (
    ID INT PRIMARY KEY,
    PacienteNombre NVARCHAR(50),
    MedicoNombre NVARCHAR(50),
    Especialidad NVARCHAR(50),
    Fecha DATE
);

-- 2FN
CREATE TABLE Paciente2FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50)
);
CREATE TABLE Medico2FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50),
    Especialidad NVARCHAR(50)
);
CREATE TABLE Cita2FN (
    ID INT PRIMARY KEY,
    ID_Paciente INT,
    ID_Medico INT,
    Fecha DATE,
    FOREIGN KEY (ID_Paciente) REFERENCES Paciente2FN(ID),
    FOREIGN KEY (ID_Medico) REFERENCES Medico2FN(ID)
);

-- 3FN
CREATE TABLE Paciente3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50)
);
CREATE TABLE Medico3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50),
    Especialidad NVARCHAR(50)
);
CREATE TABLE Cita3FN (
    ID INT PRIMARY KEY,
    ID_Paciente INT,
    ID_Medico INT,
    Fecha DATE,
    FOREIGN KEY (ID_Paciente) REFERENCES Paciente3FN(ID),
    FOREIGN KEY (ID_Medico) REFERENCES Medico3FN(ID)
);


/* 
   BD35 - Banco
   Enunciado: Registrar clientes, cuentas y transacciones.
    */
USE master;
GO
IF DB_ID('BD35_Banco') IS NOT NULL
BEGIN
    ALTER DATABASE BD35_Banco SET SINGLE_USER WITH ROLLBACK IMMEDIATE;
    DROP DATABASE BD35_Banco;
END
GO
CREATE DATABASE BD35_Banco;
GO
USE BD35_Banco;
GO

-- 1FN
CREATE TABLE Transaccion1FN (
    ID INT PRIMARY KEY,
    ClienteNombre NVARCHAR(50),
    CuentaNumero NVARCHAR(20),
    Tipo NVARCHAR(20),
    Monto DECIMAL(10,2),
    Fecha DATE
);

-- 2FN
CREATE TABLE Cliente2FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50)
);
CREATE TABLE Cuenta2FN (
    Numero NVARCHAR(20) PRIMARY KEY,
    Saldo DECIMAL(10,2)
);
CREATE TABLE Transaccion2FN (
    ID INT PRIMARY KEY,
    ID_Cliente INT,
    Numero NVARCHAR(20),
    Tipo NVARCHAR(20),
    Monto DECIMAL(10,2),
    Fecha DATE,
    FOREIGN KEY (ID_Cliente) REFERENCES Cliente2FN(ID),
    FOREIGN KEY (Numero) REFERENCES Cuenta2FN(Numero)
);

-- 3FN
CREATE TABLE Cliente3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50)
);
CREATE TABLE Cuenta3FN (
    Numero NVARCHAR(20) PRIMARY KEY,
    Saldo DECIMAL(10,2)
);
CREATE TABLE Transaccion3FN (
    ID INT PRIMARY KEY,
    ID_Cliente INT,
    Numero NVARCHAR(20),
    Tipo NVARCHAR(20),
    Monto DECIMAL(10,2),
    Fecha DATE,
    FOREIGN KEY (ID_Cliente) REFERENCES Cliente3FN(ID),
    FOREIGN KEY (Numero) REFERENCES Cuenta3FN(Numero)
);


/* 
   BD36 - Aerolínea
   Enunciado: Registrar pasajeros, vuelos y boletos.
    */
USE master;
GO
IF DB_ID('BD36_Aerolinea') IS NOT NULL
BEGIN
    ALTER DATABASE BD36_Aerolinea SET SINGLE_USER WITH ROLLBACK IMMEDIATE;
    DROP DATABASE BD36_Aerolinea;
END
GO
CREATE DATABASE BD36_Aerolinea;
GO
USE BD36_Aerolinea;
GO

-- 1FN
CREATE TABLE Boleto1FN (
    ID INT PRIMARY KEY,
    PasajeroNombre NVARCHAR(50),
    VueloCodigo NVARCHAR(20),
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
CREATE TABLE Boleto2FN (
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
CREATE TABLE Boleto3FN (
    ID INT PRIMARY KEY,
    ID_Pasajero INT,
    Codigo NVARCHAR(20),
    Fecha DATE,
    FOREIGN KEY (ID_Pasajero) REFERENCES Pasajero3FN(ID),
    FOREIGN KEY (Codigo) REFERENCES Vuelo3FN(Codigo)
);


/* 
   BD37 - Empresa
   Enunciado: Registrar empleados, departamentos y proyectos.
    */
USE master;
GO
IF DB_ID('BD37_Empresa') IS NOT NULL
BEGIN
    ALTER DATABASE BD37_Empresa SET SINGLE_USER WITH ROLLBACK IMMEDIATE;
    DROP DATABASE BD37_Empresa;
END
GO
CREATE DATABASE BD37_Empresa;
GO
USE BD37_Empresa;
GO

-- 1FN
CREATE TABLE Proyecto1FN (
    ID INT PRIMARY KEY,
    EmpleadoNombre NVARCHAR(50),
    Departamento NVARCHAR(50),
    Proyecto1 NVARCHAR(50),
    Proyecto2 NVARCHAR(50)
);

-- 2FN
CREATE TABLE Empleado2FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50),
    Departamento NVARCHAR(50)
);
CREATE TABLE Proyecto2FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50)
);
CREATE TABLE Asignacion2FN (
    ID INT PRIMARY KEY,
    ID_Empleado INT,
    ID_Proyecto INT,
    FOREIGN KEY (ID_Empleado) REFERENCES Empleado2FN(ID),
    FOREIGN KEY (ID_Proyecto) REFERENCES Proyecto2FN(ID)
);

-- 3FN
CREATE TABLE Departamento3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50)
);
CREATE TABLE Empleado3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50),
    ID_Departamento INT,
    FOREIGN KEY (ID_Departamento) REFERENCES Departamento3FN(ID)
);
CREATE TABLE Proyecto3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50)
);
CREATE TABLE Asignacion3FN (
    ID INT PRIMARY KEY,
    ID_Empleado INT,
    ID_Proyecto INT,
    FOREIGN KEY (ID_Empleado) REFERENCES Empleado3FN(ID),
    FOREIGN KEY (ID_Proyecto) REFERENCES Proyecto3FN(ID)
);


/* 
   BD38 - Farmacia
   Enunciado: Registrar clientes, medicamentos y ventas.
    */
USE master;
GO
IF DB_ID('BD38_Farmacia') IS NOT NULL
BEGIN
    ALTER DATABASE BD38_Farmacia SET SINGLE_USER WITH ROLLBACK IMMEDIATE;
    DROP DATABASE BD38_Farmacia;
END
GO
CREATE DATABASE BD38_Farmacia;
GO
USE BD38_Farmacia;
GO

-- 1FN
CREATE TABLE Venta1FN (
    ID INT PRIMARY KEY,
    ClienteNombre NVARCHAR(50),
    Medicamento1 NVARCHAR(50),
    Medicamento2 NVARCHAR(50),
    Fecha DATE
);

-- 2FN
CREATE TABLE Cliente2FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50)
);
CREATE TABLE Medicamento2FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50),
    Precio DECIMAL(10,2)
);
CREATE TABLE Venta2FN (
    ID INT PRIMARY KEY,
    ID_Cliente INT,
    ID_Medicamento INT,
    Fecha DATE,
    FOREIGN KEY (ID_Cliente) REFERENCES Cliente2FN(ID),
    FOREIGN KEY (ID_Medicamento) REFERENCES Medicamento2FN(ID)
);

-- 3FN
CREATE TABLE Cliente3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50)
);
CREATE TABLE Medicamento3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50),
    Precio DECIMAL(10,2)
);
CREATE TABLE Venta3FN (
    ID INT PRIMARY KEY,
    ID_Cliente INT,
    ID_Medicamento INT,
    Fecha DATE,
    FOREIGN KEY (ID_Cliente) REFERENCES Cliente3FN(ID),
    FOREIGN KEY (ID_Medicamento) REFERENCES Medicamento3FN(ID)
);


/* 
   BD39 - Biblioteca Escolar
   Enunciado: Registrar estudiantes, libros y préstamos.
    */
USE master;
GO
IF DB_ID('BD39_BibliotecaEscolar') IS NOT NULL
BEGIN
    ALTER DATABASE BD39_BibliotecaEscolar SET SINGLE_USER WITH ROLLBACK IMMEDIATE;
    DROP DATABASE BD39_BibliotecaEscolar;
END
GO
CREATE DATABASE BD39_BibliotecaEscolar;
GO
USE BD39_BibliotecaEscolar;
GO

-- 1FN
CREATE TABLE Prestamo1FN (
    ID INT PRIMARY KEY,
    EstudianteNombre NVARCHAR(50),
    Libro1 NVARCHAR(100),
    Libro2 NVARCHAR(100),
    Fecha DATE
);

-- 2FN
CREATE TABLE Estudiante2FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50)
);
CREATE TABLE Libro2FN (
    ISBN CHAR(13) PRIMARY KEY,
    Titulo NVARCHAR(100)
);
CREATE TABLE Prestamo2FN (
    ID INT PRIMARY KEY,
    ID_Estudiante INT,
    ISBN CHAR(13),
    Fecha DATE,
    FOREIGN KEY (ID_Estudiante) REFERENCES Estudiante2FN(ID),
    FOREIGN KEY (ISBN) REFERENCES Libro2FN(ISBN)
);

-- 3FN
CREATE TABLE Estudiante3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50)
);
CREATE TABLE Libro3FN (
    ISBN CHAR(13) PRIMARY KEY,
    Titulo NVARCHAR(100)
);
CREATE TABLE Prestamo3FN (
    ID INT PRIMARY KEY,
    ID_Estudiante INT,
    ISBN CHAR(13),
    Fecha DATE,
    FOREIGN KEY (ID_Estudiante) REFERENCES Estudiante3FN(ID),
    FOREIGN KEY (ISBN) REFERENCES Libro3FN(ISBN)
);


/* 
   BD40 - Música
   Enunciado: Registrar usuarios, artistas y canciones favoritas.
    */
USE master;
GO
IF DB_ID('BD40_Musica') IS NOT NULL
BEGIN
    ALTER DATABASE BD40_Musica SET SINGLE_USER WITH ROLLBACK IMMEDIATE;
    DROP DATABASE BD40_Musica;
END
GO
CREATE DATABASE BD40_Musica;
GO
USE BD40_Musica;
GO

-- 1FN
CREATE TABLE Favorito1FN (
    ID INT PRIMARY KEY,
    UsuarioNombre NVARCHAR(50),
    Artista NVARCHAR(50),
    Cancion1 NVARCHAR(100),
    Cancion2 NVARCHAR(100)
);

-- 2FN
CREATE TABLE Usuario2FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50)
);
CREATE TABLE Cancion2FN (
    ID INT PRIMARY KEY,
    Titulo NVARCHAR(100),
    Artista NVARCHAR(50)
);
CREATE TABLE Favorito2FN (
    ID INT PRIMARY KEY,
    ID_Usuario INT,
    ID_Cancion INT,
    FOREIGN KEY (ID_Usuario) REFERENCES Usuario2FN(ID),
    FOREIGN KEY (ID_Cancion) REFERENCES Cancion2FN(ID)
);

-- 3FN
CREATE TABLE Usuario3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50)
);
CREATE TABLE Artista3FN (
    ID INT PRIMARY KEY,
    Nombre NVARCHAR(50)
);
CREATE TABLE Cancion3FN (
    ID INT PRIMARY KEY,
    Titulo NVARCHAR(100),
    ID_Artista INT,
    FOREIGN KEY (ID_Artista) REFERENCES Artista3FN(ID)
);
CREATE TABLE Favorito3FN (
    ID INT PRIMARY KEY,
    ID_Usuario INT,
    ID_Cancion INT,
    FOREIGN KEY (ID_Usuario) REFERENCES Usuario3FN(ID),
    FOREIGN KEY (ID_Cancion) REFERENCES Cancion3FN(ID)
);
