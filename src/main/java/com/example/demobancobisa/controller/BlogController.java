package com.example.demobancobisa.controller;

import com.example.demobancobisa.Exception.ResourceNotFoundException;
import com.example.demobancobisa.model.Blog;
import com.example.demobancobisa.model.Comentario;
import com.example.demobancobisa.service.BlogService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blogs")
@Tag(name = "Blog", description = "Operaciones para gestionar blogs")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @Operation(summary = "Obtener todos los blogs")
    @GetMapping
    public List<Blog> obtenerTodosLosBlogs() {
        return blogService.obtenerBlogs();
    }

    @Operation(summary = "Obtener un blog por su ID")
    @GetMapping("/{id}")
    public Blog obtenerBlogPorId(@PathVariable Long id) throws ResourceNotFoundException {
        return blogService.obtenerBlogPorId(id);
    }

    @Operation(summary = "Actualizar un blog")
    @PutMapping("/{id}")
    public Blog actualizarBlog(@PathVariable Long id, @RequestBody Blog blog) throws ResourceNotFoundException {
        return blogService.actualizarBlog(id, blog);
    }

    @Operation(summary = "Agregar un comentario a un blog")
    @PostMapping("/{id}/comentarios")
    public ResponseEntity<String> agregarComentario(@PathVariable Long id, @RequestBody Comentario comentario) throws ResourceNotFoundException {
        blogService.agregarComentario(id, comentario);
        return ResponseEntity.ok("Comentario agregado correctamente.");
    }
}

