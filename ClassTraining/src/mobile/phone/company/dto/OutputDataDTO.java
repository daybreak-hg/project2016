package mobile.phone.company.dto;

/**
 * 携帯電話料金シミュレーション入力データクラス
 */
public class OutputDataDTO extends InputDataDTO {
	
	/** キャリア名称 */
	private String carrierName;

	/** 基本料金 */
	private int basicPrice;

	/** 通話料(分) */
	private int callPrice;

	/** 通話料金(1ヶ月分) */
	private int callAmount;

	/** 利用料金 */
	private int totalAmount;

	/** 割引後基本料金 */
	private int discountBasicPrice;

	/** 割引後通話料金(1ヶ月分) */
	private int discountCallAmount;

	/** 割引後利用料金 */
	private int discountTotalAmount;
	
	/** 割引適用文言 */
	private String remarks;
	
	/** キャリア名称 */
	public String getCarrierName() {
		return carrierName;
	}

	/** キャリア名称 */
	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
	}

	/** 基本料金 */
	public int getBasicPrice() {
		return basicPrice;
	}

	/** 基本料金 */
	public void setBasicPrice(int basicPrice) {
		this.basicPrice = basicPrice;
	}

	/** 通話料(分) */
	public int getCallPrice() {
		return callPrice;
	}

	/** 通話料(分) */
	public void setCallPrice(int callPrice) {
		this.callPrice = callPrice;
	}

	/** 通話料金(1ヶ月分) */
	public int getCallAmount() {
		return callAmount;
	}

	/** 通話料金(1ヶ月分) */
	public void setCallAmount(int callAmount) {
		this.callAmount = callAmount;
	}

	/** 利用料金 */
	public int getTotalAmount() {
		return totalAmount;
	}

	/** 利用料金 */
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	/** 割引後基本料金 */
	public int getDiscountBasicPrice() {
		return discountBasicPrice;
	}

	/** 割引後基本料金 */
	public void setDiscountBasicPrice(int discountBasicPrice) {
		this.discountBasicPrice = discountBasicPrice;
	}

	/** 割引後通話料金(1ヶ月分) */
	public int getDiscountCallAmount() {
		return discountCallAmount;
	}

	/** 割引後通話料金(1ヶ月分) */
	public void setDiscountCallAmount(int discountCallAmount) {
		this.discountCallAmount = discountCallAmount;
	}

	/** 割引後利用料金 */
	public int getDiscountTotalAmount() {
		return discountTotalAmount;
	}

	/** 割引後利用料金 */
	public void setDiscountTotalAmount(int discountTotalAmount) {
		this.discountTotalAmount = discountTotalAmount;
	}

	/** 割引適用文言 */
	public String getRemarks() {
		return remarks;
	}

	/** 割引適用文言 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}
