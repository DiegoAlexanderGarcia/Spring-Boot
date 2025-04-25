package com.diego.helloword.domain;

public class Producto {
    private int id;
    private String nombre;
    private double price;

    public Producto(int id, String nombre, double price) {
        this.id = id;
        this.nombre = nombre;
        this.price = price;
    }

    public int getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public Double getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setPrice(Double price) {
        this.price = price;
    }

}
