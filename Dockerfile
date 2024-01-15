FROM tomcat:latest
COPY target/dulcemordidaService-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/
EXPOSE 8080