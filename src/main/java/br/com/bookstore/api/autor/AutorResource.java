/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bookstore.api.autor;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.stream.Collectors;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

/**
 *
 * @author brayanbertan
 */
@Path("autores")
public class AutorResource {
    static DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    static List<Autor> autores = new ArrayList<>(
              Arrays.asList(
                new Autor(1,"abc",LocalDate.of(1998,Month.MAY,1),Sexo.M)
                 )
            );
    
 
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Autor> getAutores(){
        return autores;
    }
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Autor getAutor(@PathParam("id") int id){
       Autor autor =  autores.stream()
                .filter(a -> a.getId() == id)
                .findFirst()
                .orElse(null);
       if(autor == null){
            throw new WebApplicationException("Autor não encontrando",Response.Status.NOT_FOUND);
       }
       return autor;
    }
    
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Autor setAutor(Autor autor){
        int id = autores.get(autores.size()-1).getId();
        autor.setId(++id);
        this.autores.add(autor);
        return autor;
    }
    
}
