/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.miltecnologia.main;

import com.asprise.util.jtwain.Source;
import com.asprise.util.jtwain.SourceManager;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.apache.commons.codec.binary.Base64;

/**
 *
 * @author admin
 */
public class Scanner {

    private BufferedImage imagemScanneada;
    
    public void scanear() {
        try {
            Source source = SourceManager.instance().getDefaultSource();
            source.open();
            imagemScanneada = source.acquireImageAsBufferedImage();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            SourceManager.closeSourceManager();
        }
    }

    public void salvarImagemNoDisco() {
        try {
            File outputfile = new File("C://imagemScannerTeste.png");
            ImageIO.write(imagemScanneada, "png", outputfile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Encode image to string
     * @param image The image to encode
     * @param type jpeg, bmp, ...
     * @return encoded string
     */
    public String encodeToString(BufferedImage image, String type) {
        String imageString = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        try {
            ImageIO.write(image, type, bos);
            byte[] imageBytes = bos.toByteArray();

            imageString = Base64.encodeBase64String(imageBytes);
            //BASE64Encoder encoder = new BASE64Encoder();
            //imageString = encoder.encode(imageBytes);

            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageString;
    }
    
    public BufferedImage getImagemScanneada(){
        return imagemScanneada;
    }
}
