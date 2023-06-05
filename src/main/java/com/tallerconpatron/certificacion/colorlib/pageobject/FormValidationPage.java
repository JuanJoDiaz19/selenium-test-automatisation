package com.tallerconpatron.certificacion.colorlib.pageobject;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class FormValidationPage extends PageObject {

    @FindBy(xpath = "//*[@id=\"content\"]/div/div/div[1]/div/div/header/h5")
    public WebElementFacade title;
    @FindBy(xpath = "//*[@id=\"req\"]")
    public WebElementFacade required;

    @FindBy(xpath = "//*[@id=\"sport\"]")
    public WebElementFacade select;

    @FindBy(xpath = "//*[@id=\"sport2\"]")
    public WebElementFacade multipleSelect;

    @FindBy(xpath = "//*[@id=\"url1\"]")
    public WebElementFacade url;

    @FindBy(xpath = "//*[@id=\"email1\"]")
    public WebElementFacade email;

    @FindBy(xpath = "//*[@id=\"pass1\"]")
    public WebElementFacade password;

    @FindBy(xpath = "//*[@id=\"pass2\"]")
    public WebElementFacade confirmPassword;

    @FindBy(xpath = "//*[@id=\"minsize1\"]")
    public WebElementFacade minField;

    @FindBy(xpath = "//*[@id=\"maxsize1\"]")
    public WebElementFacade maxField;

    @FindBy(xpath = "//*[@id=\"number2\"]")
    public WebElementFacade number;

    @FindBy(xpath = "//*[@id=\"ip\"]")
    public WebElementFacade IP;

    @FindBy(xpath = "//*[@id=\"date3\"]")
    public WebElementFacade date;

    @FindBy(xpath = "//*[@id=\"past\"]")
    public WebElementFacade dateEarlier;

    @FindBy(xpath = "//*[@id=\"popup-validation\"]/div[14]/input")
    public WebElementFacade validateButton;
}
