FROM maven:3.8.2-jdk-11
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
#RUN mvn clean install
#CMD mvn spring-boot:run
