-- ==========================================
-- 🔹 Versión Segura del Script AltavistaDB (SQL Server)
-- ==========================================

-- Asegurarse de estar en master
USE master;
GO

-- 1️⃣ Si la base existe, elimínala sin desconectar sesión
IF EXISTS (SELECT name FROM sys.databases WHERE name = N'AltavistaDB')
BEGIN
    -- Desconectar a todos los usuarios de forma segura
    ALTER DATABASE AltavistaDB SET SINGLE_USER WITH ROLLBACK IMMEDIATE;
    DROP DATABASE AltavistaDB;
END
GO

-- 2️⃣ Crear la base
CREATE DATABASE AltavistaDB;
GO

-- 3️⃣ Usar la nueva base
USE AltavistaDB;
GO

-- Crear tabla de clientes
IF NOT EXISTS (SELECT * FROM sys.tables WHERE name = 'customer')
BEGIN
    CREATE TABLE customer (
        customer_id INT IDENTITY(1,1) PRIMARY KEY,
        first_name NVARCHAR(100) NOT NULL,
        last_name NVARCHAR(100) NOT NULL,
        phone NVARCHAR(20),
        email NVARCHAR(100),
        registered_at DATETIME DEFAULT GETDATE(),
        updated_at DATETIME DEFAULT GETDATE(),
        preferences NVARCHAR(MAX),
        is_active BIT DEFAULT 1,
        client_type CHAR(1) NOT NULL
    );
END
GO

-- Crear tabla de productos
IF NOT EXISTS (SELECT * FROM sys.tables WHERE name = 'product')
BEGIN
    CREATE TABLE product (
        product_id INT IDENTITY(1,1) PRIMARY KEY,
        name NVARCHAR(100) NOT NULL,
        description NVARCHAR(MAX),
        price DECIMAL(10,2) NOT NULL,
        category CHAR(3),
        is_available BIT DEFAULT 1,
        image_url NVARCHAR(255),
        launch_date DATE,
        prep_time TIME,
        is_featured BIT DEFAULT 0,
        nutritional_info NVARCHAR(MAX)
    );
END
GO

-- Insertar datos de ejemplo
INSERT INTO customer (first_name, last_name, phone, email, preferences, is_active, client_type) VALUES
(N'Juan', N'García', '555-0001', 'juan@example.com', N'{"notifications": true}', 1, 'A'),
(N'María', N'López', '555-0002', 'maria@example.com', N'{"notifications": false}', 1, 'B'),
(N'Carlos', N'Martínez', '555-0003', 'carlos@example.com', N'{"notifications": true}', 0, 'A');
GO

INSERT INTO product (name, description, price, category, is_available, image_url, launch_date, prep_time, is_featured, nutritional_info) VALUES
(N'Hamburguesa Clásica', N'Hamburguesa con queso y lechuga', 8.99, 'HAM', 1, '/images/hamburguesa.jpg', '2024-01-15', '00:15:00', 1, N'{"calories": 450, "protein": 25}'),
(N'Pizza Margarita', N'Pizza con tomate, mozzarella y albahaca', 12.99, 'PIZ', 1, '/images/pizza.jpg', '2024-01-20', '00:20:00', 1, N'{"calories": 280, "protein": 12}'),
(N'Ensalada César', N'Ensalada fresca con pollo y aderezo César', 9.99, 'ENS', 1, '/images/ensalada.jpg', '2024-02-01', '00:10:00', 0, N'{"calories": 350, "protein": 30}');
GO

-- 7️⃣ Verificar datos
SELECT 'customer_vertabelo' AS TableName, * FROM customer;
SELECT 'product_ajustado' AS TableName, * FROM product;
GO






Contenedor docker
PS C:\Users\Yancarlos> docker run -e "ACCEPT_EULA=Y" -e "SA_PASSWORD=MiPassword123!" -p 1433:1433 --name sqlserver -d m
