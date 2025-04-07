package ar.unrn.restaurante;

public class ItemMenu {
    private float precio;
    private String nombreItem;


    protected ItemMenu(float precio, String nombreItem) {
        this.precio = precio;
        this.nombreItem = nombreItem;
    }


    float obtenerPrecio() {
        return this.precio;
    }
}
