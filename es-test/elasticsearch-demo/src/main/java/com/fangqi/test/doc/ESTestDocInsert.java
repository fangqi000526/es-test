package com.fangqi.test.doc;

import com.fangqi.test.pojo.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

/**
 * @author 方琪
 * @date 2022/4/11 12:44:52
 */
public class ESTestDocInsert {
    public static void main(String[] args) throws Exception {

        // 创建ES客户端
        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("127.0.0.1", 9200, "http"))
        );

        // 插入数据
        IndexRequest indexRequest = new IndexRequest();
        // 指定索引和ID
        indexRequest.index("user").id("1002");

        User user = new User("张四", "男", 30);

        // ES插入数据必须将数据转换为JSON格式
        ObjectMapper mapper = new ObjectMapper();
        String userJson = mapper.writeValueAsString(user);
        // 设置数据源
        indexRequest.source(userJson, XContentType.JSON);

        IndexResponse indexResponse = esClient.index(indexRequest, RequestOptions.DEFAULT);
        System.out.println(indexResponse.getResult());

        // 关闭ES客户端
        esClient.close();
    }
}
