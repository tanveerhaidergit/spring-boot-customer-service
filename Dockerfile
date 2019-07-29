FROM openjdk:8
ARG JAR_FILE=spring-boot-customer-service-0.0.1-SNAPSHOT.jar
COPY ./target/$JAR_FILE $JAR_FILE
CMD ["java","-jar","spring-boot-customer-service-0.0.1-SNAPSHOT.jar"]