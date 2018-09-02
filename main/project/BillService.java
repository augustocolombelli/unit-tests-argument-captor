package project;

public class BillService {
	private BillEmailService billEmailService;

	public BillService(BillEmailService billEmailService) {
		this.billEmailService = billEmailService;
	}

	public void process(Bill bill) {
		Double newVale = applySomeRuleToCalcNewQuantity(bill.getQuantity());

		bill.setQuantity(newVale);

		billEmailService.sendBillByEmail(bill);
	}

	private Double applySomeRuleToCalcNewQuantity(Double quantity) {
		return quantity + (quantity * 0.1);
	}

}
