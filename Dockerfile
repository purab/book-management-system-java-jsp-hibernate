FROM adoptopenjdk:8-jre-hotspot

EXPOSE 8080

ADD target/book-management-system-java.war book-management-system-java.war

ENTRYPOINT ["java","-jar","book-management-system-java.war"]