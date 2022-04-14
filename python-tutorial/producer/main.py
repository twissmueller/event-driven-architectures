import json
from kafka import KafkaProducer
from datetime import datetime
from time import sleep

from TimestampEvent import TimestampEvent

producer = KafkaProducer(bootstrap_servers='localhost:9092', value_serializer=lambda x: json.dumps(x.__dict__).encode('utf-8'))

while True:
    timestampEvent = TimestampEvent(datetime.now().strftime("%H:%M:%S"))
    print("Sending: " + timestampEvent.timestamp)
    producer.send('timestamp', timestampEvent)
    sleep(5)
