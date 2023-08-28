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

## Write up
### Initializing the Project
The project is initialized using https://start.spring.io/.
It must include the dependencies:
* Spring Web
* Spring for RabbitMQ
* Lombok

It is initiated using Maven, Java 20 and Spring Boot 3.1.3.

The Package is called com.georgeh and the app called basicrabbit.

### Project Structure
The main structure is:
* BasicRabbitApplication.java
* config
  * RabbitConfig.java
* consumer
  * RabbitMQConsumer
* controller
  * MessageController
* publisher
  * RabbitMQProducer

