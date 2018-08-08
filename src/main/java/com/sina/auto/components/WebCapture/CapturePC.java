package com.sina.auto.components.WebCapture;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.concurrent.TimeUnit;
import static com.sina.auto.components.WebCapture.OSname.osname;
import static com.sina.auto.components.WebCapture.ScrollWindow.scroll;

public class CapturePC {
    static String chromeDriver = osname();


    //将整个页面截取出
    public static BufferedImage CaptureFullPage(String url, String zoom,boolean setHeadless) throws Exception {
        int width = 640;
        Double zoomfactor = Double.parseDouble(zoom);
        //配置chromedriver和chrome的路径
        System.setProperty("webdriver.chrome.driver",chromeDriver);//chromedriver服务地址

        //配置ChromeDriver启动参数，关闭Chrome自动化提示
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("useAutomationExtension", false);
        options.addArguments("disable-infobars");
        //options.setHeadless(setHeadless);

        //创建ChromeDriverEx对象，ChromeDriverEx对ChromeDriver进行扩展。
        ChromeDriverEx driver = new ChromeDriverEx(options);

        //打开网页
        driver.get(url);
        scroll(driver);
        //生成图片
        File file = driver.getFullScreenshotAs(OutputType.FILE);
        BufferedImage bi = ImageIO.read(file);
        driver.quit();
        return bi;
    }

    //截取首屏
    public static BufferedImage CaptureCurrentPage (String url, String zoom, boolean setHeadless) throws Exception{
        int width = 640;
        Double zoomfactor = Double.parseDouble(zoom);
        System.setProperty("webdriver.chrome.driver",chromeDriver);//chromedriver服务地址
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("useAutomationExtension", false);
        options.addArguments("disable-infobars");
        options.setHeadless(setHeadless);

        ChromeDriver driver = new ChromeDriver(options);

        driver.manage().window().setSize(new Dimension(700, 600));

        driver.manage().timeouts().pageLoadTimeout(3,TimeUnit.SECONDS);
        driver.get(url);

        File file = driver.getScreenshotAs(OutputType.FILE);
        BufferedImage bi = ImageIO.read(file);
        driver.quit();
        return bi;
    }

    //截取页面指定区域
    public static BufferedImage CapturePartialPage (String url, String zoom, String cropheight, boolean setHeadless) throws Exception{
        Double zoomfactor = Double.parseDouble(zoom);
        System.setProperty("webdriver.chrome.driver",chromeDriver);//chromedriver服务地址

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("useAutomationExtension", false);
        options.addArguments("disable-infobars");
        options.setHeadless(setHeadless);

        ChromeDriverEx driver = new ChromeDriverEx(options);

        driver.manage().window().setSize(new Dimension(700, 600));

        driver.manage().timeouts().pageLoadTimeout(3,TimeUnit.SECONDS);
        driver.get(url);

        File file = driver.getPartialScreenshotAs(OutputType.FILE, "640",cropheight);
        BufferedImage bi = ImageIO.read(file);
        driver.quit();
        return bi;
    }

}
