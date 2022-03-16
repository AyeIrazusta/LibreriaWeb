
package com.ProyectoSpring.Libreria.proyectoLibreria.servicios;

import com.ProyectoSpring.Libreria.proyectoLibreria.entidades.Autor;
import com.ProyectoSpring.Libreria.proyectoLibreria.entidades.Editorial;
import com.ProyectoSpring.Libreria.proyectoLibreria.entidades.Libro;
import com.ProyectoSpring.Libreria.proyectoLibreria.errores.ErrorServicio;
import com.ProyectoSpring.Libreria.proyectoLibreria.repositorios.LibroRepositorio;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibroServicio {
        @Autowired //la variable la inicializa el servidor de aplicaciones
    private LibroRepositorio libroRepositorio;
    
    
    
    @Transactional 
    public void cargarLibro(long isbn,String titulo,int anio,int ejemplares,int ejemplaresPrestados,String nombreAutor,String apellidoAutor,String nombreEditorial) throws ErrorServicio{
        Libro libro =  new Libro();
        libro.setIsbn(isbn);
        libro.setTitulo(titulo);
        libro.setAnio(anio);
        libro.setEjemplares(ejemplares);
        libro.setEjemplaresPrestados(ejemplaresPrestados);
        Autor autor = new Autor();
        autor.setNombre(nombreAutor);
        autor.setApellido(apellidoAutor);
        Editorial editorial = new Editorial();
        editorial.setNombre(nombreEditorial);
        libro.setAutor(autor);
        libro.setEditorial(editorial);
        libroRepositorio.save(libro);
       
    }
    
    @Transactional 
    public void modificarLibro(long isbn,String titulo,int anio,int ejemplares,int ejemplaresPrestados, String id)throws ErrorServicio{
        Libro libro = libroRepositorio.buscarPorId(id);
        libro.setIsbn(isbn);
        libro.setTitulo(titulo);
        libro.setAnio(anio);
        libro.setEjemplares(ejemplares);
        libro.setEjemplaresPrestados(ejemplaresPrestados);
        libroRepositorio.save(libro);
        
    }
    
    @Transactional 
    public void eliminarLibro(String id){
        Libro libro = libroRepositorio.buscarPorId(id);
        libroRepositorio.delete(libro);
    }
   
    
    public List<Libro> listarLibros(){
        List<Libro> libros = libroRepositorio.ListarLibros();
        return libros;
    }
    
    public Libro listarLibro(String id){
        Libro libro = libroRepositorio.buscarPorId(id);
        return libro;
    }
}
