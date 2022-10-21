FROM openjdk:11.0.6-jre
ADD target/achat.jar achat.jar
EXPOSE 9090
CMD ["java", "-jar", "/achat.jar"]
