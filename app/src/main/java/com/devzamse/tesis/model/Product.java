package com.devzamse.tesis.model;

import java.io.Serializable;

public class Product implements Serializable {

    private String nombreProducto;
    private String codigoProducto;
    private double precioProducto;
    private String enfermedadCronicaQueCombate;
    private String regionOriunda;
    private String menuAPreparar;
    private String localDondeComprar;
    private String rutaImagen;

    public Product(){}

    public Product(String nombreProducto, String codigoProducto, double precioProducto, String enfermedadCronicaQueCombate, String regionOriunda, String menuAPreparar, String localDondeComprar, String rutaImagen) {
        this.nombreProducto = nombreProducto;
        this.codigoProducto = codigoProducto;
        this.precioProducto = precioProducto;
        this.enfermedadCronicaQueCombate = enfermedadCronicaQueCombate;
        this.regionOriunda = regionOriunda;
        this.menuAPreparar = menuAPreparar;
        this.localDondeComprar = localDondeComprar;
        this.rutaImagen = rutaImagen;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public double getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(double precioProducto) {
        this.precioProducto = precioProducto;
    }

    public String getEnfermedadCronicaQueCombate() {
        return enfermedadCronicaQueCombate;
    }

    public void setEnfermedadCronicaQueCombate(String enfermedadCronicaQueCombate) {
        this.enfermedadCronicaQueCombate = enfermedadCronicaQueCombate;
    }

    public String getRegionOriunda() {
        return regionOriunda;
    }

    public void setRegionOriunda(String regionOriunda) {
        this.regionOriunda = regionOriunda;
    }

    public String getLocalDondeComprar() {
        return localDondeComprar;
    }

    public void setLocalDondeComprar(String localDondeComprar) {
        this.localDondeComprar = localDondeComprar;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    public String getMenuAPreparar() {
        return menuAPreparar;
    }

    public void setMenuAPreparar(String menuAPreparar) {
        this.menuAPreparar = menuAPreparar;
    }

    @Override
    public String toString() {
        return "Product{" +
                "nombreProducto='" + nombreProducto + '\'' +
                ", codigoProducto='" + codigoProducto + '\'' +
                ", precioProducto=" + precioProducto +
                ", enfermedadCronicaQueCombate='" + enfermedadCronicaQueCombate + '\'' +
                ", regionOriunda='" + regionOriunda + '\'' +
                ", menuAPreparar='" + menuAPreparar + '\'' +
                ", localDondeComprar='" + localDondeComprar + '\'' +
                ", rutaImagen='" + rutaImagen + '\'' +
                '}';
    }
}
