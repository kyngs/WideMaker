package cz.kyngs.widemaker.core;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class WideCore {

    public static BufferedImage wideImg(BufferedImage source){

        BufferedImage target = new BufferedImage(source.getWidth()*3 , source.getHeight(), BufferedImage.TYPE_INT_RGB);

        Graphics2D graphics = source.createGraphics();

        graphics.drawImage(target, 0, 0, target.getWidth(), target.getHeight(), null);

        return target;

    }

    public static BufferedImage wideImgFromFile(File source) throws IOException {
        return wideImg(ImageIO.read(source));
    }

    public static void wideImgFromFileToFile(File source, File target) throws IOException {
        ImageIO.write(wideImgFromFile(source), "PNG", target);
    }


}
