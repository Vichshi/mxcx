package com.orange.sh.quartz.model;

import java.sql.Blob;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Calendars {

	private String schedName;
	private String calendarName;
	private Blob calendar;
}
