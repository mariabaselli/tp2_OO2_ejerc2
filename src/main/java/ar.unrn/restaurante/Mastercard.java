package ar.unrn.restaurante;

public class Mastercard implements Tarjeta {

    private static float descuento = 0.98F;

    @Override
    public float calcularCosto(Mesa mesa, float propina) {
        float costoPlatos = mesa.cerrarPlatos();
        float PlatosConDescuento = costoPlatos * descuento;
        float totalSinPropina = PlatosConDescuento + mesa.cerrarBebidas();
        return totalSinPropina * (1 + (float) propina / 100);
    }
}
