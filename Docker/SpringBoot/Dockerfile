FROM openjdk:8-jdk-alpine

EXPOSE 8080

ARG JAR_FILE=target/spring-rabbit-mq-receiver-0.1.jar

# Add the application's jar to the container
ADD ${JAR_FILE} spring-rabbit-mq-receiver-0.1.jar
 
CMD ["java","-jar","/spring-rabbit-mq-receiver-0.1.jar"]
