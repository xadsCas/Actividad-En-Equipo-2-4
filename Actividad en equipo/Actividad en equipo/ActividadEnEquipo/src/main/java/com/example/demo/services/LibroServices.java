
package com.example.demo.services;

import com.example.demo.dto.Libro;
import java.util.List;
import java.util.Optional;



public interface LibroServices {
    List<Libro> GetAllLibros();
    Optional<Libro> getLibroById(Long id);
    Optional<Libro> CreateLibro(Libro producto);
    Libro updateLibro(Long id,Libro producto);
    void deleteLibroById(Long id);
}


