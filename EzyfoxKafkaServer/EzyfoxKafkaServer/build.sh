#export EZYFOX_SERVER_HOME=
mvn -pl . clean install
mvn -pl EzyfoxKafkaServer-common -Pexport clean install
mvn -pl EzyfoxKafkaServer-app-api -Pexport clean install
mvn -pl EzyfoxKafkaServer-app-entry -Pexport clean install
mvn -pl EzyfoxKafkaServer-plugin -Pexport clean install