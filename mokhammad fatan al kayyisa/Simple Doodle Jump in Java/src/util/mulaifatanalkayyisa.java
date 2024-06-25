package util;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

public class mulaifatanalkayyisa {

    public static BufferedImage getImage(String file) {
        try {
            return ImageIO.read(mulaifatanalkayyisa.class.getResource("/images/" + file));
        } catch (IOException ex) {
            throw new RuntimeException("Error loading image: " + file, ex);
        }
    }

    public static URL getSoundFile(String file) {
        return mulaifatanalkayyisa.class.getResource("/sounds/" + file);
    }
}
