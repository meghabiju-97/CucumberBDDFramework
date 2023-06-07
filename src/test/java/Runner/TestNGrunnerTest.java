package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;


@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber.html","summary"},
        snippets = CucumberOptions.SnippetType.CAMELCASE,
       // dryRun = false,
        glue = {"awesomecucumber"},
        features ="src/test/resources/awesomecucumber"
        //tags = "@feature1"

)
public class TestNGrunnerTest extends AbstractTestNGCucumberTests {
@Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

}
