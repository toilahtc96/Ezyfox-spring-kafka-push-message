# Kafka-Spring-Ezyfox-Push-Message

# Spring-kafka-server
A small system to receiver message from endpoint user and send to kafka topic 
# Requirement
1. JDK 1.8
2. Maven 3
3. Kafka
# Architecture
<img src="https://github.com/toilahtc96/Kafka-Spring-Ezyfox-Push-Message/blob/main/public/image/so-do.PNG" />
# How to run?
## Start kafka

```bash
# start zookeeper first
bin/zookeeper-server-start.sh config/zookeeper.properties
# then start kafka
bin/kafka-server-start.sh config/server.properties
```

Please refer kafka quickstart to get more guide
# Start Spring java api gateway server
## Build
1. Move to publisher-server folder
2. Run command
```bash
mvn package
```
## Run 
```bash
java -jar target/demo-0.0.1-SNAPSHOT.jar
```

# Start Ezyfox-Server
## Ezyfox-Server is server to listen from kafka and send command to client 
## Build 
1. Move to socket-server folder
2. Run command bash build.sh or
```bash
mvn -Denv.EZYFOX_SERVER_HOME=deploy -Pezyfox-deploy clean install
```
## Run
1. Move to socket-server/deploy folder
2. Run command

```bash
# On linux
bash ./console.sh

# On windows
console.bat
```

#  Start Vue.js web client
1. Move to folder client-vuejs
2. Run npm i, you get an error with vuex you can run npm install vuex@next --save
3. Run npm start and open http://localhost:3001/

# How to test?
run:
```bash
curl --location --request POST 'http://localhost:8080/send-msg-topic' \
--header 'Content-Type: application/json' \
--data-raw '{
    "data":{
        "username":"dungtv",
        "messageContent":"message content test "
        
    },
    "topic":"message"
}'
```

On the commandline of Spring server you can see 
```bash
Received Message in group - group-id:  {"username":"dungtv", "data":{"message":"message content test "}}
```

On the commandline of Ezyfox-Server you can see
```bash
Received Message in group - group-id:message content test
```
On the vue client in browser you can see
<p align="left">
  <img src="https://github.com/toilahtc96/Kafka-Spring-Ezyfox-Push-Message/blob/main/public/image/vue-client-result.png" width="500" alt="accessibility text">
</p>
