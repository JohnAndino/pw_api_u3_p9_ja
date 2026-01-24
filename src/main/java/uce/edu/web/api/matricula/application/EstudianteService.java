package uce.edu.web.api.matricula.application;

import java.util.ArrayList;
import java.util.List;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import uce.edu.web.api.matricula.application.representation.EstudianteRepresentation;
import uce.edu.web.api.matricula.domain.Estudiante;
import uce.edu.web.api.matricula.infraestructure.EstudianteRepository;

@ApplicationScoped
public class EstudianteService {

    @Inject
    private EstudianteRepository estudianteRepository;

    public List<EstudianteRepresentation> listarTodos() {
        List<EstudianteRepresentation> list = new ArrayList<>();
        for(Estudiante estu: this.estudianteRepository.listAll()){
            list.add(this.mapperToEr(estu));
        }
        return list;
    }

    public Estudiante consultarPorId(Integer id) {
        return this.mapperToEr(this.estudianteRepository.findById(id.longValue()));

    }

    @Transactional
    public void crear(Estudiante estu) {
        this.estudianteRepository.persist(estu);
    }

    @Transactional
    public void actualizar(Integer id, Estudiante est) {
        Estudiante estu = this.consultarPorId(id);
        estu.setApellido(est.getApellido());
        estu.setNombre(est.getNombre());
        estu.setFechaNaciemiento(est.getFechaNaciemiento());

        // se actualiza automaticamente por dirtychecking
    }

    @Transactional
    public void actualizarParcial(Integer id, Estudiante est) {
        Estudiante estu = this.mapperToEstudiante(this.consultarPorId(id));
        if (est.getNombre() != null) {
            estu.setNombre(est.getNombre());
        }
        if (est.getApellido() != null) {
            estu.setApellido(est.getApellido());
        }
        if (est.getFechaNaciemiento() != null) {
            estu.setFechaNaciemiento(est.getFechaNaciemiento());
        }
    }

    @Transactional
    public void eliminar(Integer id) {
        this.estudianteRepository.deleteById(id.longValue());
    }

    public List<Estudiante> buscarPorProvincia(String provincia, String genero){
        //return this.estudianteRepository.find("provincia", provincia).list();
        return this.estudianteRepository.find("provincia = ?1 and genero = ?2", provincia, genero).list();
    }


    private EstudianteRepresentation mapperToEr(Estudiante est){
        EstudianteRepresentation estuR = new EstudianteRepresentation();
        estuR.setId(est.getId());
        estuR.setNombre(est.getNombre());
        estuR.setApellido(est.getApellido());
        estuR.setFechaNaciemiento(est.getFechaNaciemiento());
        estuR.setGenero(est.getGenero());
        estuR.setProvincia(est.getProvincia());

    return estuR;  
  }

    private Estudiante mapperToEstudiante(EstudianteRepresentation est){
        Estudiante estuR = new Estudiante();
        estuR.setId(est.getId());
        estuR.setNombre(est.getNombre());
        estuR.setApellido(est.getApellido());
        estuR.setFechaNaciemiento(est.getFechaNaciemiento());
        estuR.setGenero(est.getGenero());
        estuR.setProvincia(est.getProvincia());

    return estuR;  
  }

}
