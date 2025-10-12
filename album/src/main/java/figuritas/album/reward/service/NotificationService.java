package figuritas.album.reward.service;
import figuritas.album.reward.model.UserReward;
import figuritas.album.reward.state.IObserver;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class NotificationService implements IObserver {
    @Autowired
    JavaMailSender mailSender;
    @Override
    public void actualizar(UserReward userReward) {
        String userEmail = userReward.getUsuario().getEmail();
        String userName = userReward.getUsuario().getUsername();
        String albumTitle = userReward.getAlbum().getTitulo();

        if (userEmail == null || userEmail.isEmpty()) {
            System.out.println("El usuario no tiene un email válido. No se puede enviar la notificación.");
            return;
        }

        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

            helper.setFrom("noreply@albumvirtual.com");
            helper.setTo(userEmail);
            helper.setSubject("¡Felicidades, " + userName + "!");

            String htmlContent = crearPlantillaHtml(userName, albumTitle);
            helper.setText(htmlContent, true);

            mailSender.send(message);

        } catch (MessagingException e) {
            System.out.println("Error al enviar el correo electrónico: " + e.getMessage());
        }
    }

    private String crearPlantillaHtml(String userName, String albumTitle) {
        return "<!DOCTYPE html>"
                + "<html lang='es'>"
                + "<head>"
                + "<meta charset='UTF-8'>"
                + "<style>"
                + "  body { font-family: Arial, sans-serif; margin: 0; padding: 0; background-color: #f4f4f4; }"
                + "  .container { width: 100%; max-width: 600px; margin: 20px auto; background-color: #ffffff; border-radius: 8px; box-shadow: 0 4px 8px rgba(0,0,0,0.1); overflow: hidden; }"
                + "  .header { background-color: #4A90E2; color: #ffffff; padding: 40px; text-align: center; }"
                + "  .header h1 { margin: 0; font-size: 28px; }"
                + "  .content { padding: 30px; color: #333333; line-height: 1.6; }"
                + "  .content p { margin: 0 0 20px; }"
                + "  .highlight { font-weight: bold; color: #4A90E2; }"
                + "  .footer { background-color: #f4f4f4; color: #888888; text-align: center; padding: 20px; font-size: 12px; }"
                + "</style>"
                + "</head>"
                + "<body>"
                + "  <div class='container'>"
                + "    <div class='header'>"
                + "      <h1>🏆 ¡Premio Reclamado! 🏆</h1>"
                + "    </div>"
                + "    <div class='content'>"
                + "      <p>Hola <span class='highlight'>" + userName + "</span>,</p>"
                + "      <p>¡Felicidades! Has completado con éxito el álbum <span class='highlight'>&quot;" + albumTitle + "&quot;</span> y has reclamado tu premio.</p>"
                + "    </div>"
                + "    <div class='footer'>"
                + "      <p>&copy; 2025 Álbum Virtual. Todos los derechos reservados.</p>"
                + "    </div>"
                + "  </div>"
                + "</body>"
                + "</html>";
    }
}

