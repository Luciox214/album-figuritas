package figuritas.album.reward.controller;

import figuritas.album.response.ResponseApi;
import figuritas.album.reward.model.UserReward;
import figuritas.album.reward.service.RewardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/albums")
@Tag(name = "Premios (Acceso rápido)", description = "Alias REST para reclamar premios desde el recurso álbum")
public class RewardClaimController {

    @Autowired
    private RewardService rewardService;

    @Operation(summary = "Reclamar premio por álbum", description = "Permite a un usuario reclamar el premio asociado a un álbum desde la ruta de álbumes")
    @ApiResponse(responseCode = "200", description = "Premio reclamado exitosamente")
    @PostMapping("/{albumId}/claim-reward")
    public ResponseEntity<ResponseApi<String>> claimReward(
            @PathVariable Long albumId,
            @RequestParam Long usuarioId) {
        UserReward reward = rewardService.reclamarPremio(usuarioId, albumId);
        String mensaje = "Premio '" + reward.getReward().getTipo() + "' reclamado correctamente.";
        return ResponseEntity.ok(ResponseApi.success(mensaje, null));
    }
}
