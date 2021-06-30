## Test
````
./mvnw test
````

## Build
````
 ./mvnw package -DskipTests 
````

## Docker
Install

Build
````
docker build -t maxmorev/customer-report-calculation .
````
Run
````
docker run -i --rm -p 8080:8080 \
--name customer-report-calculation \
maxmorev/customer-report-calculation
````
