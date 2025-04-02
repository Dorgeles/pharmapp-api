/*
 * Created on 2022-05-06 ( Time 16:26:17 )
 * Generator tool : Telosys Tools Generator ( version 3.1.2 )
 * Copyright 2019 Smile CI. All Rights Reserved.
 */


package com.wdyapplications.pharmapp.utils.es;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ElasticSearch client configuration
 * 
 * @author Lazare yao, Smile Back-End developper
 *
 */
@Component
public class ClientConfig {

    @Value("${es.host}")
    private String host;

    public String getHost() {
        return this.host;
    }

}
