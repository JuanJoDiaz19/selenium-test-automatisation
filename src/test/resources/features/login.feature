#Autor: Juan Jose Diaz

  @HistoriaDeUsuario
  Feature: Verify the validation form
    Me as user WANT to enter the colorlib page TO verify the validation form

  Scenario Outline: Verify the validation form
    Given I enter with my credentials
    | User | Password |
    | <User> | <Password> |
    When I proceed with the authentication
    And go to the main view of the page
    And enter the submenu form validation
    And check the title of the form on the screen
    And fill all the fields
      | Required | Select | MultipleSelect | Url | Email | PasswordForm | ConfirmPassword | MinField | MaxField | Number | IP| Date | Date Earlier |
      | <Required> | <Select> | <MultipleSelect> | <Url> | <Email> | <PasswordForm> | <ConfirmPassword> | <MinField> | <MaxField> | <Number> | <IP> | <Date> | <Date Earlier> |
    And click button validate
    Then field requiered will be empty

    Examples:
      | User | Password | Required             | Select | MultipleSelect | Url| Email            | PasswordForm            | ConfirmPassword | MinField | MaxField | Number     | IP           | Date       | Date Earlier |
      | admin | admin   | Universidad Icesi   | 2      |1,3| http://google.com| juan@u.icesi.edu.com |123456|123456|Automatizacion de pruebas        | Ing     | 3.14159265 | 192.168.1.8 | 2023-05-05 | 2012-9-12     |





