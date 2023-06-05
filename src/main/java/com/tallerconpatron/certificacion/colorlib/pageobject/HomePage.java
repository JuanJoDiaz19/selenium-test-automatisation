package com.tallerconpatron.certificacion.colorlib.pageobject;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageObject {
    @FindBy(xpath = "//*[@id=\"bootstrap-admin-template\"]")
    public WebElementFacade title;
    @FindBy(xpath = "//*[@id=\"menu\"]/li[6]/a")
    public WebElementFacade item;
    @FindBy(xpath = "//*[@id=\"menu\"]/li[6]/ul/li[2]/a")
    public WebElementFacade Element;
}
