FROM openjdk:8-jdk-alpine
ADD target/pos-biblioteca.jar app.jar
CMD ["java","-Djava.security.egd=file:/dev/./urandom", "-jar","/app.jar", "--spring.config.location=file:/src/main/resources/application.properties"]