package com.example.bibliotecaduoc.controller;

import com.example.bibliotecaduoc.model.Libro;
import com.example.bibliotecaduoc.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/libros")
public class LibroController {

    @Autowired
    private LibroService libroService;

    @GetMapping
    public List<Libro> listarLibros() {
        return libroService.getLibros();
    }

    @PostMapping
    public Libro agregarLibro(@RequestBody Libro libro) {
        return libroService.saveLibro(libro);
    }

    @GetMapping("{id}")
    public Libro buscarLibro(@PathVariable int id){
        return libroService.getLibroId(id);
    }

    @PutMapping("{id}")
    public Libro actualizarLibro(@PathVariable int id, @RequestBody Libro libro){
        // el id lo usaremos mas adelante
        return libroService.updateLibro(libro);
    }

    @DeleteMapping("{id}")
    public String eliminarLibro(@PathVariable int id) {
        return libroService.deleteLibro(id);
    }

    @GetMapping("total")
    public int totalLibrosV2(){
        return libroService.totalLibrosV2();
    }

    @GetMapping("/isbm/{isbn}")
    public Libro buscarPorIsbn(@PathVariable String isbn){
        return libroService.buscarPorIsbn(isbn);
    }

    @GetMapping("/anio/{anio}")
    public int buscarPorAnio(@PathVariable int anio){
        return libroService.cantidadPorAnio(anio);
    }

    @GetMapping("/autor/{autor}")
    public List<Libro>BuscarPorAutor(@PathVariable String autor){
        return libroService.buscarAutor(autor);
    }

    @GetMapping("antiguo")
    public Libro libroMasAntiguo(){
        return libroService.libroMasAntiguo();
    }

}
