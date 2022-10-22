package com.example.proyectofincaraiz.modelos;

import com.example.proyectofincaraiz.modelos.enums.TipoEstado;
import com.example.proyectofincaraiz.modelos.enums.TipoVenta;

public class Propiedades {
    private Integer id;
    private String direccion;
    private Float valorVenta;
    private String area;
    private Integer numCuartos;
    private Integer numBanios;
    private TipoEstado estado;
    private TipoVenta tipoVenta;
    private Usuario usuario;


    public Propiedades() {
    }


    public Propiedades(Integer id, String direccion, Float valorVenta, String area, TipoEstado estado, TipoVenta tipoVenta, Usuario usuario) {
        this.id = id;
        this.direccion = direccion;
        this.valorVenta = valorVenta;
        this.area = area;
        this.estado = estado;
        this.tipoVenta = tipoVenta;
        this.usuario = usuario;
    }

    public Propiedades(Integer id, String direccion, Float valorVenta, String area, Integer numCuartos, Integer numBanios, TipoEstado estado, TipoVenta tipoVenta, Usuario usuario) {
        this.id = id;
        this.direccion = direccion;
        this.valorVenta = valorVenta;
        this.area = area;
        this.numCuartos = numCuartos;
        this.numBanios = numBanios;
        this.estado = estado;
        this.tipoVenta = tipoVenta;
        this.usuario = usuario;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Float getValorVenta() {
        return valorVenta;
    }

    public void setValorVenta(Float valorVenta) {
        this.valorVenta = valorVenta;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
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

    public TipoEstado getEstado() {
        return estado;
    }

    public void setEstado(TipoEstado estado) {
        this.estado = estado;
    }

    public TipoVenta getTipoVenta() {
        return tipoVenta;
    }

    public void setTipoVenta(TipoVenta tipoVenta) {
        this.tipoVenta = tipoVenta;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
