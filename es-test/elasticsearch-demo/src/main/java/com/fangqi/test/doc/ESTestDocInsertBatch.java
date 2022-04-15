package com.fangqi.test.doc;

import com.fangqi.test.pojo.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

import java.util.Arrays;

/**
 * @author 方琪
 * @date 2022/4/11 12:44:52
 */
public class ESTestDocInsertBatch {
    public static void main(String[] args) throws Exception {

        // 创建ES客户端
        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("127.0.0.1", 9200, "http"))
        );

        // 批量插入数据
        BulkRequest bulkRequest = new BulkRequest();
        bulkRequest.add(new IndexRequest().index("user").id("1009").source(XContentType.JSON, "name", "wangwu1", "age", 30, "gender", "男"));
        bulkRequest.add(new IndexRequest().index("user").id("1011").source(XContentType.JSON, "name", "wangwu11", "age", 30, "gender", "女"));
        bulkRequest.add(new IndexRequest().index("user").id("1012").source(XContentType.JSON, "name", "wangwu111", "age", 40, "gender", "男"));
        bulkRequest.add(new IndexRequest().index("user").id("1013").source(XContentType.JSON, "name", "wangwu2", "age", 40, "gender", "女"));
        bulkRequest.add(new IndexRequest().index("user").id("1014").source(XContentType.JSON, "name", "wangwu22", "age", 50, "gender", "男"));
        bulkRequest.add(new IndexRequest().index("user").id("1010").source(XContentType.JSON, "name", "wangwu224", "age", 50, "gender", "男"));

        BulkResponse bulk = esClient.bulk(bulkRequest, RequestOptions.DEFAULT);
        System.out.println("花费时间：" + bulk.getTook());
        System.out.println("多个响应：" + Arrays.toString(bulk.getItems()));

        // 关闭ES客户端
        esClient.close();
    }
}
