package com.biciman.go.persistence.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "bicicletas" )
public class BiciEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String marca;

    @Column(nullable = false, length = 150)
    private String modelo;

    @Column(nullable = false, length = 20)
    private String genero;

    @Column(nullable = false, length = 40)
    private String tipo;

    @Column(nullable = false, length = 1)
    private String estado;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
