package figuritas.album.trade.state;

import figuritas.album.trade.model.Trade;

public class Creado implements IEstadoIntercambio {

    @Override
    public void ofertar(Trade trade) {
        trade.cambiarEstado(new Ofertado());
    }

    @Override
    public void cancelar(Trade trade) {
        trade.cambiarEstado(new Cancelado());
    }

    @Override
    public TradeStateEnum getEstadoEnum() {
        return TradeStateEnum.CREADO;
    }
}

