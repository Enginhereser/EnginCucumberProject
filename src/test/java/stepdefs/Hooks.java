package stepdefs;

import Driver.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void befor(){
        Driver.getDriver();

    }

    @After
    public void after() {
        Driver.quitDriver();

    }
}
