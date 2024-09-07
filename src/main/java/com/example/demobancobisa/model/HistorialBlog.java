package com.example.demobancobisa.model;
import com.example.demobancobisa.enums.Periodicidad;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class HistorialBlog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Blog blog;

    private String titulo;
    private String tema;

    @Lob
    private String contenido;

    @Enumerated(EnumType.STRING)
    private Periodicidad periodicidad;

    private Boolean permiteComentarios;

    private LocalDateTime fechaActualizacion;

    // Getters y setters
}

