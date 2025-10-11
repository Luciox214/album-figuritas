package figuritas.album.trade.service;

import figuritas.album.trade.model.Trade;
import figuritas.album.trade.model.TradeItem;
import figuritas.album.trade.repository.TradeRepository;
import figuritas.album.trade.state.Creado;
import figuritas.album.trade.state.TradeStateEnum;
import figuritas.album.userSticker.model.UserSticker;
import figuritas.album.userSticker.repository.UserStickerRepository;
import figuritas.album.usuario.model.Usuario;
import figuritas.album.usuario.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Objects;

@Service
public class TradeService {

    private final TradeRepository tradeRepository;
    private final UsuarioRepository usuarioRepository;
    private final UserStickerRepository userStickerRepository;

    public TradeService(TradeRepository tradeRepository, UsuarioRepository usuarioRepository, UserStickerRepository userStickerRepository) {
        this.tradeRepository = tradeRepository;
        this.usuarioRepository = usuarioRepository;
        this.userStickerRepository = userStickerRepository;
    }

    @Transactional
    public Trade crearTrade(Long creadorId, Long receptorId, Long userStickerOfrecidoId, Long userStickerSolicitadoId) {
        Usuario creador = usuarioRepository.findById(creadorId)
                .orElseThrow(() -> new EntityNotFoundException("Creador no encontrado"));
        Usuario receptor = usuarioRepository.findById(receptorId)
                .orElseThrow(() -> new EntityNotFoundException("Receptor no encontrado"));
        UserSticker stickerOfrecido = userStickerRepository.findById(userStickerOfrecidoId)
                .orElseThrow(() -> new EntityNotFoundException("Figurita ofrecida no encontrada"));
        UserSticker stickerSolicitado = userStickerRepository.findById(userStickerSolicitadoId)
                .orElseThrow(() -> new EntityNotFoundException("Figurita solicitada no encontrada"));

        if (!stickerOfrecido.getUsuario().equals(creador)) {
            throw new IllegalStateException("La figurita ofrecida no pertenece al creador del intercambio.");
        }
        if (!stickerSolicitado.getUsuario().equals(receptor)) {
            throw new IllegalStateException("La figurita solicitada no pertenece al receptor del intercambio.");
        }

        Trade trade = new Trade();
        trade.setCreador(creador);
        trade.setReceptor(receptor);
        trade.setCreatedAt(LocalDateTime.now());
        trade.setEstadoDB(TradeStateEnum.CREADO);
        trade.setEstado(new Creado());

        TradeItem itemOfrecido = new TradeItem();
        itemOfrecido.setUserSticker(stickerOfrecido);
        itemOfrecido.setEsOfrecida(true);
        trade.addItem(itemOfrecido);

        TradeItem itemSolicitado = new TradeItem();
        itemSolicitado.setUserSticker(stickerSolicitado);
        itemSolicitado.setEsOfrecida(false);
        trade.addItem(itemSolicitado);

        return tradeRepository.save(trade);
    }

    @Transactional
    public Trade ofertarTrade(Long tradeId, Long userId) {
        Trade trade = tradeRepository.findById(tradeId)
                .orElseThrow(() -> new EntityNotFoundException("Intercambio no encontrado"));
        if (!Objects.equals(trade.getCreador().getId(), userId)) {
            throw new IllegalStateException("Solo el creador puede ofertar el intercambio.");
        }
        trade.ofertar();
        return tradeRepository.save(trade);
    }

    @Transactional
    public Trade aceptarTrade(Long tradeId, Long userId) {
        Trade trade = tradeRepository.findById(tradeId)
                .orElseThrow(() -> new EntityNotFoundException("Intercambio no encontrado"));
        if (!Objects.equals(trade.getReceptor().getId(), userId)) {
            throw new IllegalStateException("Solo el receptor puede aceptar el intercambio.");
        }
        trade.aceptar();
        return tradeRepository.save(trade);
    }

    @Transactional
    public Trade rechazarTrade(Long tradeId, Long userId) {
        Trade trade = tradeRepository.findById(tradeId)
                .orElseThrow(() -> new EntityNotFoundException("Intercambio no encontrado"));
        if (!Objects.equals(trade.getReceptor().getId(), userId)) {
            throw new IllegalStateException("Solo el receptor puede rechazar el intercambio.");
        }
        trade.rechazar();
        return tradeRepository.save(trade);
    }

    @Transactional
    public Trade cancelarTrade(Long tradeId, Long userId) {
        Trade trade = tradeRepository.findById(tradeId)
                .orElseThrow(() -> new EntityNotFoundException("Intercambio no encontrado"));
        if (!Objects.equals(trade.getCreador().getId(), userId)) {
            throw new IllegalStateException("Solo el creador puede cancelar el intercambio.");
        }
        trade.cancelar();
        return tradeRepository.save(trade);
    }

    @Transactional
    public Trade cerrarTrade(Long tradeId, Long userId) {
        Trade trade = tradeRepository.findById(tradeId)
                .orElseThrow(() -> new EntityNotFoundException("Intercambio no encontrado"));
        trade.cerrar();
        return tradeRepository.save(trade);
    }
}

