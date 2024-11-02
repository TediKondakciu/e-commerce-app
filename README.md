# E-Commerce Web Application

This project is an E-Commerce web application built with a microservices architecture. It is designed to be scalable, maintainable, and efficient, leveraging various Spring technologies for optimal performance and developer productivity.

## Technologies Used
- **Spring Boot 3**
- **Spring Cloud**
- **Spring Cloud Config** for centralized configuration management
- **Spring Cloud Gateway** as the API Gateway
- **Spring Cloud Discovery (Eureka)** for service registration and discovery
- **OpenFeign** and **RestTemplate** for inter-service communication
- **Apache Kafka** for asynchronous messaging
- **MongoDB / PostgreSQL** 
- **Docker** for containerization

## Project Structure and Key Components
1. **Microservices Architecture**: The application is divided into multiple microservices, each responsible for a distinct business function, such as customer management, product catalog, ordering, and payment processing.

2. **Service Discovery**: All microservices are registered with a discovery service, allowing dynamic discovery and load balancing of instances.

3. **Configuration Management**: The configurations for each microservice are externalized and managed centrally via a Config Server. This approach allows for easier updates and environment-specific configuration handling.

4. **API Gateway**: Only selected endpoints from each microservice are exposed through an API Gateway. This setup provides a single entry point for clients, enhances security, and improves manageability.

5. **Inter-Service Communication**:
    - **Synchronous Communication**: Microservices communicate synchronously using OpenFeign and RestTemplate where immediate response is required.
    - **Asynchronous Communication**: For scenarios that can operate in an asynchronous manner, such as order processing, Apache Kafka is used as a message broker, enabling decoupled and reliable event-driven communication between services.

6. **Order and Payment Workflow**: Once a user successfully places an order and completes payment, a series of events are triggered. These include:
    - Order and payment confirmation processes.
    - Sending confirmation emails to the client for each successful transaction step.

