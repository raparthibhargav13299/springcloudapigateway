Assignment - Service Discovery
Problem Statement: Use service registry for service discovery
In this exercise, you will concentrate on Service Discovery and its usage. It contains two Spring boot applications:
app-service – A Spring Boot based microservice which exposes one REST endpoint. This is a client-service application which registers itself at the registry.
service-registry – A Spring Boot based, which holds the information about all client-service applications. This service uses Eureka Server as Service Registry.