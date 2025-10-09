package figuritas.album.reward.state;

import figuritas.album.reward.model.UserReward;

public interface IEstadoUserReward {
    void reclamar(UserReward context);
    RewardStateEnum getEstadoEnum();

}
