from kafka import KafkaProducer
from datetime import datetime
from json import dumps
from time import sleep

producer = KafkaProducer(bootstrap_servers='localhost:9092',
                         value_serializer=lambda x: dumps(x).encode('utf-8'))
while True:
    timestampStr = datetime.now().strftime("%H:%M:%S")
    print("Sending: " + timestampStr)
    producer.send('timestamp', timestampStr)
    sleep(5)
