package com.kiki.autotest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.junit.jupiter.api.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class First {

    private IOSDriver iosDriver;

    @BeforeAll
    public void initDriver() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "IOS");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone");
        desiredCapabilities.setCapability("bundleId", "cc.pelly.iflow");
        desiredCapabilities.setCapability("noReset","True");
        desiredCapabilities.setCapability("udid","9c35410072089084117814143c0abd6ae3fd056c");
//        desiredCapabilities.setCapability(MobileCapabilityType.APP, "/Users/NEO/Library/Developer/Xcode/DerivedData/WebDriverAgent-hgctewdoodlffqfntrworqjqsugx/Build/Products/Debug-iphonesimulator/Pelly.app");

        URL url = null;
        try {
            url = new URL("http://127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException e) {

            e.printStackTrace();
        }

        iosDriver = new IOSDriver(url, desiredCapabilities);

    }

    @Test
    public void login() {
        String sessionId = iosDriver.getSessionId().toString();

        System.out.println(sessionId);
//        //左滑动屏幕
//        telPa = self.driver.get_window_size();
//        self.width = telPa["width"];
//        self.height = telPa["height"];
//        TouchAction taction=new TouchAction(iosDriver);
//        taction.press(313,430).waitAction(200).moveTo(60,430).release().perform();
        iosDriver.findElementByAccessibilityId("我的").click();
        String phonenumxpath="//XCUIElementTypeApplication[@name='IFLOW']/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeTextField";
        String Phonenum="18512391083";
        iosDriver.findElementByXPath(phonenumxpath).clear();
        iosDriver.findElementByXPath(phonenumxpath).sendKeys(Phonenum);
        String pwdxpath="//XCUIElementTypeApplication[@name='IFLOW']/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeSecureTextField";
        String pwd="123456";
        iosDriver.findElementByXPath(pwdxpath).sendKeys(pwd);
        iosDriver.findElementByAccessibilityId("立即登录").click();
        iosDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        iosDriver.findElementByAccessibilityId("商城").click();
        iosDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        MobileElement el1 = (MobileElement) iosDriver.findElementByAccessibilityId("  输入搜索的商品名称");
        el1.click();
        MobileElement el2 = (MobileElement) iosDriver.findElementByXPath("//XCUIElementTypeApplication[@name=\"IFLOW\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeTextField");
        el2.sendKeys("可可测试");
        MobileElement el3 = (MobileElement) iosDriver.findElementByAccessibilityId("Search");
        el3.click();
        MobileElement el4 = (MobileElement) iosDriver.findElementByXPath("//XCUIElementTypeApplication[@name=\"IFLOW\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell");
        el4.click();
        iosDriver.findElementByAccessibilityId("立即购买").click();
        iosDriver.findElementByAccessibilityId("确定").click();
        iosDriver.findElementByAccessibilityId("提交订单").click();
        iosDriver.findElementByAccessibilityId("确认提交").click();
        iosDriver.findElementByAccessibilityId("立即支付").click();
        iosDriver.findElementByXPath("//XCUIElementTypeApplication[@name='IFLOW']/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeAlert/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther").sendKeys(pwd);
        iosDriver.findElementByAccessibilityId("确定").click();
        try {
                    iosDriver.findElementByAccessibilityId("hb icon guanbi") .click();
        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }

}
