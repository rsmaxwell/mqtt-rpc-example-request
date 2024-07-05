# mqtt-rpc-example-request

This project is an example of how to user the mqtt-rcp package to perform a Remote Procedure Call (i.e request/response).

It relies on the following dependencies:

 
```
repositories {
    maven {
        url "https://pluto.rsmaxwell.co.uk/archiva/repository/releases"
    }
}

dependencies {
     ...
    implementation 'com.rsmaxwell.mqtt.rpc:mqtt-rpc-common:0.0.1.7'
    implementation 'com.rsmaxwell.mqtt.rpc:mqtt-rpc-request:0.0.1.7'
}
```
  
  
  
The lastest version can be found at 

```
https://pluto.rsmaxwell.co.uk/archiva/#artifact~releases/com.rsmaxwell.mqtt.rpc/mqtt-rpc-common
```

mqtt expects that a [Mosquitto](https://mosquitto.org/) broker is running to which clients connect and communicate using standard topics

It expects that a matching responder program is also running to listen for requests and respond with a suitable reply.

This project implements a couple of requester programs which make simple requests using mqtt-rpc



A Handler:

  * makes an mqtt client 
  * creates an instance of [RemoteProcedureCall](https://github.com/rsmaxwell/mqtt-rpc-request/blob/main/src/main/java/com/rsmaxwell/mqtt/rpc/request/RemoteProcedureCall.java)
  * connects the client to the mqtt broker
  * subscribes to the response topic
  * constructs a [RpcRequest ](https://github.com/rsmaxwell/mqtt-rpc-request/blob/main/src/main/java/com/rsmaxwell/mqtt/rpc/request/RpcRequest.java)
  * publishes the request as a json string
  * waits for the response
  * handles the response


A Request is an object containing a map of values and a identifier for the type of request. It is serialised into json and sent as an mqtt message to the Responder program.

An RpcRequest is an abstract object which contains a Request and describing how the Requester will parse an incoming mqtt reply

An example of how to make an RpcRequest is [Calculator](https://github.com/rsmaxwell/mqtt-rpc-example-request/blob/main/src/main/java/com/rsmaxwell/mqtt/rpc/example/request/requests/Calculator.java)
which: 

  * makes a new [request](https://github.com/rsmaxwell/mqtt-rpc-common/blob/main/src/main/java/com/rsmaxwell/mqtt/rpc/common/Request.java)
  * sets the Request.function to a string to identify this type of request
  * fills in the Request with appropriate key/values, in the case of a calculator these are an 'operation' string and two numbers
  * sets the Request into the RpcRequest
  
An RpcRequest also handles the response

  * Extracts values from the response
  * prints the values 