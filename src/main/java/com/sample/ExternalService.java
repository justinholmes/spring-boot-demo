package com.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ExternalService {

    private RestTemplate restTemplate = new RestTemplate();


    private String url;

    public ExternalService() {
        this.url = MarathonApplicationLocator.getHostAndPortForApplication("boot-demo2");
    }

    public String getUser() {
        return restTemplate.getForEntity(url, String.class).getBody();
    }

}
