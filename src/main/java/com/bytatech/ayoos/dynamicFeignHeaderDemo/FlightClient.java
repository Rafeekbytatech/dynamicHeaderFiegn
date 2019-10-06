package com.bytatech.ayoos.dynamicFeignHeaderDemo;

import java.util.List;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
/*
import com.bytatech.ayoos.client.custom_dms_core.model.NodeBodyCreate;
import com.bytatech.ayoos.client.custom_dms_core.model.NodeEntry;
*/
//import io.swagger.annotations.ApiParam;

@FeignClient(name="FlightClient", url= "https://i0rezn.trial.alfresco.com/alfresco/api/-default-/public/alfresco/versions/1")
public interface FlightClient {

   /* @RequestMapping(method = RequestMethod.GET, value = "/flight/FRA/departure")
    List<FlightWrapper> getDepartingFlights();
    
    
    @RequestMapping(method = RequestMethod.GET, value = "/flightDetails/{airlineCode}/{flightNumber}/")
    List<FlightWrapper> getFlightDetails(@PathVariable("airlineCode") String airlineCode, @PathVariable("flightNumber") Integer flightNumber);
   */ 
	  @RequestMapping(value = "/nodes/{nodeId}/children",
		        produces = "application/json", 
		        consumes = "application/json",
		        method = RequestMethod.POST)
		    ResponseEntity<NodeEntry> createNode( @PathVariable("nodeId") String nodeId,  @Valid @RequestBody NodeBodyCreate nodeBodyCreate, @Valid @RequestParam(value = "autoRename", required = false) Boolean autoRename, List<String> include,@Valid @RequestParam(value = "fields", required = false) List<String> fields);

}
