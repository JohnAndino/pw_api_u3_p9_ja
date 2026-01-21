package uce.edu.web.api.matricula.interfaces;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import uce.edu.web.api.matricula.application.MateriaService;
import uce.edu.web.api.matricula.application.dto.MateriaMaxCreditosDTO;
import uce.edu.web.api.matricula.domain.Materia;

import java.util.List;

@Path("/materias")
public class MateriaResource {

    @Inject
    MateriaService materiaService;

    @GET
    @Path("/todos")
    public List<Materia> listarTodos() {
        return materiaService.listarTodos();
    }

    @GET
    @Path("/consultarPorId/{id}")
    public Materia consultarPorId(@PathParam("id") Integer id) {
        return materiaService.consultarPorId(id);
    }

    @POST
    @Path("/crear")
    public void crear(Materia materia) {
        materiaService.crear(materia);
    }

    @PUT
    @Path("/actualizar/{id}")
    public void actualizar(@PathParam("id") Integer id, Materia materia) {
        materiaService.actualizar(id, materia);
    }

    @PATCH
    @Path("/actualizarParcial/{id}")
    public void actualizarParcial(@PathParam("id") Integer id, Materia materia) {
        materiaService.actualizarParcial(id, materia);
    }

    @DELETE
    @Path("/borrar/{id}")
    public void borrar(@PathParam("id") Integer id) {
        materiaService.eliminar(id);
    }

    //Consulta que me devuelve la materia con mas creditos
    @GET
    @Path("/max-creditos")
    public List<MateriaMaxCreditosDTO> materiaConMasCreditos() {
        return materiaService.materiaConMasCreditos();
    }

    //Consulta que me devuelve la materia con mas horas semanales
    @GET
    @Path("/max-horas")
    public List<MateriaMaxCreditosDTO> materiaConMasHoras() {
        return materiaService.materiaConMasHoras();
    }
}

