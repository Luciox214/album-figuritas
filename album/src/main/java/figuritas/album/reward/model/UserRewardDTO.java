package figuritas.album.reward.model;

import figuritas.album.reward.state.RewardStateEnum;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

@Schema(name = "UserRewardDTO", description = "Representa un premio reclamado por un usuario")
public record UserRewardDTO(
        @Schema(description = "Identificador del registro de premio reclamado", example = "10") Long id,
        @Schema(description = "Identificador del premio", example = "3") Long rewardId,
        @Schema(description = "Tipo de premio reclamado", example = "SKIN") String rewardTipo,
        @Schema(description = "Identificador del álbum asociado", example = "2") Long albumId,
        @Schema(description = "Título del álbum asociado", example = "Álbum Mundial 2026") String albumTitulo,
        @Schema(description = "Estado actual del premio", example = "RECLAMADO") RewardStateEnum estado,
        @Schema(description = "Fecha y hora en la que se reclamó el premio") LocalDateTime claimedAt
) {
}
