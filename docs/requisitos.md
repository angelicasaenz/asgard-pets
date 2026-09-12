# 📋 Documento de Requisitos Técnicos - Asgard Pets API (v3.0)

Este documento define la arquitectura, reglas de negocio y endpoints a desarrollar en Spring Boot con persistencia en MySQL.

---

## 🗄️ 1. Entidades y Base de Datos (MySQL)

Las clases del modelo se mapearán a tablas relacionales usando Spring Data JPA:

* **Usuario:** `id` (PK), `cedula` (Unique), `nombre`, `email`, `telefono`, `rol` (ENUM: CLIENTE, EMPLEADO, ADMIN, PROVEEDOR).
* **Producto:** `id` (PK), `codigo` (Unique), `nombre`, `categoria`, `precio`, `stock`.
* **Venta:** `id` (PK), `fecha`, `cliente_id` (FK), `total`.
* **DetalleVenta:** `id` (PK), `venta_id` (FK), `producto_id` (FK), `cantidad`, `subtotal`.

---

## 🛠️ 2. Reglas de Negocio y Excepciones

* **Stock Insuficiente:** No se puede realizar una venta si la cantidad solicitada supera el stock disponible.
* **Cédula / Código Duplicado:** No se permite registrar usuarios o productos con identificadores ya existentes.
* **Manejo Global de Errores:** Implementar `@RestControllerAdvice` para capturar excepciones personalizadas y retornar respuestas HTTP estructuradas (404, 400, 409).

---

## 🔌 3. Endpoints REST a Construir

### 👤 Módulo Usuarios (`/api/usuarios`)
* `GET /api/usuarios` - Listar todos los usuarios.
* `GET /api/usuarios/{cedula}` - Buscar usuario por cédula.
* `POST /api/usuarios` - Registrar nuevo usuario.

### 📦 Módulo Productos (`/api/productos`)
* `GET /api/productos` - Listar productos.
* `POST /api/productos` - Crear producto.
* `PUT /api/productos/{id}` - Actualizar producto.
* `DELETE /api/productos/{id}` - Eliminar producto.

### 🛒 Módulo Ventas (`/api/ventas`)
* `POST /api/ventas` - Registrar nueva venta y actualizar stock.
* `GET /api/ventas` - Listar historial de ventas.