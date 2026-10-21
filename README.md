# API REST de Videojuegos

API REST básica desarrollada con Java y Spring Boot para la actividad colaborativa #1 de Lenguaje de Programación III. Permite consultar y registrar videojuegos. Los datos se guardan en memoria, sin base de datos.

**Autor:** [Tu nombre completo]

## Requisitos

- JDK 17 o superior
- Maven (incluido en el proyecto mediante `mvnw`)

## Cómo ejecutarlo

1. Clona el repositorio o descarga el código.
2. Abre la carpeta en VS Code (o en otro IDE).
3. Ejecuta la clase `VideojuegosApiApplication`, o desde la terminal:

```
./mvnw spring-boot:run
```

En Windows puedes usar `mvnw.cmd spring-boot:run`.

4. El servidor queda disponible en `http://localhost:8080`.

## Endpoints

| Método | Ruta | Descripción |
|---|---|---|
| GET | `/videojuegos` | Lista todos los videojuegos |
| GET | `/videojuegos/{id}` | Busca un videojuego por su id (PathVariable) |
| GET | `/videojuegos/buscar?genero=Deportes` | Filtra por género (RequestParam) |
| POST | `/videojuegos` | Agrega un videojuego enviando JSON (RequestBody) |

### Ejemplo de JSON para el POST

```json
{
  "titulo": "Minecraft",
  "genero": "Sandbox",
  "plataforma": "PC",
  "anio": 2011
}
```

## Códigos de respuesta

- `200 OK`: la consulta se realizó correctamente.
- `201 Created`: el videojuego fue creado.
- `404 Not Found`: no existe un videojuego con ese id.

## Tecnologías

Java, Spring Boot, Maven.