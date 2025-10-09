package figuritas.album.simulacion.controller;
import figuritas.album.userSticker.model.UserSticker;
import figuritas.album.simulacion.service.SimulacionCompraService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/v1/simulacion")
@Tag(name = "Simulación de Compra", description = "Simula la compra de paquetes de figuritas")
public class SimulacionController {

    @Autowired
    private SimulacionCompraService simulacionCompraService;

    @Operation(
            summary = "Simular compra de paquete",
            description = "Devuelve 5 figuritas aleatorias del álbum seleccionado para el usuario indicado"
    )
    @ApiResponse(responseCode = "200", description = "Paquete generado correctamente")
    @PostMapping("/comprar/{albumId}")
    public List<UserSticker> simularCompra(
            @RequestParam Long userId,
            @PathVariable Long albumId) {
        return simulacionCompraService.comprarPaquete(userId, albumId);
    }
}
