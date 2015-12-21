package model.job.type;

import model.job.PiazzaJobType;

public class AbortJob implements PiazzaJobType {
	public String jobId = null;
	public final String type = "abort";
	public String reason;
	
	public AbortJob() {

	}

	public AbortJob(String jobId) {
		this.jobId = jobId;
	}

	public String getType() {
		return type;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

}
