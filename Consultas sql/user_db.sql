

-- Tabla principal de usuarios (según tu User.java)
CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    lastname VARCHAR(100) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password_hash TEXT NOT NULL
);

-- Tabla de roles básica
CREATE TABLE roles (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL UNIQUE
);

-- Tabla de relación usuario-rol
CREATE TABLE user_roles (
    user_id INTEGER REFERENCES users(id),
    role_id INTEGER REFERENCES roles(id),
    PRIMARY KEY (user_id, role_id)
);

-- Insertar datos de prueba
INSERT INTO roles (name) VALUES 
('ADMIN'), ('USER'), ('TECHNICIAN');

INSERT INTO users (name, lastname, email, password_hash) VALUES 
('Juan', 'Pérez', 'juan@example.com', '$2a$10$xD...'),
('María', 'Gómez', 'maria@example.com', '$2a$10$yF...');

INSERT INTO user_roles (user_id, role_id) VALUES 
(1, 1), -- Juan es ADMIN
(2, 2); -- María es USER


-- Ver todos los usuarios registrados
SELECT id, name, lastname, email FROM users;

-- Ver usuarios con sus roles
SELECT u.id, u.name, u.email, r.name AS role
FROM users u
JOIN user_roles ur ON u.id = ur.user_id
JOIN roles r ON ur.role_id = r.id;

-- Contar usuarios por rol
SELECT r.name AS role, COUNT(u.id) AS user_count
FROM roles r
LEFT JOIN user_roles ur ON r.id = ur.role_id
LEFT JOIN users u ON ur.user_id = u.id
GROUP BY r.name;

-- Ver estructura de la tabla usuarios (metadatos)
SELECT column_name, data_type, character_maximum_length 
FROM information_schema.columns 
WHERE table_name = 'users';
