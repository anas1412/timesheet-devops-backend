FROM openjdk:8-jre-alpine
EXPOSE 8089
ADD target//github.com/anas1412/timesheet_devops/blob/achref-dridi/target/appachat.jar appachat.jar
CMD ["java", "-jar", "/achat.jar"]