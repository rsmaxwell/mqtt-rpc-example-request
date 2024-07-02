package com.rsmaxwell.mqtt.rpc.example.request.requests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.rsmaxwell.mqtt.rpc.common.Request;
import com.rsmaxwell.mqtt.rpc.common.Response;
import com.rsmaxwell.mqtt.rpc.request.RpcRequest;

public class Quit extends RpcRequest {

	private static final Logger logger = LogManager.getLogger(Quit.class);

	public Quit() {
		Request request = new Request("quit");
		setRequest(request);
	}

	@Override
	public void handle(Response response) throws Exception {
		logger.info("Quit.handle");
	}
}
