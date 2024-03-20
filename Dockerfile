FROM openjdk:17
VOLUME /tmp
EXPOSE 8080
COPY --from=build /build/libs/quiz-online-0.0.1-SNAPSHOT.jar quiz-online-0.0.1.jar
ENTRYPOINT ["java","-jar","/quiz-online-0.0.1.jar"]