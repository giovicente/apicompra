FROM openjdk:8-alpine
WORKDIR /aplicativos
COPY /target/Cambio-ApiCompra.jar .
CMD ["java", "-jar", "/aplicativos/Cambio-ApiCompra.jar"]