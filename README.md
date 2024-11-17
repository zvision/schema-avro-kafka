# schema-avro-kafka
Simple Spring Boot project using Apache Kafka with Schema Registry and Avro

<strong><u>Using:</u></strong>

- Spring  3.3.2
- Java 17
- Maven 3.9.5
- Docker 27.3.1
<br></br> 

<strong><u>How to</u></strong>
<br></br> 
<u>Prerequisite</u>

Program Docker is running in the system. 

- Build: mvn clean install 
- Navigate to project's root folder and run: docker compose up -d 
- Run: mvn spring-boot:run    (java -jar target\schema-avro-kafka-0.0.1-SNAPSHOT.jar)



<strong><u>What to invoke</u></strong>


POST: 
- curl -X POST -d "{\"firstname\": \"Karl\",\"lastname\": \"Nilsson\", \"age\": 23}" -H "Content-Type: application/json" http://localhost:8181/event
- curl -X POST -d "{\"firstname\": \"Karl\",\"lastname\": \"Nilssn\" }" -H "Content-Type: application/json" http://localhost:8181/event
- curl -X POST -d "{\"firstname\": \"Karl\", \"age\": 23}" -H "Content-Type: application/json" http://localhost:8181/event
- curl -X POST -d "{\"firstname\": \"Karl\" }" -H "Content-Type: application/json" http://localhost:8181/event

<br></br> 

