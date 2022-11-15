package com.example.proyectofincaraiz.modelos;

import com.example.proyectofincaraiz.modelos.enums.TipoEstado;
import com.example.proyectofincaraiz.modelos.enums.TipoVenta;

public class Chalets extends Propiedad{

    private boolean aguaPotable;
    private boolean servAlcantarillado;
    private  boolean servinternet;
    private boolean servEnergia;
    private boolean servGas;

    public Chalets(Integer id, String direccion, Float valorVenta, String area, Integer numCuartos, Integer numBanios, TipoEstado estado, TipoVenta tipoVenta, Usuario usuario, boolean aguaPotable, boolean servAlcantarillado, boolean servinternet, boolean servEnergia, boolean servGas) {
        super(id, direccion, valorVenta, area, numCuartos, numBanios, estado, tipoVenta, usuario);
        this.aguaPotable = aguaPotable;
        this.servAlcantarillado = servAlcantarillado;
        this.servinternet = servinternet;
        this.servEnergia = servEnergia;
        this.servGas = servGas;
    }
}
