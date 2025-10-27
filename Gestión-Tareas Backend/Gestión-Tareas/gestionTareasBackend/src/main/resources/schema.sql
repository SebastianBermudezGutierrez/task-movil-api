-- Script de inicialización simplificado para la base de datos de gestión de tareas
-- Este archivo se ejecuta automáticamente al iniciar la aplicación

-- Insertar categorías de ejemplo (compatible con H2)
INSERT INTO categories (name, description) VALUES 
('Universidad', 'Tareas relacionadas con estudios universitarios'),
('Trabajo', 'Tareas profesionales y laborales'),
('Personal', 'Tareas personales y del hogar'),
('Salud', 'Tareas relacionadas con salud y bienestar'),
('Finanzas', 'Tareas relacionadas con gestión financiera');