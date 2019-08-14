package com.example.demo.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.data.mongodb.core.mapping.Document;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
@Document(collection = "coach_data")
public class CoachNew implements Serializable {
	private static final long serialVersionUID = 641755134642426840L;

	@Id
	private Long id;

	private String dataScopeKey;

	private String sn;

	private Account userAssignTo;

	private String assignToName;

	private String hrId;

	private String employeeName;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss", timezone = "America/New_York")
	private Calendar createdTime;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "yyyy/MM/dd", timezone = "America/New_York")
	private Calendar deadline;

	private String title;
	private String description;
	private CoachStatus status;
	private String type;
	private String displayName;

	private Integer classification;

	private String callRecordingNumber;

	private String kpiJsonStr;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "yyyy/MM/dd", timezone = "America/New_York")
	private Calendar completedTime;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "yyyy/MM/dd", timezone = "America/New_York")
	private Calendar acknowledgeTime;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "yyyy/MM/dd", timezone = "America/New_York")
	private Calendar cancelTime;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "yyyy/MM/dd", timezone = "America/New_York")
	private Calendar ongoingTime;

	private Float satisfaction;

	@Temporal(TemporalType.DATE)
	private Date startDate;

	private Map<String, Object> coachDetail;

}
