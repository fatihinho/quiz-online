FROM openjdk:17
EXPOSE 8080
COPY target/quiz-online-0.0.1-SNAPSHOT.jar quiz-online-0.0.1.jar
ENTRYPOINT ["java","-jar","/quiz-online-0.0.1.jar"]