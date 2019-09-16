# Quarkus Bug Reproduction
Exception thrown from an injected RestClient are not being properly handled the registered 
ExceptionMapper. This repo contains a simple [controller](src/main/java/demo/FailableResource.java) 
with an injected [RestClient](src/main/java/demo/SomeRestClient.java) and some [tests](src/test/java/demo/FailableResourceTest.java) 
to show how the unexpected behaviour.