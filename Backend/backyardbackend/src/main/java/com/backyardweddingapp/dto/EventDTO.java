package com.backyardweddingapp.dto;

import java.time.LocalDate;

public class EventDTO {
	
  private Integer eventId;
  private String eventName;
  private LocalDate eventDate;

  // being used for adding events.
  private Integer backyardId;

  // -----------------------------------------------------------------------------------------------------------

  public Integer getEventId() {
    return eventId;
  }
  public void setEventId(Integer eventId) {
    this.eventId = eventId;
  }
  public String getEventName() {
    return eventName;
  }
  public void setEventName(String eventName) {
    this.eventName = eventName;
  }
  public LocalDate getEventDate() {
    return eventDate;
  }
  public void setEventDate(LocalDate eventDate) {
    this.eventDate = eventDate;
  }
  public Integer getBackyardId() {
    return backyardId;
  }
  public void setBackyardId(Integer backyardId) {
    this.backyardId = backyardId;
  }
}
