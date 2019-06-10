package cn.edu.uestc.aone.web.helloworld.dao.es;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;

import cn.edu.uestc.aone.web.helloworld.config.ElasticSearchClientFactory;
import cn.edu.uestc.aone.web.helloworld.model.po.es.ItemBaseDoc;
import org.springframework.stereotype.Repository;


/**
 * 处理Item数据的Elasticesarch Repository
 * Created by Carter Peng 2018/10/14
 */
@Repository
public class ItemRepo {
    @Autowired
    private ElasticSearchClientFactory elasticSearchClientFactory;

    /**
     * 根据关键词搜索Item列表
     * @param keyword 关键词
     * @param pageable 包含分页编号与大小
     * @return 查询结果List<ItemBaseDoc>
     */
    public List<ItemBaseDoc> findByKeyword(String keyword, Pageable pageable){
        // 获取ES Client
        Client client = elasticSearchClientFactory.getInstance();
        // 构建搜索语句、执行并返回结果
        QueryBuilder matchAllQuery = QueryBuilders.multiMatchQuery(keyword, "item_name",
                "powersource", "item_object", "department.department_fullname", "category.category_fullname",
                "material.material_name", "material.material_source", "basis.basis_name", "flow.transactor_name");
        SearchResponse response = client.prepareSearch()
                .setFrom(pageable.getPageNumber())
                .setSize(pageable.getPageSize())
                .setQuery(matchAllQuery)
                .execute()
                .actionGet();

        // 将搜索结果封装到ItemBaseDoc持久化对象
        List<SearchHit> searchHits = Arrays.asList(response.getHits().getHits());
        List<ItemBaseDoc> itemBaseDocs = new ArrayList<>(searchHits.size());

        for(SearchHit hit: searchHits){
            ItemBaseDoc doc = new ItemBaseDoc();
            doc.setId(hit.getId());
            Map map = hit.getSourceAsMap();

            if(map.get("item_id") != null)
            doc.setItem_id((Integer) map.get("item_id"));

            if(map.get("item_code") != null)
            doc.setItem_code((String) map.get("item_code"));

            if(map.get("item_name") != null)
            doc.setItem_name((String) map.get("item_name"));

            if(map.get("department_id") != null)
            doc.setDepartment_id((Integer) map.get("department_id"));

            if(map.get("category_id") != null)
            doc.setCategory_id((Integer) map.get("category_id"));

            if(map.get("parent_name") != null)
            doc.setParent_name((String) map.get("parent_name"));

            itemBaseDocs.add(doc);
        }

        return itemBaseDocs;
    }
}
