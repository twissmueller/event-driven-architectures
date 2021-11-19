package net.wissmueller.kafkatutorial.consumer;

import java.time.ZonedDateTime;

public class TimestampEvent {
  private ZonedDateTime timestamp;

  public TimestampEvent() {}

  public ZonedDateTime getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(ZonedDateTime timestamp) {
    this.timestamp = timestamp;
  }
}
