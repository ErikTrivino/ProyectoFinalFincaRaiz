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
        private Integer numBanios;

    public Apartamento(String id, String direccion, Float valorVenta, String area, TipoEstado estado, TipoVenta tipoVenta, Usuario usuario, boolean balcon, boolean ascensor, Integer ubicacionPiso, Float valorAdministracion, Integer numParking, Integer numBanios) {
        super(id, direccion, valorVenta, area, estado, tipoVenta, usuario);
        this.balcon = balcon;
        this.ascensor = ascensor;
        this.ubicacionPiso = ubicacionPiso;
        this.valorAdministracion = valorAdministracion;
        this.numParking = numParking;
        this.numBanios = numBanios;
    }

    public boolean isBalcon() {
        return balcon;
    }

    public void setBalcon(boolean balcon) {
        this.balcon = balcon;
    }

    public boolean isAscensor() {
        return ascensor;
    }

    public void setAscensor(boolean ascensor) {
        this.ascensor = ascensor;
    }

    public Integer getUbicacionPiso() {
        return ubicacionPiso;
    }

    public void setUbicacionPiso(Integer ubicacionPiso) {
        this.ubicacionPiso = ubicacionPiso;
    }

    public Float getValorAdministracion() {
        return valorAdministracion;
    }

    public void setValorAdministracion(Float valorAdministracion) {
        this.valorAdministracion = valorAdministracion;
    }

    public Integer getNumParking() {
        return numParking;
    }

    public void setNumParking(Integer numParking) {
        this.numParking = numParking;
    }

    public Integer getNumBanios() {
        return numBanios;
    }

    public void setNumBanios(Integer numBanios) {
        this.numBanios = numBanios;
    }
}


