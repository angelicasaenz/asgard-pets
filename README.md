# 🐾 Asgard Pets - API Backend Profesional

Asgard Pets es una API RESTful en desarrollo construida con **Spring Boot** y **MySQL** para la gestión comercial de una distribuidora de alimentos, medicamentos y accesorios para mascotas.

El proyecto evolucionará desde un sistema monolítico por consola hacia una arquitectura profesional por capas, garantizando la administración de usuarios, productos, ventas y el registro detallado de transacciones.

---

## 👥 Equipo de Desarrollo

Proyecto desarrollado en pareja simulando un entorno de trabajo colaborativo real con Git/GitHub:

* 💻 **Angelica Saenz** ([@angelicasaenz](https://github.com/angelicasaenz)) — *Módulo DetalleVenta y Ventas*
* 💻 **Mohamed Omais** ([@mohaomais](https://github.com/mohaomais)) — *Módulo Productos y Usuarios*

---

## 📖 Historia y Contexto Comercial

Asgard Pets requiere centralizar sus operaciones. Anteriormente, la información de clientes, stock de bodega y facturación vivía en registros dispersos y hojas de cálculo.

Esta API REST solucionará la desorganización mediante una persistencia relacional confiable, prevención de errores de negocio (como vender productos sin stock o registrar ítems duplicados) y control de acceso basado en roles (`CLIENTE`, `EMPLEADO`, `ADMIN`, `PROVEEDOR`)[cite: 1, 4].

---

## 🛠️ Tecnologías Utilizadas

* **Lenguaje:** Java 17
* **Framework:** Spring Boot (Spring Web, Spring Data JPA, Spring Security)[cite: 1, 2, 5]
* **Base de Datos:** MySQL / MySQL Workbench
* **Seguridad:** JSON Web Tokens (JWT) y BCrypt Password Encoder[cite: 1]
* **Documentación y Pruebas:** Swagger UI / OpenAPI 3.0[cite: 1, 2]
* **Gestor de Dependencias:** Maven[cite: 1, 2, 5]
* **Control de Versiones:** Git y GitHub[cite: 1, 2, 5]

---

## 🗂️ Arquitectura del Proyecto

El sistema seguirá una **Arquitectura por Capas** estricta para garantizar el desacoplamiento y la mantenibilidad[cite: 1, 2, 5]:

```text
com.asgard.pets.backend
 ├── config/          # Configuraciones globales (Swagger, OpenApi)
 ├── controller/      # Endpoints HTTP y gestión de respuestas (200, 201, 400, 403)
 ├── dto/             # Objetos de transferencia de datos (Request / Response)
 ├── exception/       # Manejo global de errores (GlobalExceptionHandler, ApiError)
 ├── model/           # Entidades JPA mapeadas a tablas de MySQL
 ├── repository/      # Interfaces JpaRepository para persistencia
 ├── security/        # Filtros JWT, SecurityConfig y Carga de UserDetails
 └── service/         # Lógica de negocio y validación de reglas
```

## 🛢️ Modelo de Datos (Entidades & Atributos)

El diseño relacional se compone de las siguientes 4 entidades mapeadas con JPA/Hibernate:

* **`Usuario`**: Representa la identidad en el sistema.
    * `id` (PK, Long)
    * `cedula` (Unique, String)
    * `nombre` (String)
    * `email` (String)
    * `telefono` (String)
    * `rol` (ENUM: CLIENTE, EMPLEADO, ADMIN, PROVEEDOR)
* **`Producto`**: Catálogo de artículos disponibles.
    * `id` (PK, Long)
    * `codigo` (Unique, String)
    * `nombre` (String)
    * `categoria` (String)
    * `precio` (Double)
    * `stock` (Integer)
* **`Venta`**: Cabecera de la transacción de compra.
    * `id` (PK, Long)
    * `fecha` (LocalDateTime)
    * `cliente_id` (FK -> Usuario, Long)
    * `total` (Double)
* **`DetalleVenta`**: Ítems individuales agrupados en una venta.
    * `id` (PK, Long)
    * `venta_id` (FK -> Venta, Long)
    * `producto_id` (FK -> Producto, Long)
    * `cantidad` (Integer)
    * `subtotal` (Double)

> **Nota sobre DTOs:** Las respuestas públicas utilizan objetos DTO para evitar ciclos de recursión JSON y ocultar datos sensibles.

---

## 🔐 Seguridad y Autenticación

El sistema implementa una política de sesión **Stateless** respaldada por **JWT**:

* **Rutas Públicas:** `/api/auth/register` y `/api/auth/login`.
* **Rutas Protegidas:** Exigen un token enviado en el encabezado HTTP: `Authorization: Bearer <TOKEN>`.
* **Control de Roles:** Los usuarios estándar (`CLIENTE`/`USER`) pueden consultar el catálogo e interactuar con la tienda, mientras que la gestión avanzada de productos o personal exige rol `ADMIN`.

---

## 🚀 Cómo Ejecutar el Proyecto

### Requisitos Previos
* Tener instalado **Java 17+** y **Maven**.
* Servicio activo de **MySQL**.

### Pasos de Configuración

1. **Clonar el repositorio y ubicar la rama de trabajo:**
   ```bash
   git clone [https://github.com/angelicasaenz/asgard-pets.git](https://github.com/angelicasaenz/asgard-pets.git)
   cd asgard-pets/backend
   git checkout feature/spring-boot
    ```

### 2. Configurar la base de datos MySQL

Crea la base de datos desde MySQL Workbench:

```sql
CREATE DATABASE asgard_pets_db;
```
### 3. Configurar `application.properties`

Ajusta las credenciales de tu motor local en `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/asgard_pets_db?serverTimezone=UTC
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update    
```

### 4. Ejecutar la aplicación

* **En Windows:**
  ```cmd
  .\mvnw.cmd spring-boot:run

* **En Linux/macOS:**
  ```bash
  ./mvnw spring-boot:run
  ```
### 5. Acceder a Swagger UI (Documentación interactiva)

Una vez iniciado el servidor, ingresa en tu navegador a:  
`http://localhost:8080/swagger-ui.html`

## 📂 Documentación del Proyecto

La carpeta `docs/` incluye la información de diseño:
* `requisitos.md`: Especificación funcional y reglas de negocio del sistema.
* `Diagrama-clases-v2.png`: Diagrama UML relacional de entidades.

---
## 📌 Endpoints de la API

| Método | Ruta | Acceso | Descripción |
| :--- | :--- | :--- | :--- |
| **POST** | `/api/auth/register` | Público | Registro de usuarios (asignará rol `CLIENTE`/`USER`). |
| **POST** | `/api/auth/login` | Público | Autenticación y generación del token JWT. |
| **POST** | `/api/productos` | ADMIN | Registrar un nuevo producto en el catálogo. |
| **GET** | `/api/productos` | Autenticado | Consultar catálogo de productos mediante DTO. |
| **POST** | `/api/ventas` | Autenticado | Registrar la cabecera de una compra. |
| **GET** | `/api/ventas` | Autenticado | Consultar historial de ventas. |
| **POST** | `/api/detalles-venta` | Autenticado | Registrar ítem de venta validando stock. |
| **GET** | `/api/detalles-venta/venta/{id}` | Autenticado | Filtrar detalles por ID de venta. |

---

## ⚠️ Manejo Global de Errores y Validaciones

La API implementará un `@ControllerAdvice` global (`GlobalExceptionHandler`) para capturar las excepciones de negocio y validación (`@Valid`), retornando un objeto estandarizado `ApiError`:

* **`200 OK`**: Consultas exitosas.
* **`201 Created`**: Creación exitosa de recursos.
* **`400 Bad Request`**: Datos de entrada inválidos, campos nulos o violación de reglas de negocio (ej. producto sin stock).
* **`403 Forbidden`**: Intento de acceso a rutas administrativas con un rol no autorizado.
* **`500 Internal Server Error`**: Errores no controlados sin exponer detalles sensibles del servidor.

---

## 🧪 Matriz de Pruebas Manuales (A ejecutar en Swagger UI)

| # | Escenario de Prueba | Resultado Esperado | Estado HTTP |
| :-: | :--- | :--- | :-: |
| **1** | Registro de usuario válido | Usuario registrado y JWT emitido | `200 OK` |
| **2** | Registro con correo inválido o clave corta | Rechazo por validación DTO | `400 Bad Request` |
| **3** | Login con credenciales correctas | Retornará Bearer Token | `200 OK` |
| **4** | Consulta de ventas sin Token | Acceso denegado por filtro JWT | `401 Unauthorized` |
| **5** | Crear producto con rol `CLIENTE` | Acceso restringido a administradores | `403 Forbidden` |
| **6** | Crear producto con rol `ADMIN` | Producto creado exitosamente | `201 Created` |
| **7** | Venta con producto sin stock disponible | Rechazo por regla de negocio | `400 Bad Request` |
| **8** | Consulta filtrada de detalles de venta | Retornará lista plana en DTO | `200 OK` |
| **9** | Persistencia tras reiniciar servidor | Los datos permanecerán en MySQL | `200 OK` |

---

## 🤖 Uso de Inteligencia Artificial

Se utiliza IA como herramienta de apoyo para el diagnóstico de errores de entorno (Git/OneDrive), estructuración del modelo relacional, diseño de la arquitectura DTO y redacción de la documentación. Todas las decisiones de código y arquitectura se validarán y probarán manualmente durante el desarrollo del proyecto.

---

🎯 **Proyecto educativo desarrollado con Java y Spring Boot.**