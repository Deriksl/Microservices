-- Tabla de reservaciones
CREATE TABLE reservations (
    id SERIAL PRIMARY KEY,
    usuario VARCHAR(255) NOT NULL,
    equipo VARCHAR(255) NOT NULL,
    fecha VARCHAR(50) NOT NULL,
    estado VARCHAR(50) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Índices para búsquedas frecuentes
CREATE INDEX idx_reservations_usuario ON reservations(usuario);
CREATE INDEX idx_reservations_equipo ON reservations(equipo);
CREATE INDEX idx_reservations_fecha ON reservations(fecha);

-- Datos de prueba
INSERT INTO reservations (usuario, equipo, fecha, estado) VALUES
('user1@example.com', 'Laptop Dell XPS', '2025-04-01', 'CONFIRMADA'),
('user2@example.com', 'Sala de Conferencias A', '2025-04-02', 'PENDIENTE'),
('user3@example.com', 'Proyector Epson', '2025-04-03', 'CANCELADA');

-- Consulta para ver datos
SELECT * FROM reservations;