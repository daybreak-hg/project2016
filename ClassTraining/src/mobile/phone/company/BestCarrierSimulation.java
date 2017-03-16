package mobile.phone.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import mobile.phone.company.carrier.AbstractBaseCarrier;
import mobile.phone.company.carrier.CarrierAu;
import mobile.phone.company.carrier.CarrierDocomo;
import mobile.phone.company.carrier.CarrierSoftbank;
import mobile.phone.company.dto.InputDataDTO;
import mobile.phone.company.dto.OutputDataDTO;

/**
 * 携帯電話料金シミュレーション
 */
public class BestCarrierSimulation {

	/** 携帯電話会社リスト */
	final List<AbstractBaseCarrier> carriers = Arrays.asList(new CarrierAu(), new CarrierDocomo(), new CarrierSoftbank());

	/**
	 * シミュレーション実行
	 * 
	 * @param dtoIn {@link InputDataDTO}
	 * @return シミュレーション結果
	 */
	public String execute(final InputDataDTO dtoIn) {
		final StringBuffer stringBuffer = new StringBuffer();

		final List<OutputDataDTO> outputs = new ArrayList<OutputDataDTO>();
		for (final AbstractBaseCarrier carrier : this.carriers) {
			final OutputDataDTO dtoOut = carrier.calclation(dtoIn);

			stringBuffer.append(String.format("携帯会社:%s\t", dtoOut.getCarrierName()));
			stringBuffer.append(String.format("基本料金:%d\t", dtoOut.getDiscountBasicPrice()));
			stringBuffer.append(String.format("通話料(分):%d\t", dtoOut.getCallPrice()));
			stringBuffer.append(String.format("1ヶ月分の使用料金:%d", dtoOut.getDiscountTotalAmount()));
			if (dtoOut.getRemarks() != null) {
				stringBuffer.append(System.lineSeparator());
				stringBuffer.append(String.format("\t%s", dtoOut.getRemarks()));
			}
			stringBuffer.append(System.lineSeparator());
			outputs.add(dtoOut);
		}

		/* 最良会社を算出する */
		OutputDataDTO bestCarrier = null;
		for (final OutputDataDTO dtoOut : outputs) {

			if (bestCarrier == null) {
				bestCarrier = dtoOut;
				continue;
			}

			if (dtoOut.getDiscountTotalAmount() > bestCarrier.getDiscountTotalAmount()) {
				continue;
			}
			bestCarrier = dtoOut;
		}
		stringBuffer.append(System.lineSeparator());
		stringBuffer.append(String.format("%sさんにお勧めの携帯会社名:%s", dtoIn.getName(), bestCarrier.getCarrierName()));

		return stringBuffer.toString();
	}
}
