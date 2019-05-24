FROM java:8
COPY target/limit-service.jar limit-service.jar
HEALTHCHECK CMD --interval=5s --timeout=5s curl  http://localhost:8080/ || exit 1
CMD ["java","-jar","limit-service.jar"]