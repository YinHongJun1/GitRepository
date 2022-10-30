package com.yhj.test;

import org.junit.Test;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

import static junit.framework.TestCase.assertNotNull;

public class ImageTest {
    @Test
    public void test(){
        try {
            BufferedImage image = ImageIO.read(new File("E:\\IDEA【马士兵说】\\IDEAWorkspaces\\tank-master\\tank\\src\\images\\0.gif"));
            assertNotNull(image);
            BufferedImage images = ImageIO.read(ImageTest.class.getClassLoader().getResourceAsStream("images/bulletD.gif"));
            assertNotNull(images);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
