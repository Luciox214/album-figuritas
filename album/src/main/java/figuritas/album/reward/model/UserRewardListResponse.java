package figuritas.album.reward.model;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@Schema(name = "UserRewardListResponse", description = "Respuesta estándar para premios reclamados")
public record UserRewardListResponse(
        @Schema(example = "success") String status,
        @Schema(example = "Listado de premios reclamados obtenido correctamente") String mensaje,
        @ArraySchema(schema = @Schema(implementation = UserRewardDTO.class)) List<UserRewardDTO> data
) {
}
