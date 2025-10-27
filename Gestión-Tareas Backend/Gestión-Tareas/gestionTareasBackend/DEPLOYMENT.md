# Guía de Despliegue - Gestión de Tareas

Sistema completo de gestión de tareas con categorías, incluyendo backend Spring Boot y frontend Ionic Vue.

## Arquitectura

- **Backend**: Spring Boot + JPA + PostgreSQL
- **Frontend**: Ionic Vue + Axios
- **Base de datos**: PostgreSQL (desarrollo y producción)

## Configuración para Producción

### 1. Configuración del Backend

#### Variables de Entorno
Crea un archivo `.env` o configura las siguientes variables de entorno:

```bash
# Base de datos
DB_URL=jdbc:postgresql://tu-servidor:5432/tareas
DB_USERNAME=tu-usuario
DB_PASSWORD=tu-password

# CORS (URLs permitidas)
CORS_ALLOWED_ORIGINS=https://tu-dominio-frontend.com,https://www.tu-dominio-frontend.com

# Puerto
SERVER_PORT=8080
```

#### Archivo de Configuración
Modifica `src/main/resources/application-prod.properties`:

```properties
# Base de datos de producción
spring.datasource.url=${DB_URL}
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}

# CORS para producción
cors.allowed-origins=${CORS_ALLOWED_ORIGINS}
```

### 2. Configuración del Frontend

#### Archivo de Configuración
Modifica `src/config/api.js`:

```javascript
// Cambia esta URL por la de tu backend en producción
const API_BASE_URL = 'https://tu-dominio-backend.com/api';

// O usa variables de entorno
const API_BASE_URL = process.env.VUE_APP_API_URL || 'http://localhost:8080/api';
```

#### Variables de Entorno del Frontend
Crea un archivo `.env.production`:

```bash
VUE_APP_API_URL=https://tu-dominio-backend.com/api
```

### 3. Despliegue en la Nube

#### Opción 1: Heroku
1. Crea una app en Heroku
2. Conecta tu repositorio
3. Configura las variables de entorno en el dashboard
4. Despliega automáticamente

#### Opción 2: Railway
1. Conecta tu repositorio
2. Configura las variables de entorno
3. Despliega automáticamente

#### Opción 3: DigitalOcean App Platform
1. Conecta tu repositorio
2. Configura las variables de entorno
3. Despliega automáticamente

### 4. Base de Datos

#### PostgreSQL en la Nube
- **Heroku Postgres**: Add-on gratuito
- **Railway PostgreSQL**: Incluido
- **DigitalOcean Managed Databases**: Servicio gestionado
- **AWS RDS**: Servicio de base de datos

#### Configuración de la Base de Datos
1. Crea la base de datos `tareas`
2. Ejecuta el script `schema.sql` para crear las tablas
3. Configura las credenciales en las variables de entorno

### 5. Dominio Personalizado

#### Backend
- Configura un dominio para tu API (ej: `api.tu-dominio.com`)
- Actualiza la configuración CORS
- Configura SSL/HTTPS

#### Frontend
- Configura un dominio para tu app (ej: `app.tu-dominio.com`)
- Actualiza la URL del API en la configuración
- Configura SSL/HTTPS

### 6. Monitoreo y Logs

#### Heroku
```bash
# Ver logs
heroku logs --tail

# Ver métricas
heroku metrics
```

#### Railway
- Logs disponibles en el dashboard
- Métricas incluidas

### 7. Ejemplo de Configuración Completa

#### Backend (application-prod.properties)
```properties
spring.datasource.url=jdbc:postgresql://db-postgresql-nyc1-12345-do-user-123456-0.db.ondigitalocean.com:25060/defaultdb?sslmode=require
spring.datasource.username=doadmin
spring.datasource.password=tu-password-seguro
cors.allowed-origins=https://tu-app.vercel.app,https://tu-app.netlify.app
```

#### Frontend (api.js)
```javascript
const API_BASE_URL = 'https://tu-api.herokuapp.com/api';
```

### 8. Checklist de Despliegue

- [ ] Base de datos configurada y accesible
- [ ] Variables de entorno configuradas
- [ ] CORS configurado correctamente
- [ ] SSL/HTTPS habilitado
- [ ] Dominios configurados
- [ ] Logs funcionando
- [ ] Monitoreo configurado
- [ ] Backup de base de datos configurado

### 9. Troubleshooting

#### Error de CORS
- Verifica que las URLs del frontend estén en `cors.allowed-origins`
- Asegúrate de que el protocolo (http/https) coincida

#### Error de Base de Datos
- Verifica las credenciales
- Asegúrate de que la base de datos esté accesible
- Verifica la configuración SSL

#### Error de Conexión Frontend-Backend
- Verifica la URL del API en el frontend
- Asegúrate de que el backend esté funcionando
- Verifica los logs del backend

### 10. URLs de Ejemplo

#### Desarrollo Local
- Backend: `http://localhost:8080`
- Frontend: `http://localhost:8100`

#### Producción
- Backend: `https://tu-api.herokuapp.com`
- Frontend: `https://tu-app.vercel.app`

---

## 📝 Notas Importantes

1. **Siempre usa HTTPS en producción**
2. **Configura variables de entorno para datos sensibles**
3. **Habilita logs para monitoreo**
4. **Configura backup de la base de datos**
5. **Prueba la aplicación después del despliegue**

## 🔧 Comandos Útiles

```bash
# Ejecutar en desarrollo
npm run dev

# Construir para producción
npm run build

# Ejecutar backend
mvn spring-boot:run

# Ejecutar con perfil de producción
mvn spring-boot:run -Dspring.profiles.active=prod
```
