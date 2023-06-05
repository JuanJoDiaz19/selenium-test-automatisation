package com.tallerconpatron.certificacion.colorlib.definition;

import com.tallerconpatron.certificacion.colorlib.step.TaskAction;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

import java.util.Date;

public class FormValidationDefinition {

    private String user;
    private String password;

    private String required;
    private int select;
    private int[] multipleSelect;
    private String url;
    private String email;
    private String passwordForm;
    private String confirmPassword;
    private String minField;
    private String maxField;

    private Double number;
    private String ip;
    private String date;
    private String dateEarlier;

    @Steps
    TaskAction taskAction;

    @Given("I enter with my credentials")
    public void iEnterWithMyCredentials(io.cucumber.datatable.DataTable dataTable) {
        this.user = dataTable.cell(1,0);
        this.password = dataTable.cell(1, 1);
    }

    @When("I proceed with the authentication")
    public void iProceedWithTheAuthentication() {
        try {
            taskAction.openPage();
            taskAction.singIn(user, password);
        }catch (NullPointerException e) {
            System.out.println("NullPointerException thrown!");
        }
    }

    @And("go to the main view of the page")
    public void goToTheMainViewOfThePage() {
        try {
            taskAction.checkTitleHomePage();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @And("enter the submenu form validation")
    public void enterTheSubmenuFormValidation() {
        taskAction.selectElementInMenu();
    }

    @And("check the title of the form on the screen")
    public void checkTheTitleOfTheFormOnTheScreen() {
        try {
            taskAction.checkTitleFormValidationPage();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @And("fill all the fields")
    public void fillAllTheFields(io.cucumber.datatable.DataTable dataTable) {
        this.required = dataTable.cell(1, 0);
        this.select = Integer.parseInt(dataTable.cell(1, 1));
        String tempMultipleSelect = dataTable.cell(1, 2);
        String[] stringArray = tempMultipleSelect.split(",");

        this.multipleSelect = new int[stringArray.length];
        for (int i =0; i < stringArray.length; i ++) {
            multipleSelect[i] = Integer.parseInt(stringArray[i]);
        }

        this.url = dataTable.cell(1, 3);
        this.email = dataTable.cell(1, 4);
        this.passwordForm = dataTable.cell(1, 5);
        this.confirmPassword = dataTable.cell(1, 6);
        this.minField = dataTable.cell(1, 7);
        this.maxField = dataTable.cell(1, 8);
        this.number = Double.parseDouble(dataTable.cell(1,9));
        this.ip = dataTable.cell(1,10);
        this.date = dataTable.cell(1,11);
        this.dateEarlier = dataTable.cell(1,12);

        taskAction.enterTheFormFields(required, select, multipleSelect, url, email, passwordForm, confirmPassword, minField, maxField, number, ip, date, dateEarlier);
    }

    @And("click button validate")
    public void clickButtonValidate() {
        taskAction.clickValidateButton();
    }

    @Then("field requiered will be empty")
    public void fieldRequieredWillBeEmpty() {
        taskAction.checkEmptyFields();
    }
}
