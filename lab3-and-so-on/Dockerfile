FROM eclipse-temurin:22-alpine
ARG JAR_FILE=target/*.jar
RUN apk add --no-cache curl \
&& mkdir /opt/app
COPY ${JAR_FILE} /opt/app/japp.jar
CMD ["java", "-jar", "/opt/app/japp.jar"]