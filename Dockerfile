FROM openjdk:17
COPY target/spring-boot-todo-0.0.1.jar spring-boot-todo-0.0.1.jar
ENTRYPOINT ["java","-jar","spring-boot-todo-0.0.1.jar"]
