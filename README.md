# Education Center
___
### Spring Boot Application



---

### Tech Stack

---
- Java 11
- Spring Boot
- Spring Data JPA
- Kotlin 1.5.0
- Restful API
- OpenAPI documentation
- H2 In memory database  
- Docker
- Docker compose
- PostgreSQL

### Prerequisites

---
- Maven
- Docker

### Properties Settings- Ayarlar
```
örnek.value={value}
```
{value} değeri yerine gerçek değer yazılmalı.
{value} should be replaced current value

#### PostgreSql properties
```
spring.datasource.url={PostgreSql Server URL}
spring.datasource.username={PostgreSql Server Username}
spring.datasource.password={PostgreSql Server Password}
```

### Kurulum - Setup
```
$ git clone https://github.com/keremdurak/education-center.git
$ cd education-center/
$ install maven
$ mvn -N io.takari:maven:wrapper
$ ./mvnw package
$ cd target/
$ java -jar education-center-0.0.1-SNAPSHOT.jar
```

### Run & Build

---
There are 2 ways of run & build the application.

#### Docker Compose
You just need to run `docker-compose up` command
___
*$PORT: 8080*
```ssh
$ cd education-center/src/main/resources
$ docker-compose up
```

#### Maven

 `"http://localhost:8080"` 
___
*$PORT: 8080*
```ssh
$ cd education-center
$ mvn clean install
$ mvn spring-boot:run
```

### Swagger UI will be run on this url
`http://localhost:${PORT}/swagger-ui.html`# education-center
