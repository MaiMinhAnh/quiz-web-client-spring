package com.quiz.api_exchange;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Component
public class ApiExchangeService {

	
	@Autowired
	private RestTemplate restTemplate;

	public <T> T get(String url, Class<T> classType, String token) {
		HttpHeaders headers = new HttpHeaders();
		headers.set(HttpHeaders.AUTHORIZATION,token);
		HttpEntity<?> entity = new HttpEntity<Object>(headers);
		try {
			return restTemplate.exchange(url, HttpMethod.GET, entity, classType).getBody();
		} catch (HttpClientErrorException e) {
			throw e;
		}

//		return restTemplate.getForEntity(url, classType).getBody();		
	}

	public <T> T post(String url, Object object, Class<T> classType, String token) {
		HttpHeaders headers = new HttpHeaders();
		headers.set(HttpHeaders.AUTHORIZATION, token);
		HttpEntity<?> entity = new HttpEntity<Object>(object, headers);
		try {
			return restTemplate.exchange(url, HttpMethod.POST, entity, classType).getBody();
		} catch (HttpClientErrorException e) {
			throw e;
		}
	}

	public <T> T postNonToken(String url, Object object, Class<T> classType) {
		try {
			return restTemplate.postForEntity(url, object, classType).getBody();
		} catch (HttpClientErrorException e) {
			throw e;
		}
	}

	public void put(String url, Object object, String token) {
		HttpHeaders headers = new HttpHeaders();
		headers.set(HttpHeaders.AUTHORIZATION,  token);
		HttpEntity<?> entity = new HttpEntity<Object>(object, headers);
		try {
			restTemplate.put(url, entity);
		} catch (HttpClientErrorException e) {
			throw e;
		}
	}

	public void delete(String url, String token) {
		HttpHeaders headers = new HttpHeaders();
		headers.set(HttpHeaders.AUTHORIZATION,  token);
		HttpEntity<?> entity = new HttpEntity<Object>(headers);
		try {
			restTemplate.exchange(url, HttpMethod.GET, entity, void.class);
		} catch (HttpClientErrorException e) {
			throw e;
		}
	}
}
