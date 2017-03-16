package mobile.phone.company.carrier;

import mobile.phone.company.dto.InputDataDTO;

public class CarrierAu extends AbstractBaseCarrier {

	/**
	 * キャリア名称を設定する
	 */
	@Override
	protected String setCarrierName() {
		return "Au by KDDI";
	}
	
	/**
	 * 基本料金を設定する
	 */
	@Override
	protected int setBasicPrice() {
		return 1300;
	}

	/**
	 * 通話料(分)を設定する
	 */
	@Override
	protected int setCallPrice() {
		return 25;
	}

	/**
	 * 割引対象者判定
	 */
	@Override
	protected boolean isDiscount(final InputDataDTO dtoIn) {
		return dtoIn.getJob().indexOf("学生") >= 0 || dtoIn.getJob().indexOf("高校生") >= 0;
	}

	/**
	 * 割引後基本料金を設定する
	 */
	@Override
	protected int setDiscountBasicPrice(final InputDataDTO dtoIn) {
		return setBasicPrice() - 500;
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
		return "学生割引(学生は基本料500円割引)";
	}
}
