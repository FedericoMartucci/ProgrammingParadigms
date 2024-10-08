package banco.cuenta;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transaccion {
    private BigDecimal monto;
    private String motivo;
    private TipoTransaccion tipoTransaccion;
    private LocalDateTime fecha;

    public Transaccion(BigDecimal monto, String motivo, TipoTransaccion tipoTransaccion) {
        this.monto = monto;
        this.motivo = motivo;
        this.tipoTransaccion = tipoTransaccion;
        this.fecha = LocalDateTime.now(); // Fecha actual
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public String getMotivo() {
        return motivo;
    }

    public TipoTransaccion getTipoTransaccion() {
        return tipoTransaccion;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    @Override
    public String toString() {
        return "Transaccion{" +
                "monto=" + monto +
                ", motivo='" + motivo + '\'' +
                ", tipoTransaccion=" + tipoTransaccion +
                ", fecha=" + fecha +
                '}';
    }
}