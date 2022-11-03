package com.example.proyectofincaraiz.modelos.propiedades;

import com.example.proyectofincaraiz.modelos.Propiedad;
import com.example.proyectofincaraiz.modelos.Usuario;
import com.example.proyectofincaraiz.modelos.enums.TipoEstado;
import com.example.proyectofincaraiz.modelos.enums.TipoVenta;

public class Casa extends Propiedad {

    private Integer numeroPisos;
    private String material;

    public Casa(Integer id, String direccion, Float valorVenta, String area, Integer numCuartos, Integer numBanios, TipoEstado estado, TipoVenta tipoVenta, Usuario usuario, Integer numeroPisos, String material) {
        super(id, direccion, valorVenta, area, numCuartos, numBanios, estado, tipoVenta, usuario);
        this.numeroPisos = numeroPisos;
        this.material = material;
    }
}
