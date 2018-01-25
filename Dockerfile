FROM openjdk:9
VOLUME /tmp
ADD target/demo.jar demo.jar
RUN bash -c 'touch /demo.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/demo.jar"]