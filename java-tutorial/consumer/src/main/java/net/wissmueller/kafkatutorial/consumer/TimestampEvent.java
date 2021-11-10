package net.wissmueller.kafkatutorial.consumer;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TimestampEvent {
  private String timestamp;

  public TimestampEvent() {

  }

  public String getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(String timestamp) {
    this.timestamp = timestamp;
  }
}
