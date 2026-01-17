package uce.edu.web.api.matricula.application;

import java.util.List;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.PathParam;
import uce.edu.web.api.matricula.domain.Estudiante;
import uce.edu.web.api.matricula.infraestructure.EstudianteRepository;

@ApplicationScoped
public class EstudianteService {

    @Inject
    private EstudianteRepository estudianteRepository;

    public List<Estudiante> listarTodos() {
        return this.estudianteRepository.listAll();
    }

    public Estudiante consultarPorId(Integer id) {
        return this.estudianteRepository.findById(id.longValue());

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
        Estudiante estu = this.consultarPorId(id);
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
}
