# Spring Boot and Apache Camel Example

This is an example of using [Apache Camel](https://camel.apache.org/) as a routing
engine between [Apache Kafka](https://kafka.apache.org/) and [RabbitMQ](https://www.rabbitmq.com/).

## Dependencies

I used [Docker](https://www.docker.com/) for the RabbitMQ and Kafka infrastructure.

To start the [Docker image for RabbitMQ](https://hub.docker.com/_/rabbitmq), type the following command:

```bash
$ docker run -d --hostname my-rabbit --name some-rabbit rabbitmq:3-management
```

Navigate to _http://${dockerHostIP}:15672_, where _dockerHostIP_ is the IP address of the
docker container. If you do not know what it is, type the following command:

```bash
$ docker inspect some-rabbit
```

To execute [Kafka using Docker](https://hub.docker.com/r/wurstmeister/kafka/),
use the following command at the base directory for this project:

```bash
$ docker-compose up -d
```

## RabbitMQ Example Route

## Kafka Topic Example Route
