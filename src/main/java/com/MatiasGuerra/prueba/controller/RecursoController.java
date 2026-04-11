package com.MatiasGuerra.prueba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MatiasGuerra.prueba.model.Recurso;
import com.MatiasGuerra.prueba.service.RecursoService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/v1/recursos")
public class RecursoController {
    @Autowired
    private RecursoService recursoService;

    @GetMapping
    public List<Recurso> getRecurso() {
        return recursoService.readAll();
    }

    @PostMapping
    public ResponseEntity<String> postRecurso(@RequestBody Recurso recurso) {
        recursoService.create(recurso);
        return ResponseEntity.ok("Recurso agregado correctamente");
    }

    //Obtener un recurso por id
    @GetMapping("id/{id}")
    public Recurso getRecursoById(@PathVariable int id) {
        return recursoService.readbyId(id);
    }

    //Actualizar un Recurso por id
    @PutMapping("id/{id}")
    public Recurso putRecurso(@PathVariable int id, @RequestBody Recurso recurso) {
        return recursoService.updateRecurso(id,recurso);
    }

    //Eliminar 
    @DeleteMapping("eliminar/{id}")
    public String deleteRecurso(@PathVariable int id) {
        if(recursoService.deleteRecurso(id)){
            return "Recurso Eliminado";
        }
        return "No fue posible eliminar el Recurso";
    }
    
    
}
