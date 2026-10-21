package com.andesgalindo.videojuegosapi;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/videojuegos")
public class VideojuegoController {

    private final List<Videojuego> videojuegos = new ArrayList<>();

    public VideojuegoController() {
        videojuegos.add(new Videojuego(1L, "Zelda: Breath of the Wild", "Aventura", "Nintendo Switch", 2017));
        videojuegos.add(new Videojuego(2L, "FIFA 23", "Deportes", "PlayStation 5", 2022));
        videojuegos.add(new Videojuego(3L, "Hollow Knight", "Metroidvania", "PC", 2017));
    }

    // 1. GET simple: lista todos los juegos
    @GetMapping
    public List<Videojuego> listar() {
        return videojuegos;
    }

    // 2. GET con PathVariable: busca un juego por su id
    @GetMapping("/{id}")
    public ResponseEntity<Videojuego> buscarPorId(@PathVariable Long id) {
        for (Videojuego v : videojuegos) {
            if (v.id().equals(id)) {
                return ResponseEntity.ok(v);
            }
        }
        return ResponseEntity.notFound().build();
    }

    // 3. GET con RequestParam: filtra por género
    @GetMapping("/buscar")
    public ResponseEntity<List<Videojuego>> buscarPorGenero(@RequestParam String genero) {
        List<Videojuego> resultado = new ArrayList<>();
        for (Videojuego v : videojuegos) {
            if (v.genero().equalsIgnoreCase(genero)) {
                resultado.add(v);
            }
        }
        return ResponseEntity.ok(resultado);
    }

    // 4. POST con RequestBody: agrega un juego nuevo
    @PostMapping
    public ResponseEntity<Videojuego> crear(@RequestBody Videojuego nuevo) {
        Videojuego creado = new Videojuego(
                videojuegos.size() + 1L,
                nuevo.titulo(),
                nuevo.genero(),
                nuevo.plataforma(),
                nuevo.anio());
        videojuegos.add(creado);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }
}