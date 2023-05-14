package com.hormigo.david.parkingmanager.bdd.steps;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.hormigo.david.parkingmanager.bdd.CucumberConfiguration;
import com.hormigo.david.parkingmanager.user.service.UserService;

import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;

@CucumberContextConfiguration
public class CucumberSteps extends CucumberConfiguration {

	@MockBean
	private UserService userService;
	@Value("${local.server.port}")
	private  int port;
	private static ChromeDriver driver;
	@BeforeAll
	public static void prepareWebDriver() {

			System.setProperty("webdriver.chrome.driver","C:\\ChromeDriver\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options);
			
	}

	//  Usuarios creados

	@Given("un usuario esta en la pagina inicial")
	public void openHome1() {
			driver.get("http://localhost:" + port + "/");


	}

	@When("el usuario hace click sobre el botón de Usuarios")
	public void clickUserButton2(){
			driver.findElement(By.id("to-users-link")).click();

	}

	@Then("se muestran todos los usuarios del sistema")
	public void navigateToUsersList2(){
			String currentUrl = driver.getCurrentUrl();
			assertTrue(currentUrl.contains("/users"));
	}

	//  Pagina Home

	@Given("un usuario esta en la pagina home")
	public void showHomePage(){
			driver.get("http://localhost:" + port + "/");
	}
	@Then("se muestra el titulo con un h1")
	public void showH1(){
			WebElement title = driver.findElement(By.id("home-title"));
	}
	@Then("se muestra el boton Sorteos")
	public void showDrawButton(){
			WebElement drawButton = driver.findElement(By.id("to-draws-link"));
			assertNotNull(drawButton);
	}
	@Then("se muestra el boton Usuarios")
	public void showUserButton(){
			WebElement userButton = driver.findElement(By.id("to-users-link"));
			assertNotNull(userButton);
	}

	//	Pagina User

	@Given("un usuario esta en la pagina users")
	public void userPage(){
			driver.get("http://localhost:" + port + "/users");
	}
	@Then("se muestra el titulo de users")
	public void showTitle(){
			WebElement userTitle=driver.findElement(By.id("users-title"));
			
	}
	@Then("se muestra el boton de crear usuario")
	public void showCreateUserButton(){
			WebElement createUserButton=driver.findElement(By.id("users-button-create"));
			assertNotNull(createUserButton);
	}
	@Then("se muestra la tabla de users")
	public void showTable(){
			WebElement userTable=driver.findElement(By.id("user-table"));
			
	}

	//	Pagina sorteo

	@Given("un usuario esta en la pagina sorteos")
    public void drawPage(){
        driver.get("http://localhost:" + port + "/draws");
    }
    @Then("se muestra el titulo")
    public void showDrawTitle(){
        WebElement drawTitle=driver.findElement(By.id("draws-title"));
        
    }
    @Then("se muestra el boton de crear sorteo")
    public void showCreateDrawButton(){
        WebElement createDrawButton=driver.findElement(By.id("draws-button-create"));
        assertNotNull(createDrawButton);
    }
    @Then("se muestra la tabla")
    public void showDrawTable(){
        WebElement drawTable =driver.findElement(By.id("draw-list-table"));
        
    }

		//Navegacion Home a Users

    @Given("un usuario esta en la pagina inicial")
    public void openHome() {
        driver.get("http://localhost:" + port + "/");
    }
    @When("el usuario hace click sobre el botón de Usuarios")
    public void clickUserButton(){
        driver.findElement(By.id("to-users-link")).click();
    }
    @Then("se muestran todos los usuarios del sistema")
    public void navigateToUsersList(){
        String currentUrl = driver.getCurrentUrl();
        assertTrue(currentUrl.contains("/users"));
    }


		//	Navegación Home a Draw


    @Given("un usuario esta en la pagina inicial")
    public void openHometoDraw() {
        driver.get("http://localhost:" + port + "/");
    }
    @When("el usuario hace click sobre el botón de Sorteo")
    public void clickDrawButton(){
        driver.findElement(By.id("to-draws-link")).click();
    }
    @Then("se muestran todos los sorteos del sistema")
    public void navigateToDrawList(){
        String currentUrl = driver.getCurrentUrl();
        assertTrue(currentUrl.contains("/draws"));
    }

	
}
