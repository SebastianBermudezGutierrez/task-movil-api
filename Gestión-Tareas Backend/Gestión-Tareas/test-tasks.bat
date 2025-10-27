@echo off
echo ========================================
echo    PROBANDO ENDPOINTS DE TAREAS
echo ========================================
echo.

echo 1. Obteniendo todas las tareas...
curl -X GET http://localhost:8079/api/tasks
echo.
echo.

echo 2. Obteniendo tarea con ID 1...
curl -X GET http://localhost:8079/api/tasks/1
echo.
echo.

echo 3. Obteniendo todas las categorías...
curl -X GET http://localhost:8079/api/categories
echo.
echo.

pause
