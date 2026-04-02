# ec-catalog-svc

Spring Boot catalog service with PostgreSQL and Flyway migrations.

## Prerequisites

- Java 25
- Maven (or use the included `./mvnw` wrapper)
- PostgreSQL running on `localhost:5432`

## Database Setup

Create the database before running the app:

```sql
CREATE DATABASE catalog_db;
```

Update credentials in [src/main/resources/application.yaml](src/main/resources/application.yaml):

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/catalog_db
    username: your_username
    password: your_password
```

## Running the App

```bash
./mvnw spring-boot:run
```

The app starts on `http://localhost:8080`.

## Database Migrations

Migrations are managed by Flyway and run automatically on startup. Migration files are in [src/main/resources/db/migration/](src/main/resources/db/migration/).

To run migrations manually via Maven:

```bash
./mvnw flyway:migrate
```

with options:

```bash
./mvnw flyway:migrate \
  -Dflyway.url=jdbc:postgresql://localhost:5432/catalog_db \
  -Dflyway.user=your_username \
  -Dflyway.password=your_password
```

## Building

```bash
./mvnw clean package
```
