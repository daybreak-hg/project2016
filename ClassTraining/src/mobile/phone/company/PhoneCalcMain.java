package mobile.phone.company;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import mobile.phone.company.dto.InputDataDTO;

public class PhoneCalcMain {

	/** HashMap Key */
	private static final List<String> KEYS = Arrays.asList("NAME", "AGE", "JOB", "CALL_TIME");

	/** Display Word */
	private static final Map<String, String> DISPLAY_WORD = new HashMap<String, String>() {

		/** serialVersionUID */
		private static final long serialVersionUID = 1L;

		{
			super.put("NAME", "名前");
			super.put("AGE", "年齢");
			super.put("JOB", "職業");
			super.put("CALL_TIME", "1か月の通話時間");
		}

	};

	public static void main(final String[] args) {

		Scanner scanner = null;
		try {
			/* プログラム実行前の情報入力 */
			scanner = new Scanner(System.in);

			System.out.println("■利用者情報を入力して下さい");
			final Map<String, String> map = new HashMap<String, String>();
			for (final String key : KEYS) {
				System.out.print(String.format("\t%s:", DISPLAY_WORD.get(key)));

				final String inputWord = scanner.next();
				map.put(key, inputWord);
			}
			System.out.println(System.lineSeparator());

			/* 入力データをDto変換 */
			final InputDataDTO dtoIn = new InputDataDTO();
			dtoIn.setName(map.get("NAME"));
			dtoIn.setAge(parse(map.get("AGE")).intValue());
			dtoIn.setJob(map.get("JOB"));
			dtoIn.setCallTime(parse(map.get("CALL_TIME")).intValue());

			final BestCarrierSimulation simulation = new BestCarrierSimulation();
			final String result = simulation.execute(dtoIn);
			System.out.println(result);
		} catch (final Throwable e) {
			if (scanner != null) {
				scanner.close();
			}
			scanner = null;
		}
	}

	/**
	 * 文字列から数値返還
	 * 
	 * @param s 文字列
	 * @return 数値
	 */
	protected static BigDecimal parse(final String s) {
		try {
			return new BigDecimal(s);
		} catch (final Throwable e) {
			System.out.println("数値以外が入力されたため0として見做します。");
			return BigDecimal.ZERO;
		}

	}
}
