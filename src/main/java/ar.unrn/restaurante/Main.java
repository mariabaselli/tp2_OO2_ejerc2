package ar.unrn.restaurante;

import ar.unrn.persistencia.ArchivoDeCostos;
import ar.unrn.persistencia.RegistroDAOJDBC;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        Tarjeta visa = new Visa();
        RegistroDeCostos registroDAO = new RegistroDAOJDBC();
        RegistroDeCostos registro = new ArchivoDeCostos("C:\\Users\\Maria\\Documents\\universidad\\2025\\Objetos 2\\Tp's\\Tp2 registroCostos.txt");
        Mesa unaMesa = Mesa.crearMesa(10, registro, () -> LocalDate.now());
        unaMesa.agregarBebida(new ItemMenu(8f, "cerveza"), 2);
        unaMesa.cerrarMesa(visa, 2);

    }
}
