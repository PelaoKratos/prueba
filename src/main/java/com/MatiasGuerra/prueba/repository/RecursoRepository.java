package com.MatiasGuerra.prueba.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.MatiasGuerra.prueba.model.Recurso;

@Repository
public class RecursoRepository {
    
    private List<Recurso> listarRecursos = new ArrayList<>();

    //Metodo para retornar todo los recursos
    public List<Recurso> obtenerRecursos(){
        return listarRecursos;
    }

    //Buscar por nombre
    public Recurso buscaPorId(int id){
        for (Recurso recurso : listarRecursos) {
            if(recurso.getId()==id){
                return recurso;
            }
        }
        return null;
    }

    //Metodo para guardar recurso
    public Recurso crearRecurso(Recurso recur){
        listarRecursos.add(recur);
        return recur;
    }


    //Actualizar Recurso por Id
    public Recurso actualizar(Recurso recur){
        Recurso recursoBuscado=buscaPorId(recur.getId());
        if(recursoBuscado!=null){
            recursoBuscado.setNombre(recur.getNombre());
            recursoBuscado.setResponsable(recur.getResponsable());
            recursoBuscado.setFecha(recur.getFecha());
            recursoBuscado.setTipo(recur.getTipo());
            recursoBuscado.setCantidadRecurso(recur.getCantidadRecurso());
            return recursoBuscado;
    }
    return null;
    }

    //Eliminar Recurso
    public void eliminar(int id){
        listarRecursos.removeIf(recur -> recur.getId()==id);
    }

    public boolean eliminarRecurso(int id){
        listarRecursos.removeIf((b-> b.getId()==id));
        return true;
    }
}
