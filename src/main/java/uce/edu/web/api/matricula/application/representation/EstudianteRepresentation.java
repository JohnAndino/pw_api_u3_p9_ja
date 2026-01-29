package uce.edu.web.api.matricula.application.representation;

import java.time.LocalDateTime;
import java.util.List;

public class EstudianteRepresentation {

    private Integer id;
    private String nombre;
    private String apellido;
    private LocalDateTime fechaNaciemiento;
    private String provincia;
    private String genero;

    //http://localhost:8080/......../estudiantes/1/hijos

    private List<LinkDto> links;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public LocalDateTime getFechaNaciemiento() {
        return fechaNaciemiento;
    }
    public void setFechaNaciemiento(LocalDateTime fechaNaciemiento) {
        this.fechaNaciemiento = fechaNaciemiento;
    }
    public String getProvincia() {
        return provincia;
    }
    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public List<LinkDto> getLinks() {
        return links;
    }
    public void setLinks(List<LinkDto> links) {
        this.links = links;
    }

    
}
