import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.llm.keyword.LlmKeywords as LLM
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

String url = 'https://www.saucedemo.com/'
String username = 'standard_user'
String password = 'secret_sauce'
String Firstname = 'Kautsar'
String Lastname = 'QA'
String Codeposs = '025'

WebUI.openBrowser('')
WebUI.navigateToUrl(url)

WebUI.setText(findTestObject('Object Repository/page_login/input_Swag Labs_user-name'), username)
WebUI.setText(findTestObject('Object Repository/page_login/input_Swag Labs_password'), password)

WebUI.click(findTestObject('Object Repository/page_login/input_Swag Labs_login-button'))

WebUI.verifyElementPresent(findTestObject('Object Repository/page_login/span_Products'), 5)
boolean loginSuccess = WebUI.verifyElementVisible(findTestObject('Object Repository/page_login/span_Products'), FailureHandling.OPTIONAL)

if(loginSuccess) {
	println('Login test passed')
} else {
	println('Login test failed')
}

WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_product/select_Name (A to Z)Name (Z to A)Price (low to high)Price (high to low)'), 'Price (low to high)', false)

WebUI.click(findTestObject('Object Repository/Page_product/button_Add to cart'))
WebUI.click(findTestObject('Object Repository/Page_product/a_Swag Labs_shopping_cart_link'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_product/span_Your Cart'), 5)
boolean incartsuccess = WebUI.verifyElementVisible(findTestObject('Object Repository/Page_product/span_Your Cart'), FailureHandling.OPTIONAL)

if(incartsuccess) {
	println('Add to cart test passed')
} else {
	println('Add to cart test failed')
}

WebUI.click(findTestObject('Object Repository/Page_checkout/button_Checkout'))

WebUI.setText(findTestObject('Object Repository/Page_checkout/input_Checkout Your Information_first-name'), Firstname)
WebUI.setText(findTestObject('Object Repository/Page_checkout/input_Checkout Your Information_last-name'), Lastname)
WebUI.setText(findTestObject('Object Repository/Page_checkout/input_Checkout Your Information_postal-code'), Codeposs)
WebUI.click(findTestObject('Object Repository/Page_checkout/input_Cancel_continue'))

WebUI.click(findTestObject('Object Repository/Page_checkout/button_Finish'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_checkout/h2_Thank you for your order'), 5)
boolean ordersuccess = WebUI.verifyElementVisible(findTestObject('Object Repository/Page_checkout/h2_Thank you for your order'), FailureHandling.OPTIONAL)

if(ordersuccess) {
	println('Checkout test passed')
} else {
	println('Checkout test failed')
}

WebUI.closeBrowser()