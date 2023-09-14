FROM maven:3.9.4-eclipse-temurin-17-alpine

WORKDIR /app

COPY . .

ENV DATASOURCE_URL=jdbc:mysql://pet-db:3306/petrar
ENV DATASOURCE_USERNAME=root
ENV DATASOURCE_PASSWORD=root

RUN mvn clean package -DskipTests

CMD ["java", "-jar", "target/pet-0.0.1-SNAPSHOT.jar"]
