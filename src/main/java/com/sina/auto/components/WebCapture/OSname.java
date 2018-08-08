package com.sina.auto.components.WebCapture;

import com.sina.auto.components.SystemInfo.OSinfo;

public class OSname {
    static String osname(){
        String OSname = "";
        OSinfo.EPlatform osname = OSinfo.getOSname();
        if(String.valueOf(osname).equals("Windows")){
            OSname =  "chromedriver/Windows/chromedriver.exe";
        }else if(String.valueOf(osname).equals("Linux")){
            OSname = "chromedriver/Linux/chromedriver";
        }else if(String.valueOf(osname).equals("Mac OS X")){
            OSname = "chromedriver/Mac/chromedriver";
        }
        return OSname;
    }
}
