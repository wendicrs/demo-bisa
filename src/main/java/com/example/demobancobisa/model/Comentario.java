package com.example.demobancobisa.model;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", length = 100)
    private String nombre;
    @Column(name = "correo", length = 100)
    private String correo;
    @Column(name = "pais_residencia", length = 100)
    private String paisResidencia;

    @Lob
    @Column(name = "comentario")
    private String comentario;

    @Column(name = "puntuacion")
    private int puntuacion;  // Entre 0 y 10

    @ManyToOne
    private Blog blog;

}

