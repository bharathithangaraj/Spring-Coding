1) start Zipkin using docker or using Zipkin distribution jar

   docker run -d -p 9411:9411 openzipkin/zipkin

   or

   curl -sSL https://zipkin.io/quickstart.sh | bash -s
   java -jar zipkin.jar

2) open the following url in browser. You should see Zipkin dashboard
   http://localhost:9411/zipkin

3) start rest-consumer Spring boot application. This runs on port number 8080

   cd rest-consumer
   mvn spring-boot:run



3) start rest-producer Spring boot application. This runs on port number 9090

   cd rest-producer
   mvn spring-boot:run


4) Make a Rest API call  http://localhost:8080/get-greeting/User


5) View Zipkin traces in page http://localhost:9411/zipkin/




