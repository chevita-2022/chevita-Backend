FROM java:11
LABEL maintainer="susu19@ewhain.net"
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=target/kbsc-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} chevita.jar
ENTRYPOINT["java", "-jar", "/chevita.jar"]