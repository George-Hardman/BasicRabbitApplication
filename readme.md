## Basic Spring RabbitMQ Application

A demonstration of 3 queues, a Direct Exchange to each Queue and a Fanout to All the Queues.

### Running Rabbit
RabbitMQ needs to be running.
This can be done using:
```bash
docker run -d -p 5672:5672 -p 15672:15672 --name my-rabbit rabbitmq:3-management
```

