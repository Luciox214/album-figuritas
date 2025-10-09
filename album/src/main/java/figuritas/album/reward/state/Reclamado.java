package figuritas.album.reward.state;

import figuritas.album.reward.model.UserReward;

public class Reclamado implements IEstadoUserReward {
    @Override
    public void reclamar(UserReward context) {
        throw new IllegalStateException("El premio ya ha sido reclamado y no se puede volver a reclamar.");
    }

    @Override
    public RewardStateEnum getEstadoEnum() {
        return RewardStateEnum.RECLAMADO;
    }
}
