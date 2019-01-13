package com.lovecws.mumu.bboss.elastic.rest;

import com.alibaba.fastjson.JSON;
import junit.framework.TestCase;
import org.apache.log4j.Logger;

import java.util.Map;

/**
 * @program: mumu-bboss
 * @description: rest接口测试
 * @author: 甘亮
 * @create: 2019-01-13 10:31
 **/
public class ElasticsearchRestQueryTest extends TestCase {

    private static final Logger log = Logger.getLogger(ElasticsearchRestQuery.class);
    private ElasticsearchRestQuery elasticsearchRestQuery = new ElasticsearchRestQuery();

    public void testQuery() {
        Map<String, Object> resultMap = elasticsearchRestQuery.query("guangdong_jmr", "{\n" +
                "  \"size\": 0,\n" +
                "  \"aggs\": {\n" +
                "    \"ipCouner\": {\n" +
                "      \"terms\": {\n" +
                "        \"field\": \"malware_behavior_type\",\n" +
                "        \"size\": 10\n" +
                "      }\n" +
                "    }\n" +
                "  }\n" +
                "}");
        log.info(JSON.toJSONString(resultMap));
    }
}
