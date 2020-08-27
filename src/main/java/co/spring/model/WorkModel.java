package co.spring.model;

import java.util.Date;

import co.spring.constant.Constant;

public class WorkModel {

	private int WorkId;
	
	private String WorkName;
	
	private Date StartDate;
	
	private Date EndDate;
	
	private int Status;
	
	private String StatusDisplay;

	public String getStatusDisplay() {
		switch (this.Status) {
		case 1:
			StatusDisplay = Constant.Doing;
			break;
		case 2:
			StatusDisplay = Constant.Complete;
			break;
		default:
			StatusDisplay = Constant.Planning;
			break;
		}
		return StatusDisplay;
	}

	public void setStatusDisplay(String statusDisplay) {
		StatusDisplay = statusDisplay;
	}

	public int getWorkId() {
		return WorkId;
	}

	public void setWorkId(int workId) {
		WorkId = workId;
	}

	public String getWorkName() {
		return WorkName;
	}

	public void setWorkName(String workName) {
		WorkName = workName;
	}

	public Date getStartDate() {
		return StartDate;
	}

	public void setStartDate(Date startDate) {
		StartDate = startDate;
	}

	public Date getEndDate() {
		return EndDate;
	}

	public void setEndDate(Date endDate) {
		EndDate = endDate;
	}

	public int getStatus() {
		return Status;
	}

	public void setStatus(int status) {
		Status = status;
	}	

	public WorkModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public WorkModel(int workId, String workName, Date startDate, Date endDate, int status, String statusDisplay) {
		super();
		WorkId = workId;
		WorkName = workName;
		StartDate = startDate;
		EndDate = endDate;
		Status = status;
		StatusDisplay = statusDisplay;
	}
	
}
