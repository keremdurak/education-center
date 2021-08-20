FROM openjdk:11 AS build

COPY pom.xml mvnw ./
COPY .mvn .mvn
RUN ./mvnw dependency:resolve

COPY src src
RUN ./mvnw package

FROM openjdk:11
WORKDIR education-center
COPY --from=build target/*.jar education-center.jar
ENTRYPOINT ["java", "-jar", "education-center.jar"]