package figuritas.album.usuario.service;
import figuritas.album.album.model.Album;
import figuritas.album.album.repository.AlbumRepository;
import figuritas.album.userSticker.model.UserSticker;
import figuritas.album.userSticker.repository.UserStickerRepository;
import figuritas.album.usuario.model.Usuario;
import figuritas.album.usuario.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class UsuarioService {
    @Autowired
    AlbumRepository albumRepository;
    @Autowired
    UserStickerRepository userStickerRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    public void crearUsuario(Usuario usuario){
        usuarioRepository.save(usuario);
    }
    public List<Usuario> obtenerUsuarios(){
        return usuarioRepository.findAll();
    }

    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

}