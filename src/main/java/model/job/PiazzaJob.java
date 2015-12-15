package model.job;

import model.job.type.AbortJob;
import model.job.type.GetJob;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({ @Type(value = GetJob.class, name = "get"), @Type(value = AbortJob.class, name = "abort") })
public interface PiazzaJob {
	public String getType();

	public String getJobId();
}
