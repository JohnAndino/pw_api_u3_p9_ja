package uce.edu.web.api.matricula.application.dto;

public class MateriaMaxCreditosDTO {

    private String codigo;
    private String nombre;
    private Integer creditos;

    public MateriaMaxCreditosDTO(String codigo, String nombre, Integer creditos) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.creditos = creditos;
    }

    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public Integer getCreditos() { return creditos; }
}

