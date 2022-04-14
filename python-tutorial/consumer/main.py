from kafka import KafkaConsumer
import json

from TimestampEvent import TimestampEvent

consumer = KafkaConsumer('timestamp', bootstrap_servers='localhost:9092', value_deserializer=lambda x: json.loads(x.decode('utf-8')))

for message in consumer:
    timestampEvent = TimestampEvent(**(message.value))
    print("Received: " + timestampEvent.timestamp)
