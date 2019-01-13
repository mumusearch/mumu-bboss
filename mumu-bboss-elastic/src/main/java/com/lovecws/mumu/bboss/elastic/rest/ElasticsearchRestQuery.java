package com.lovecws.mumu.bboss.elastic.rest;

import org.apache.log4j.Logger;
import org.frameworkset.elasticsearch.ElasticSearchHelper;
import org.frameworkset.elasticsearch.client.ClientInterface;
import org.frameworkset.elasticsearch.entity.ESDatas;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: mumu-bboss
 * @description: es的rest接口查询
 * @author: 甘亮
 * @create: 2019-01-13 10:16
 **/
public class ElasticsearchRestQuery {

    private static final Logger log = Logger.getLogger(ElasticsearchRestQuery.class);

    public Map<String, Object> query(String indexName, String dslQuery) {
        ClientInterface clientUtil = ElasticSearchHelper.getRestClientUtil();
        ESDatas<Map> esDatas = clientUtil.searchList(indexName + "/_search",
                dslQuery,
                Map.class);
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("total", esDatas.getTotalSize());
        resultMap.put("data", esDatas.getDatas());
        resultMap.put("aggregations", esDatas.getAggregations());
        return resultMap;
    }
}
