/*
 * Created on 2022-05-06 ( Time 16:26:17 )
 * Generator tool : Telosys Tools Generator ( version 3.1.2 )
 * Copyright 2019 Smile CI. All Rights Reserved.
 */

package com.wdyapplications.pharmapp.utils.es;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.UnknownHostException;
/**
 * ElasticSearch High Level Rest Client factory
 * 
 * @author Lazare yao, Smile Back-End developper
 *
 */
@Service
public class HighClientFactory {
    @Autowired
    private ClientConfig clientConfig;

    private RestClient          lowLevelRestClient = null;
    private RestHighLevelClient client             = null;

    public RestHighLevelClient getClient() {
        if (client == null) {
            initC();
        }
        return client;
    }
    public RestClient getRestClient() throws UnknownHostException {
        if (client == null) {
            initC();
        }
        return lowLevelRestClient;
    }

    private void initC() {
        String[] hostParams = clientConfig.getHost().split(":");
        String   address    = hostParams[0];
        int      port       = hostParams.length > 1 ? Integer.parseInt(hostParams[1]) : 9200;
        HttpHost datasHttpHost = new HttpHost(address, port, "http");
        RestClientBuilder restClientBuilder = RestClient.builder(datasHttpHost);
        lowLevelRestClient = restClientBuilder.build();
        client             = new RestHighLevelClient(restClientBuilder);
    }
}
