# phoneopedia

This project is for phoneopedia.


## Getting Started ##

### Prerequisites ###

* Git
* JDK 1.8
* Spring Boot 2.7.4
* Maven 3.0 or later


### Clone ###

To get started you can simply clone this repository using git:

```
git clone git@bitbucket.org:entercard/phoneopedia.git
cd phoneopedia
```


### Build and run application locally

You can run the application from the command line using:

```
mvn spring-boot:run
```

Or you can build a single executable JAR file that contains all the necessary dependencies, classes, and resources with:

```
mvn clean package
```

Then you can run the JAR file with:

```
java -jar target/phoneopedia-bootified.jar
```

*Instead of `mvn` you can also use the maven-wrapper `./mvnw` to ensure you have everything necessary to run the Maven build.*

Also you can execute the main method in the

```
com.phoneopedia.Application
```

 class from your IDE.

To test that it works, open a browser tab at

```
http://localhost:8081///actuator/health
```


Here are some endpoints you can call:

<b>Get information about system health, configurations, etc.</b>

```
http://localhost:8081///actuator/health/liveness
http://localhost:8081///actuator/health/readiness
http://localhost:8081///actuator/env
```

## Docker image ##

The **phoneopedia-phoneopedia-app** image is created and pushed to *OCIR (Oracle Cloud Infrastructure Registry)* through Jenkins pipeline.


## Kubernetes artifacts ##

The following Kubernetes artifacts are used to setup the **phoneopedia** micro-service in *OKE (Oracle Container Engine for Kubernetes)*  environment :

| Artifact Name  | Description |
| :--- | :---|
| phoneopedia-app.yaml  | This is responsible to create *phoneopedia-app* , *phoneopedia-deployment*  and  *phoneopedia-service*  kubernetes Pod,Deploment,Service objects respectively . |
| phoneopedia-configmap.yaml|This is responsible to create *phoneopedia-configmap*  kubernetes ConfigMap object ,which holds application properties.|
| phoneopedia-secret.yaml| This is responsible to create *phoneopedia-secret*  kubernetes Secret object ,which holds application secret properties.|

