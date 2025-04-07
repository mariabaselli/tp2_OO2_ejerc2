package ar.unrn.restaurante;

public class ComarcaPlus implements Tarjeta {
    private static float descuento = 0.98F;

    @Override
    public float calcularCosto(Mesa mesa, float propina) {
        float costoTotalSinDescuento = mesa.cerrarBebidas() + mesa.cerrarPlatos();
        float totalSinPropina = costoTotalSinDescuento * descuento;
        return totalSinPropina * (1 + propina / 100);
    }
}
