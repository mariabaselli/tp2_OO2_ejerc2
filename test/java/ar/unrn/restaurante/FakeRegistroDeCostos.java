package ar.unrn.restaurante;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FakeRegistroDeCostos implements RegistroDeCostos {
    private StringBuilder registro;

    public FakeRegistroDeCostos() {
        this.registro = new StringBuilder();
    }

    Boolean startWith(String start) {
        return this.registro.toString().startsWith(start);
    }

    @Override
    public void registrarCostos(LocalDate fechaCosto, float montoTotal) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String linea = fechaCosto.format(formatter) + "||" + montoTotal + "\n";
        this.registro.append(linea);
    }
}
