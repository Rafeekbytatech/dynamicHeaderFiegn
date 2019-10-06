package com.bytatech.ayoos.dynamicFeignHeaderDemo;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




import feign.RequestInterceptor;
import feign.RequestTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;

@RestController
//@RequestMapping("/api/dms")
public class DmsResource {
	@Autowired
	private FlightClient flightClient;

	@Bean
	AuthInterceptor authFeign() {
		return new AuthInterceptor();
	}

	class AuthInterceptor implements RequestInterceptor {

		@Override
		public void apply(RequestTemplate template) {
			template.header("Authorization", "Basic 9eda682e0609d9fa76f93f0190a8c8de");

		}

	}
	
	/*@Autowired
	ApiKeyRequestInterceptor apiKeyRequestInterceptor;*/
	/*@Autowired
	NodesApi nodesApi;*/
	
	@GetMapping("/")
	public String test() {
		return "success";
		}
	
	
	@PostMapping("/createNode")
		public String createNodes(/*@PathVariable String nodeId,@RequestBody NodeBodyCreate nodeBodyCreateString name,String dmsId*/ ) {
				  System.out.println("+++++++++++++success++++++++++");
				  NodeBodyCreate nodeBodyCreate = new NodeBodyCreate();
					nodeBodyCreate.setName("cuucummmmm");
					nodeBodyCreate.setNodeType("cm:content");
					//nodeBodyCreate.setRelativePath("Sites/"+dmsId);

				//	NodeEntry nodeEntry = nodesApi.createNode("-my-", nodeBodyCreate, true, null, null).getBody();
					flightClient  .createNode("-my-", nodeBodyCreate, true, null, null);
				  
				 return "succes";
				  
				  }
	

	
}
