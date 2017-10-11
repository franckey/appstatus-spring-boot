FROM anapsix/alpine-java
MAINTAINER myNAME
COPY target/appstatus-spring-boot-0.0.1-SNAPSHOT.war /home/appstatus-spring-boot.war
CMD ["java","-jar","/home/appstatus-spring-boot.war"]

EXPOSE 8080