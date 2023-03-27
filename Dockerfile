# define base docker image
FROM openjdk:11
LABEL maintainer="Malashree.lature"
ADD target/docker-demo-0.0.1-SNAPSHOT.jar docker-demo.jar
ENTRYPOINT ["java","-jar","docker-demo.jar"]