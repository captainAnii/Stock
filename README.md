# Stock

This is a Stock Management System implemented using Java Spring Boot framework. It provides RESTful API endpoints for managing stocks.

## Project Structure

The project follows a typical Spring Boot structure with the following main packages:

- `com.geekster.Stock.controller`: Contains the controllers for handling HTTP requests and defining API endpoints.
- `com.geekster.Stock.model`: Contains the entity classes that represent the stock data model.
- `com.geekster.Stock.service`: Contains the service classes that handle business logic and interact with the repository.
- `com.geekster.Stock.repository`: Contains the repository interface that defines database operations.

## API Endpoints

The following API endpoints are available:

### GET /stock/type/{stockType}

Retrieves stocks based on the given stock type.

### GET /stock/cap/{capPercentage}

Retrieves all stocks with a market cap above the given percentage.

### GET /stock/abovePrice/price/{price}/lowerData/date/{date}

Retrieves stocks above a certain price and with a lower date.

### POST /stock/

Inserts a list of stocks into the database.

### PUT /stock/marketCap/{marketCap}/id/{id}

Updates the market cap of a stock with the given ID.

### PUT /stock/type/id?stockType={stockType}&id={id}

Updates the stock type of a stock with the given ID.

### DELETE /stock/ownerCount/{count}

Deletes stocks based on the owner count.

## Database Configuration

The application uses an H2 in-memory database. The database configuration can be found in the `application.properties` file:

```properties
spring.datasource.url=jdbc:h2:mem:h2db
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.h2.console.enabled=true
spring.jpa.properties.hibernate.show_sql=true
spring.jpa.properties.hibernate.use_sql_comments=true
spring.jpa.properties.hibernate.format_sql=true
## Dependencies
- The project has the following dependencies:
- Spring Boot Starter Data JPA
- Spring Boot Starter Web
- Spring Boot DevTools
- H2 Database
- Lombok
- Spring Boot Starter Test

## Usage
- You can run the application by executing the main class com.geekster.Stock.StockApplication. The application will start a server at http://localhost:8080.
- You can use tools like Postman or cURL to send HTTP requests to the API endpoints and perform stock management operations.
- Make sure to provide valid JSON data for the request body when using the POST endpoint for inserting stocks.

## Additional Notes
- The project uses Lombok to automatically generate getter, setter, and other boilerplate code for the entity classes. Make sure to have Lombok plugin installed in your IDE.
- The project follows the Spring Data JPA conventions for defining repository methods. You can refer to the documentation for more information on custom query methods.
- The database schema is automatically generated based on the entity classes and can be accessed using the H2 console at http://localhost:8080/h2-console.
