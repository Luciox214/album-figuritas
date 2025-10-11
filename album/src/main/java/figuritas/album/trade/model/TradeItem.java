package figuritas.album.trade.model;

import figuritas.album.userSticker.model.UserSticker;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "trade_items")
public class TradeItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trade_id", nullable = false)
    private Trade trade;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_sticker_id", nullable = false)
    private UserSticker userSticker;

    private boolean esOfrecida;
}

