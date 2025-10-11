package figuritas.album.trade.controller;
import figuritas.album.trade.model.Trade;
import figuritas.album.trade.service.TradeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/trades")
public class TradeController {

    private final TradeService tradeService;

    public TradeController(TradeService tradeService) {
        this.tradeService = tradeService;
    }

    @PostMapping
    public ResponseEntity<Trade> crearTrade(@RequestParam Long creadorId,
                                             @RequestParam Long receptorId,
                                             @RequestParam Long userStickerOfrecidoId,
                                             @RequestParam Long userStickerSolicitadoId) {
        Trade trade = tradeService.crearTrade(creadorId, receptorId, userStickerOfrecidoId, userStickerSolicitadoId);
        return ResponseEntity.ok(trade);
    }

    @PostMapping("/{tradeId}/offer")
    public ResponseEntity<Trade> ofertarTrade(@PathVariable Long tradeId, @RequestParam Long userId) {
        Trade tradeActualizado = tradeService.ofertarTrade(tradeId, userId);
        return ResponseEntity.ok(tradeActualizado);
    }

    @PostMapping("/{tradeId}/accept")
    public ResponseEntity<Trade> aceptarTrade(@PathVariable Long tradeId, @RequestParam Long userId) {
        Trade tradeActualizado = tradeService.aceptarTrade(tradeId, userId);
        return ResponseEntity.ok(tradeActualizado);
    }

    @PostMapping("/{tradeId}/reject")
    public ResponseEntity<Trade> rechazarTrade(@PathVariable Long tradeId, @RequestParam Long userId) {
        Trade tradeActualizado = tradeService.rechazarTrade(tradeId, userId);
        return ResponseEntity.ok(tradeActualizado);
    }

    @PostMapping("/{tradeId}/cancel")
    public ResponseEntity<Trade> cancelarTrade(@PathVariable Long tradeId, @RequestParam Long userId) {
        Trade tradeActualizado = tradeService.cancelarTrade(tradeId, userId);
        return ResponseEntity.ok(tradeActualizado);
    }

    @PostMapping("/{tradeId}/close")
    public ResponseEntity<Trade> cerrarTrade(@PathVariable Long tradeId, @RequestParam Long userId) {
        Trade tradeActualizado = tradeService.cerrarTrade(tradeId, userId);
        return ResponseEntity.ok(tradeActualizado);
    }
}


