package com.lovecws.mumu.bboss.elastic.common;

import org.frameworkset.elasticsearch.ElasticSearchHelper;
import org.frameworkset.elasticsearch.client.ClientInterface;

import java.util.List;
import java.util.Map;

/**
 * @program: mumu-bboss
 * @description: 基本操作
 * @author: 甘亮
 * @create: 2019-01-13 13:00
 **/
public class ElasticsearchIndex {

    public void createIndex(String indexName, String indexMapping) {
        ClientInterface restClientUtil = ElasticSearchHelper.getRestClientUtil();
        String mapping = restClientUtil.createIndiceMapping(indexName, indexMapping);

    }


    public void search(String indexName, String indexMapping) {
        ClientInterface restClientUtil = ElasticSearchHelper.getRestClientUtil();
    }


    public String addDateDocument(String indexName, String typeName, Map<String, Object> body) {
        ClientInterface restClientUtil = ElasticSearchHelper.getRestClientUtil();
        return restClientUtil.addDateDocument(indexName, typeName, body);
    }


    public String addDateDocuments(String indexName, String typeName, List<Map<String, Object>> bodys) {
        ClientInterface restClientUtil = ElasticSearchHelper.getRestClientUtil();
        return restClientUtil.addDateDocuments(indexName, typeName, bodys);
    }
}
