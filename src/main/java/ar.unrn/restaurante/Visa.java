package ar.unrn.restaurante;

public class Visa implements Tarjeta {
    private float descuento = 0.97F;

    @Override
    public float calcularCosto(Mesa mesa, float propina) {
        float costoBebidas = mesa.cerrarBebidas();
        float BebidasConDescuento = costoBebidas * descuento;
        float totalSinPropina = BebidasConDescuento + mesa.cerrarPlatos();
        return totalSinPropina * (1 + (float) propina / 100);
    }
}
