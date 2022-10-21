FROM openjdk:11-jre-alpine
ADD target/achat.jar achat.jar
EXPOSE 9090
CMD ["java", "-jar", "/achat.jar"]