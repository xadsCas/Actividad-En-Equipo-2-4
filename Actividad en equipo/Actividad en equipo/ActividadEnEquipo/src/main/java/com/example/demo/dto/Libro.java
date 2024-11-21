
package com.example.demo.dto;

/**
 *
 * @author ernes
 */
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;


@Entity
@Table(name="Libro")
public class Libro {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="titulo",nullable=false)
    @NotNull
    private String titulo;
    
    @Column(name="autor",nullable=false)
    @NotNull
    private String autor;
    
    @Column(name="isbn",unique=true,nullable=false)
    @NotNull
    private String isbn;
    
    @Column(name="Publicacion",nullable=false)
    @NotNull
    private int publicacion;
    
    @Column(name="Precio",nullable=false)
    @NotNull
    private double precio;
    
    public Libro(){}
    public Libro(Long id,String titulo,String autor,String isbn,int publicacion,double precio){
        this.id=id;
        this.autor=autor;
        this.titulo=titulo;
        this.isbn=isbn;
        this.publicacion=publicacion;
        this.precio=precio;
    }
    
    public Long getId(){
        return id;
    }
    
    public void setId(Long id){
        this.id=id;
    }
    
    public String getAutor(){
        return autor;
    }
    
    public void setAutor(String autor){
        this.autor=autor;
    }
    
    public String getTitulo(){
        return titulo;
    }
    
    public void setTitulo(String titulo){
        this.titulo=titulo;
    }
    
    public String getISBN(){
        return isbn;
    }
    
    public void setISBN(String isbn){
        this.isbn=isbn;
    }
    
    public int getPublicacion(){
        return publicacion;
    }
    
    public void setPublicacion(int publicacion){
        this.publicacion=publicacion;
    }
    
    public double getPrecio(){
        return precio;
    }
    
    public void setPrecio(double precio){
        this.precio=precio;
    }
    
    @Override
    public String toString(){
        return "Libro[id= " + id + ", Titulo= "+ titulo +", Precio= " + precio+", Publicacion= "+publicacion+",isbn= "+isbn+",Autor= "+ autor +"]"; 
    }
    
    
    
}
