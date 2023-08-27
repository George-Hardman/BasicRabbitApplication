## Basic Spring RabbitMQ Application

A demonstration of 3 queues, a Direct Exchange to each Queue and a Fanout to All the Queues.

### Running Rabbit
RabbitMQ needs to be running.
This can be done using:
```bash
docker run -d -p 5672:5672 -p 15672:15672 --name my-rabbit rabbitmq:3-management
```

When the application is run, an endpoint is set on http://localhost:8080/

To send to a Direct Queue, use the endpoint:
http://localhost:8080/direct?key={k1/k2/k3}&message={message}

To send a fanout, use the endpoint:
http://localhost:8080/fan?message={message}