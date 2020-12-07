# Springboot App


## Run the Application

The Application can be run using the following command 

```bash
mvn spring-boot:run 
```

Access application on `localhost:8080/api/<path>`

## Build Docker image

```bash
docker build -t simplerestapiapp:v1 .
```

## Run image on docker containers

```bash
docker run -p 8080:8080 simplerestapiapp:v1
```

## Run on k8s

This will deploy app on k8s and create service exposing on `NodePort`

```bash
cd k8s
kubectl apply -f .
```