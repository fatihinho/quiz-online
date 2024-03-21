FROM openjdk:17
EXPOSE 8080
ADD target/*.jar quiz-online.jar
ENTRYPOINT ["java", "-jar", "/quiz-online.jar"]