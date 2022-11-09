package dataset;

import org.testng.annotations.DataProvider;

public class DataSet {

	@DataProvider(name = "data-provider")
	public Object[][] setData() {
		return new Object[][] { { 100000, 9.0, 2, 2.0, 4568, 9643, 2000, 109643 },
				{ 325000, 9.5, 5, 1.5, 6825, 84536, 4875, 409536 } };
	}
}
