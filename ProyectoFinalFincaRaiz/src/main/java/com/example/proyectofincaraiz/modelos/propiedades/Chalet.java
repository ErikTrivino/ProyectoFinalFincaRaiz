package com.example.proyectofincaraiz.modelos.propiedades;

import com.example.proyectofincaraiz.modelos.Propiedad;
import com.example.proyectofincaraiz.modelos.Usuario;
import com.example.proyectofincaraiz.modelos.enums.TipoEstado;
import com.example.proyectofincaraiz.modelos.enums.TipoVenta;

public class Chalet extends Propiedad {

    private Integer numCuartos;
    private Integer numBanios;
    private Integer numeroPisos;
    private String material;
    private boolean aguaPotable;
    private boolean servicioAlcantarillado;
    private boolean internet;
    private boolean energia;
    private boolean gasDomiciliario;

    public Chalet(String id, String direccion, Float valorVenta, String area, TipoEstado estado, TipoVenta tipoVenta, Usuario usuario, Integer numCuartos, Integer numBanios, Integer numeroPisos, String material, boolean aguaPotable, boolean servicioAlcantarillado, boolean internet, boolean energia, boolean gasDomiciliario) {
        super(id, direccion, valorVenta, area, estado, tipoVenta, usuario);
        this.numCuartos = numCuartos;
        this.numBanios = numBanios;
        this.numeroPisos = numeroPisos;
        this.material = material;
        this.aguaPotable = aguaPotable;
        this.servicioAlcantarillado = servicioAlcantarillado;
        this.internet = internet;
        this.energia = energia;
        this.gasDomiciliario = gasDomiciliario;
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

    public boolean isAguaPotable() {
        return aguaPotable;
    }

    public void setAguaPotable(boolean aguaPotable) {
        this.aguaPotable = aguaPotable;
    }

    public boolean isServicioAlcantarillado() {
        return servicioAlcantarillado;
    }

    public void setServicioAlcantarillado(boolean servicioAlcantarillado) {
        this.servicioAlcantarillado = servicioAlcantarillado;
    }

    public boolean isInternet() {
        return internet;
    }

    public void setInternet(boolean internet) {
        this.internet = internet;
    }

    public boolean isEnergia() {
        return energia;
    }

    public void setEnergia(boolean energia) {
        this.energia = energia;
    }

    public boolean isGasDomiciliario() {
        return gasDomiciliario;
    }

    public void setGasDomiciliario(boolean gasDomiciliario) {
        this.gasDomiciliario = gasDomiciliario;
    }
}
