package CreateNewAddress;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.core.options.Constants.FEATURES_PROPERTY_NAME;
import static io.cucumber.core.options.Constants.PLUGIN_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectPackages("Zadanie1")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "html:out.html")
@ConfigurationParameter(key = FEATURES_PROPERTY_NAME, value = "src/Cucumber/Features")

public class CreateNewAddressTest {
}
