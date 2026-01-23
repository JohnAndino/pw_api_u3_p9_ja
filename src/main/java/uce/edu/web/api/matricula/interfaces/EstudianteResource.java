package uce.edu.web.api.matricula.interfaces;

import java.util.List;

import io.vertx.codegen.annotations.GenIgnore;
import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.Produces;
import uce.edu.web.api.matricula.application.EstudianteService;
import uce.edu.web.api.matricula.domain.Estudiante;


@Path("/estudiantes")
public class EstudianteResource {
    @Inject
    private EstudianteService estudianteService;

    @GET
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Estudiante> listarTodos() {
        List<Estudiante> test = this.estudianteService.listarTodos();
        System.out.println("LISTAR TODOS XXXXXXXXXXXXXX");
        return test;

    }

    @GET
    @Path("/provincia/genero")
    public List<Estudiante> buscarPorProvincia(@QueryParam("provincia") String provincia,@QueryParam("genero") String genero){
        System.out.println("LISTAR POR PROVINCIA Y GENERO");
        return this.estudianteService.buscarPorProvincia(provincia,genero);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Estudiante consultarPorId(@PathParam("id") Integer iden) {
        return this.estudianteService.consultarPorId(iden);

    }
    @POST
    @Path("")
    public Response guardar(Estudiante estu) {
        this.estudianteService.crear(estu);
        return Response.status(Response.Status.CREATED).entity(estu).build();
    }

    @PUT
    @Path("/{id}")
    public void actualizar(@PathParam("id") Integer id, Estudiante esstu){
        this.estudianteService.actualizar(id, esstu);
    }

    @PATCH
    @Path("/{id}")
    public Response actualizarParcial(@PathParam("id") Integer id, Estudiante esstu){
        this.estudianteService.actualizarParcial(id, esstu);
        return Response.status(209).entity(null).build();
    }

    @DELETE
    @Path("/{id}")
    public void borrar(@PathParam("id") Integer id){
        this.estudianteService.eliminar(id);;
    }

    
}
