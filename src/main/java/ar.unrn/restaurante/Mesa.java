package ar.unrn.restaurante;

import java.util.ArrayList;

public class Mesa {


    static final String ERROR_NUMERO_MESA = "Ya supero la creación de 10 mesas";
    private static final int CANTIDAD_MESAS_TOTALES = 10;
    private static int cantidadMesasCreadas = 0;
    private int numero;
    private ArrayList<ItemMenu> listaDeBebidas;
    private ArrayList<ItemMenu> listaDePlatos;
    private float precioTotalBebidas;
    private float precioTotalPlatos;
    private RegistroDeCostos registro;
    private ProveedorDeFecha proveedor;


    private Mesa(int numero, RegistroDeCostos registro, ProveedorDeFecha proveedor) {
        this.listaDeBebidas = new ArrayList<>();
        this.listaDePlatos = new ArrayList<>();
        this.numero = numero;
        this.precioTotalBebidas = 0.0F;
        this.precioTotalPlatos = 0.0F;
        this.registro = registro;
        this.proveedor = proveedor;


        {
            cantidadMesasCreadas++;
        }
    }


    static Mesa crearMesa(int numero, RegistroDeCostos registro, ProveedorDeFecha proveedorFecha) {
        assertCantidadMesas(numero);
        return new Mesa(numero, registro, proveedorFecha);
    }

    private static void assertCantidadMesas(int numero) {
        if (cantidadMesasCreadas > CANTIDAD_MESAS_TOTALES) {
            throw new IllegalArgumentException(ERROR_NUMERO_MESA);
        }
    }

    void agregarBebida(ItemMenu unaBebida, int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            listaDeBebidas.add(unaBebida);
        }

    }

    void agregarPlato(ItemMenu unPlato, int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            listaDePlatos.add(unPlato);
        }

    }

    int cantidadPlatos() {
        return listaDePlatos.size();
    }

    int cantidadBebidas() {
        return listaDeBebidas.size();
    }

    float cerrarMesa(Tarjeta unaTarjeta, int propina) {
        float costoTotal = unaTarjeta.calcularCosto(this, propina);
        this.registro.registrarCostos(proveedor.fecha(), costoTotal);
        return costoTotal;
    }

    float cerrarBebidas() {
        for (ItemMenu item : listaDeBebidas) this.precioTotalBebidas += item.obtenerPrecio();
        return this.precioTotalBebidas;
    }

    float cerrarPlatos() {
        for (ItemMenu item : listaDePlatos) this.precioTotalPlatos += item.obtenerPrecio();
        return this.precioTotalPlatos;
    }

}
