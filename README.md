# 🐾 Asgard Pets y Fundación Aurora - Módulo Consola POO

Asgard Pets y Fundación Aurora es una aplicación backend en consola desarrollada en Java puro. El proyecto simula la gestión operativa de una empresa distribuidora de productos para mascotas y la administración de su fundación social dedicada al rescate, cuidado y adopción responsable de animales.

El objetivo principal de esta versión es demostrar el dominio práctico de la Programación Orientada a Objetos, el diseño de arquitecturas en capas para consola y el uso eficiente de colecciones en memoria RAM.

---

## 📖 Estado del Proyecto

### `v2.0` - Core POO y Manejo en Memoria (En Desarrollo)
Reestructuración integral del sistema aplicando los pilares de la Programación Orientada a Objetos y colecciones dinámicas (`ArrayList`) para gestionar la información en memoria RAM a través de menús interactivos en consola.

---
### 🛠️ Funcionalidades Clave y Estructura del Menú

#### 🛍️ Módulo Asgard Pets (Gestión Comercial e Inventario)
* **Gestión de Inventario:**
    * Registro parametrizado de productos por categoría (Alimentos, Medicamentos y Accesorios).
    * Búsqueda individual de productos por ID con validación defensiva.
    * Muestreo completo del inventario disponible.
    * Actualización en tiempo real de datos (precio, cantidad, nombre).
    * Eliminación física de registros del inventario.

#### 🐾 Módulo Fundación Aurora (Gestión Social y Adopciones)
* **Información Institucional:** Muestra de la misión, visión y relación estratégica entre Asgard Pets y la Fundación.
* **Gestión de Mascotas Rescatadas:**
    * Registro de animales rescatados (ID, Nombre, Especie, Edad).
    * Listado completo de mascotas disponibles para adopción.
    * Procesamiento de adopciones mediante la actualización de estado por ID de la mascota.

#### 💳 Módulo de Ventas
* Registro de ventas asociando datos de transacción, producto y cantidad.
* Cálculo automático del costo total e impacto directo en el stock disponible del inventario.

#### 👤 Módulo de Personas (Herencia y Polimorfismo)
* **Gestión de Usuarios y Roles:** Registro y consulta modular de Clientes, Empleados, Administradores y Proveedores utilizando la clase base abstracta `Usuario`.

#### 🛡️ Control de Entrada y Validaciones
* Componente centralizado `Validador` para interceptar errores de tipo de dato en la consola (`Scanner`).
* Flujos de navegación protegidos con cláusulas de guarda (*guard clauses*) para evitar excepciones en tiempo de ejecución.
---

## 🛠️ Tecnologías Utilizadas

* **Java** (JDK 17+)
* **IntelliJ IDEA**
* **Git y GitHub**
* **Markdown**
* **StarUML**

---

## 📚 Conceptos de POO y Arquitectura Aplicados

* **Paradigmas POO:** Encapsulamiento, Herencia, Polimorfismo y Clases Abstractas.
* **Estructuras de Datos:** Manejo de colecciones dinámicas (`ArrayList` e interfaz `List`).
* **Arquitectura Limpia en Capas (MVC simplificado):**
    * `model`: Clases y POJOs con su jerarquía e información del dominio.
    * `service`: Lógica de negocio pura y manipulación de las listas en memoria.
    * `util`: Lógica transversal de validación de entradas por `Scanner`.
    * `view`: Gestión de menús, flujos interactivos y muestra de respuestas al usuario.

---

## 📂 Documentación del Proyecto

Toda la documentación técnica de esta etapa se encuentra dentro de la carpeta `docs`:
* Requerimientos funcionales del sistema.
* Diagrama de clases UML completo.

---

## 🎯 Próximos Pasos

La lógica de negocio y las estructuras diseñadas en esta versión en consola servirán como base conceptual para la posterior migración hacia una arquitectura web distribuida utilizando Spring Boot, Spring Data JPA y bases de datos relacionales.

---
*Desarrollado como parte del proceso de aprendizaje y especialización en desarrollo backend con Java.*