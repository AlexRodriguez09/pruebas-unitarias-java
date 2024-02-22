FROM anapsix/alpine-java
ADD ./target/*.jar /home/connection-mysql-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","./home/connection-mysql-0.0.1-SNAPSHOT.jar"]
