package figuritas.album.album.controller;
import figuritas.album.album.model.Album;
import figuritas.album.album.service.AlbumService;
import figuritas.album.sticker.model.Sticker;
import figuritas.album.userSticker.model.UserSticker;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/v1/album")
@Tag(name = "Gestión de Álbumes", description = "Administración de álbumes y figuritas")
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @Operation(summary = "Crear un nuevo álbum", description = "Registra un nuevo álbum en el sistema")
    @ApiResponse(responseCode = "200", description = "Álbum creado exitosamente")
    @PostMapping
    public Album guardarAlbum(@RequestBody Album album) {
        return albumService.crearAlbum(album);
    }

    @Operation(summary = "Cargar figuritas en un álbum", description = "Agrega una lista de figuritas a un álbum existente")
    @ApiResponse(responseCode = "200", description = "Figuritas cargadas correctamente")
    @PostMapping("/{id}/stickers")
    public Album cargarFiguritas(@PathVariable Long id, @RequestBody List<Sticker> stickers) {
        return albumService.cargarAlbum(id, stickers);
    }

    @Operation(summary = "Eliminar un álbum", description = "Elimina un álbum por su ID")
    @ApiResponse(responseCode = "200", description = "Álbum eliminado exitosamente")
    @DeleteMapping("/{id}")
    public void borrarAlbum(@PathVariable Long id) {
        albumService.borrarAlbum(id);
    }

    @Operation(summary = "Listar todos los álbumes", description = "Devuelve la lista completa de álbumes del sistema")
    @ApiResponse(responseCode = "200", description = "Listado obtenido correctamente")
    @GetMapping
    public List<Album> obtenerAlbums() {
        return albumService.obtenerAlbums();
    }


    @Operation(summary = "Obtener figuritas repetidas", description = "Devuelve la lista de figuritas repetidas del usuario")
    @ApiResponse(responseCode = "200", description = "Figuritas repetidas obtenidas correctamente")
    @GetMapping("/figuritas")
    public List<UserSticker> obtenerFiguritasRepetidas(@RequestParam Long userId) {
        return albumService.obtenerFiguritasRepetidas(userId);
    }

    @Operation(summary = "Porcentaje de álbum completo", description = "Calcula el porcentaje de figuritas completadas en el álbum del usuario")
    @ApiResponse(responseCode = "200", description = "Porcentaje obtenido exitosamente")
    @GetMapping("/porcentaje-album")
    public String obtenerPorcentajeAlbumCompleto(@RequestParam Long userId, @RequestParam Long albumId) {
        return albumService.obtenerPorcentajeAlbumCompleto(userId, albumId);
    }
}
