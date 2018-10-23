package com.fangjun.test.how2j_solr;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.junit.Test;

public class TestSolr4j {
    @Test
    public static void main(String[] args) throws SolrServerException, IOException {
       /* *//*List<Product> products = ProductUtil.file2list("/home/demo/Documents/idea_project/solr/src/main/java/com/fangjun/test/how2j_solr/140k_products.txt");
        SolrUtil.batchSaveOrUpdate(products);*//*
        //查询
     *//*   QueryResponse queryResponse = SolrUtil.query("name:手机",0,10);
        SolrDocumentList documents= queryResponse.getResults();
        System.out.println("累计找到的条数："+documents.getNumFound());
        if(!documents.isEmpty()){

            Collection<String> fieldNames = documents.get(0).getFieldNames();
            for (String fieldName : fieldNames) {
                System.out.print(fieldName+"\t");
            }
            System.out.println();
        }

        for (SolrDocument solrDocument : documents) {

            Collection<String> fieldNames= solrDocument.getFieldNames();

            for (String fieldName : fieldNames) {
                System.out.print(solrDocument.get(fieldName)+"\t");

            }
            System.out.println();

        }*//*
        //高亮查询查询
        //SolrUtil.queryHighlight("name:手机");
        String keyword = "name:鞭";
        System.out.println("修改之前");
        query(keyword);

        Product p = new Product();
        p.setId(51173);
        p.setName("修改后的神鞭");
        SolrUtil.saveOrUpdate(p);
        System.out.println("修改之后");
        query(keyword);

        SolrUtil.deleteById("51173");
        System.out.println("删除之后");
        query(keyword);

    }
    private static void query(String keyword) throws SolrServerException, IOException {
        QueryResponse queryResponse = SolrUtil.query(keyword,0,10);
        SolrDocumentList documents= queryResponse.getResults();
        System.out.println("累计找到的条数："+documents.getNumFound());
        if(!documents.isEmpty()){

            Collection<String> fieldNames = documents.get(0).getFieldNames();
            for (String fieldName : fieldNames) {
                System.out.print(fieldName+"\t");
            }
            System.out.println();
        }

        for (SolrDocument solrDocument : documents) {

            Collection<String> fieldNames= solrDocument.getFieldNames();

            for (String fieldName : fieldNames) {
                System.out.print(solrDocument.get(fieldName)+"\t");

            }
            System.out.println();

        }*/
    }

}