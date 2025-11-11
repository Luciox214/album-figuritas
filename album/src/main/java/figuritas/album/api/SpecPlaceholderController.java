package figuritas.album.api;

import figuritas.album.response.ResponseApi;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@Validated
@Tag(name = "API Draft", description = "Endpoints planificados pendientes de implementación")
public class SpecPlaceholderController {

    private ResponseEntity<ResponseApi<Void>> notImplemented(String mensaje) {
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED)
                .body(ResponseApi.error(mensaje, null));
    }

    @Operation(summary = "Registrar un usuario", description = "Crea un nuevo usuario en el sistema")
    @ApiResponse(responseCode = "501", description = "Funcionalidad pendiente de implementación")
    @PostMapping("/auth/register")
    public ResponseEntity<ResponseApi<Void>> register(@Valid @RequestBody AuthRegisterRequest request) {
        return notImplemented("Registro de usuarios pendiente de implementación");
    }

    @Operation(summary = "Iniciar sesión", description = "Autentica a un usuario y devuelve un token de acceso")
    @ApiResponse(responseCode = "501", description = "Funcionalidad pendiente de implementación")
    @PostMapping("/auth/login")
    public ResponseEntity<ResponseApi<Void>> login(@Valid @RequestBody AuthLoginRequest request) {
        return notImplemented("Login pendiente de implementación");
    }

    @Operation(summary = "Perfil propio", description = "Obtiene la información del usuario autenticado")
    @ApiResponse(responseCode = "501", description = "Funcionalidad pendiente de implementación")
    @GetMapping("/users/me")
    public ResponseEntity<ResponseApi<Void>> currentUser() {
        return notImplemented("Consulta de perfil pendiente de implementación");
    }

    @Operation(summary = "Actualizar perfil", description = "Actualiza los datos del usuario autenticado")
    @ApiResponse(responseCode = "501", description = "Funcionalidad pendiente de implementación")
    @PutMapping("/users/me")
    public ResponseEntity<ResponseApi<Void>> updateProfile(@Valid @RequestBody UserProfileUpdateRequest request) {
        return notImplemented("Actualización de perfil pendiente de implementación");
    }

    @Operation(summary = "Publicar álbum", description = "Marca un álbum como publicado y visible para la tienda")
    @ApiResponse(responseCode = "501", description = "Funcionalidad pendiente de implementación")
    @PostMapping("/albums/{albumId}/publish")
    public ResponseEntity<ResponseApi<Void>> publishAlbum(@PathVariable Long albumId) {
        return notImplemented("Publicación de álbum pendiente de implementación");
    }

    @Operation(summary = "Metadatos de figuritas", description = "Obtiene la información de figuritas para un álbum publicado")
    @ApiResponse(responseCode = "501", description = "Funcionalidad pendiente de implementación")
    @GetMapping("/albums/{albumId}/stickers")
    public ResponseEntity<ResponseApi<Void>> albumStickers(@PathVariable Long albumId) {
        return notImplemented("Metadatos de figuritas pendiente de implementación");
    }

    @Operation(summary = "Comprar pack", description = "Genera un pack de figuritas y las agrega a la colección del usuario")
    @ApiResponse(responseCode = "501", description = "Funcionalidad pendiente de implementación")
    @PostMapping("/shop/albums/{albumId}/packs")
    public ResponseEntity<ResponseApi<Void>> buyPack(
            @PathVariable Long albumId,
            @Valid @RequestBody PackPurchaseRequest request) {
        return notImplemented("Compra de pack pendiente de implementación");
    }

    @Operation(summary = "Mi colección", description = "Devuelve la colección del usuario autenticado para un álbum")
    @ApiResponse(responseCode = "501", description = "Funcionalidad pendiente de implementación")
    @GetMapping("/me/collection")
    public ResponseEntity<ResponseApi<Void>> meCollection(@RequestParam Long albumId) {
        return notImplemented("Colección del usuario pendiente de implementación");
    }

    @Operation(summary = "Figuritas faltantes", description = "Lista las figuritas faltantes para el usuario autenticado")
    @ApiResponse(responseCode = "501", description = "Funcionalidad pendiente de implementación")
    @GetMapping("/me/missing")
    public ResponseEntity<ResponseApi<Void>> meMissing(@RequestParam Long albumId) {
        return notImplemented("Faltantes del usuario pendiente de implementación");
    }

    @Operation(summary = "Figuritas duplicadas", description = "Lista las figuritas duplicadas del usuario autenticado")
    @ApiResponse(responseCode = "501", description = "Funcionalidad pendiente de implementación")
    @GetMapping("/me/duplicates")
    public ResponseEntity<ResponseApi<Void>> meDuplicates(@RequestParam Long albumId) {
        return notImplemented("Duplicadas del usuario pendiente de implementación");
    }

    @Operation(summary = "Crear trade", description = "Crea una propuesta de intercambio de figuritas")
    @ApiResponse(responseCode = "501", description = "Funcionalidad pendiente de implementación")
    @PostMapping("/trades")
    public ResponseEntity<ResponseApi<Void>> createTrade(@Valid @RequestBody TradeCreateRequest request) {
        return notImplemented("Creación de trade pendiente de implementación");
    }

    @Operation(summary = "Ofrecer figurita", description = "Agrega una oferta a un intercambio existente")
    @ApiResponse(responseCode = "501", description = "Funcionalidad pendiente de implementación")
    @PostMapping("/trades/{tradeId}/offer")
    public ResponseEntity<ResponseApi<Void>> offerTrade(
            @PathVariable Long tradeId,
            @Valid @RequestBody TradeOfferRequest request) {
        return notImplemented("Oferta de trade pendiente de implementación");
    }

    @Operation(summary = "Aceptar trade", description = "Acepta una oferta de intercambio")
    @ApiResponse(responseCode = "501", description = "Funcionalidad pendiente de implementación")
    @PostMapping("/trades/{tradeId}/accept")
    public ResponseEntity<ResponseApi<Void>> acceptTrade(@PathVariable Long tradeId) {
        return notImplemented("Aceptación de trade pendiente de implementación");
    }

    @Operation(summary = "Rechazar trade", description = "Rechaza una oferta de intercambio")
    @ApiResponse(responseCode = "501", description = "Funcionalidad pendiente de implementación")
    @PostMapping("/trades/{tradeId}/reject")
    public ResponseEntity<ResponseApi<Void>> rejectTrade(@PathVariable Long tradeId) {
        return notImplemented("Rechazo de trade pendiente de implementación");
    }

    @Operation(summary = "Cancelar trade", description = "Cancela un intercambio iniciado")
    @ApiResponse(responseCode = "501", description = "Funcionalidad pendiente de implementación")
    @PostMapping("/trades/{tradeId}/cancel")
    public ResponseEntity<ResponseApi<Void>> cancelTrade(@PathVariable Long tradeId) {
        return notImplemented("Cancelación de trade pendiente de implementación");
    }

    @Operation(summary = "Top álbumes", description = "Reporte de los álbumes más populares")
    @ApiResponse(responseCode = "501", description = "Funcionalidad pendiente de implementación")
    @GetMapping("/reports/top-albums")
    public ResponseEntity<ResponseApi<Void>> reportTopAlbums() {
        return notImplemented("Reporte de top álbumes pendiente de implementación");
    }

    @Operation(summary = "Figuritas raras", description = "Reporte de figuritas con rareza destacada")
    @ApiResponse(responseCode = "501", description = "Funcionalidad pendiente de implementación")
    @GetMapping("/reports/rare-stickers")
    public ResponseEntity<ResponseApi<Void>> reportRareStickers() {
        return notImplemented("Reporte de figuritas raras pendiente de implementación");
    }

    @Schema(name = "AuthRegisterRequest", description = "Datos necesarios para registrar un usuario")
    public record AuthRegisterRequest(
            @NotBlank @Schema(example = "pepe.garcia") String username,
            @NotBlank @Schema(example = "pepe@example.com") String email,
            @NotBlank @Schema(example = "S3cret!") String password
    ) { }

    @Schema(name = "AuthLoginRequest", description = "Credenciales para iniciar sesión")
    public record AuthLoginRequest(
            @NotBlank @Schema(example = "pepe@example.com") String usernameOrEmail,
            @NotBlank @Schema(example = "S3cret!") String password
    ) { }

    @Schema(name = "UserProfileUpdateRequest", description = "Datos para actualizar el perfil del usuario")
    public record UserProfileUpdateRequest(
            @Schema(example = "Pepe García") String nombre,
            @Schema(example = "+5491100000000") String telefono,
            @Schema(example = "Avatar mundial 2026") String avatarUrl
    ) { }

    @Schema(name = "PackPurchaseRequest", description = "Solicitud para comprar paquetes de figuritas")
    public record PackPurchaseRequest(
            @Min(1) @Schema(example = "1") int cantidad
    ) { }

    @Schema(name = "TradeCreateRequest", description = "Datos mínimos para crear un trade")
    public record TradeCreateRequest(
            @NotNull @Schema(example = "2") Long albumId,
            @NotNull @Schema(example = "25") Long stickerId,
            @NotNull @Schema(example = "5") Long targetUserId
    ) { }

    @Schema(name = "TradeOfferRequest", description = "Datos para ofrecer una figurita en un trade")
    public record TradeOfferRequest(
            @NotNull @Schema(example = "12") Long offeredStickerId
    ) { }
}
