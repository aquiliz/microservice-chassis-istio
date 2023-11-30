# Microservice chassis
### Based on: Java 19, Spring Boot, Istio (service mesh), Docker, Kubernetes, Gradle

Contains the basic infrastructure, configuration and scripts to quickly bootstrap a new microservice
injectable into the service mesh.
Contains two microservices communicating between each other via REST call and 
a Kubernetes Ingress (api-gateway) routing the traffic to each microservice

## Prerequisites
- JDK 19
- Docker and Kubernetes running (e.g. Docker Desktop)
- Istio

## To start them
- Execute `kubectl apply -f /kube` in project's root

## Calling the api gateway
- POST http://localhost/order (with the respective payload)
- GET http://localhost/inventory/1

## Tips

### Installing Istio for Windows
- Download `istio-xxx-win.zip` and `istioctl-xxx-win.zip`
  from [here](https://github.com/istio/istio/releases)
- Unzip them into a directory and add that directory to Windows' PATH env var
- Follow [these two simple steps](https://istio.io/latest/docs/setup/getting-started/#install
  ) to install it using `istioctl`



### Example how to build one of the services as docker image, run it and push to Docker hub
- Navigate to the specific service's parent directory
- `docker build -f ./docker/Dockerfile -t <docker-hub-user>/inventory-service:0.0.1 .`
- `docker run -p 8080:8080 <docker-hub-user>/inventory-service:0.0.1`  (exposes container's port 8080)
- `docker push <docker-hub-user>/inventory-service:0.0.1`  (requires authentication to docker hub)

