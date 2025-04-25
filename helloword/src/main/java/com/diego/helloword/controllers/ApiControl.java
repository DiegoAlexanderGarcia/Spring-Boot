package com.diego.helloword.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.diego.helloword.domain.Producto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class ApiControl {
    
    @GetMapping("/")
    public String home() {
        return "home de campers";
    }

    @GetMapping("/saludo")  // /saludo?nombre=Diego&apellido=Garcia
    public String saludo(
        @RequestParam(name = "nombre", required = true) String nombre,
        @RequestParam(name = "apellido", required = true, defaultValue = "apellido comun") String lastname) 
        {
            return "Hola " + nombre + " " + lastname;
        }

        @GetMapping("/search")
        public Map<String, String> buscar(
        @RequestParam(name = "name", defaultValue = "") String name
        ){
        Map<String, String> cities = new HashMap<>();
        cities.put("BUC", "BUCARAMANGA");
        cities.put("BOG", "BOGOTA");
        cities.put("MEDE", "MEDELLIN");
        cities.put("CALI", "CALI");
        cities.put("CART", "CARTAGENA");

        if (cities.containsKey(name)) {
            return Map.of("name", cities.get(name));
        } else {
            return cities;
        }
    }

    @GetMapping("/tax")
    public Map<String, Object> calcular(
        @RequestParam(defaultValue = "0") Double impuestos
    ){
        List<Producto> productos = new ArrayList<>(
            List.of(new Producto(1, "pan", 1000)));
        productos.add(new Producto(2, "leche", 2000));
        productos.add(new Producto(3, "huevos", 3000));
        productos.add(new Producto(4, "carne", 4000));

        Double precios = productos.stream().map(producto -> producto.getPrice()).reduce(0.0,(precioA, precioB) -> precioA + precioB);

        return Map.of("productos", productos,"total",(precios + (precios * (impuestos/100))), "valor_neto", precios); 
    }

    @GetMapping("/tax2")
    public Map<String, Object> calcular2(
        @RequestParam(name = "impuestos", defaultValue = "0") Double impuestos
    ){
        List<Producto> productos = new ArrayList<>(
            List.of(new Producto(1, "pan", 1000)));
        productos.add(new Producto(2, "leche", 2000));
        productos.add(new Producto(3, "huevos", 3000));
        productos.add(new Producto(4, "carne", 4000));

        double total = 0;
        for (Producto producto : productos) {
            total += producto.getPrice();
        }

        return Map.of("productos", productos, "total", total + total * (impuestos/100), "valor_neto", total);
    }
}
