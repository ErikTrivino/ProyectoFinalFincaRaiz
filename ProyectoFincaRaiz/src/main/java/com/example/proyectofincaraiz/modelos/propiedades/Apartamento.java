package com.example.proyectofincaraiz.modelos.propiedades;

import com.example.proyectofincaraiz.modelos.Propiedad;
import com.example.proyectofincaraiz.modelos.Usuario;
import com.example.proyectofincaraiz.modelos.enums.TipoEstado;
import com.example.proyectofincaraiz.modelos.enums.TipoVenta;

public class Apartamento extends Propiedad {


        private boolean balcon;
        private boolean ascensor;
        private Integer ubicacionPiso;
        private Float valorAdministracion;
        private Integer numParking;

    public Apartamento(Integer id, String direccion, Float valorVenta, String area, Integer numCuartos, Integer numBanios, TipoEstado estado, TipoVenta tipoVenta, Usuario usuario, boolean balcon, boolean ascensor, Integer ubicacionPiso, Float valorAdministracion, Integer numParking) {
        super(id, direccion, valorVenta, area, numCuartos, numBanios, estado, tipoVenta, usuario);
        this.balcon = balcon;
        this.ascensor = ascensor;
        this.ubicacionPiso = ubicacionPiso;
        this.valorAdministracion = valorAdministracion;
        this.numParking = numParking;
    }


    }


