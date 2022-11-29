FROM maven:3.6.3-jdk-11 AS builder

COPY ./ ./
# For install private maven dependency
COPY ./settings.xml /root/.m2/settings.xml

RUN mvn clean package -DskipTests
FROM openjdk:11.0.7-jdk-slim
COPY --from=builder /target/github-docker-package-example.jar /app.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]