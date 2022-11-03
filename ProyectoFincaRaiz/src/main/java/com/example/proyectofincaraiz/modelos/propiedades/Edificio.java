package com.example.proyectofincaraiz.modelos.propiedades;

import com.example.proyectofincaraiz.modelos.Propiedad;
import com.example.proyectofincaraiz.modelos.Usuario;
import com.example.proyectofincaraiz.modelos.enums.TipoEstado;
import com.example.proyectofincaraiz.modelos.enums.TipoVenta;

public class Edificio extends Propiedad {

    private Integer numPisos;

    public Edificio(Integer id, String direccion, Float valorVenta, String area, TipoEstado estado, TipoVenta tipoVenta, Usuario usuario, Integer numPisos) {
        super(id, direccion, valorVenta, area, estado, tipoVenta, usuario);
        this.numPisos = numPisos;
    }
}
