/*
 * Created on 2022-05-06 ( Time 16:26:17 )
 * Generator tool : Telosys Tools Generator ( version 3.1.2 )
 * Copyright 2019 Smile CI. All Rights Reserved.
 */

package com.wdyapplications.pharmapp.utils.es;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.wdyapplications.pharmapp.utils.Utilities;
import com.wdyapplications.pharmapp.utils.dto.es._AggregationDto;
import com.wdyapplications.pharmapp.utils.dto.es._AggregationResponseDto;
import com.wdyapplications.pharmapp.utils.enums.OperatorEnum;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.support.WriteRequest;
import org.elasticsearch.client.IndicesClient;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.springframework.lang.Nullable;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;

import static org.elasticsearch.index.query.QueryBuilders.rangeQuery;

public class EsUtils {


    public static AggregationBuilder buildAggs(_AggregationDto aggregation) {
        if (aggregation == null || Utilities.isBlank(aggregation.getField())) {
            return null;
        }
        Integer size = (aggregation.getSize() != null) ? aggregation.getSize() : 100000000;
        boolean asc = Utilities.isNotBlank(aggregation.getOrderDirection())
                && aggregation.getOrderDirection().toLowerCase().equals("asc");
//        BucketOrder order = TagEnum.hasNumericValue(TagEnum.get(aggregation.getOrderField())) ? BucketOrder.count(asc)
//                : BucketOrder.key(asc);
        AggregationBuilder aggs = AggregationBuilders
                .terms(aggregation.getField())
                .field(aggregation.getField())
                .size(size);
        //.order(order);
        if (Utilities.isNotEmpty(aggregation.getDatasSubAggregation())) {
            for (_AggregationDto subAggregation : aggregation.getDatasSubAggregation()) {
                AggregationBuilder subAggs = buildAggs(subAggregation);
                if (subAggs != null) {
                    aggs.subAggregation(subAggs);
                }
            }
        }
        return aggs;
    }

    public static List<_AggregationResponseDto> getAggs(List<_AggregationDto> datasAggregation,
                                                     Aggregations aggregations) {
        if (Utilities.isEmpty(datasAggregation) || aggregations == null) {
            return null;
        }
        List<_AggregationResponseDto> result = new ArrayList<_AggregationResponseDto>();
        for (_AggregationDto dto : datasAggregation) {
            Terms terms = aggregations.get(dto.getField());
            if (terms != null) {
                List<_AggregationResponseDto> buckets = new ArrayList<_AggregationResponseDto>();
                Long                       total   = 0l;
                for (Terms.Bucket termsBucket : terms.getBuckets()) {
                    _AggregationResponseDto bucket = new _AggregationResponseDto();
                    bucket.setName(termsBucket.getKeyAsString());
                    bucket.setDrilldown(termsBucket.getKeyAsString());
                    bucket.setY(termsBucket.getDocCount());
                    total += termsBucket.getDocCount();
                    List<_AggregationResponseDto> datas = getAggs(dto.getDatasSubAggregation(),
                            termsBucket.getAggregations());
                    if (Utilities.isNotEmpty(datas)) {
                        bucket.setDatas(datas);
                    }
                    buckets.add(bucket);
                }

                Long finalTotal = total;
                buckets.forEach(bucket -> {
                    bucket.setTaux(
                            Utilities.calculTaux(bucket.getY().doubleValue(), finalTotal.doubleValue()).doubleValue());
                });

                // Sorting
                if (dto.getManualSorting() != null && dto.getManualSorting()) {
                    Comparator<_AggregationResponseDto> cp = _AggregationResponseDto.getComparator(dto.getOrderField());
                    if (Utilities.isNotBlank(dto.getOrderDirection())
                            && dto.getOrderDirection().equalsIgnoreCase("desc")) {
                        cp = cp.reversed();
                    }
                    buckets.sort(cp);
                }

                _AggregationResponseDto data = new _AggregationResponseDto();
                data.setName(terms.getName());
                data.setTotal(total);
                data.setBuckets(buckets);
                data.setSize((long) buckets.size());

                if (terms.getDocCountError() > 0) {
                    data.setDoc_count_error_upper_bound(terms.getDocCountError());
                }
                if (terms.getSumOfOtherDocCounts() > 0) {
                    data.setSum_other_doc_count(terms.getSumOfOtherDocCounts());
                }
                result.add(data);
            }
        }
        return result;
    }

