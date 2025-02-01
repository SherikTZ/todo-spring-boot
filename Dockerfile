FROM openjdk:17

COPY wait-for-it.sh /wait-for-it.sh
RUN chmod +x /wait-for-it.sh

COPY target/spring-boot-todo-0.0.1.jar spring-boot-todo-0.0.1.jar

ENTRYPOINT ["/wait-for-it.sh", "mysql:3306", "--", "java", "-jar", "spring-boot-todo-0.0.1.jar"]
