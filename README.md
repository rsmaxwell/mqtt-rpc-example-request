# mqtt-rpc-example-request

This project is an example showing how to perform a Remote Procedure Call (i.e request/response) using the the mqtt-rcp package.

It relies on the following dependencies:

 
```
repositories {
    maven {
        url "https://pluto.rsmaxwell.co.uk/archiva/repository/releases"
    }
}

dependencies {
     ...
    implementation 'com.rsmaxwell.mqtt.rpc:mqtt-rpc-common:+'
    implementation 'com.rsmaxwell.mqtt.rpc:mqtt-rpc-request:+'
}
```

The lastest version can be found at 

```
https://pluto.rsmaxwell.co.uk/archiva/#artifact~releases/com.rsmaxwell.mqtt.rpc/mqtt-rpc-common
```

An mqtt broker must be running to which clients connect and communicate using standard topics. For example [Mosquitto](https://mosquitto.org/)

This project expects a matching responder program is also running and listening for requests and providing suitable responses.

This project implements a number of example request handlers to the responder using 'mqtt-rpc'.



A request handler is a program which:

  * makes an mqtt client 
  * creates an instance of [RemoteProcedureCall](https://github.com/rsmaxwell/mqtt-rpc-request/blob/main/src/main/java/com/rsmaxwell/mqtt/rpc/request/RemoteProcedureCall.java)
  * connects the client to the mqtt broker
  * subscribes to the response topic
  * makes a [Request ](https://github.com/rsmaxwell/mqtt-rpc-common/blob/main/src/main/java/com/rsmaxwell/mqtt/rpc/common/Request.java)
  * publishes the request as a json string
  * waits for the response and outputs the result


A Request is an object containing a map of values and a identifier for the type of request. It is serialised into json and sent as an mqtt message to the Responder program.

An example of how to make an Request is [Calculator](https://github.com/rsmaxwell/mqtt-rpc-example-request/blob/main/src/main/java/com/rsmaxwell/mqtt/rpc/example/request/requests/Calculator.java)
which: 

  * makes a new [Request](https://github.com/rsmaxwell/mqtt-rpc-common/blob/main/src/main/java/com/rsmaxwell/mqtt/rpc/common/Request.java)
  * sets the Request.function to a string to identify this type of request
  * fills in the Request with appropriate key/values, in the case of a calculator these are an 'operation' string and two numbers
  
When the response arrives, the Calculator:

  * prints the result from the response
