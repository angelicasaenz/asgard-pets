# 📋 Documento de Requisitos Técnicos - Asgard Pets API (v3.0)

Este documento define la arquitectura, reglas de negocio y endpoints a desarrollar en Spring Boot con persistencia en MySQL y seguridad JWT.

---

## 🗄️ 1. Entidades y Base de Datos (MySQL)

Las clases del modelo se mapearán a tablas relacionales usando Spring Data JPA:

* **Usuario:** `id` (PK), `cedula` (Unique), `nombre`, `email`, `telefono`, `password` (Encrypted), `rol` (ENUM: CLIENTE, EMPLEADO, ADMIN, PROVEEDOR).
* **Producto:** `id` (PK), `codigo` (Unique), `nombre`, `categoria`, `precio`, `stock`.
* **Venta:** `id` (PK), `fecha`, `cliente_id` (FK -> Usuario), `total`.
* **DetalleVenta:** `id` (PK), `venta_id` (FK -> Venta), `producto_id` (FK -> Producto), `cantidad`, `subtotal`.

---

## 🛠️ 2. Reglas de Negocio y Excepciones

* **Stock Insuficiente:** No se puede realizar una venta o detalle de venta si la cantidad solicitada supera el stock disponible.
* **Cédula / Código Duplicado:** No se permite registrar usuarios o productos con identificadores ya existentes.
* **Manejo de DTOs:** Toda comunicación con el cliente HTTP usará objetos DTO (`RequestDTO` / `ResponseDTO`) para proteger contraseñas y evitar bucles de recursión circular JSON.
* **Manejo Global de Errores:** Implementar `@RestControllerAdvice` (`GlobalExceptionHandler`) para capturar excepciones personalizadas y retornar un DTO estándar `ApiError` con códigos HTTP apropiados (400, 401, 403, 404, 409).

---

## 🔌 3. Endpoints REST a Construir

### 🔐 Módulo Autenticación (`/api/auth`)
* `POST /api/auth/register` - Registrar un nuevo usuario (público).
* `POST /api/auth/login` - Autenticarse y obtener Token JWT.

### 👤 Módulo Usuarios (`/api/usuarios`)
* `GET /api/usuarios` - Listar todos los usuarios (Requiere rol ADMIN).
* `GET /api/usuarios/{cedula}` - Buscar usuario por cédula.
* `POST /api/usuarios` - Registrar nuevo usuario.

### 📦 Módulo Productos (`/api/productos`)
* `GET /api/productos` - Listar productos del catálogo (Público / Autenticado).
* `POST /api/productos` - Crear producto (ADMIN).
* `PUT /api/productos/{id}` - Actualizar producto (ADMIN).
* `DELETE /api/productos/{id}` - Eliminar producto (ADMIN).

### 🛒 Módulo Ventas (`/api/ventas`)
* `POST /api/ventas` - Registrar nueva venta y calcular total.
* `GET /api/ventas` - Listar historial de ventas.

### 🧾 Módulo DetalleVenta (`/api/detalles-venta`)
* `POST /api/detalles-venta` - Registrar ítem en una venta y descontar stock del producto.
* `GET /api/detalles-venta/venta/{ventaId}` - Consultar todos los detalles pertenecientes a una venta específica.