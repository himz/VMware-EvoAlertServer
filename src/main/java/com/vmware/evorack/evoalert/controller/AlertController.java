package com.vmware.evorack.evoalert.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlertController {
	private static final Logger logger = LoggerFactory.getLogger(AlertController.class);

    List<String> alertList = new ArrayList<String>() ;
	
    @RequestMapping(value = RestURIConstants.INGEST_ALERT, method = RequestMethod.POST)
    public @ResponseBody String ingestAlert(@RequestBody String alertJsonString) {
        logger.info("Start create alert.");
        alertList.add(alertJsonString);
        return alertJsonString;
    }
    
    @RequestMapping(value = RestURIConstants.GET_LATEST_ALERT, method = RequestMethod.GET)
    public @ResponseBody String getLatestAlert() {
        logger.info("Start get latest alert");
        if(alertList.size() > 0)
        	return alertList.get(0).toString();
        else
        	return "No Alerts to show";
    }
    
    @RequestMapping(value = RestURIConstants.GET_ALL_ALERTS, method = RequestMethod.GET)
    public @ResponseBody String getAllAlerts() {
        logger.info("Start get all alerts");
        
        if(alertList.size() > 0) {
        	/* Return Array List of Json Objects */
        	return alertList.toString();
        } else {
        	return "No Alerts to show";
        }
    }
}
