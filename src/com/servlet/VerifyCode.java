package com.servlet;

import com.sun.glass.ui.Accessible;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/vc")
public class VerifyCode extends HttpServlet {
    private static final int HEIGHT=30;
    private static final int WIDTH=120;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        setBackground(g);
        setBorder(g);
        drawRandomLine(g);

        String code= drawRandomNum((Graphics2D)g);
        request.getSession().setAttribute("verifyCode",code);
        response.setDateHeader("expries",-1);
        response.setHeader("Cache-Control","no-cache");
        response.setHeader("Pragma","no-cache");

        response.setContentType("image/jpeg");//输出格式
        ImageIO.write(image,"jpg",response.getOutputStream());
        //图片输出,这里只能用输出流

    }

    private String drawRandomNum(Graphics2D g) {
        g.setColor(Color.BLUE);
        g.setFont(new Font("宋体",Font.BOLD,20));
        //String base="\u7684\u4e00\u4e86\u662f\u6211\u4e0d\u5728\u4eba\u4eec";//可以用数字代替
        String base="1234567890abcdefgABCDEFG";
        int x=5;
        StringBuffer sb=new StringBuffer();//StringBuffer变长，String固定长度
        for(int i=0;i<4;i++){
            String ch = base.charAt(new Random().nextInt(base.length())) + "";
            sb.append(ch);
            int degree=new Random().nextInt()%30;//得到-30到30
            g.rotate(degree*Math.PI/180,x,20);
            g.drawString(ch,x,20);//y的坐标不变化
            g.rotate(-degree*Math.PI/180,x,20);//!理解
            x+=30;
            //如何让字体旋转之类 g.rotate(degree*Math.PI/180,x,20);
            // 但是只有这一句所有的都一起旋转，要那两句才可以每个字都偏移
            //如何让字体不只是朝一个方向旋转 int degree=new Random().nextInt()%30;
        }
        return sb.toString();
    }

    private void drawRandomLine(Graphics g) {
        g.setColor(new Color(new Random().nextInt(255),new Random().nextInt(255),new Random().nextInt(255)));
        for(int i=1;i<=10;i++){
            int x1=new Random().nextInt(WIDTH);
            int y1=new Random().nextInt(HEIGHT);
            int x2=new Random().nextInt(WIDTH);
            int y2=new Random().nextInt(HEIGHT);
            g.drawLine(x1,y1,x2,y2);
        }
    }

    private void setBorder(Graphics g) {
        g.setColor(Color.RED);
        g.drawRect(0,0,WIDTH-2,HEIGHT-2);
    }

    private void setBackground(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0,0,WIDTH,HEIGHT);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
