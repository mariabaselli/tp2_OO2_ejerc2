package ar.unrn.restaurante;

import java.time.LocalDate;

public interface RegistroDeCostos {

    public void registrarCostos(LocalDate fechaCosto, float montoTotal);
}
