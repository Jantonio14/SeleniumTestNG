package com.demoqa.pages;

import com.ecommerce.pages.BasePage;
import org.openqa.selenium.By;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;

public class FilePage extends BasePage {

    private By fileUploadBtn = By.name("fileToUpload");
    private By submitFileBtn = By.name("submit");

    public void uploadFile() throws IOException {
        Path tempFile = Files.createTempFile("tempfiles", ".tmp");
        String filename = tempFile.toAbsolutePath().toString();
        find(fileUploadBtn).sendKeys(filename);
        click(submitFileBtn);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }
}
