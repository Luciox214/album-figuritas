package figuritas.album.trade.state;

import figuritas.album.trade.model.Trade;
import java.time.LocalDateTime;

public class Aceptado implements IEstadoIntercambio {

    @Override
    public void cerrar(Trade trade) {
        trade.setClosedAt(LocalDateTime.now());
        trade.cambiarEstado(new Cerrado());
    }

    @Override
    public TradeStateEnum getEstadoEnum() {
        return TradeStateEnum.ACEPTADO;
    }
}

