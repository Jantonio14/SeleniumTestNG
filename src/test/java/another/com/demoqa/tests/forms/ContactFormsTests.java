package another.com.demoqa.tests.forms;

import another.com.demoqa.base.BaseTest;
import org.testng.annotations.Test;

public class ContactFormsTests extends BaseTest {

    @Test
    public void resetContactForms() {
        homePage.clickOnContactForms();
        contactFormPage.setFirstNameField("Tester");
        contactFormPage.setLastNameField("One");
        contactFormPage.setEmailField("testingmail@mail.com");
        contactFormPage.setCommentField("Testing comments");
        contactFormPage.resetAllFields();
        contactFormPage.verifyEmptyFields();
    }

    @Test
    public void submitContactForms() {
        homePage.clickOnContactForms();
        contactFormPage.fillAllFields("test", "test", "test@mail.com", "NA");
        contactFormPage.clickSubmitBtn();
        submitFormsPage.verifySuccessMessage();
    }


    @Test
    public void submitInvalidForms() {
        homePage.clickOnContactForms();
        contactFormPage.fillAllFields("", "", "", "");
        contactFormPage.clickSubmitBtn();
        submitFormsPage.verifyFailureMessage();
    }
}
