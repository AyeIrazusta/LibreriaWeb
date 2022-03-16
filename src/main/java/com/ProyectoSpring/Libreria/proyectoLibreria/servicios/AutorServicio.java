
package com.ProyectoSpring.Libreria.proyectoLibreria.servicios;

import com.ProyectoSpring.Libreria.proyectoLibreria.entidades.Autor;
import com.ProyectoSpring.Libreria.proyectoLibreria.errores.ErrorServicio;
import com.ProyectoSpring.Libreria.proyectoLibreria.repositorios.AutorRepositorio;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutorServicio {
     @Autowired //la variable la inicializa el servidor de aplicaciones
    private AutorRepositorio autorRepositorio;
    
    @Transactional 
    public void cargarAutor(String nombre,String apellido) throws ErrorServicio{
        validar(nombre, apellido);
        Autor autor =  new Autor();
        autor.setNombre(nombre);
        autor.setApellido(apellido);
        autorRepositorio.save(autor);
    }
    
    @Transactional 
    public void modificarAutor(String nombre, String apellido, String id)throws ErrorServicio{
        Autor autor = autorRepositorio.buscarPorId(id);
        validar(nombre, apellido);
        autor.setNombre(nombre);
        autor.setApellido(apellido);
        autorRepositorio.save(autor);
    }
    
    @Transactional 
    public void eliminarAutor(String id){
        Autor autor = autorRepositorio.buscarPorId(id);
        autorRepositorio.delete(autor);
    }
    private void validar(String nombre, String apellido) throws ErrorServicio{
        if(nombre == null || nombre.isEmpty()){
            throw new ErrorServicio("El nombre no puede estar vacio");
        }
        if(apellido == null || apellido.isEmpty()){
            throw new ErrorServicio("El apellido no puede estar vacio");
        }
    }
    
    public List<Autor> listarAutores(){
        List<Autor> autores = autorRepositorio.ListarAutores();
        return autores;
    }
    
    public Autor listarAutor(String id){
        Autor autor = autorRepositorio.buscarPorId(id);
        return autor;
    }

}
