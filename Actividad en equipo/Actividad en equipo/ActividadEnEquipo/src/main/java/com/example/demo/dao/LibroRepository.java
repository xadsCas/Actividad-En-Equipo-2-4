
package com.example.demo.dao;
import com.example.demo.dto.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;







@Repository
public interface LibroRepository extends JpaRepository<Libro, Long>{
    
}
