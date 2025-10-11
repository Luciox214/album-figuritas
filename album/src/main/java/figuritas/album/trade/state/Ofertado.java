package figuritas.album.trade.state;

import figuritas.album.trade.model.Trade;
import figuritas.album.trade.model.TradeItem;
import figuritas.album.userSticker.model.UserSticker;
import figuritas.album.usuario.model.Usuario;

public class Ofertado implements IEstadoIntercambio {

    @Override
    public void aceptar(Trade trade) {
        UserSticker stickerOfrecido = null;
        UserSticker stickerSolicitado = null;

        for (TradeItem item : trade.getItems()) {
            if (item.isEsOfrecida()) {
                stickerOfrecido = item.getUserSticker();
            } else {
                stickerSolicitado = item.getUserSticker();
            }
        }

        if (stickerOfrecido == null || stickerSolicitado == null) {
            throw new IllegalStateException("El intercambio no está bien formado.");
        }

        Usuario creador = trade.getCreador();
        Usuario receptor = trade.getReceptor();

        stickerOfrecido.setUsuario(receptor);
        stickerSolicitado.setUsuario(creador);

        trade.cambiarEstado(new Aceptado());
    }

    @Override
    public void rechazar(Trade trade) {
        trade.cambiarEstado(new Rechazado());
    }

    @Override
    public void cancelar(Trade trade) {
        trade.cambiarEstado(new Cancelado());
    }

    @Override
    public TradeStateEnum getEstadoEnum() {
        return TradeStateEnum.OFERTADO;
    }
}
