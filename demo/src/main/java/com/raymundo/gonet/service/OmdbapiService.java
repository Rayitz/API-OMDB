package com.raymundo.gonet.service;

import java.util.Arrays;
import java.util.Properties;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AnonymousAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.raymundo.gonet.bean.MessageBean;
import com.raymundo.gonet.utilities.Constant;
import com.raymundo.gonet.utilities.Utilities;

@Service

public class OmdbapiService {

	private static ResourceBundle bundle = ResourceBundle.getBundle("application");
	public static Properties props = System.getProperties();
	
	@Autowired
	private RestTemplate restTemplate;

	@SuppressWarnings("unused")
	public String getByName(String name) {
		String json = null;
		String url = (String) bundle.getObject("raymundo.gonet.omdb.key.name");
		Object data = restTemplate.getForObject(url + name, Object.class);
		if (data != null) {
			json = Utilities.objectToJson(data);
		} else {
			MessageBean messageBean = new MessageBean();
			messageBean.setMessage(Constant.NO_MOVIE + name);
			json = Utilities.mensajeToJson(messageBean);

		}

		System.out.println(" data : " + json);

		return json;
	}
    
	@SuppressWarnings("unused")
	public JsonNode getById(String id) {
		String url = (String) bundle.getObject("raymundo.gonet.omdb.key.id");
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		ResponseEntity<JsonNode> response = restTemplate.exchange(url + id, HttpMethod.GET, entity, JsonNode.class);
		JsonNode map = null;
		if(response!=null){
			map = response.getBody();
		}
//		System.out.println("imdbID :" + map.get("imdbID").asText() + " title : " + map.get("Title").asText() + " year: "
//				+ map.get("Year").asText() + " plot: " + map.get("Plot").asText());

		return map;
	}
 
    
}
