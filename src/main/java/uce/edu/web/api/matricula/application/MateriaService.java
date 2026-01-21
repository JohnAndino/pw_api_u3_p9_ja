package uce.edu.web.api.matricula.application;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import uce.edu.web.api.matricula.application.dto.MateriaMaxCreditosDTO;
import uce.edu.web.api.matricula.domain.Materia;
import uce.edu.web.api.matricula.infraestructure.MateriaRepository;

import java.util.List;

@ApplicationScoped
public class MateriaService {

    @Inject
    MateriaRepository materiaRepository;

    public List<Materia> listarTodos() {
        return materiaRepository.listAll();
    }

    public Materia consultarPorId(Integer id) {
        return materiaRepository.findById(id.longValue());
    }

    @Transactional
    public void crear(Materia materia) {
        materiaRepository.persist(materia);
    }

    @Transactional
    public void actualizar(Integer id, Materia mat) {
        Materia m = consultarPorId(id);
        m.setCodigo(mat.getCodigo());
        m.setNombre(mat.getNombre());
        m.setCreditos(mat.getCreditos());
        m.setHorasSemanales(mat.getHorasSemanales());
        m.setActiva(mat.getActiva());
    }

    @Transactional
    public void actualizarParcial(Integer id, Materia mat) {
        Materia m = consultarPorId(id);

        if (mat.getCodigo() != null) m.setCodigo(mat.getCodigo());
        if (mat.getNombre() != null) m.setNombre(mat.getNombre());
        if (mat.getCreditos() != null) m.setCreditos(mat.getCreditos());
        if (mat.getHorasSemanales() != null) m.setHorasSemanales(mat.getHorasSemanales());
        if (mat.getActiva() != null) m.setActiva(mat.getActiva());
    }

    @Transactional
    public void eliminar(Integer id) {
        materiaRepository.deleteById(id.longValue());
    }

    //Metodos nuevos con query, no necesitan el transactional porque no modifican la db
    public List<MateriaMaxCreditosDTO> materiaConMasCreditos() {
        return materiaRepository.materiaConMasCreditos();
    }

    public List<MateriaMaxCreditosDTO> materiaConMasHoras() {
        return materiaRepository.materiaConMasHoras();
    }

}
