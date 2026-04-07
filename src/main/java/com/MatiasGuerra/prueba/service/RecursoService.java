package com.MatiasGuerra.prueba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.MatiasGuerra.prueba.model.Recurso;
import com.MatiasGuerra.prueba.repository.RecursoRepository;

@Service
public class RecursoService {
    @Autowired
    private RecursoRepository recursoRepository;

    public List<Recurso> readAll(){
        return recursoRepository.obtenerRecursos();
    }

    public Recurso create(Recurso recur){
        return recursoRepository.crearRecurso(recur);
    }

    public Recurso readbyNombre(String nombre){
        return recursoRepository.buscaPorNombre(nombre);
    }

    public Recurso update(Recurso recur){
        return recursoRepository.actualizar(recur);
    }

    public boolean deleteRecurso(int id){
        return recursoRepository.eliminarRecurso(id);
    }
}