    /**
     * @param aggregations
     * @param aggName
     * @param aggClass
     * @return agg
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public static <T> T getAggregation(Aggregations aggregations, String aggName, Class<T> aggClass)
            throws InstantiationException, IllegalAccessException {
        if (aggregations == null || aggregations.asList().isEmpty()) {
            return aggClass.newInstance();
        }

        T agg = aggregations.get(aggName);
        return agg;
    }
    
    public static <T> Map<String, Object> getAggregationObject(Aggregations aggregations, String aggName, Object aggClass)
            throws InstantiationException, IllegalAccessException {
        if (aggregations == null || aggregations.asList().isEmpty()) {
            return (Map<String, Object>) aggClass.getClass().newInstance();
        }

        T agg = aggregations.get(aggName);
        return (Map<String, Object>) agg;
    }
    


    public static String readJsonDefn(String url) throws Exception {
        StringBuilder bufferJSON = new StringBuilder();

        FileInputStream input       = new FileInputStream(new File(url).getAbsolutePath());
        DataInputStream inputStream = new DataInputStream(input);
        BufferedReader  br          = new BufferedReader(new InputStreamReader(inputStream));

        String line;

        while ((line = br.readLine()) != null) {
            bufferJSON.append(line);
        }
        br.close();
        return bufferJSON.toString();
    }

    public static BigDecimal arrondirChiffreVirgule(Double nombre, Integer nombre_chiffre_virgule) {
        BigDecimal bigDecimal = new BigDecimal(nombre);
        return bigDecimal.setScale(nombre_chiffre_virgule, BigDecimal.ROUND_HALF_UP);
    }

    public static Double convert(Double nombre, int precision) {
        if (nombre.isNaN()) {
            nombre = 0.00;
        }
        String roundPecision = "#.##";
        if (precision >= 0) {
            roundPecision = "#";
            if (precision >= 1) {
                roundPecision += ".";
                for (int i = 1; i <= precision; i++) {
                    roundPecision += "#";
                }
            }
        }
        DecimalFormat df = new DecimalFormat(roundPecision);
        df.setRoundingMode(RoundingMode.HALF_UP);
        String tmp = df.format(nombre).replaceAll(",", ".");
        return Double.parseDouble(tmp);
    }

    public static RangeQueryBuilder generateRangeQueryBuilder(String field, String operator, String start, String end) {
        return generateRangeQueryBuilder(field, operator, start, end, false, null);
    }

    public static RangeQueryBuilder generateRangeQueryBuilder(String field, String operator, String start, String end,
                                                              String pattern) {
        return generateRangeQueryBuilder(field, operator, start, end, true, pattern);
    }

    public static RangeQueryBuilder generateRangeQueryBuilder(String field, String operator, String start, String end,
                                                              Boolean fieldIsDateField, String pattern) {
        if (fieldIsDateField != null && fieldIsDateField && Utilities.blank(pattern)) {
            pattern = "";
            String startPattern = Utilities.findDateFormatByParsing(start);
            if (Utilities.notBlank(startPattern)) {
                pattern = startPattern;
            }
            String endPattern = Utilities.findDateFormatByParsing(end);
            if (Utilities.notBlank(endPattern)) {
                if (Utilities.notBlank(pattern)) {
                    pattern += "||";
                }
                pattern += endPattern;
            }
        }
        RangeQueryBuilder range = rangeQuery(field);
        switch (operator) {
//		case OperatorEnum.NOT_EQUAL_1:
//		case OperatorEnum.NOT_EQUAL_2:
//			if (Utilities.notBlank(start)) {
//				range = range.from(start).includeLower(true).to(start).includeUpper(true);
//			}
//			break;
            case OperatorEnum.EQUAL:
                if (Utilities.notBlank(start)) {
                    range = range.from(start).includeLower(true).to(start).includeUpper(true);
                }
                break;
            case OperatorEnum.LESS:
                if (Utilities.notBlank(end)) {
                    range = range.to(end).includeUpper(false);
                }
                break;
            case OperatorEnum.LESS_OR_EQUAL:
                if (Utilities.notBlank(end)) {
                    range = range.to(end).includeUpper(true);
                }
                break;
            case OperatorEnum.MORE:
                if (Utilities.notBlank(start)) {
                    range = range.from(start).includeLower(false);
                }
                break;
            case OperatorEnum.MORE_OR_EQUAL:
                if (Utilities.notBlank(start)) {
                    range = range.from(start).includeLower(true);
                }
                break;
            case OperatorEnum.BETWEEN:
                if (Utilities.notBlank(start) && Utilities.notBlank(end)) {
                    range = range.from(start).includeLower(true).to(end).includeUpper(true);
                }
                break;
            case OperatorEnum.BETWEEN_OUT:
                if (Utilities.notBlank(start) && Utilities.notBlank(end)) {
                    range = range.from(start).includeLower(false).to(end).includeUpper(false);
                }
                break;
            case OperatorEnum.BETWEEN_LEFT_OUT:
                if (Utilities.notBlank(start) && Utilities.notBlank(end)) {
                    range = range.from(start).includeLower(false).to(end).includeUpper(true);
                }
                break;
            case OperatorEnum.BETWEEN_RIGHT_OUT:
                if (Utilities.notBlank(start) && Utilities.notBlank(end)) {
                    range = range.from(start).includeLower(true).to(end).includeUpper(false);
                }
                break;
            default:
                if (Utilities.notBlank(start) && Utilities.notBlank(end)) {
                    range = range.from(start).includeLower(true).to(end).includeUpper(true);
                }
                break;
        }
        if (Utilities.notBlank(pattern)) {
            range = range.format(pattern);
        }
        return range;
    }

    public static <T> T insert(String indexName, String type, String templateName, HighClientFactory highClientFactory, T itemToSave) throws Exception {
        return save(indexName, type, templateName, highClientFactory, itemToSave, null);
    }

    public static <T> List<T> insert(String indexName, String type, String templateName, HighClientFactory highClientFactory, List<T> itemsToSave) throws Exception {
        return saveAll(indexName, type, templateName, highClientFactory, itemsToSave, null);
    }

    public static <T> T update(String indexName, String type, String templateName, HighClientFactory highClientFactory, T itemToSave, @Nullable String id) throws Exception {
        return save(indexName, type, templateName, highClientFactory, itemToSave, id);
    }

    public static <T> T save(String indexName, String type, String templateName, HighClientFactory highClientFactory, T itemToSave, @Nullable String id) throws Exception {
        T dto = null;
        // si l'index existe
        if (!HighClientEsUtils.indicesExists(indexName, highClientFactory)) {
            boolean created = HighClientEsUtils.createIndex(indexName, templateName, highClientFactory);
            if (!created) {
                throw new RuntimeException("La création de l'index '" + indexName + "' a echoué.");
            }
        }
        IndexRequest request = id != null
                ? HighClientEsUtils.getIndexRequest(indexName, type, id)
                : HighClientEsUtils.getIndexRequest(indexName, type);
        Gson gson = new Gson();
        request.source(gson.toJson(itemToSave), XContentType.JSON);
        request.setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE);

        RestHighLevelClient client        = highClientFactory.getClient();
        IndexResponse       indexResponse = client.index(request, RequestOptions.DEFAULT);
        //log.info(indexResponse.toString());
        if (indexResponse != null) {
            dto = itemToSave;
        }
        return dto;
    }

    public static <T> List<T> saveAll(String indexName, String type, String templateName, HighClientFactory highClientFactory, List<T> itemsToSave, @Nullable String id) throws Exception {
        List<T> dtos = new ArrayList<>();
        try {
            BulkRequest request = new BulkRequest();
            BulkResponse        bulkResponse = null;
            // si l'index existe
            if (!HighClientEsUtils.indicesExists(indexName, highClientFactory)) {
                boolean created = HighClientEsUtils.createIndex(indexName, templateName, highClientFactory);
                if (!created) {
                    throw new RuntimeException("La création de l'index '" + indexName + "' a echoué.");
                }
            }
            final Gson  gson    = new Gson();
            for (T itemToSave : itemsToSave) {
                IndexRequest indexRequest = id != null
                        ? HighClientEsUtils.getIndexRequest(indexName, type, id)
                        : HighClientEsUtils.getIndexRequest(indexName, type);
                indexRequest.source(gson.toJson(itemToSave), XContentType.JSON);
                request.add(indexRequest);
                
                System.out.println(" gson.toJson(itemToSave) ====> "+gson.toJson(itemToSave));
                
            }
            RestHighLevelClient client       = highClientFactory.getClient();
            try {
                bulkResponse = client.bulk(request, RequestOptions.DEFAULT);	
                System.out.println("bulkResponse " + bulkResponse.buildFailureMessage());
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}	
            if (bulkResponse != null) {
                dtos.addAll(itemsToSave);
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
        return dtos;
    }

    public static void createIndexIfNotExists(HighClientFactory highClientFactory) throws IOException {
        RestHighLevelClient client = highClientFactory.getClient();
        IndicesClient indicesClient = client.indices();
        GetIndexRequest getIndexRequest = new GetIndexRequest("records");

        boolean exists = indicesClient.exists(getIndexRequest, RequestOptions.DEFAULT);

        if (!exists) {
            CreateIndexRequest createIndexRequest = new CreateIndexRequest("records");
            CreateIndexResponse createIndexResponse = indicesClient.create(createIndexRequest, RequestOptions.DEFAULT);

            if (!createIndexResponse.isAcknowledged()) {
                throw new IOException("Échec de la création de l'index Elasticsearch.");
            }
        }
    }

    public static String saveRecord(Record record, HighClientFactory highClientFactory) throws IOException {
        createIndexIfNotExists(highClientFactory);
        RestHighLevelClient client = highClientFactory.getClient();
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> dataMap = objectMapper.convertValue(record, HashMap.class);
        IndexRequest indexRequest = new IndexRequest("records")
                .id(UUID.randomUUID().toString()) // Génère un ID unique
                .source(dataMap);
        IndexResponse response = client.index(indexRequest, RequestOptions.DEFAULT);
        return response.getId();
    }
}

