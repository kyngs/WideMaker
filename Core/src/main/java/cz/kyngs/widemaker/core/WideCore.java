package cz.kyngs.widemaker.core;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class WideCore {

    public static BufferedImage wideImg(BufferedImage source){

        BufferedImage target = new BufferedImage(source.getWidth()*4 , source.getHeight(), BufferedImage.TYPE_INT_ARGB);

        Graphics graphics = target.getGraphics();

        graphics.drawImage(source, 0, 0, target.getWidth(), target.getHeight(), null);

        return target;

    }

    public static BufferedImage wideImgFromFile(File source) throws IOException {
        return wideImg(ImageIO.read(source));
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    public static void wideImgFromFileToFile(File source, File target) throws IOException {
        if (target.exists()) target.delete();
        target.createNewFile();
        ImageIO.write(wideImgFromFile(source), "PNG", target);
    }


}
