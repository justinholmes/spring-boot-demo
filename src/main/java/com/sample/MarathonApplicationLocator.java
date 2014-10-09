package com.sample;

import mesosphere.marathon.client.Marathon;
import mesosphere.marathon.client.MarathonClient;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

public class MarathonApplicationLocator {

    private static String marathonEndpoint  = "http://10.245.183.252:8080";

    private static Marathon marathonClient = MarathonClient.getInstance(marathonEndpoint);

    public static String getHostAndPortForApplication(String application) {
        Optional<Integer> first = marathonClient.getApp(application).getApp().getPorts().stream().findFirst();
        return "http://172.17.42.1:" + first.get() ;
    }

}
