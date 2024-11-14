# One Shop

One Shop is a simple e-commerce application built with Spring Boot. It provides basic functionalities for managing products, carts, orders, and user authentication.

## Features

- User authentication and authorization
- Product management
- Cart management
- Order management
- JWT-based authentication
- H2 in-memory database for development and testing

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven 3.6.0 or higher

### Installation

1. Clone the repository:
    ```sh
    git clone https://github.com/yourusername/one-shop.git
    cd one-shop
    ```

2. Build the project:
    ```sh
    mvn clean install
    ```

3. Run the application:
    ```sh
    mvn spring-boot:run
    ```

## Configuration
The application uses an H2 in-memory database for development and testing. You can configure the database settings in the src/main/resources/application.properties file.