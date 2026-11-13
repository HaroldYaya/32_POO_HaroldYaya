-- Base de datos del sistema Tienda de Muebles
CREATE DATABASE IF NOT EXISTS tienda_muebles
  CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE tienda_muebles;

CREATE TABLE IF NOT EXISTS muebles (
    id_producto INT AUTO_INCREMENT PRIMARY KEY,
    nombre      VARCHAR(100) NOT NULL,
    categoria   VARCHAR(60)  NOT NULL,
    material    VARCHAR(60)  NOT NULL,
    color       VARCHAR(40)  NOT NULL,
    dimensiones VARCHAR(60)  NOT NULL,
    precio      DECIMAL(10,2) NOT NULL CHECK (precio >= 0),
    stock       INT NOT NULL DEFAULT 0 CHECK (stock >= 0)
);

-- Datos de prueba
INSERT INTO muebles (nombre, categoria, material, color, dimensiones, precio, stock) VALUES
('Sofá Nórdico 3 cuerpos', 'Sala',        'Tela y madera',  'Gris',     '210x90x85 cm',  1850.00, 5),
('Mesa de comedor Roble',  'Comedor',     'Madera roble',   'Marrón',   '160x90x75 cm',  1200.00, 8),
('Silla Eames',            'Comedor',     'Plástico/Madera','Blanco',   '46x48x82 cm',    180.00, 25),
('Ropero 3 puertas',       'Dormitorio',  'Melamina',       'Wengué',   '150x50x200 cm',  950.00, 6),
('Escritorio Home Office', 'Oficina',     'Melamina',       'Negro',    '120x60x75 cm',   420.00, 12),
('Cama 2 plazas',          'Dormitorio',  'Madera cedro',   'Natural',  '140x190x40 cm', 1100.00, 4),
('Estante flotante',       'Decoración',  'MDF',            'Blanco',   '80x20x3 cm',      65.00, 40);
