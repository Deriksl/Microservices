-- Tabla para almacenar equipos
CREATE TABLE equipment (
    id SERIAL PRIMARY KEY, -- Identificador único autoincremental
    name VARCHAR(100) NOT NULL, -- Nombre del equipo
    description TEXT, -- Descripción del equipo
    category VARCHAR(50) NOT NULL, -- Categoría (computadora, proyector, etc.)
    status VARCHAR(50) NOT NULL, -- Estado (disponible, en uso, mantenimiento)
    last_maintenance TIMESTAMP, -- Fecha del último mantenimiento
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- Fecha de creación
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP -- Fecha de actualización
);

-- Tabla para almacenar el historial de mantenimientos
CREATE TABLE maintenance_history (
    id SERIAL PRIMARY KEY, -- Identificador único autoincremental
    equipment_id INT REFERENCES equipment(id), -- Relación con la tabla equipment
    maintenance_date TIMESTAMP NOT NULL, -- Fecha del mantenimiento
    description TEXT, -- Descripción del mantenimiento
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP -- Fecha de creación
);

SELECT * FROM equipment;
SELECT * FROM maintenance_history;