package com.tallerconpatron.certificacion.colorlib.step;

import com.tallerconpatron.certificacion.colorlib.common.BasePage;
import com.tallerconpatron.certificacion.colorlib.pageobject.FormValidationPage;
import com.tallerconpatron.certificacion.colorlib.pageobject.HomePage;
import com.tallerconpatron.certificacion.colorlib.pageobject.PaginaLogin;
import net.thucydides.core.annotations.Step;

public class TaskAction extends BasePage {
    private PaginaLogin paginaLogin;
    private HomePage homePage;
    private FormValidationPage formValidationPage;

    @Step
    public void openPage() {
        openApp();
    }

    @Step
    public void singIn(String strUser, String strPassword) {
        sendKeyUser(strUser);
        sendKeysPassword(strPassword);
        paginaLogin.btnSingIn.click();
    }

    public void sendKeyUser(String strUser) {
        paginaLogin.user.click();
        paginaLogin.user.clear();
        paginaLogin.user.sendKeys(strUser);
    }

    public void sendKeysPassword(String strPassword) {
        paginaLogin.password.click();
        paginaLogin.password.clear();
        paginaLogin.password.sendKeys(strPassword);
    }

    public void checkTitleHomePage() throws Exception {
        String titleHomePage = homePage.title.getText();
        //System.out.println(titleHomePage);
        if (titleHomePage.compareTo("Bootstrap-Template") !=  0) {
            throw new Exception("Title not equal to expected");
        }
    }
    public void selectElementInMenu(){
        homePage.item.click();
        homePage.Element.click();
    }

    public void checkTitleFormValidationPage() throws Exception {
        String titleFormValidationPage = formValidationPage.title.getText();
        //System.out.println(titleFormValidationPage);
        if(titleFormValidationPage.compareTo("Popup Validation") != 0) {
            throw new Exception("Title not equal to expected");
        }
    }

    public void enterTheFormFields(String required, int select, int[] options, String url, String email, String password, String confirmPassword, String minField, String maxField, Double number, String ip, String date, String dateEarlier) {
        sendKeyRequired(required);
        selectOptionSport(select);
        selectMultipleOptionSport(options);
        sendKeyUrl(url);
        sendKeyEmail(email);
        sendKeyPassword(password);
        sendKeyConfirmPassword(confirmPassword);
        sendKeMinField(minField);
        sendKeyMaxField(maxField);
        sendKeyNumber(number);
        sendKeyIp(ip);
        sendDate(date);
        sendDateEarlier(dateEarlier);
    }


    public void sendKeyRequired(String strRequired) {
        formValidationPage.required.click();
        formValidationPage.required.clear();
        formValidationPage.required.sendKeys(strRequired);
    }

    public void selectOptionSport(int option) {
        formValidationPage.select.selectByIndex(option);
    }

    public void selectMultipleOptionSport(int[] options) {
        formValidationPage.multipleSelect.selectByIndex(options[0]);
        formValidationPage.multipleSelect.selectByIndex(options[1]);
    }

    public void sendKeyUrl(String url) {
        formValidationPage.url.clear();
        formValidationPage.url.sendKeys(url);
    }

    public void sendKeyEmail(String email) {
        formValidationPage.email.clear();
        formValidationPage.email.sendKeys(email);
    }

    public void sendKeyPassword(String password) {
        formValidationPage.password.clear();
        //System.out.println("." + password + ".");
        formValidationPage.password.sendKeys(password);
    }

    public void sendKeyConfirmPassword(String confirmPassword) {
        formValidationPage.confirmPassword.clear();
        //System.out.println("." + confirmPassword + ".");
        formValidationPage.confirmPassword.sendKeys(confirmPassword);
    }

    public void sendKeMinField(String minField) {
        formValidationPage.minField.clear();
        formValidationPage.minField.sendKeys(minField);
    }

    public void sendKeyMaxField(String maxField) {
        formValidationPage.maxField.clear();
        formValidationPage.maxField.sendKeys(maxField);
    }

    public void sendKeyNumber(Double number) {
        formValidationPage.number.clear();
        formValidationPage.number.sendKeys(number.toString());
    }

    public void sendKeyIp(String ip) {
        formValidationPage.IP.clear();
        formValidationPage.IP.sendKeys(ip);
    }

    public void sendDate(String date) {
        formValidationPage.date.clear();
        formValidationPage.date.sendKeys(date);
    }


    public void sendDateEarlier(String dateEarlier) {
        formValidationPage.dateEarlier.clear();
        formValidationPage.dateEarlier.sendKeys(dateEarlier);
    }

    public void clickValidateButton() {
        formValidationPage.validateButton.click();
    }

    public void checkEmptyFields(){
        if(!formValidationPage.required.getText().equals("")) {
            throw new RuntimeException("Fields not empty after submission");
        }

        if (formValidationPage.select.isSelected()) {
            throw new RuntimeException("Fields not empty after submission");
        }

        if(formValidationPage.multipleSelect.isSelected()) {
            throw new RuntimeException("Fields not empty after submission");
        }
        if (formValidationPage.url.getText().equals("http://")) {
            throw new RuntimeException("Fields not empty after submission");
        }

        if (!formValidationPage.email.getText().equals("")) {
            throw new RuntimeException("Fields not empty after submission");
        }

        if (!formValidationPage.password.getText().equals("")) {
            throw new RuntimeException("Fields not empty after submission");
        }

        if (!formValidationPage.confirmPassword.getText().equals("")) {
            throw new RuntimeException("Fields not empty after submission");
        }

        if (!formValidationPage.minField.getText().equals("")) {
            throw new RuntimeException("Fields not empty after submission");
        }

        if (!formValidationPage.maxField.getValue().equals("0123456789")) {
            throw new RuntimeException("Fields not empty after submission");
        }

        if (formValidationPage.IP.getValue().compareTo("192.168.3.") !=0) {
            throw new RuntimeException("Fields not empty after submission");
        }
        if (formValidationPage.date.getValue().compareTo("201-12-01") !=0) {
            throw new RuntimeException("Fields not empty after submission");
        }
        if (formValidationPage.dateEarlier.getValue().compareTo("2012/12/16") !=0) {
            throw new RuntimeException("Fields not empty after submission");
        }
    }

}
