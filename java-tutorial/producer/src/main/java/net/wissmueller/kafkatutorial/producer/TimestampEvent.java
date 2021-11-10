package net.wissmueller.kafkatutorial.producer;

import java.time.ZonedDateTime;

public class TimestampEvent {
  private ZonedDateTime timestamp;

  public TimestampEvent(ZonedDateTime timestamp) {
    this.timestamp = timestamp;
  }

  public ZonedDateTime getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(ZonedDateTime timestamp) {
    this.timestamp = timestamp;
  }
}
