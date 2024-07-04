# mqtt-rpc-example-request

This project is an example of how to user the mqtt-rcp package to perform a Remote Procedure Call (i.e request/response).

It relies on the following dependencies:

    implementation 'com.rsmaxwell.mqtt.rpc:mqtt-rpc-common:0.0.1.5'
    implementation 'com.rsmaxwell.mqtt.rpc:mqtt-rpc-request:0.0.1.5'
  
which are available at the maven repository:

    https://pluto.rsmaxwell.co.uk/archiva/repository/releases
  
mqtt expects that a mosquitto broker is running to which clients can connect and communicate using standard topics

This project implements a couple of requester programs which make simple requests using mqtt-rpc

It expects that a matching responder program is also running to listen for requests and respond with a suitable reply.



