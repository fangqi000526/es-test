package com.fangqi.test.doc;

import org.apache.http.HttpHost;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

/**
 * @author 方琪
 * @date 2022/4/11 12:44:52
 */
public class ESTestDocUpdate {
    public static void main(String[] args) throws Exception {

        // 创建ES客户端
        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("127.0.0.1", 9200, "http"))
        );

        // 修改数据
        UpdateRequest updateRequest = new UpdateRequest();
        // 指定索引和ID
        updateRequest.index("user").id("1011");
        // 局部修改
        updateRequest.doc(XContentType.JSON, "name", "wangwu1");

        UpdateResponse updateResponse = esClient.update(updateRequest, RequestOptions.DEFAULT);
        System.out.println(updateResponse.getResult());

        // 关闭ES客户端
        esClient.close();
    }
}
