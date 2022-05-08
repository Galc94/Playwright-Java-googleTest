import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue={"Steps", "cucumberHooks"},
        features = "src/test/resources/features",
        plugin = { "pretty", "html:target/cucumber.html",
                "json:target/cucumber.json"},
        tags = "@Smoke"
)
public class CucumberTestRunner {
}