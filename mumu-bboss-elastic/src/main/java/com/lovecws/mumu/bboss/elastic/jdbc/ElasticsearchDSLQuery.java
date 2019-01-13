package com.lovecws.mumu.bboss.elastic.jdbc;

import org.frameworkset.elasticsearch.ElasticSearchHelper;
import org.frameworkset.elasticsearch.client.ClientInterface;
import org.frameworkset.elasticsearch.entity.ESDatas;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: mumu-bboss
 * @description: dsl查询
 * @author: 甘亮
 * @create: 2019-01-13 11:23
 **/
public class ElasticsearchDSLQuery {

    public Map<String, Object> dsl(String indexName, String dslName, String queryName, Map<String, Object> params) {
        ClientInterface clientUtil = ElasticSearchHelper.getConfigRestClientUtil(dslName);
        ESDatas<Map> esDatas = clientUtil.searchList(indexName + "/_search", queryName, params, Map.class);
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("total", esDatas.getTotalSize());
        resultMap.put("data", esDatas.getDatas());
        resultMap.put("aggregations", esDatas.getAggregations());
        return resultMap;
    }

    public Map<String, Object> sql(String sql, Map<String, Object> params) {
        ClientInterface restClientUtil = ElasticSearchHelper.getRestClientUtil();
        ESDatas<Map> esDatas = restClientUtil.searchList("/_sql", sql, params, Map.class);
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("total", esDatas.getTotalSize());
        resultMap.put("data", esDatas.getDatas());
        return resultMap;
    }
}
