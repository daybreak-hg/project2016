package mobile.phone.company.carrier;

import mobile.phone.company.dto.InputDataDTO;

public class CarrierDocomo extends AbstractBaseCarrier {
	
	/**
	 * キャリア名称を設定する
	 */
	@Override
	protected String setCarrierName() {
		return "NTT docomo";
	}
	
	/**
	 * 基本料金を設定する
	 */
	@Override
	protected int setBasicPrice() {
		return 1500;
	}

	/**
	 * 通話料(分)を設定する
	 */
	@Override
	protected int setCallPrice() {
		return 22;
	}

	/**
	 * 割引対象者判定
	 */
	@Override
	protected boolean isDiscount(final InputDataDTO dtoIn) {
		return dtoIn.getAge() < 10;
	}

	/**
	 * 割引後基本料金を設定する
	 */
	@Override
	protected int setDiscountBasicPrice(final InputDataDTO dtoIn) {
		return 0;
	}

	/**
	 * 割引後通話料金(1ヶ月分)を設定する
	 */
	@Override
	protected int setDiscountCallAmount(final InputDataDTO dtoIn) {
		return super.setCallAmount(dtoIn);
	}

	/**
	 * 割引適用文言を設定する
	 */
	@Override
	protected String setRemarks() {
		return "コドモダケ割引(年齢が10歳未満は基本料無料)";
	}
}
