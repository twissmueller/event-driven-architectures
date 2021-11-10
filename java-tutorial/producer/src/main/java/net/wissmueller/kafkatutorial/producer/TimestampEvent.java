package net.wissmueller.kafkatutorial.producer;

public class TimestampEvent {
  private String timestamp;

  public TimestampEvent(String timestamp) {
    this.timestamp = timestamp;
  }

  public String getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(String timestamp) {
    this.timestamp = timestamp;
  }
}
