package mobile.phone.company.carrier;

import mobile.phone.company.dto.InputDataDTO;

public class CarrierSoftbank extends AbstractBaseCarrier {
	
	/**
	 * キャリア名称を設定する
	 */
	@Override
	protected String setCarrierName() {
		return "Softbank";
	}
	
	/**
	 * 基本料金を設定する
	 */
	@Override
	protected int setBasicPrice() {
		return 980;
	}

	/**
	 * 通話料(分)を設定する
	 */
	@Override
	protected int setCallPrice() {
		return 36;
	}

	/**
	 * 割引対象者判定
	 */
	@Override
	protected boolean isDiscount(final InputDataDTO dtoIn) {
		return dtoIn.getCallTime() >= 180;
	}

	/**
	 * 割引後基本料金を設定する
	 */
	@Override
	protected int setDiscountBasicPrice(final InputDataDTO dtoIn) {
		return 2000;
	}

	/**
	 * 割引後通話料金(1ヶ月分)を設定する
	 */
	@Override
	protected int setDiscountCallAmount(final InputDataDTO dtoIn) {
		return setCallPrice() * 180;
	}

	/**
	 * 割引適用文言を設定する
	 */
	@Override
	protected String setRemarks() {
		return "通話時間が3時間以上なら基本料金が2000円となり、3時間を越えた分の通話料はかからない";
	}
}
