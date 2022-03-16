
package com.ProyectoSpring.Libreria.proyectoLibreria.repositorios;

import com.ProyectoSpring.Libreria.proyectoLibreria.entidades.Libro;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LibroRepositorio extends  JpaRepository<Libro, String> {
        @Query("SELECT c FROM Libro c")
    public List<Libro> ListarLibros();
    
        
    @Query("SELECT c FROM Libro c WHERE c.id = :id")
    public Libro buscarPorId(@Param("id")String id);
}
