package ar.unrn.restaurante;

public class Viedma implements Tarjeta {

    @Override
    public float calcularCosto(Mesa mesa, float propina) {
        float costoTotalSinDescuento = mesa.cerrarBebidas() + mesa.cerrarPlatos();
        return costoTotalSinDescuento * (1 + propina / 100);
    }
}
