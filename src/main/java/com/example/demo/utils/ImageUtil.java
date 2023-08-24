package com.example.demo.utils;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Random;

/**
 * @author ：楼兰
 * @date ：Created in 2021/1/19
 * @description:
 **/

public class ImageUtil {

    private String str ;// 验证码
    private ByteArrayInputStream image ;//验证码图片

    private int width = 350; //图片宽度
    private int height = 46; //图片高度

    private ImageUtil(){
        init();
    }

    public static ImageUtil getInstance(){
        return new ImageUtil();
    };

    private void init(){
        this.str= "";

        final BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        final Graphics g = image.getGraphics();

        Random random = new Random();

        g.setColor(getRandColor(200,250));
        g.fillRect(0,0,width,height);

        g.setFont(new Font("Times New Roman",Font.PLAIN,20));

        g.setColor(getRandColor(160,200));
        for(int i = 0 ; i < 150 ; i ++){
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int x1 = random.nextInt(50);
            int y1 = random.nextInt(50);
            g.drawLine(x,y,x+x1,y+y1);
        }

//        for(int i = 0 ; i < 6 ; i ++){
//            final String rand = String.valueOf(random.nextInt(10));
//            this.str += rand;
//            g.setColor(getRandColor(20,110));
//            g.drawString(rand,(width / 6)*i,46);
//        }

        int num1 = random.nextInt(10);
        int num2 = random.nextInt(10);
        g.setColor(getRandColor(20,110));
        g.drawString(String.valueOf(num1),(width/5)*0+6,36);
        g.drawString("+",(width/5)*1+6,36);
        g.drawString(String.valueOf(num2),(width/5)*2+6,36);
        g.drawString("=",(width/5)*3+6,36);
        g.drawString("?",(width/5)*4+6,36);

        this.str = String.valueOf(num1+num2);

        g.dispose();
        ByteArrayInputStream inputStream = null;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try{
            final ImageOutputStream imageOut = ImageIO.createImageOutputStream(outputStream);
            ImageIO.write(image,"JPEG",imageOut);
            imageOut.close();
            inputStream = new ByteArrayInputStream(outputStream.toByteArray());
        }catch (Exception e){
            System.out.println("验证码图片生成失败："+e);
        }
        this.image = inputStream;
    }

    private Color getRandColor(int fc, int bc) {
        Random random  = new Random();
        if(fc > 255) { fc = 255;}
        if(bc > 255) { bc = 255;}
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r,g,b);
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public ByteArrayInputStream getImage() {
        return image;
    }

    public void setImage(ByteArrayInputStream image) {
        this.image = image;
    }
}
