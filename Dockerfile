FROM openjdk:17-oracle

WORKDIR /app

ARG JAR_FILE=build/libs/*.jar

COPY ${JAR_FILE} app.jar

EXPOSE 8082

CMD ["java", "-jar", "app.jar"]