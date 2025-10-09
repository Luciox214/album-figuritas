package figuritas.album.reward.state;

import figuritas.album.reward.model.UserReward;

import java.time.LocalDateTime;

public class NoReclamado implements IEstadoUserReward {

    @Override
    public void reclamar(UserReward context) {
        context.cambiarEstado(new Reclamado());
        context.setClaimedAt(LocalDateTime.now());
        System.out.println("Premio reclamado con éxito.");
    }

    @Override
    public RewardStateEnum getEstadoEnum() {
        return RewardStateEnum.NORECLAMADO;
    }

}
