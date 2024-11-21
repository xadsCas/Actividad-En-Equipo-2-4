
package com.example.demo.controllers;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.services.LibroServiceImpl;
import com.example.demo.dto.Libro;


@RestController
@RequestMapping("/Libros")
public class LibroController {
     @Autowired
    public LibroServiceImpl libroServiceImpl;
    
    @GetMapping("/Listado")
    public List<Libro> getAllLibros(){
            return libroServiceImpl.GetAllLibros();
    }
    
    @GetMapping("/{id}")
    public Libro getLibroById(@PathVariable(name="id")Long id){
        Optional<Libro> libro= libroServiceImpl.getLibroById(id);
        if(libro.isPresent()){
            return libro.get();
        }else{
            throw new NoSuchElementException();
        }
    }
    
    @PostMapping("/Libro")
    public Optional<Libro> createLibro(@RequestBody Libro libro){
        Optional<Libro> newLibro= libroServiceImpl.CreateLibro(libro);
        if(newLibro.isPresent()){
            return newLibro;
        }else{
            throw new NoSuchElementException();
        }
    }
    
    @PutMapping("/modifica/{id}")
    public Libro updateLibro(@PathVariable(name="id")Long id,@RequestBody Libro libro){
        Libro updateProducto = libroServiceImpl.updateLibro(id, libro);
        return updateProducto;
    }
    
    @DeleteMapping("/elimina/{id}")
    public void deleteLibro(@PathVariable(name="id")Long id){
        libroServiceImpl.deleteLibroById(id);
    }
}
