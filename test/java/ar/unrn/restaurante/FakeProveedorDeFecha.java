package ar.unrn.restaurante;

import java.time.LocalDate;

public class FakeProveedorDeFecha implements ProveedorDeFecha {

    @Override
    public LocalDate fecha() {
        return LocalDate.of(2025, 5, 8);
    }
}
