package manufacture.common;

import io.cucumber.spring.CucumberContextConfiguration;
import manufacture.StoreApplication;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { StoreApplication.class })
public class CucumberSpingConfiguration {}
