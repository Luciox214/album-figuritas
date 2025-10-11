package figuritas.album.trade.state;

public class Cerrado implements IEstadoIntercambio {
    @Override
    public TradeStateEnum getEstadoEnum() {
        return TradeStateEnum.CERRADO;
    }
}
