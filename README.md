# API REST de Videojuegos con persistencia (CRUD)

API REST desarrollada con Java y Spring Boot para la Actividad Colaborativa #2 de Lenguaje de Programación III. Permite crear, consultar, actualizar y eliminar videojuegos, guardando la información en una base de datos H2 mediante JPA e Hibernate.

## Contexto

Catálogo de videojuegos. Cada videojuego tiene título, género, plataforma y año de lanzamiento.

## Integrantes

- Andrés Galindo (trabajo individual)

## Tecnologías utilizadas

- Java
- Spring Boot (Spring Web)
- Spring Data JPA e Hibernate
- Base de datos H2 (en memoria)
- Maven

## Cómo ejecutar el proyecto

1. Clonar el repositorio o descargar el código.
2. Abrir la carpeta en VS Code o en otro IDE con Java 17 o superior.
3. Ejecutar la clase `VideojuegosApiApplication`, o desde la terminal:

```
./mvnw spring-boot:run
```

En Windows se puede usar `mvnw.cmd spring-boot:run`.

4. La API queda disponible en `http://localhost:8080`.

Nota: la base de datos H2 es en memoria, por lo que los datos se borran al reiniciar la aplicación.

## Endpoints principales

| Método | Ruta | Descripción | Respuesta |
|---|---|---|---|
| POST | `/videojuegos` | Crea un videojuego | 201 Created |
| GET | `/videojuegos` | Lista todos los videojuegos | 200 OK |
| GET | `/videojuegos/{id}` | Consulta un videojuego por id | 200 OK o 404 Not Found |
| PUT | `/videojuegos/{id}` | Actualiza un videojuego | 200 OK o 404 Not Found |
| DELETE | `/videojuegos/{id}` | Elimina un videojuego | 204 No Content o 404 Not Found |
| GET | `/videojuegos/buscar?genero=Deportes` | Consulta personalizada por género | 200 OK |

## Ejemplo

Solicitud `POST /videojuegos`:

```json
{
  "titulo": "FIFA 23",
  "genero": "Deportes",
  "plataforma": "PlayStation 5",
  "anio": 2022
}
```

Respuesta `201 Created`:

```json
{
  "id": 1,
  "titulo": "FIFA 23",
  "genero": "Deportes",
  "plataforma": "PlayStation 5",
  "anio": 2022
}
```