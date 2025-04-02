/*
 * Created on 2022-05-06 ( Time 16:26:17 )
 * Generator tool : Telosys Tools Generator ( version 3.1.2 )
 * Copyright 2019 Smile CI. All Rights Reserved.
 */

package com.wdyapplications.pharmapp.utils.es;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.wdyapplications.pharmapp.utils.Utilities;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.ParseException;
import org.apache.http.entity.ContentType;
import org.apache.http.nio.entity.NStringEntity;
import org.apache.http.util.EntityUtils;
import org.elasticsearch.action.DocWriteRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.support.ActiveShardCount;
import org.elasticsearch.action.support.IndicesOptions;
import org.elasticsearch.action.support.WriteRequest.RefreshPolicy;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.*;
import org.elasticsearch.client.core.CountRequest;
import org.elasticsearch.client.core.CountResponse;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.SortBuilder;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.net.UnknownHostException;
import java.security.InvalidParameterException;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;


public class HighClientEsUtilsBase extends EsUtils {

    // private static Logger slf4jLogger =
    // LoggerFactory.getLogger(HighClientEsUtils.class);

    public static SearchRequest getSearchRequest(String[] indexName, String indexType, IndicesOptions indicesOptions) {
        SearchRequest searchRequest = new SearchRequest(indexName);

		/*
		if (Utilities.isNotBlank(indexType)) {
			searchRequest.types(indexType);
		}
		*/

        if (indicesOptions != null) {
            searchRequest.indicesOptions(indicesOptions);
        }

        return searchRequest;
    }

    public static SearchRequest getSearchRequest(String... indexName) {
        return getSearchRequest(indexName, IndicesOptions.lenientExpandOpen());
    }

    public static SearchRequest getSearchRequest(String[] indexName, String indexType) {
        return getSearchRequest(indexName, indexType, IndicesOptions.lenientExpandOpen());
    }

    public static SearchRequest getSearchRequest(String[] indexName, IndicesOptions indicesOptions) {
        return getSearchRequest(indexName, null, indicesOptions);
    }

    public static SearchRequest getSearchRequest(String[] indexName, String indexType, IndicesOptions indicesOptions,
                                                 SearchSourceBuilder sourceBuilder) {
        SearchRequest searchRequest = getSearchRequest(indexName, indexType, indicesOptions);
        if (sourceBuilder != null) {
            searchRequest.source(sourceBuilder);
        }
        return searchRequest;
    }

    public static SearchRequest getSearchRequest(SearchRequest searchRequest, SearchSourceBuilder sourceBuilder) {
        if (searchRequest == null) {
            return null;
        }
        if (sourceBuilder != null) {
            searchRequest.source(sourceBuilder);
        }
        return searchRequest;
    }

    public static SearchSourceBuilder getSearchSourceBuilder() {
        return new SearchSourceBuilder();
    }

