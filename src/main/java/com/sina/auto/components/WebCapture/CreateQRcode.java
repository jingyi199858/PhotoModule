package com.sina.auto.components.WebCapture;

import java.awt.image.BufferedImage;

public class CreateQRcode {
    protected static BufferedImage QRcode(String url) throws Exception{
        BufferedImage bi = QRcodeUtil.encode(url);
        return bi;
    }

}
