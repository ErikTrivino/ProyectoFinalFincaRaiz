package com.example.proyectofincaraiz.modelos.propiedades;

import com.example.proyectofincaraiz.modelos.Propiedad;
import com.example.proyectofincaraiz.modelos.Usuario;
import com.example.proyectofincaraiz.modelos.enums.TipoEstado;
import com.example.proyectofincaraiz.modelos.enums.TipoVenta;

public class Casa extends Propiedad {


    private Integer numCuartos;
    private Integer numBanios;
    private Integer numeroPisos;
    private String material;

    public Casa(String id, String direccion, Float valorVenta, String area, TipoEstado estado, TipoVenta tipoVenta, Usuario usuario, Integer numCuartos, Integer numBanios, Integer numeroPisos, String material) {
        super(id, direccion, valorVenta, area, estado, tipoVenta, usuario);
        this.numCuartos = numCuartos;
        this.numBanios = numBanios;
        this.numeroPisos = numeroPisos;
        this.material = material;
    }

    public Integer getNumCuartos() {
        return numCuartos;
    }

    public void setNumCuartos(Integer numCuartos) {
        this.numCuartos = numCuartos;
    }

    public Integer getNumBanios() {
        return numBanios;
    }

    public void setNumBanios(Integer numBanios) {
        this.numBanios = numBanios;
    }

    public Integer getNumeroPisos() {
        return numeroPisos;
    }

    public void setNumeroPisos(Integer numeroPisos) {
        this.numeroPisos = numeroPisos;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
}
