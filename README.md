# Spring Boot 2 and PostGIS
GIS Spring Boot 2 REST application based on PostGIS

## Technologies

* Java 8
* Maven
* Spring Boot 2
* GeoTools
* PostGIS
* Flyway
* Swagger
* Lombok
* Docker

## Run

### PostGIS start

```bash
docker run --name postgis -p 5432:5432 -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=sb2spatial -d mdillon/postgis:9.5-alpine
```

### Application build and run

```bash
mvn package && java -jar target/pl.giscon.demo.sb2spatial-0.0.1-SNAPSHOT.jar
```

### Swagger UI

http://localhost:8080/swagger-ui.html
