package jp.shoko.web.refer.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ReferPageOutputDto implements Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	/** recNo */
	private BigDecimal recNo;

	/** userName */
	private String userName;

	/** updateDate */
	private Date updateDate;

	public BigDecimal getRecNo() {
		return recNo;
	}

	public void setRecNo(BigDecimal recNo) {
		this.recNo = recNo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

}
