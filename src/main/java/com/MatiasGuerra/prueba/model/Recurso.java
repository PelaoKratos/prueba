package com.MatiasGuerra.prueba.model;

import java.util.concurrent.atomic.AtomicInteger;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
//import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
//@AllArgsConstructor
public class Recurso {

    private int id;

    @NotBlank(message = "Debe agregar el nombre")
    @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres")
    private String nombre;


    //private boolean disponibilidad;

    @NotBlank(message = "Debe agregar el nombre del responsable")
    @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres")
    private String responsable;

    private int fecha;

    @NotBlank(message = "Debe agregar el tipo")
    @Size(min = 2, max = 50, message = "El tipo debe tener entre 2 y 50 caracteres")
    private String tipo;

    @Min(value = 0, message = "La cantidad no puede ser negativa")
    @Max(value = 1000000, message = "La cantidad no puede ser mayor a 1000000")
    private int cantidadRecurso;

    public Recurso(String nombre, String responsable, int fecha, String tipo, int cantidadRecurso) {
        this.nombre = nombre;
        this.responsable = responsable;
        this.fecha = fecha;
        this.tipo = tipo;
        this.cantidadRecurso = cantidadRecurso;
    }

}
