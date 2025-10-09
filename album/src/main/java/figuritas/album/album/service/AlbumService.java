package figuritas.album.album.service;
import figuritas.album.album.repository.AlbumRepository;
import figuritas.album.album.model.Album;
import figuritas.album.sticker.model.Sticker;
import figuritas.album.sticker.repository.StickerRepository;
import figuritas.album.userSticker.model.UserSticker;
import figuritas.album.userSticker.repository.UserStickerRepository;
import figuritas.album.usuario.model.Usuario;
import figuritas.album.usuario.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.List;

@Service
public class AlbumService {
    @Autowired
    UserStickerRepository userStickerRepository;
    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private StickerRepository stickerRepository;

    public Album crearAlbum(Album album) {
        return albumRepository.save(album);
    }

    public Album cargarAlbum(Long albumId, List<Sticker> stickers) {
        Album album = albumRepository.findById(albumId)
                .orElseThrow(() -> new IllegalArgumentException("Álbum no encontrado con id: " + albumId));
        for (Sticker sticker : stickers) {
            sticker.setAlbum(album);
            stickerRepository.save(sticker);
        }
        int total= album.getTotalFiguritas()+stickers.size();
        album.setTotalFiguritas(total);
        return albumRepository.save(album);
    }

    public void borrarAlbum(Long id) {
        albumRepository.deleteById(id);
    }

    public List<Album> obtenerAlbums() {
        return albumRepository.findAll();
    }


    @Transactional()
    public List<UserSticker> obtenerFiguritasRepetidas(Long userId) {
        Usuario usuario = usuarioRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado con ID: " + userId));

        List<Long> stickerIdDuplicados = userStickerRepository.findDuplicateStickerIdsByUsuario(usuario);

        if (stickerIdDuplicados.isEmpty()) {
            return Collections.emptyList();
        }
        return userStickerRepository.findByUsuarioAndStickerIds(usuario, stickerIdDuplicados);
    }
    public String obtenerPorcentajeAlbumCompleto(Long usuarioId, Long albumId) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado con ID: " + usuarioId));
        Album album = albumRepository.findById(albumId)
                .orElseThrow(() -> new EntityNotFoundException("Álbum no encontrado con ID: " + albumId));
        long totalFiguritasAlbum = album.getTotalFiguritas();
        if (totalFiguritasAlbum == 0) {
            return "0%";
        }
        long figuritasUnicasUsuario = userStickerRepository.countByUserAndAlbum(usuario, album);
        double porcentaje = ((double) figuritasUnicasUsuario / totalFiguritasAlbum) * 100;
        return String.format("%.2f%%", porcentaje);
    }
}