package figuritas.album.simulacion.service;
import figuritas.album.album.model.Album;
import figuritas.album.sticker.model.Sticker;
import figuritas.album.userSticker.model.UserSticker;
import figuritas.album.usuario.model.Usuario;
import figuritas.album.album.repository.AlbumRepository;
import figuritas.album.sticker.repository.StickerRepository;
import figuritas.album.userSticker.repository.UserStickerRepository;
import figuritas.album.usuario.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class SimulacionCompraService {
    @Autowired
    AlbumRepository albumRepository;
    @Autowired
    StickerRepository stickerRepository;
    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    UserStickerRepository userStickerRepository;

    @Transactional
    public List<UserSticker> comprarPaquete(Long userId, Long albumId) {
        Usuario usuario = usuarioRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));
        Album album = albumRepository.findById(albumId)
                .orElseThrow(() -> new IllegalArgumentException("Álbum no encontrado"));

        List<Sticker> figuritasDisponibles = stickerRepository.findByAlbumId(albumId);
        if (figuritasDisponibles.isEmpty()) {
            throw new IllegalStateException("No hay figuritas disponibles para este álbum");
        }

        Collections.shuffle(figuritasDisponibles);
        List<Sticker> seleccionadas = figuritasDisponibles.stream()
                .limit(5)
                .toList();

        List<UserSticker> obtenidas = seleccionadas.stream()
                .map(sticker -> {
                    UserSticker us = new UserSticker();
                    us.setUsuario(usuario);
                    us.setSticker(sticker);
                    return us;
                })
                .toList();

        return userStickerRepository.saveAll(obtenidas);
    }

}
