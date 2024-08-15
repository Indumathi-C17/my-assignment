package com.baseClass;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {

	public static WebDriver driver;

	protected static WebDriver browserLaunch(String name) {
        if (name.equalsIgnoreCase("Chrome")) {
            ChromeOptions option = new ChromeOptions();
            driver = new ChromeDriver(option);
        } else if (name.equalsIgnoreCase("FireFox")) {
            driver = new FirefoxDriver();
        } else if (name.equalsIgnoreCase("Edge")) {
            EdgeOptions option1 = new EdgeOptions();
            driver = new EdgeDriver(option1);
        } else {
            throw new IllegalArgumentException("Browser name not recognized. Please use Chrome, FireFox, or Edge.");
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        return driver;
    }
  
  protected void deleteCookies() {
  	
  	driver.manage().deleteAllCookies();
  }

  protected static void launchURL(String url) {
      try {
          driver.get(url);
      } catch (Exception e) {
          System.out.println("Error occurs in line number: 43");
          e.printStackTrace();
      }
  }

  protected static void clickTheElement(WebDriver driver, WebElement element) {
      try {
          new WebDriverWait(driver, Duration.ofSeconds(10))
              .until(ExpectedConditions.elementToBeClickable(element));
          element.click();
      } catch (Exception e) {
          e.printStackTrace();
      }
  }

  protected static void inputValues(WebElement element, String value) {
	  if (element != null) {
          element.clear(); 
          element.sendKeys(value); 
      } else {
          System.out.println("Element is not initialized.");
      }
  }
  
  protected static void deleteInput(WebDriver driver, WebElement element) {
  	
  	  try {
            new WebDriverWait(driver, Duration.ofSeconds(10))
             .until(ExpectedConditions.elementToBeClickable(element));
            element.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
  	
  }
  
  protected String getText(WebDriver driver, WebElement element) {
  	
  	try {
			return element.getText();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
  	
  	return null;    	
  }
  
  protected boolean isEnabled(WebDriver driver, WebElement element) {
  	
  	return element.isEnabled();
  }
  
  protected boolean isDisplayed(WebDriver driver, WebElement element) {
  	
  	return element.isDisplayed();
  }
  
protected boolean isSelected(WebDriver driver, WebElement element) {
  	
  	return element.isSelected();
  }
  

  
  protected static void screenShot(WebDriver driver, String filename) {
      try {
          File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
          File dest = new File("C:\\Users\\indum\\eclipse-workspace\\retirement-calculator-automation\\ScreenShot\\" + filename + ".png");
          FileHandler.copy(source, dest);
      } catch (IOException e) {
          e.printStackTrace();
      }
  }
  
  protected static void scroll(WebDriver driver, int x, int y) {
	    try {
	        ((JavascriptExecutor) driver).executeScript("window.scrollBy(" + x + ", " + y + ");");
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}


  protected void jsClick(WebDriver driver, WebElement element) {
  	
  	try {
			((JavascriptExecutor) driver)
			.executeScript("arguments[0].click();", element);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
  	
  }
  
protected void explicitWaitVisible(WebDriver driver, WebElement element) {
	  
	  try {
		new WebDriverWait(driver, Duration.ofSeconds(30))
		  .until(ExpectedConditions.visibilityOf(element));
	} catch (Exception e) {
		
		e.printStackTrace();
	}
}
  
protected void selectFromDropDown(WebDriver driver, WebElement element, String option, String value) {
	  
	  try {
		Select s = new Select(element);
		  if(option.equalsIgnoreCase("index")) {
			  s.selectByIndex(Integer.parseInt(value));
		  } else if (option.equalsIgnoreCase("value")) {
			  s.selectByValue(value);		 
		  } else if (option.equalsIgnoreCase("visibleText")) {
			  s.selectByVisibleText(value);
		  }
	} catch (NumberFormatException e) {
		
		e.printStackTrace();
	}
	  
}

protected void confirmAlert(WebDriver driver, WebElement element, String condition) {
	 
	  try {
		Alert confirm_alert = driver.switchTo().alert();
		  if(condition.equalsIgnoreCase("accept")) {	  
			  confirm_alert.accept();
		  } else if (condition.equalsIgnoreCase("dismiss")) {
			  confirm_alert.dismiss();
		  }
	} catch (Exception e) {
		
		e.printStackTrace();
	}
	  
}

protected void dragAndDrop(WebDriver driver, WebElement element, WebElement element1) {
	  
	  try {
		new Actions(driver).dragAndDrop(element, element1).perform();
	} catch (Exception e) {
		
		e.printStackTrace();
	}
	  
	  
}

protected void mouseHover(WebDriver driver, WebElement element) {
	  
	  try {
		new Actions(driver).moveToElement(element).perform();
	} catch (Exception e) {
		
		e.printStackTrace();
	}
}

protected void frameUsingName(WebDriver driver, String name) {
	  
	  try {
		driver.switchTo().frame(name);
	} catch (Exception e) {
		
		e.printStackTrace();
	}
}

protected void frameUsingElement(WebDriver driver, WebElement element) {
	  
	  try {
		driver.switchTo().frame(element);
	} catch (Exception e) {
		
		e.printStackTrace();
	}
}

protected void navigateTo(WebDriver driver, String url) {
	  
	  try {
		driver.navigate().to(url);
	} catch (Exception e) {
		
		e.printStackTrace();
	}
}

protected void previousPage(WebDriver driver) {
	  
	  try {
		driver.navigate().back();
	} catch (Exception e) {
		
		e.printStackTrace();
	}
}

protected void nextPage(WebDriver driver) {
	  
	  try {
		driver.navigate().forward();
	} catch (Exception e) {
		
		e.printStackTrace();
	}
}

protected void refreshPage(WebDriver driver, WebElement element) {
	 
	  try {
			driver.navigate().refresh();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
}


protected String getCurrentUrl(WebDriver driver) {
	 
	  try {
			return driver.getCurrentUrl();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	  
	  return null;
}   

protected String getTitle(WebDriver driver) {
	 
	  try {
			return driver.getTitle();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	  
	  return null;
	 
}
  
  protected static void closeTab(WebDriver driver) {
      driver.close();
  }

  protected void terminatebBrowser() {
  	
  	driver.quit();
  }

	
}
