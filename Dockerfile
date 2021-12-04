FROM eclipse-temurin:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} /opt/app/japp.jar
CMD ["java","-jar","/opt/app/japp.jar", "--server.port=$PORT"]
