package testrunner;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import dataset.DataSet;
import screens.EMICalcScreen;
import setup.Setup;

public class CalculateTestRunner extends Setup {

	EMICalcScreen calcScreen;

	@BeforeTest
	public void startEMICalculator() {
		calcScreen = new EMICalcScreen(driver);
		calcScreen.btnStart.click();
	}

	@Test(dataProvider = "data-provider", dataProviderClass = DataSet.class)
	public void calculateEMI(int loanAmount, double rInterest, int period, double pFee, int mEMI, int tInterest,
			int tpFee, int tPayment) throws InterruptedException {

		calcScreen = new EMICalcScreen(driver);
		calcScreen.calculateEMI(loanAmount, rInterest, period, pFee);

		String monthlyEMI = calcScreen.mEMI.getText();
		String totalInterest = calcScreen.tInterest.getText();
		String totalProcessingFee = calcScreen.tpFee.getText();
		String totalPayment = calcScreen.tPayment.getText();

		monthlyEMI = String.valueOf((int) Math.floor(Double.parseDouble(monthlyEMI.replace(",", ""))));
		totalInterest = String.valueOf((int) Math.floor(Double.parseDouble(totalInterest.replace(",", ""))));
		totalProcessingFee = String.valueOf((int) Math.floor(Double.parseDouble(totalProcessingFee.replace(",", ""))));
		totalPayment = String.valueOf((int) Math.floor(Double.parseDouble(totalPayment.replace(",", ""))));

		Assert.assertEquals(monthlyEMI, String.valueOf(mEMI));
		Assert.assertEquals(totalInterest, String.valueOf(tInterest));
		Assert.assertEquals(totalProcessingFee, String.valueOf(tpFee));
		Assert.assertEquals(totalPayment, String.valueOf(tPayment));

		Thread.sleep(3000);
		calcScreen.btnReset.click();
		Thread.sleep(2000);
	}

}
