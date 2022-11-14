package com.example.proyectofincaraiz.modelos.propiedades;

import com.example.proyectofincaraiz.modelos.Propiedad;
import com.example.proyectofincaraiz.modelos.Usuario;
import com.example.proyectofincaraiz.modelos.enums.TipoEstado;
import com.example.proyectofincaraiz.modelos.enums.TipoVenta;

public class Bodega extends Propiedad {

    public Bodega(String id, String direccion, Float valorVenta, String area, TipoEstado estado, TipoVenta tipoVenta, Usuario usuario) {
        super(id, direccion, valorVenta, area, estado, tipoVenta, usuario);
    }
}
