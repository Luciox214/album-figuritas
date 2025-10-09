package figuritas.album.reward.controller;
import figuritas.album.reward.model.Reward;
import figuritas.album.reward.model.UserReward;
import figuritas.album.reward.service.RewardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/premios")
@Tag(name = "Gestión de Premios", description = "Creación y reclamo de premios de álbumes")
public class RewardController {

    @Autowired
    private RewardService rewardService;

    @Operation(summary = "Crear un nuevo premio", description = "Registra un nuevo premio en el sistema")
    @ApiResponse(responseCode = "200", description = "Premio creado exitosamente")
    @PostMapping
    public Reward crearPremio(@RequestBody Reward reward) {
        return rewardService.crearPremio(reward);
    }

    @Operation(summary = "Reclamar premio", description = "Permite a un usuario reclamar un premio asociado a su álbum")
    @ApiResponse(responseCode = "200", description = "Premio reclamado exitosamente")
    @PostMapping("/reclamar")
    public UserReward reclamarPremio(
            @RequestParam Long usuarioId,
            @RequestParam Long albumId) {
        return rewardService.reclamarPremio(usuarioId, albumId);
    }
}
