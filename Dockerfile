FROM maven:3.8.3-openjdk-17 AS build
COPY . .
RUN mvn clean package -Pprod -DskipTests

FROM openjdk:17
COPY --from=build /target/quiz-online-0.0.1-SNAPSHOT.jar quiz-online.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","quiz-online.jar"]