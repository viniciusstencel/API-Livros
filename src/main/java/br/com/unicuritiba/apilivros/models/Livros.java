package br.com.unicuritiba.apilivros.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "livros")
@Getter
@Setter
public class Livros {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "editora")
    private String editora;

    @Column(name = "autor")
    private String autor;

    @Column(name = "sinopse")
    private String sinopse;

}
