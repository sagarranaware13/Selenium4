# Selenium4

Selenium 4:  Features 

1: Selenium Relative locators:
•	above(): Element will be located above with respect to the specified element.
•	below(): Element will be located below with respect to the specified element.
•	toLeftOf(): Element will be located to the left of the specified element.
•	toRightOf(): Element will be located to the right of the specified element.

Example: 
WebElement regLink=driver.findElement(By.xpath("//a[text()='REGISTER']"));
driver.findElement(withTagName("td").above(regLink));

2: Invoking multiple windows/tabs in selenium using single driver instance 
•	User will able to open multiple tabs in single browser using one webdriver instance .
driver.switchTo().newWindow(WindowType.TAB);

•	User will able to open multiple windows using one webdriver instance .
driver.switchTo().newWindow(WindowType.WINDOW);

3: Take web element screenshot, here we can take partial screen shot.
Example:
WebElement name=driver.findElement(By.xpath("//input[@name='name']"));
File file=name.getScreenshotAs(OutputType.FILE);

4: Get height and width of web element using selenium 
Example:
element.getRect().getDimension().getHeight());
element.getRect().getDimension().getWidth());
