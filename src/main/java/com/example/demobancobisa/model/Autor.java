package com.example.demobancobisa.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "nombre", length = 100)
    private String nombre;
    @Column(name = "apellido_paterno", length = 100)
    private String apellidoPaterno;
    @Column(name = "apellido_materno", length = 100)
    private String apellidoMaterno;
    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;
    @Column(name = "pais_residencia", length = 100)
    private String paisResidencia;
    @Column(unique = true)
    private String correo;

}
