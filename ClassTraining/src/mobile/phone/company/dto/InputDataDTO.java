package mobile.phone.company.dto;

/**
 * 携帯電話料金シミュレーション入力データクラス
 */
public class InputDataDTO {

	/** 名前 */
	private String name;

	/** 年齢 */
	private int age;

	/** 職業 */
	private String job;

	/** 1か月の通話時間(単位:分) */
	private int callTime;

	/** 名前 */
	public String getName() {
		return name;
	}

	/** 名前 */
	public void setName(String name) {
		this.name = name;
	}

	/** 年齢 */
	public int getAge() {
		return age;
	}

	/** 年齢 */
	public void setAge(int age) {
		this.age = age;
	}

	/** 職業 */
	public String getJob() {
		return job;
	}

	/** 職業 */
	public void setJob(String job) {
		this.job = job;
	}

	/** 1か月の通話時間(単位:分) */
	public int getCallTime() {
		return callTime;
	}

	/** 1か月の通話時間(単位:分) */
	public void setCallTime(int callTime) {
		this.callTime = callTime;
	}

}
