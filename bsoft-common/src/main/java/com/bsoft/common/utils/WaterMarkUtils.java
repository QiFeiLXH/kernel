package com.bsoft.common.utils;

import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.pdf.*;
import org.apache.commons.lang3.StringUtils;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Xuhui Lin
 * @Date 2020/7/10 10:37
 * @Description 文件工具类
 */
public class WaterMarkUtils {
    private static int interval = -5;

    public static byte[] setWaterMark(byte[] input, String fileName, String waterMarkName) {
        List<String> imageTypes = Arrays.asList("jpg", "jpeg", "bmp", "png", "gif", "tif");
        // 判断文件类型
        String fileType = getFileType(fileName);
        // 文件为pdf或者图片则加水印
        if (fileType.equals("pdf")) {
            return setFileWaterMark(input, waterMarkName);
        } else if (imageTypes.contains(fileType)) {
            return setImageWaterMark(input, waterMarkName, fileType);
        } else {
            return input;
        }
    }

    /**
     * 将pdf文件中添加水印
     *
     * @return byte[] 输出带有水印的字节码
     * @Param: input 传入的文件字节码
     * @Param: waterMarkName 选择显示的水印内容
     * @author Xuhui Lin
     */
    public static byte[] setFileWaterMark(byte[] input, String waterMarkName) {
        // 输出字节流
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        BufferedOutputStream bos = new BufferedOutputStream(baos);
        try {
            PdfReader reader = new PdfReader(input);
            PdfStamper stamper = new PdfStamper(reader, bos);
            Map<String, Object> fileWaterMarkData = getFileWaterMarkBaseData(reader, waterMarkName);
            Integer textH = (Integer) fileWaterMarkData.get("textH");
            Integer textW = (Integer) fileWaterMarkData.get("textW");
            PdfGState gs = (PdfGState) fileWaterMarkData.get("gs");

            PdfContentByte under;
             BaseFont base = BaseFont.createFont("Helvetica-Bold", "Cp1252", BaseFont.EMBEDDED);
            // 以下解决中文不显示问题
//             BaseFont base = BaseFont.createFont("STSong-Light","UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);// 使用系统字体
            com.lowagie.text.Rectangle pageRect = null;
            int total = reader.getNumberOfPages() + 1;
            for (int i = 1; i < total; i++) {
                pageRect = reader.getPageSizeWithRotation(i);
                under = stamper.getOverContent(i);
                under.saveState();
                under.setGState(gs);
                under.beginText();
                under.setFontAndSize(base, 52);

                 setFileWaterMarkAngle(pageRect, textH, textW, waterMarkName, under);
                 // setFileWaterMarkAngleWithCenter(pageRect, textH, textW, waterMarkName, under);
                // 添加水印文字
                under.endText();
            }
            stamper.close();
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return baos.toByteArray();
    }

    /**
     * 将图片文件中添加文本水印
     *
     * @return byte[] 输出带有水印的字节码
     * @Param: input 传入的文件字节码
     * @Param: waterMarkName 选择显示的水印内容
     * @Param: imgType 图片格式
     * @author Xuhui Lin
     */
    public static byte[] setImageWaterMark(byte[] input, String waterMarkName, String imgType) {
        ByteArrayInputStream bais = new ByteArrayInputStream(input);// 输入字节流
        BufferedInputStream bis = new BufferedInputStream(bais);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();// 输出字节流
        BufferedOutputStream bos = new BufferedOutputStream(baos);

        try {
            BufferedImage img = ImageIO.read(bis);
            Map<String, Object> baseData = getImageWaterMarkBaseData(img, waterMarkName);
            Integer waterMarkWidth = (Integer) baseData.get("waterMarkWidth");
            Integer rowsNumber = (Integer) baseData.get("rowsNumber");
            Integer columnsNumber = (Integer) baseData.get("columnsNumber");
            Graphics2D graphics = (Graphics2D) baseData.get("graphics");
            BufferedImage bufImg = (BufferedImage) baseData.get("bufImg");
            //防止图片太小而文字水印太长，所以至少打印一次
            if (rowsNumber < 1) {
                rowsNumber = 1;
            }
            if (columnsNumber < 1) {
                columnsNumber = 1;
            }
            for (int j = 0; j < rowsNumber; j++) {
                for (int i = 0; i < columnsNumber; i++) {
                    graphics.drawString(waterMarkName, i * waterMarkWidth + j * waterMarkWidth, -i * waterMarkWidth + j * waterMarkWidth);//画出水印,并设置水印位置
                }
            }
            graphics.dispose();// 释放资源
            // 输出图片
            ImageIO.write(bufImg, imgType, bos);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return baos.toByteArray();
    }

    /**
     * 根据传入的文件名称获取获取文件后缀文件类型
     */
    public static String getFileType(String fileName) {
        if (StringUtils.isNotBlank(fileName)) {
            String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
            return suffix;
        } else {
            return "";
        }
    }

    /**
     * 获取文件水印的基础数据
     */
    private static Map<String, Object> getFileWaterMarkBaseData(PdfReader reader, String waterMarkName) throws IOException, DocumentException {
        PdfGState gs = new PdfGState();
        gs.setFillOpacity(0.03f);
        gs.setStrokeOpacity(0.9f);

        JLabel label = new JLabel();
        FontMetrics metrics;
        int textH = 0;
        int textW = 0;
        label.setText(waterMarkName);
        metrics = label.getFontMetrics(label.getFont());
        textH = metrics.getHeight();
        textW = metrics.stringWidth(label.getText());
        Map<String, Object> fileWaterMarkData = new HashMap<>();
        fileWaterMarkData.put("textH", textH);
        fileWaterMarkData.put("textW", textW);
        fileWaterMarkData.put("gs", gs);
        return fileWaterMarkData;
    }

    private static Map<String, Object> getImageWaterMarkBaseData(BufferedImage img, String waterMarkName){
        int imgW = img.getWidth(null);//获取图片的宽
        int imgH = img.getHeight(null);//获取图片的高
        Font font = new Font("Helvetica-Bold", Font.BOLD, 50);//水印字体，大小

        Color markContentColor = Color.BLACK;//水印颜色
        Integer degree = -30;//设置水印文字的旋转角度
        float alpha = 0.03f;//设置水印透明度 默认为1.0  值越小颜色越浅
        // 加水印
        BufferedImage bufImg = new BufferedImage(imgW, imgH, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = bufImg.createGraphics();//得到画笔
        graphics.drawImage(img, 0, 0, imgW, imgH, null);
        graphics.setColor(markContentColor); //设置水印颜色
        graphics.setFont(font);              //设置字体
        graphics.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));//设置水印文字透明度
        if (null != degree) {
            graphics.rotate(Math.toRadians(degree), (double) bufImg.getWidth(), (double) bufImg.getHeight());//设置水印旋转
        }
        JLabel label = new JLabel(waterMarkName);
        FontMetrics metrics = label.getFontMetrics(font);
        int waterMarkWidth = metrics.stringWidth(label.getText());//文字水印的宽
        int rowsNumber = imgH / waterMarkWidth + imgH % waterMarkWidth;// 图片的高  除以  文字水印的宽  打印的行数(以文字水印的宽为间隔)
        int columnsNumber = imgW / waterMarkWidth + imgW % waterMarkWidth;//图片的宽 除以 文字水印的宽  每行打印的列数(以文字水印的宽为间隔)

        Map<String, Object> baseData = new HashMap<>();
        baseData.put("waterMarkWidth", waterMarkWidth); // 文字水印宽度
        baseData.put("rowsNumber", rowsNumber); // 行数
        baseData.put("columnsNumber", columnsNumber); // 列数
        baseData.put("bufImg", bufImg); // 输出图片
        baseData.put("graphics", graphics); // 画笔工具
        return baseData;
    }

    /**
     * 设置文件文字水印的角度
     */
    private static void setFileWaterMarkAngle(com.lowagie.text.Rectangle pageRect, int textH, int textW, String waterMarkName, PdfContentByte under) {
        // 水印文字成30度角倾斜
        //可以自行修改水印倾斜角度
        for (int height = interval + textH; height < pageRect.getHeight(); height = height + textH * 6) {
            for (int width = interval + textW; width < pageRect.getWidth() + textW; width = width + textW * 4) {
                under.showTextAligned(1, waterMarkName, width - textW, height - textH, 30);
            }
        }
    }

    /**
     * 设置文件文字水印的角度，每页居中显示一个水印
     */
    private static void setFileWaterMarkAngleWithCenter(com.lowagie.text.Rectangle pageRect, int textH, int textW, String waterMarkName, PdfContentByte under) {
        // 水印文字成30度角倾斜
        //可以自行修改水印倾斜角度
        float x = pageRect.getWidth() / 2;
        float y = pageRect.getHeight() / 2;
        under.showTextAligned(Element.ALIGN_CENTER, waterMarkName, x,y, 30);

    }
}
