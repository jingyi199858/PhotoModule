package com.sina.auto.components.WebCapture;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class ImageOutput {
    public static void main(String[] args) throws Exception {
        String url = "http://db.auto.sina.cn/car_manual/detail/236";
        BufferedImage web = CaptureWAP.CaptureFullPage(url,"2", false);
        BufferedImage bi = CaptureEdit.mergeImage(web, CaptureEdit.overlapImage(CreateDock.createDock("扫描二维码",web.getWidth(),400, CaptureEdit.checkRGB(web)), CreateQRcode.QRcode(url)));
        ImageIO.write(bi,"png",new File("C:/Users/Jing/Desktop/haha.png"));
    }
}
