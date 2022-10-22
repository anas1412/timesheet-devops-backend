FROM adoptopenjdk/openjdk11:jre-11.0.6_10-alpine
ADD target/achat.jar achat.jar
EXPOSE 9090
CMD ["java", "-jar", "/achat.jar"]
