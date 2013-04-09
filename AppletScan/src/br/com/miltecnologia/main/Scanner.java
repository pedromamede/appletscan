/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.miltecnologia.main;

import com.asprise.util.jtwain.Source;
import com.asprise.util.jtwain.SourceManager;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 *
 * @author admin
 */
public class Scanner {

    private BufferedImage imagemScanneada;
    
    public void scanear() {
        try {
            Source source = SourceManager.instance().selectSourceUI();
            source.open();
            imagemScanneada = source.acquireImageAsBufferedImage();
            salvarImagemNoDisco();
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
    
    public BufferedImage getImagemScanneada(){
        return imagemScanneada;
    }
}
