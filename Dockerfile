FROM openjdk:8-jdk-alpine

EXPOSE 8080

ADD wait-for-it.sh /wait-for-it.sh
RUN chmod +x /wait-for-it.sh

ADD target/*.jar /pl.giscon.demo.sb2spatial.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/pl.giscon.demo.sb2spatial.jar"]
