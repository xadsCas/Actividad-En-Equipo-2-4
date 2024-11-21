/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.services;
import com.example.demo.dto.Libro;
import com.example.demo.dao.LibroRepository;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ernes
 */
@Service
public class LibroServiceImpl implements LibroServices{
    
    @Autowired
    public LibroRepository libroRepository;
    
    org.slf4j.Logger logger= LoggerFactory.getLogger(LibroServiceImpl.class);
    
    @Override
    public List<Libro> GetAllLibros(){
        List<Libro> Libro=libroRepository.findAll();
        return Libro;
    }
    
    @Override
    public Optional<Libro> getLibroById(Long id){
        Optional<Libro> searchLibro=libroRepository.findById(id);
        if(searchLibro.isPresent()){
            logger.error("Libro encontrado!!");
            return searchLibro;
        }else{
            logger.error("No se han encontrado Libros con el id" + id );
            throw new NoSuchElementException("No");
        }
    }
    
    @Override
    public Optional<Libro> CreateLibro(Libro libro){
        Optional<Libro> optLibro=Optional.of(libro);
        if(optLibro.isPresent()){
            Libro newLibro= new Libro();
            newLibro.setTitulo(libro.getTitulo());
            newLibro.setPrecio(libro.getPrecio());
            newLibro.setISBN(libro.getISBN());
            newLibro.setPublicacion(libro.getPublicacion());
            newLibro.setAutor(libro.getAutor());
            libroRepository.save(newLibro);
            logger.info("Se ha creado el producto correctamente");
            Optional<Libro>rturnOptPro=Optional .of(newLibro);
            return rturnOptPro;
        }else{
            logger.error("No se ha recibido un producto para crear");
            throw new NoSuchElementException("No se ha recibido un Producto para crear");
        }
    }
    
        @Override
        public Libro updateLibro(Long id,Libro libro){
        Optional<Libro> optLibro=libroRepository.findById(id);
        if(optLibro.isPresent()){
            Libro libroUpdate = optLibro.get();
            libroUpdate.setTitulo(libro.getTitulo());
            libroUpdate.setPrecio(libro.getPrecio());
            libroUpdate.setISBN(libro.getISBN());
            libroUpdate.setPublicacion(libro.getPublicacion());
            libroUpdate.setAutor(libro.getAutor());
            libroRepository.save(libroUpdate);
            logger.error("Actualizacion correcta");
           
            return libroUpdate;
        }else{
            logger.error("No se ha recibido un libro para Actualizar");
            throw new NoSuchElementException("No se ha recibido un libro para Actualiar");
        }
    }
        @Override
        public void deleteLibroById(Long id){
            Optional<Libro>optPro=libroRepository.findById(id);
            if(optPro.isPresent()){
                Libro productoTrust=optPro.get();
                libroRepository.deleteById(productoTrust.getId());
                logger.error("Libro con id: "+ id+"Eliminado de forma correcta");
            }else{
                logger.error("El Libro ha eliminar no existe :v");
            }
        }
   
}
  