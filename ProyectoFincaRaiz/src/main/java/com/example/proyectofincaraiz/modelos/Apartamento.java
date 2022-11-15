package com.example.proyectofincaraiz.modelos;

import com.example.proyectofincaraiz.modelos.enums.TipoEstado;
import com.example.proyectofincaraiz.modelos.enums.TipoVenta;

public class Apartamento extends Propiedad{


        private boolean tieneBalcon;
        private boolean ascensor;
        private int ubicacionPiso;
        private float valorAdministracion;
        private int numParking;

    public Apartamento(Integer id, String direccion, Float valorVenta, String area, Integer numCuartos, Integer numBanios, TipoEstado estado, TipoVenta tipoVenta, Usuario usuario, boolean tieneBalcon, boolean ascensor, int ubicacionPiso, float valorAdministracion, int numParking) {
        super(id, direccion, valorVenta, area, numCuartos, numBanios, estado, tipoVenta, usuario);
        this.tieneBalcon = tieneBalcon;
        this.ascensor = ascensor;
        this.ubicacionPiso = ubicacionPiso;
        this.valorAdministracion = valorAdministracion;
        this.numParking = numParking;
    }

    public Apartamento(boolean tieneBalcon, boolean ascensor, int ubicacionPiso, float valorAdministracion, int numParking) {

        }
    }


