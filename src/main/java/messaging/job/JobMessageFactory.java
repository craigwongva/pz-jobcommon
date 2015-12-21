package messaging.job;

import java.io.IOException;

import model.job.Job;
import model.request.PiazzaJobRequest;

import org.apache.kafka.clients.producer.ProducerRecord;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Factory class to abstract the production of Job-related Kafka messages using
 * this projects defined POJO Models.
 * 
 * @author Patrick.Doody
 * 
 */
public class JobMessageFactory {
	private static final String REQUEST_JOB_TOPIC_NAME = "Request-Job";
	private static final String CREATE_JOB_TOPIC_NAME = "Create-Job";

	/**
	 * Creates a Kafka message for a Piazza Job to be created. This Topic is
	 * listened to solely by the Dispatcher and acts as a simple pass-through
	 * from the outer world to the internal Piazza components.
	 * 
	 * @param piazzaRequest
	 *            The Job to be created.
	 * @param jobId
	 *            The ID of the Job
	 * @return Kafka message
	 * @throws JsonProcessingException
	 *             The PiazzaJob cannot be serialized to JSON.
	 */
	public static ProducerRecord<String, String> getRequestJobMessage(PiazzaJobRequest piazzaRequest, String jobId)
			throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		return new ProducerRecord<String, String>(REQUEST_JOB_TOPIC_NAME, jobId,
				mapper.writeValueAsString(piazzaRequest));
	}

	/**
	 * Creates a Kafka message for a Piazza Job to be created. This Topic is
	 * designed to be consumed by internal Piazza components that will handle
	 * the processing of such a job. The JobManager will also track this message
	 * and use it to commit the job transaction record into the Job Tables.
	 * 
	 * @param job
	 *            The Job to be created.
	 * @return Kafka message
	 * @throws JsonProcessingException
	 *             The PiazzaJob cannot be serialized to JSON.
	 */
	public static ProducerRecord<String, String> getCreateJobMessage(Job job) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		return new ProducerRecord<String, String>(CREATE_JOB_TOPIC_NAME, job.getJobId(), mapper.writeValueAsString(job));
	}

	/**
	 * Parses the raw JSON Payload into the PiazzaRest backing models. No value
	 * validation done here, only syntax.
	 * 
	 * @param json
	 *            JSON Payload from POST RequestBody
	 * @return PiazzaRequest object for the JSON Payload.
	 * @throws Exception
	 */
	public static PiazzaJobRequest parseRequestJson(String json) throws IOException, JsonParseException,
			JsonMappingException {
		PiazzaJobRequest request = new ObjectMapper().readValue(json, PiazzaJobRequest.class);
		return request;
	}
}
