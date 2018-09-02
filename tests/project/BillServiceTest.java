package project;

import static junit.framework.Assert.assertEquals;
import static org.mockito.ArgumentCaptor.forClass;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BillServiceTest {

	@Mock
	private BillEmailService billEmailService;

	private BillService billService;

	@Before
	public void setUp() {
		billService = new BillService(billEmailService);
	}

	@Test
	public void shouldSendBillByEmailWithNewQuantity() {
		Double valueExpectedAfterApplyTheRule = 110.0;

		Bill bill = new Bill();
		bill.setId(10);
		bill.setQuantity(100.0);
		bill.setNote("Some note");

		ArgumentCaptor<Bill> billcaptured = forClass(Bill.class);

		billService.process(bill);

		verify(billEmailService).sendBillByEmail(billcaptured.capture());

		assertEquals(valueExpectedAfterApplyTheRule, billcaptured.getValue().getQuantity());
	}

}
