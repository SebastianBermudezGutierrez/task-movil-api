# 🚀 Instrucciones Rápidas - Gestión de Tareas

## 📋 Resumen del Proyecto

Sistema completo de gestión de tareas con categorías:
- **Backend**: Spring Boot + PostgreSQL
- **Frontend**: Ionic Vue
- **API**: REST endpoints en `/api/categories` y `/api/tasks`

## 🛠️ Configuración Inicial

### 1. Backend (Spring Boot)
```bash
cd gestionTareas
mvn spring-boot:run
```
- **Puerto**: 8079
- **API**: http://localhost:8079/api
- **Base de datos**: PostgreSQL (configurada en `application.properties`)

### 2. Frontend (Ionic Vue)
```bash
cd layoutBasica
npm install
npm run dev
```
- **Puerto**: 8100
- **URL**: http://localhost:8100

## 🔧 Configuración de Base de Datos

### PostgreSQL
1. **Crear base de datos**:
   ```sql
   CREATE DATABASE tareas;
   ```

2. **Configurar usuario**:
   ```sql
   CREATE USER grupo2 WITH PASSWORD '123456';
   GRANT ALL PRIVILEGES ON DATABASE tareas TO grupo2;
   ```

3. **Verificar configuración** en `gestionTareas/src/main/resources/application.properties`:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/tareas
   spring.datasource.username=grupo2
   spring.datasource.password=123456
   ```

## 🚀 Inicio Rápido

### Opción 1: Scripts Automáticos
```bash
# Backend (Windows)
cd gestionTareas
start-backend.bat

# Frontend (Windows)
cd layoutBasica
start-dev.bat
```

### Opción 2: Comandos Manuales
```bash
# Terminal 1 - Backend
cd gestionTareas
mvn spring-boot:run

# Terminal 2 - Frontend
cd layoutBasica
npm run dev
```

## 📱 Uso de la Aplicación

### Gestión de Tareas
1. **Ver tareas**: Lista con filtros (Todas, Pendientes, Completadas)
2. **Crear tarea**: Botón "+" → Llenar formulario → Guardar
3. **Editar tarea**: Tocar tarea → Modificar → Guardar
4. **Completar tarea**: Marcar checkbox
5. **Eliminar tarea**: Botón eliminar

### Gestión de Categorías
1. **Ver categorías**: Lista con contador de tareas
2. **Crear categoría**: Botón "+" → Llenar formulario → Guardar
3. **Editar categoría**: Tocar categoría → Modificar → Guardar
4. **Eliminar categoría**: Botón eliminar

## 🔗 Endpoints de la API

### Categorías
- `GET /api/categories` - Obtener todas
- `POST /api/categories` - Crear nueva
- `PUT /api/categories/{id}` - Actualizar
- `DELETE /api/categories/{id}` - Eliminar

### Tareas
- `GET /api/tasks` - Obtener todas
- `POST /api/tasks` - Crear nueva
- `PUT /api/tasks/{id}` - Actualizar
- `PATCH /api/tasks/{id}/toggle` - Alternar completado
- `DELETE /api/tasks/{id}` - Eliminar

## 🧪 Pruebas con Postman

1. **Importar colección**: `gestionTareas/Postman_Collection_Gestion_Tareas.json`
2. **Configurar variable**: `base_url = http://localhost:8079/api`
3. **Probar endpoints**: Usar los requests predefinidos

## 🚨 Solución de Problemas

### Error de Conexión a Base de Datos
- Verificar que PostgreSQL esté ejecutándose
- Verificar credenciales en `application.properties`
- Verificar que la base de datos `tareas` exista

### Error de CORS
- Verificar que el backend esté en puerto 8079
- Verificar configuración CORS en `CorsConfig.java`

### Error 404 en API
- Verificar que uses `/api/categories` y `/api/tasks`
- Verificar que el backend esté ejecutándose

## 📁 Estructura del Proyecto

```
Gestion-Tareas/
├── gestionTareas/          # Backend Spring Boot
│   ├── src/main/java/      # Código Java
│   ├── src/main/resources/ # Configuración
│   └── pom.xml            # Dependencias Maven
├── layoutBasica/          # Frontend Ionic Vue
│   ├── src/               # Código Vue
│   ├── package.json       # Dependencias NPM
│   └── README.md          # Documentación
└── INSTRUCCIONES_RAPIDAS.md
```

## 🎯 Próximos Pasos

1. **Probar la aplicación** localmente
2. **Configurar base de datos** de producción
3. **Desplegar backend** en la nube
4. **Desplegar frontend** en la nube
5. **Configurar URLs** de producción

¡Listo para usar! 🎉
