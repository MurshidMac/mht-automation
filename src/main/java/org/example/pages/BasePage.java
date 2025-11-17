package org.example.pages;

import org.example.core.UserActions;
import org.openqa.selenium.WebDriver;

/**
 * Base class for all Page Objects.
 * Provides driver + common actions for reuse.
 */
public abstract class BasePage {

    protected WebDriver driver;
    protected UserActions actions;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.actions = new UserActions(driver);
    }
}