    public static SearchSourceBuilder getSearchSourceBuilder(QueryBuilder boolQuery, Boolean fetchSource, Integer from,
                                                             Integer size, List<SortBuilder<?>> datasSort) {
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        if (boolQuery != null) {
            sourceBuilder.query(boolQuery);
        }
        if (from != null && from >= 0) {
            sourceBuilder.from(from);
        }
        if (size != null && size >= 0) {
            sourceBuilder.size(size);
        }
        if (fetchSource != null) {
            sourceBuilder.fetchSource(fetchSource);
        }
        if (Utilities.isNotEmpty(datasSort)) {
            for (SortBuilder<?> sortBuilder : datasSort) {
                // sourceBuilder.sort(new FieldSortBuilder("_uid").order(SortOrder.ASC));
                sourceBuilder.sort(sortBuilder);
            }
        }
        sourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));

        return sourceBuilder;
    }

    public static SearchSourceBuilder getSearchSourceBuilder(QueryBuilder boolQuery) {
        return getSearchSourceBuilder(boolQuery, null, null, null, null);
    }

    public static SearchSourceBuilder getSearchSourceBuilder(QueryBuilder boolQuery, boolean fetchSource) {
        return getSearchSourceBuilder(boolQuery, fetchSource, null, null, null);
    }

    public static SearchSourceBuilder getSearchSourceBuilder(QueryBuilder boolQuery, int from, int size) {
        return getSearchSourceBuilder(boolQuery, null, from, size, null);
    }

    public static SearchSourceBuilder getSearchSourceBuilder(QueryBuilder boolQuery, List<SortBuilder<?>> datasSort) {
        return getSearchSourceBuilder(boolQuery, null, null, null, datasSort);
    }

    public static SearchSourceBuilder getSearchSourceBuilder(QueryBuilder boolQuery, int from, int size,
                                                             List<SortBuilder<?>> datasSort) {
        return getSearchSourceBuilder(boolQuery, null, from, size, datasSort);
    }

    public static UpdateRequest getUpdateRequest(String indexName, String typeName, String docId) {
        return new UpdateRequest(indexName, typeName, docId);
    }

    public static DeleteRequest getDeleteRequest(String indexName, String typeName, String docId) {
        return new DeleteRequest(indexName, typeName, docId);
    }

    public static boolean deleteIndex(HighClientFactory highClientFactory, String indexName) throws IOException {
        RestClient restClient = highClientFactory.getRestClient();
        Response   response   = restClient.performRequest(new Request("DELETE", "/" + indexName));
        return response.getStatusLine().getStatusCode() != HttpStatus.SC_NOT_FOUND;
    }

    public static IndexRequest getIndexRequest(String indexName, String typeName, String id) {
        return new IndexRequest(indexName, typeName, id);
    }

    public static IndexRequest getIndexRequest(String indexName, String typeName) {
        return new IndexRequest(indexName, typeName);
    }

    public static BulkRequest getBulkRequest(List<IndexRequest> datasIndexRequest,
                                             List<UpdateRequest> datasUpdateRequest, List<DeleteRequest> datasDeleteRequest,
                                             HighClientFactory highClientFactory, RefreshPolicy refreshPolicy, ActiveShardCount waitForActiveShards,
                                             TimeValue timeout) throws Exception {
        if (Utilities.isEmpty(datasIndexRequest) && Utilities.isEmpty(datasUpdateRequest)
                && Utilities.isEmpty(datasDeleteRequest)) {
            throw new RuntimeException("No requests to executed found !");
        }

        BulkRequest request = new BulkRequest();
        if (Utilities.isNotEmpty(datasIndexRequest)) {
            datasIndexRequest.forEach(e -> {
                if (e != null) {
                    request.add(e);
                }
            });
        }
        if (Utilities.isNotEmpty(datasUpdateRequest)) {
            datasUpdateRequest.forEach(e -> {
                if (e != null) {
                    request.add(e);
                }
            });
        }
        if (Utilities.isNotEmpty(datasDeleteRequest)) {
            datasDeleteRequest.forEach(e -> {
                if (e != null) {
                    request.add(e);
                }
            });
        }

        if (refreshPolicy == null) {
            refreshPolicy = RefreshPolicy.IMMEDIATE;
        }
        if (waitForActiveShards == null) {
            waitForActiveShards = ActiveShardCount.ALL;
        }

        request.setRefreshPolicy(refreshPolicy);
        request.waitForActiveShards(waitForActiveShards);
        request.timeout(timeout);

        return request;
    }

    public static BulkRequest getBulkRequest(List<DocWriteRequest> datasRequest, HighClientFactory highClientFactory,
                                             RefreshPolicy refreshPolicy, ActiveShardCount waitForActiveShards, TimeValue timeout) throws Exception {
        if (Utilities.isEmpty(datasRequest)) {
            throw new RuntimeException("No requests to executed found !");
        }

        BulkRequest request = new BulkRequest();
        datasRequest.forEach(req -> {
            request.add(req);
        });

        if (refreshPolicy == null) {
            refreshPolicy = RefreshPolicy.IMMEDIATE;
        }
        if (waitForActiveShards == null) {
            waitForActiveShards = ActiveShardCount.ALL;
        }

        request.setRefreshPolicy(refreshPolicy);
        request.waitForActiveShards(waitForActiveShards);
        request.timeout(timeout);

        return request;
    }

    /**
     * Création d'indedx avec le low level rest client
     *
     * @param indexName         Le nom de l'index
     * @param templatePath      Le chemin du mapping à appliquer à l'index. Ce
     *                          mapping doit comporter le type de l'index et si
     *                          besion les settings de l'index (nbre de shard,
     *                          replicat, max_result_window, ...)
     * @param highClientFactory Le high level rest client qui embarque un low level
     *                          rest client
     * @return true si l'index a été effectivement créé, i.e le code http de retour
     * vaut 200
     */
    public static Boolean createIndex(String indexName, String templatePath, HighClientFactory highClientFactory)
            throws Exception {
        if (highClientFactory == null) {
            return null;
        }
        RestClient restClient = highClientFactory.getRestClient();
        HttpEntity entity     = null;
        if (Utilities.isNotBlank(templatePath)) {
            ClassPathResource ressources = new ClassPathResource(templatePath);
            if (ressources.exists()) {
                String esTemplateName = ressources.getURL().getPath();
                String payload        = Utilities.readJsonDefn(esTemplateName);
                entity = new NStringEntity(payload, ContentType.APPLICATION_JSON);
            }
        }

        Request request = new Request("PUT", indexName);
        if (entity != null) {
            request.setEntity(entity);
        }

        Response response = restClient.performRequest(request);

        return response.getStatusLine().getStatusCode() == HttpStatus.SC_OK;
    }


    public static Boolean createIndex(String indexName, HighClientFactory highClientFactory) throws Exception {
        return createIndex(indexName, null, highClientFactory);
    }

    public static Boolean indicesExists(String indexName, HighClientFactory highClientFactory) throws IOException {
        if (highClientFactory == null) {
            return null;
        }

        Map<String, String> params = new HashMap<String, String>();

        HttpEntity entity = null;
//		Request request = new Request("HEAD", "/" + indexName, params, entity);
        Request  request  = new Request("HEAD", "/" + indexName);
        Response response = highClientFactory.getRestClient().performRequest(request);
        return response.getStatusLine().getStatusCode() != HttpStatus.SC_NOT_FOUND;
    }

    public static String[] getListOfExistingIndex(String[] list, HighClientFactory highClientFactory)
            throws IOException {
        List<String> listOfIndexes = new ArrayList<String>(Arrays.asList(list));
        List<String> toRemove      = new ArrayList<>();
        for (String indexName : listOfIndexes) {
            Boolean ifExistsResponse = null;
            try {
                ifExistsResponse = indicesExists(indexName, highClientFactory);
            } catch (UnknownHostException e) {
                toRemove.add(indexName);
            }
            if (ifExistsResponse != null && !ifExistsResponse) {
                toRemove.add(indexName);
            }
        }
        listOfIndexes.removeAll(toRemove);
        list = new String[listOfIndexes.size()];
        return listOfIndexes.toArray(list);
    }

    public static String catIndicesRequest(HighClientFactory highClientFactory, String indexPattern, String parameters,
                                           Integer indexNamePosition) throws ParseException, IOException {
        String req = "/_cat/indices";
        if (Utilities.isNotBlank(indexPattern)) {
            req += "/" + indexPattern;
        }
        if (Utilities.isNotBlank(parameters.toString())) {
            String[] params = parameters.split("&");
            parameters = "";
            for (String param : params) {
                if ((param.contains("=i") || param.contains(",i")) && !param.contains("index")) {
                    param = param.replace("=i", "=index").replace(",i", ",index");
                    // indexNamePosition = 0;
                }
                if (!parameters.isEmpty()) {
                    parameters += "&";
                }
                parameters += param;
            }
            if (!parameters.startsWith("?")) {
                parameters = "?" + parameters;
            }
            req += parameters;
            System.out.println("req = " + req);
        }
        return req;
    }

    public static Response catIndicesResponse(HighClientFactory highClientFactory,
                                              String indexPattern, String parameters, Integer indexNamePosition) throws ParseException, IOException {
        RestClient restClient = highClientFactory.getRestClient();

        String   req      = catIndicesRequest(highClientFactory, indexPattern, parameters, indexNamePosition);
        Request  request  = new Request("GET", req);
        Response response = restClient.performRequest(request);

        return response;
    }

    public static <T> List<?> catIndices(HighClientFactory highClientFactory, String indexPattern, String parameters,
                                         Integer indexNamePosition, Class<T> type) throws ParseException, IOException {
        Objects.requireNonNull(type, "The type of return elements can not be null");

        if (!Arrays.asList("String", "Map", "HashMap").contains(type.getSimpleName())) {
            throw new InvalidParameterException("The parametter <type> must be one of [String, Map, HashMap]");
        }

        List<Object> indices    = null;
        RestClient   restClient = highClientFactory.getRestClient();

        String   req      = catIndicesRequest(highClientFactory, indexPattern, parameters, indexNamePosition);
        Request  request  = new Request("GET", req);
        Response response = restClient.performRequest(request);
        if (response != null) {
            String rawBody = EntityUtils.toString(response.getEntity());
            // System.out.println("rawBody =  "+rawBody);
            if (Utilities.isNotBlank(rawBody)) {
                if (req.contains("format=json")) {
                    // parse the JSON response
                    ObjectMapper mapper = new ObjectMapper();
                    mapper.enable(SerializationFeature.INDENT_OUTPUT);

                    TypeReference<List<HashMap<String, String>>> typeRef = new TypeReference<List<HashMap<String, String>>>() {
                    };
                    List<HashMap<String, String>> list = mapper.readValue(rawBody, typeRef);

                    // get the index names
                    if (list != null) {
                        if (Arrays.asList("Map", "HashMap").contains(type.getSimpleName())) {
                            return list;
                        }
                        indices = list.stream().map(x -> x.get("index")).collect(Collectors.toList());
                    }
                } else {
                    String[] rows = rawBody.split(" ");
                    if (indexNamePosition == null || indexNamePosition < 0) {
                        indexNamePosition = 2;
                    }
                    indices = new ArrayList<Object>();
                    for (String row : rows) {
                        String[] datas = row.split(" ");
                        if (indexNamePosition < datas.length) {
                            indices.add(datas[indexNamePosition]);
                        }
                    }
                }
            }
        }
        return indices;
    }

    public static <T> List<?> catIndices(HighClientFactory highClientFactory, String indexPattern, Class<T> type)
            throws ParseException, IOException {
        return catIndices(highClientFactory, indexPattern, "?v&h=index&format=json", null, type);
    }

    public static <T> List<?> catIndices(HighClientFactory highClientFactory, Class<T> type)
            throws ParseException, IOException {
        return catIndices(highClientFactory, null, "?v&h=index&format=json", null, type);
    }
    
    // Get Index Documents Size
    @SuppressWarnings("deprecation")
//	public static long getIndexDocumentsSize(HighClientFactory highClientFactory, SearchSourceBuilder sourceBuilder, String... indices) throws IOException {
//    	CountRequest countRequest = new CountRequest(indices);
//		countRequest.source(sourceBuilder);
//		RestHighLevelClient client = highClientFactory.getClient();
//		CountResponse countResponse = client.count(countRequest, RequestOptions.DEFAULT);
//
//		return countResponse.getCount();
//    }
    
    public static RequestOptions getBuilderRequestOptions(Integer mbSize) {
    	RequestOptions.Builder builder = RequestOptions.DEFAULT.toBuilder();
		builder.setHttpAsyncResponseConsumerFactory(
		    new HttpAsyncResponseConsumerFactory
		    // change to {{mbSize}} mb 
		    .HeapBufferedResponseConsumerFactory(mbSize * 1024 * 1024));
		return builder.build();
    }
}
