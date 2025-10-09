// album/src/main/java/figuritas/album/reward/repository/RewardRepository.java
package figuritas.album.reward.repository;

import figuritas.album.reward.model.Reward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface RewardRepository extends JpaRepository<Reward, Long> {
    Optional<Reward> findByAlbumId(Long albumId);

    boolean existsByAlbumId(Long albumId);
}
