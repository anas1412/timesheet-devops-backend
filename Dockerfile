FROM maslick/minimalka:jdk11
ADD target/achat.jar achat.jar
EXPOSE 8080
CMD ["java", "-jar", "/achat.jar"]
