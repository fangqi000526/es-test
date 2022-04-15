package com.fangqi.test.index;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;

/**
 * @author 方琪
 * @date 2022/4/10 22:38:49
 */
public class ESTestClient {
    public static void main(String[] args) throws Exception{

        // 创建ES客户端
        RestHighLevelClient levelClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("127.0.0.1", 9200, "http"))
        );

        // 关闭ES客户端
        levelClient.close();
    }
}
