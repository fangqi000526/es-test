package com.fangqi.test.index;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;

/**
 * @author 方琪
 * @date 2022/4/10 22:38:49
 */
public class ESTestIndexCreate {
    public static void main(String[] args) throws Exception{

        // 创建ES客户端
        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("127.0.0.1", 9200, "http"))
        );

        // 创建索引
        CreateIndexRequest request = new CreateIndexRequest("user");
        CreateIndexResponse indexResponse
                = esClient.indices().create(request, RequestOptions.DEFAULT);
        // 响应状态
        boolean acknowledged = indexResponse.isAcknowledged();
        System.out.println("索引操作：" + acknowledged);

        // 关闭ES客户端
        esClient.close();
    }
}
