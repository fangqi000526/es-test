package com.fangqi.test.doc;

import org.apache.http.HttpHost;
import org.apache.lucene.search.suggest.analyzing.FuzzySuggester;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.*;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.AggregationBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.sort.SortOrder;

import javax.swing.text.Highlighter;
import java.util.Arrays;

/**
 * @author 方琪
 * @date 2022/4/11 12:44:52
 */
public class ESTestDocQuery {
    public static void main(String[] args) throws Exception {

        // 创建ES客户端
        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("127.0.0.1", 9200, "http"))
        );

        // 1、查询索引中全部的数据
        //SearchRequest searchRequest = new SearchRequest();
        //searchRequest.indices("user");
        //// 构建查询条件
        //searchRequest.source(new SearchSourceBuilder().query(QueryBuilders.matchAllQuery()));
        //
        //SearchResponse searchResponse = esClient.search(searchRequest, RequestOptions.DEFAULT);
        //
        //SearchHits hits = searchResponse.getHits();
        //// 命中数量
        //System.out.println(hits.getTotalHits());
        //// 消耗时间
        //System.out.println(searchResponse.getTook());
        //// 循环打印获取到的数据
        //for (SearchHit hit : hits) {
        //    System.out.println(hit.getSourceAsString());
        //}

        // 2、条件查询：termQuery
        //SearchRequest searchRequest = new SearchRequest();
        //searchRequest.indices("user");
        //// 构建查询条件
        //searchRequest.source(new SearchSourceBuilder().query(QueryBuilders.termQuery("age", 30)));
        //
        //SearchResponse searchResponse = esClient.search(searchRequest, RequestOptions.DEFAULT);
        //
        //SearchHits hits = searchResponse.getHits();
        //// 命中数量
        //System.out.println(hits.getTotalHits());
        //// 消耗时间
        //System.out.println(searchResponse.getTook());
        //// 循环打印获取到的数据
        //for (SearchHit hit : hits) {
        //    System.out.println(hit.getSourceAsString());
        //}

        // 3、分页查询
        //SearchRequest searchRequest = new SearchRequest();
        //searchRequest.indices("user");
        //// 构建查询条件
        //SearchSourceBuilder queryBuilder = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
        //// （当前页码-1）* 每页数据条数
        //queryBuilder.from(2);
        //queryBuilder.size(2);
        //searchRequest.source(queryBuilder);
        //
        //SearchResponse searchResponse = esClient.search(searchRequest, RequestOptions.DEFAULT);
        //
        //SearchHits hits = searchResponse.getHits();
        //// 命中数量
        //System.out.println(hits.getTotalHits());
        //// 消耗时间
        //System.out.println(searchResponse.getTook());
        //// 循环打印获取到的数据
        //for (SearchHit hit : hits) {
        //    System.out.println(hit.getSourceAsString());
        //}


        // 4、查询排序
        //SearchRequest searchRequest = new SearchRequest();
        //searchRequest.indices("user");
        //// 构建查询条件
        //SearchSourceBuilder queryBuilder = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
        //// （当前页码-1）* 每页数据条数
        //queryBuilder.sort("age", SortOrder.DESC);
        //searchRequest.source(queryBuilder);
        //
        //SearchResponse searchResponse = esClient.search(searchRequest, RequestOptions.DEFAULT);
        //
        //SearchHits hits = searchResponse.getHits();
        //// 命中数量
        //System.out.println(hits.getTotalHits());
        //// 消耗时间
        //System.out.println(searchResponse.getTook());
        //// 循环打印获取到的数据
        //for (SearchHit hit : hits) {
        //    System.out.println(hit.getSourceAsString());
        //}

        // 5、过滤字段
        //SearchRequest searchRequest = new SearchRequest();
        //searchRequest.indices("user");
        //// 构建查询条件
        //SearchSourceBuilder queryBuilder = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
        //// 包括字段
        //String[] includes = {"name"};
        //// 排除字段
        //String[] excludes = {"age"};
        //queryBuilder.fetchSource(includes, excludes);
        //searchRequest.source(queryBuilder);
        //
        //SearchResponse searchResponse = esClient.search(searchRequest, RequestOptions.DEFAULT);
        //
        //SearchHits hits = searchResponse.getHits();
        //// 命中数量
        //System.out.println(hits.getTotalHits());
        //// 消耗时间
        //System.out.println(searchResponse.getTook());
        //// 循环打印获取到的数据
        //for (SearchHit hit : hits) {
        //    System.out.println(hit.getSourceAsString());
        //}

        // 6、组合查询
        //SearchRequest searchRequest = new SearchRequest();
        //searchRequest.indices("user");
        //// 构建查询条件
        //SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        //
        //BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();
        //
        //// 范围
        //RangeQueryBuilder rangeQueryBuilder = QueryBuilders.rangeQuery("age");
        //rangeQueryBuilder.gte(40);
        //rangeQueryBuilder.lte(60);
        //boolQueryBuilder.filter(rangeQueryBuilder);

        // 7、字段条件
        //boolQueryBuilder.must(QueryBuilders.matchQuery("age", 30));
        //boolQueryBuilder.mustNot(QueryBuilders.matchPhraseQuery("name", "老七"));
        //boolQueryBuilder.should(QueryBuilders.matchQuery("gender", "男"));
        //boolQueryBuilder.should(QueryBuilders.matchQuery("gender", "女"));
        //
        //searchSourceBuilder.query(boolQueryBuilder);
        //
        //searchRequest.source(searchSourceBuilder);
        //
        //SearchResponse searchResponse = esClient.search(searchRequest, RequestOptions.DEFAULT);
        //
        //SearchHits hits = searchResponse.getHits();
        //// 命中数量
        //System.out.println(hits.getTotalHits());
        //// 消耗时间
        //System.out.println(searchResponse.getTook());
        //// 循环打印获取到的数据
        //for (SearchHit hit : hits) {
        //    System.out.println(hit.getSourceAsString());
        //}

        // 8、模糊查询
        //SearchRequest searchRequest = new SearchRequest();
        //searchRequest.indices("user");
        //
        //SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        //
        //// fuzziness(Fuzziness.ONE)) 表示偏差一个字符。注意中文会被分词查询
        ////searchSourceBuilder.query(QueryBuilders.fuzzyQuery("name", "wangwu").fuzziness(Fuzziness.ONE));
        //searchSourceBuilder.query(QueryBuilders.fuzzyQuery("name", "王四").fuzziness(Fuzziness.ONE));
        //
        //searchRequest.source(searchSourceBuilder);
        //SearchResponse searchResponse = esClient.search(searchRequest, RequestOptions.DEFAULT);
        //
        //SearchHits hits = searchResponse.getHits();
        //// 命中数量
        //System.out.println(hits.getTotalHits());
        //// 消耗时间
        //System.out.println(searchResponse.getTook());
        //// 循环打印获取到的数据
        //for (SearchHit hit : hits) {
        //    System.out.println(hit.getSourceAsString());
        //}

        // 9、高亮查询
        //SearchRequest searchRequest = new SearchRequest();
        //searchRequest.indices("user");
        //
        //SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        //
        //TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("name", "wangwu1");
        //
        //HighlightBuilder highlightBuilder = new HighlightBuilder();
        //// 前缀标签
        //highlightBuilder.preTags("<font color='red'>");
        //// 后缀标签
        //highlightBuilder.postTags("</font>");
        //// 选择高亮字段
        //highlightBuilder.field("name");
        //
        //searchSourceBuilder.query(termQueryBuilder);
        //searchRequest.source(searchSourceBuilder.highlighter(highlightBuilder));
        //SearchResponse searchResponse = esClient.search(searchRequest, RequestOptions.DEFAULT);
        //
        //SearchHits hits = searchResponse.getHits();
        //// 命中数量
        //System.out.println(hits.getTotalHits());
        //// 消耗时间
        //System.out.println(searchResponse.getTook());
        //// 循环打印获取到的数据
        //for (SearchHit hit : hits) {
        //    System.out.println(hit.getHighlightFields());
        //    System.out.println(hit.getSourceAsString());
        //}

        // 9、聚合查询
        //SearchRequest searchRequest = new SearchRequest();
        //searchRequest.indices("user");
        //
        //SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        //
        //AggregationBuilder aggregationBuilder = AggregationBuilders.max("maxAge").field("age");
        //
        //searchSourceBuilder.aggregation(aggregationBuilder).size(1000);
        //
        //searchRequest.source(searchSourceBuilder);
        //SearchResponse searchResponse = esClient.search(searchRequest, RequestOptions.DEFAULT);
        //
        //Aggregations aggregations = searchResponse.getAggregations();
        //// 命中数量
        //System.out.println(searchResponse);
        //// 消耗时间
        //System.out.println(searchResponse.getTook());
        //// 循环打印获取到的数据
        //for (Aggregation aggregation : aggregations) {
        //    System.out.println(aggregation.getName());
        //    System.out.println(aggregation.getMetadata());
        //}

        // 10、分组查询（聚合查询）
        SearchRequest searchRequest = new SearchRequest();
        searchRequest.indices("user");

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

        AggregationBuilder aggregationBuilder = AggregationBuilders.terms("ageGroup").field("age");

        searchSourceBuilder.aggregation(aggregationBuilder).size(1000);

        searchRequest.source(searchSourceBuilder);
        SearchResponse searchResponse = esClient.search(searchRequest, RequestOptions.DEFAULT);

        Aggregations aggregations = searchResponse.getAggregations();
        // 命中数量
        System.out.println(searchResponse);
        // 消耗时间
        System.out.println(searchResponse.getTook());
        // 循环打印获取到的数据
        for (Aggregation aggregation : aggregations) {
            System.out.println(aggregation.getName());
            System.out.println(aggregation.getMetadata());
        }

        // 关闭ES客户端
        esClient.close();
    }
}
