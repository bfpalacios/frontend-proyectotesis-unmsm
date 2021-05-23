package pe.edu.unmsm.sistemas.model;

import java.io.Serializable;

public class Product implements Serializable {

    private int idProducto;
    private String codigoPatron;
    private String codigoProducto;
    private String nombreProducto;
    private double precioProducto;
    private String enfermedadCronicaQueCombate;
    private String regionOriunda;
    private String menuAPreparar;
    private String localDondeComprar;
    private String rutaImagen;
    private String rutaImagen3d;

    public Product(){}

    public Product(int idProducto, String codigoPatron,String nombreProducto, String codigoProducto, double precioProducto, String enfermedadCronicaQueCombate, String regionOriunda, String menuAPreparar, String localDondeComprar, String rutaImagen, String rutaImagen3d) {
        this.idProducto = idProducto;
        this.codigoPatron = codigoPatron;
        this.nombreProducto = nombreProducto;
        this.codigoProducto = codigoProducto;
        this.precioProducto = precioProducto;
        this.enfermedadCronicaQueCombate = enfermedadCronicaQueCombate;
        this.regionOriunda = regionOriunda;
        this.menuAPreparar = menuAPreparar;
        this.localDondeComprar = localDondeComprar;
        this.rutaImagen = rutaImagen;
        this.rutaImagen3d = rutaImagen3d;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
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

    public String getRutaImagen3d() {
        return rutaImagen3d;
    }

    public void setRutaImagen3d(String rutaImagen3d) {
        this.rutaImagen3d = rutaImagen3d;
    }

    public String getMenuAPreparar() {
        return menuAPreparar;
    }

    public void setMenuAPreparar(String menuAPreparar) {
        this.menuAPreparar = menuAPreparar;
    }

    public String getCodigoPatron() {
        return codigoPatron;
    }

    public void setCodigoPatron(String codigoPatron) {
        this.codigoPatron = codigoPatron;
    }

    @Override
    public String toString() {
        return "Product{" +
                "idProducto=" + idProducto +
                ", codigoPatron='" + codigoPatron + '\'' +
                ", codigoProducto='" + codigoProducto + '\'' +
                ", nombreProducto='" + nombreProducto + '\'' +
                ", precioProducto=" + precioProducto +
                ", enfermedadCronicaQueCombate='" + enfermedadCronicaQueCombate + '\'' +
                ", regionOriunda='" + regionOriunda + '\'' +
                ", menuAPreparar='" + menuAPreparar + '\'' +
                ", localDondeComprar='" + localDondeComprar + '\'' +
                ", rutaImagen='" + rutaImagen + '\'' +
                ", rutaImagen3d='" + rutaImagen3d + '\'' +
                '}';
    }
}
