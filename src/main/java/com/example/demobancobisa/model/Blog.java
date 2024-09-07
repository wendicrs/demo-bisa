package com.example.demobancobisa.model;
import com.example.demobancobisa.enums.Periodicidad;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo", length = 100)
    private String titulo;
    @Column(name = "tema", length = 100)
    private String tema;

    @Lob
    private String contenido;

    @Enumerated(EnumType.STRING)
    private Periodicidad periodicidad;

    @Column(name = "permite_comentarios")
    private Boolean permiteComentarios;

    @ManyToOne
    private Autor autor;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @OneToMany(mappedBy = "blog", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Comentario> comentarios;
}

