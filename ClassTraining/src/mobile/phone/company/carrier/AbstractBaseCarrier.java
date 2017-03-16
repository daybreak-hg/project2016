package mobile.phone.company.carrier;

import mobile.phone.company.dto.InputDataDTO;
import mobile.phone.company.dto.OutputDataDTO;

/**
 * 携帯電話会社共通基底クラス
 */
public abstract class AbstractBaseCarrier {

	/** 割引対象判定 */
	private boolean isDiscount = false;

	/**
	 * 料金計算処理
	 * 
	 * @param dtoIn 利用者情報
	 * @return 料金計算結果
	 */
	public OutputDataDTO calclation(final InputDataDTO dtoIn) {
		final OutputDataDTO dtoOut = new OutputDataDTO();
		dtoOut.setName(dtoIn.getName());
		dtoOut.setAge(dtoIn.getAge());
		dtoOut.setJob(dtoIn.getJob());
		dtoOut.setCallTime(dtoIn.getCallTime());

		dtoOut.setCarrierName(setCarrierName());
		dtoOut.setBasicPrice(setBasicPrice());
		dtoOut.setCallPrice(setCallPrice());
		dtoOut.setCallAmount(setCallAmount(dtoIn));
		dtoOut.setTotalAmount(setTotalAmount(dtoIn));
		
		// 割引適用者の場合割引専用の計算方法を使用
		this.isDiscount = isDiscount(dtoIn);
		if (this.isDiscount) {
			dtoOut.setDiscountBasicPrice(setDiscountBasicPrice(dtoIn));
			dtoOut.setDiscountCallAmount(setDiscountCallAmount(dtoIn));
			dtoOut.setDiscountTotalAmount(setDiscountTotalAmount(dtoIn));
			dtoOut.setRemarks(setRemarks());
			return dtoOut;
		}
		
		// 
		dtoOut.setDiscountBasicPrice(dtoOut.getBasicPrice());
		dtoOut.setDiscountCallAmount(dtoOut.getCallAmount());
		dtoOut.setDiscountTotalAmount(dtoOut.getTotalAmount());
		return dtoOut;
	}

	/** キャリア名称を設定する */
	protected abstract String setCarrierName();

	/** 基本料金を設定する */
	protected abstract int setBasicPrice();

	/** 通話料を設定する */
	protected abstract int setCallPrice();

	/**
	 * 通話料金(1ヶ月分)を設定する
	 */
	protected int setCallAmount(final InputDataDTO dtoIn) {
		return setCallPrice() * dtoIn.getCallTime();
	}

	/** 利用料金を設定する */
	private int setTotalAmount(final InputDataDTO dtoIn) {
		return setCallAmount(dtoIn) + setBasicPrice();
	}

	/** 割引対象者判定 */
	protected abstract boolean isDiscount(final InputDataDTO dtoIn);

	/** 割引後基本料金を設定する */
	protected abstract int setDiscountBasicPrice(final InputDataDTO dtoIn);

	/** 割引後通話料金(1ヶ月分)を設定する */
	protected abstract int setDiscountCallAmount(final InputDataDTO dtoIn);

	/** 割引後利用料金を設定する */
	private int setDiscountTotalAmount(final InputDataDTO dtoIn) {
		return setDiscountBasicPrice(dtoIn) + setDiscountCallAmount(dtoIn);
	}

	/** 割引適用文言を設定する */
	protected abstract String setRemarks();
}
