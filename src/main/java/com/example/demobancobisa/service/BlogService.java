package com.example.demobancobisa.service;

import com.example.demobancobisa.Exception.ResourceNotFoundException;
import com.example.demobancobisa.model.Blog;
import com.example.demobancobisa.model.Comentario;
import com.example.demobancobisa.model.HistorialBlog;
import com.example.demobancobisa.repository.BlogRepository;
import com.example.demobancobisa.repository.ComentarioRepository;
import com.example.demobancobisa.repository.HistorialBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;

@Service
public class BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private ComentarioRepository comentarioRepository;

    @Autowired
    private HistorialBlogRepository historialBlogRepository;

    public Blog actualizarBlog(Long id, Blog newBlog) throws ResourceNotFoundException {
        Blog blog = blogRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Blog no encontrado"));

        HistorialBlog historial = new HistorialBlog();
        historial.setBlog(blog);
        historial.setTitulo(blog.getTitulo());
        historial.setTema(blog.getTema());
        historial.setContenido(blog.getContenido());
        historial.setPeriodicidad(blog.getPeriodicidad());
        historial.setPermiteComentarios(blog.getPermiteComentarios());
        historial.setFechaActualizacion(LocalDateTime.now());
        historialBlogRepository.save(historial);

        blog.setTitulo(newBlog.getTitulo());
        blog.setTema(newBlog.getTema());
        blog.setContenido(newBlog.getContenido());
        blog.setPeriodicidad(newBlog.getPeriodicidad());
        blog.setPermiteComentarios(newBlog.getPermiteComentarios());
        return blogRepository.save(blog);
    }

    public void agregarComentario(Long blogId, Comentario comentario) throws ResourceNotFoundException {
        Blog blog = blogRepository.findById(blogId)
                .orElseThrow(() -> new ResourceNotFoundException("Blog no encontrado"));

        if (!blog.getPermiteComentarios()) {
            throw new IllegalArgumentException("El blog no permite comentarios");
        }

        comentario.setBlog(blog);
        comentarioRepository.save(comentario);
    }

    public List<Blog> obtenerBlogs() {
        return blogRepository.findAll();
    }

    public Blog obtenerBlogPorId(Long id) throws ResourceNotFoundException {
        return blogRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Blog no encontrado"));
    }

    public Map<String, Object> obtenerResumenPuntuaciones(Long blogId) {
        List<Comentario> comentarios = comentarioRepository.findByBlogId(blogId);
        IntSummaryStatistics estadisticas = comentarios.stream()
                .mapToInt(Comentario::getPuntuacion)
                .summaryStatistics();

        Map<String, Object> resumen = new HashMap<>();
        resumen.put("minimo", estadisticas.getMin());
        resumen.put("maximo", estadisticas.getMax());
        resumen.put("promedio", estadisticas.getAverage());
        return resumen;
    }
}

