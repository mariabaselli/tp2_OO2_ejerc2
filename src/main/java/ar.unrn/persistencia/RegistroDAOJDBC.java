package ar.unrn.persistencia;

import ar.unrn.restaurante.RegistroDeCostos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class RegistroDAOJDBC implements RegistroDeCostos {
    private static final String queryCreateCosto = "INSERT into registro_costos (fecha_costo, monto_total) VALUES (?, ?)";

    @Override
    public void registrarCostos(LocalDate fechaCosto, float montoTotal) {
        try {
            Connection conn = ConnectionManager
                    .getConnection();

            PreparedStatement statement = conn
                    .prepareStatement(queryCreateCosto);

            statement.setDate(1, Date.valueOf(fechaCosto));
            statement.setFloat(2, montoTotal);

            int cantidad = statement.executeUpdate();
            if (cantidad != 1) {
                throw new RuntimeException("Error al crear el registro");
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error al procesar la consulta sql de creación del registro de costos");

        } catch (Exception e) {
            throw new RuntimeException("Error al insertar un costo en la mesa");
        } finally {
            ConnectionManager.disconnect();
        }

    }
}
