package com.rsmaxwell.mqtt.rpc.example.request.requests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.rsmaxwell.mqtt.rpc.common.Request;
import com.rsmaxwell.mqtt.rpc.common.Response;
import com.rsmaxwell.mqtt.rpc.request.RpcRequest;

public class GetPages extends RpcRequest {

	private static final Logger logger = LogManager.getLogger(GetPages.class);

	public GetPages() {
		Request request = new Request("getPages");
		setRequest(request);
	}

	@Override
	public void handle(Response response) throws Exception {
		String result = response.getString("result");
		logger.info(String.format("result: %s", result));
	}
}
