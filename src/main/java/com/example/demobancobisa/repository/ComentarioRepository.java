package com.example.demobancobisa.repository;

import com.example.demobancobisa.model.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
    List<Comentario> findByBlogId(Long id);
}