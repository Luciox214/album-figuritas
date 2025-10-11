package figuritas.album.trade.repository;

import figuritas.album.trade.model.TradeItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TradeItemRepository extends JpaRepository<TradeItem,Long> {
}
