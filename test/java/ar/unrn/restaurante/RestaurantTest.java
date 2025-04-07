package ar.unrn.restaurante;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RestaurantTest {

    ItemMenu unaBebida;
    ItemMenu unPlato;
    Mesa unaMesa;
    FakeRegistroDeCostos registro;


    @BeforeEach
    void inicializarVariables() {
        this.unaBebida = new ItemMenu(2f, "Coca Cola");
        this.unPlato = new ItemMenu(10f, "Pizza");
        this.registro = new FakeRegistroDeCostos();
        this.unaMesa = Mesa.crearMesa(1, registro, new FakeProveedorDeFecha());
        this.unaMesa.agregarBebida(unaBebida, 1);
        this.unaMesa.agregarPlato(unPlato, 1);
    }

    @Test
    public void verificarRegistroDeCostos() {
        unaMesa.cerrarMesa(new Visa(), 1);
        assertTrue(registro.startWith("08/05/2025"));
    }

    @Test
    void realizarPedido() {
        assertEquals(2, unaMesa.cantidadBebidas() + unaMesa.cantidadPlatos());
    }

    @Test
    public void calcularCostoVisa() {
        Tarjeta unaTarjeta = new Visa();
        assertEquals(12.178801F, unaMesa.cerrarMesa(unaTarjeta, 2));
    }

    @Test
    public void calcularCostoMastercard() {
        Tarjeta unaTarjeta = new Mastercard();
        assertEquals(12.154F, unaMesa.cerrarMesa(unaTarjeta, 3));
    }

    @Test
    public void calcularComarcaPlus() {
        Tarjeta unaTarjeta = new ComarcaPlus();
        assertEquals(12.348F, unaMesa.cerrarMesa(unaTarjeta, 5));
    }

    @Test
    public void calcularTarjetaViedma() {
        Tarjeta unaTarjeta = new Viedma();
        assertEquals(12.599999F, unaMesa.cerrarMesa(unaTarjeta, 5));
    }
}
