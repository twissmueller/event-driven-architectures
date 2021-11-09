from kafka import KafkaConsumer
from json import loads

consumer = KafkaConsumer('timestamp',
                         value_deserializer=lambda x: loads(x.decode('utf-8')))

for message in consumer:
    print(message.value)
