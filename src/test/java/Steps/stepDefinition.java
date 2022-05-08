package Steps;

import interfaces.googleMain;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import driverSetup.driver;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class stepDefinition {

    @Given("El usuario accede al buscador google")
    public void elUsuarioAccedeAlBuscadorGoogle() {
            driver.page.navigate("https://google.com.co");
            System.out.println(driver.page.title());
    }

    @And("El usuario digita la palabra clave {string}")
    public void elUsuarioDigitaLaPalabraClave(String arg0) {
            driver.page.locator(googleMain.searchBar).fill(arg0);
    }

    @When("El usuario presiona el boton Buscar")
    public void elUsuarioPresionaElBotonBuscar() {
            driver.page.locator(googleMain.searchBar).press("Enter");
    }

    @Then("En el title del navegador aparece la palabra clave")
    public void enElTitleDelNavegadorApareceLaPalabraClave() {
            assertThat(driver.page).hasTitle("Vanessa - Buscar con Google");
    }
}
