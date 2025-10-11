package figuritas.album.trade.state;

import figuritas.album.trade.model.Trade;

public interface IEstadoIntercambio {
    default void ofertar(Trade trade) {
        throw new IllegalStateException("No se puede ofertar en el estado actual: " + getEstadoEnum());
    }

    default void aceptar(Trade trade) {
        throw new IllegalStateException("No se puede aceptar en el estado actual: " + getEstadoEnum());
    }

    default void rechazar(Trade trade) {
        throw new IllegalStateException("No se puede rechazar en el estado actual: " + getEstadoEnum());
    }

    default void cancelar(Trade trade) {
        throw new IllegalStateException("No se puede cancelar en el estado actual: " + getEstadoEnum());
    }

    default void cerrar(Trade trade) {
        throw new IllegalStateException("No se puede cerrar en el estado actual: " + getEstadoEnum());
    }

    TradeStateEnum getEstadoEnum();
}

