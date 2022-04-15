package com.fangqi.test.doc;

import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

import java.util.Arrays;

/**
 * @author 方琪
 * @date 2022/4/11 12:44:52
 */
public class ESTestDocDeleteBatch {
    public static void main(String[] args) throws Exception {

        // 创建ES客户端
        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("127.0.0.1", 9200, "http"))
        );

        // 批量删除数据
        BulkRequest bulkRequest = new BulkRequest();
        bulkRequest.add(new DeleteRequest().index("user").id("1003"));
        bulkRequest.add(new DeleteRequest().index("user").id("1004"));
        bulkRequest.add(new DeleteRequest().index("user").id("1005"));

        BulkResponse bulk = esClient.bulk(bulkRequest, RequestOptions.DEFAULT);
        System.out.println("花费时间：" + bulk.getTook());
        System.out.println("多个响应：" + Arrays.toString(bulk.getItems()));

        // 关闭ES客户端
        esClient.close();
    }
}
