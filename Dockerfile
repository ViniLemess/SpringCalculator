FROM gradle:7.2-jdk17 as gradle
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon

FROM tomcat:jdk17-openjdk
COPY --from=gradle /home/gradle/src/build/libs/tema6-1.0.war /usr/local/tomcat/webapps/tema6-1.0.war
EXPOSE 8080

