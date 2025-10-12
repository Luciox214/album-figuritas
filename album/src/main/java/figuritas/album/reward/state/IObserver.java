package figuritas.album.reward.state;

import figuritas.album.reward.model.UserReward;

public interface IObserver {
    void actualizar(UserReward userReward);
}
