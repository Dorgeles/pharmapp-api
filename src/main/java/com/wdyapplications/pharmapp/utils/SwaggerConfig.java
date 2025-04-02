///*
//* Created on 2024-11-08 ( Time 00:22:29 )
//* Generator tool : Telosys Tools Generator ( version 3.3.0 )
//* Copyright 2018 Geo. All Rights Reserved.
//*/
//
//package com.wdyapplications.pharmapp.utils;
//
//import io.swagger.v3.oas.annotations.OpenAPIDefinition;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.ArrayList;
//import java.util.Collection;
//
///**
// * @author Geo
// */
//@Configuration
//@OpenAPIDefinition
//public class SwaggerConfig {
//    @Bean
//    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.any())
//                .paths(PathSelectors.any())
//                .build()
//				.apiInfo(apiInfo());
//    }
//    private ApiInfo apiInfo() {
//         Collection<VendorExtension> vendorExtensions = new ArrayList<>();
//         vendorExtensions.add( new StringVendorExtension("owner", "Backend-REST"));
//         vendorExtensions.add( new StringVendorExtension("development_team", "Backend-REST"));
//
//         Contact contactInfo = new Contact("It", "http://www.google.com","dev@api.it");
//         return new ApiInfo(
//             "ci_wdy_pharmapp",
//             "API REST ",
//             "1.0",
//             "",
//             contactInfo,
//             "OpenSource - Apache 2.0",
//             "http://www.apache.org",
//             vendorExtensions);
//       }
//}
