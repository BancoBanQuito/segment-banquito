FROM eclipse-temurin:17-jdk-focal

COPY segment/target/segment-0.0.1-SNAPSHOT.jar segment-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/segment-0.0.1-SNAPSHOT.jar"]
EXPOSE 77
