package com.lovecws.mumu.bboss.elastic.jdbc;

import com.alibaba.fastjson.JSON;
import junit.framework.TestCase;
import org.apache.commons.lang.time.DateUtils;
import org.apache.log4j.Logger;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: mumu-bboss
 * @description: dsl查询
 * @author: 甘亮
 * @create: 2019-01-13 11:29
 **/
public class ElasticsearchDSLQueryTest extends TestCase {


    private static final Logger log = Logger.getLogger(ElasticsearchDSLQueryTest.class);
    private ElasticsearchDSLQuery elasticsearchDSLQuery = new ElasticsearchDSLQuery();

    public void testDsl() {
        Map<String, Object> map = new HashMap<>();
        map.put("count", "4");
        Map<String, Object> resultMap = elasticsearchDSLQuery.dsl("guangdong_jmr", "dsl/jmr.xml", "groupByMalwareBehaviorType", map);
        log.info(JSON.toJSONString(resultMap));
    }

    public void testEventTrend() throws ParseException {
        Map<String, Object> map = new HashMap<>();
        map.put("provinceName", "广东");
        map.put("interval", "1h");
        map.put("startTime", DateUtils.parseDate("2019-01-01", new String[]{"yyyy-MM-dd"}).getTime());
        map.put("endTime", null);
        Map<String, Object> resultMap = elasticsearchDSLQuery.dsl("guangdong_jmr", "dsl/jmr.xml", "eventTrend", map);
        log.info(JSON.toJSONString(resultMap));
    }

    public void testSelectPage() throws ParseException {
        Map<String, Object> map = new HashMap<>();
        map.put("provinceName", "广东");
        map.put("startTime", DateUtils.truncate(new Date(), Calendar.YEAR).getTime());
        map.put("endTime", new Date().getTime());
        map.put("from", 100);
        map.put("size", 10);
        Map<String, Object> resultMap = elasticsearchDSLQuery.dsl("guangdong_jmr", "dsl/jmr.xml", "searchPagineDatas", map);
        log.info(JSON.toJSONString(resultMap));
    }

    public void testSql() {
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> resultMap = elasticsearchDSLQuery.sql("select *from guangdong_jmr limit 10", map);
        log.info(JSON.toJSONString(resultMap));
    }
}
