FROM maven:3.9.6-eclipse-temurin-17 AS builder

WORKDIR /app

COPY build-parent/pom.xml build-parent/pom.xml
COPY services/order-service/pom.xml services/order-service/pom.xml

RUN mvn -f services/order-service/pom.xml dependency:go-offline

COPY build-parent build-parent
COPY services/order-service services/order-service

RUN mvn -f services/order-service/pom.xml clean package -DskipTests


FROM eclipse-temurin:17-jre

WORKDIR /app

COPY --from=builder /app/services/order-service/target/order-service-*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]