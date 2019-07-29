Spring Boot RESTful Web Service Example

MY SQL is used as database for this example
Lombok library is used to avoid writing repetitive code

PlayGround

got to http://localhost:8082/swagger-ui.html to test the endpoints

******************* Integration steps with docker************************

Documentation

1. Create the network which will be used for comunication between sping boot customer container and mySql container .

docker network create customer-mysql 

docker network ls

2. create the my sql container

docker container run --name mysqldb --network customer-mysql -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=demo -d mysql:8

3. Verify if my sql container is created successfully with no errrors

docker container logs -f mysqldb

4. log into mysql console to check if demo schema is created

docker container exec -it mysqldb bash
mysql -uroot -proot

5. Build the spring customer service project . Make sure data source url is correctly pointed to mysql instance running on container  spring.datasource.url=jdbc:mysql://mysqldb/demo
also naviagte to the project from command line where the spring boot project is located
for e.g. c:
mvn clean package 

Note : if the database scripts fail , for now go and execute the statements in schema-mysql.sql manually.

6. Build spring boot project as docker image
docker image build -t springboot-customer-service .

7. Start the container for spring boot project

docker container run --network customer-mysql  --name customer-mysql-container -p 8082:8082 -d springboot-customer-service

8. verify if the customer-my-sql container is started withour errors

docker container logs  customer-mysql-container

9. Verify tend endpoints are working by testing with rest client


10. All the above tasks can be automated and done  using docker compose

Steps
1.mvn clean package 
2.docker image build -t springboot-customer-service .  This is to build image locally

docker-compose up

to run in detached mode

docker-compose up
