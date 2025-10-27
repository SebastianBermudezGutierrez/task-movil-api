@echo off
echo ========================================
echo    INICIALIZANDO BASE DE DATOS
echo ========================================
echo.

echo Creando categorías de ejemplo...
curl -X POST http://localhost:8079/api/categories -H "Content-Type: application/json" -d "{\"name\":\"Universidad\",\"description\":\"Tareas relacionadas con estudios universitarios\"}"
echo.

curl -X POST http://localhost:8079/api/categories -H "Content-Type: application/json" -d "{\"name\":\"Trabajo\",\"description\":\"Tareas profesionales y laborales\"}"
echo.

curl -X POST http://localhost:8079/api/categories -H "Content-Type: application/json" -d "{\"name\":\"Personal\",\"description\":\"Tareas personales y del hogar\"}"
echo.

echo Creando tareas de ejemplo...
curl -X POST http://localhost:8079/api/tasks -H "Content-Type: application/json" -d "{\"title\":\"Estudiar para el examen\",\"description\":\"Repasar los temas del capítulo 5\",\"categoryId\":1,\"priority\":\"HIGH\",\"dueDate\":\"2024-12-31\"}"
echo.

curl -X POST http://localhost:8079/api/tasks -H "Content-Type: application/json" -d "{\"title\":\"Reunión de equipo\",\"description\":\"Preparar presentación para la reunión\",\"categoryId\":2,\"priority\":\"MEDIUM\",\"dueDate\":\"2024-12-25\"}"
echo.

echo.
echo Base de datos inicializada con datos de ejemplo.
echo.

pause
