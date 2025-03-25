-- Tabla de mantenimientos
CREATE TABLE mantenimientos (
    id SERIAL PRIMARY KEY,
    equipo VARCHAR(255) NOT NULL,
    descripcion TEXT,
    estado VARCHAR(50) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Datos de prueba
INSERT INTO mantenimientos (equipo, descripcion, estado) VALUES
('Laptop Dell XPS', 'Cambio de teclado', 'EN_PROGRESO'),
('Proyector Epson', 'Limpieza de lentes', 'COMPLETADO'),
('Servidor HP', 'Actualización de RAM', 'PENDIENTE');

-- Consulta para ver datos
SELECT * FROM mantenimientos;