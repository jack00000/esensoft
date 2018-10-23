package com.fangjun.esensoft_solr.impl;

import com.fangjun.esensoft_solr.pojo.Question;
import com.fangjun.esensoft_solr.solrInterface.DocsManager;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.beans.DocumentObjectBinder;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

import java.util.*;

import static com.fangjun.esensoft_solr.util.SolrUtil.client;

public class DocsManagerImpl implements DocsManager {

    @Override
    @Test
    public void addDocs(List<String> questions, int aid) throws Exception {
        DocumentObjectBinder binder = new DocumentObjectBinder();
        int total = questions.size();
        int count = 0;
        System.out.println("开始-------------------------" + total);
        for (String que : questions) {
            System.out.println(que.toString());
        }
        //先要把string数组变成question对象数组
        List<Question> questions1 = new ArrayList<>();
        for (int i = 0; i < questions.size(); i++) {
            Question q = new Question();
            q.setId(10 + i);
            q.setAid(aid);
            q.setQuestion(questions.get(i));
            questions1.add(q);
            System.out.println(q.toString());


        }
        //创建文档对象提交question对象数组
        for (Question question : questions1) {
            SolrInputDocument doc = binder.toSolrInputDocument(question);
            client.add(doc);
            System.out.printf("添加数据到索引中，总共要添加 %d 条记录，当前添加第%d条 %n", total, ++count);
        }
        client.commit();
        System.out.println("结束-----------------------");
    }

    @Override
    public void updateDocs(List<String> questions, int aid) throws Exception {
        DocumentObjectBinder binder = new DocumentObjectBinder();
        int total = questions.size();
        int count = 0;
        System.out.println("开始-------------------------" + total);
        for (String que : questions) {
            System.out.println(que.toString());
        }
        //先要把string数组变成question对象数组
        List<Question> questions1 = new ArrayList<>();
        for (int i = 0; i < questions.size(); i++) {
            Question q = new Question();
            q.setId(10 + i);
            q.setAid(aid);
            q.setQuestion(questions.get(i));
            questions1.add(q);


        }
        //创建文档对象提交question对象数组
        for (Question question : questions1) {
            SolrInputDocument doc = binder.toSolrInputDocument(question);
            client.add(doc);
            System.out.printf("添加数据到索引中，总共要添加 %d 条记录，当前添加第%d条 %n", total, ++count);
        }
        client.commit();

    }

    @Override
    public void deleteDocsByAid(int aid) throws Exception {
        //先查询到aid对应的所有id
        SolrQuery query = new SolrQuery();
        query.set("q", "aid:2");
        QueryResponse rsp = client.query(query);
        SolrDocumentList documents = rsp.getResults();
        System.out.println("累计找到的条数：" + documents.getNumFound());
        if (!documents.isEmpty()) {

            Collection<String> fieldNames = documents.get(0).getFieldNames();
            for (String fieldName : fieldNames) {
                System.out.print(fieldName + "\t");
            }
            System.out.println();
        }
        //int num=Integer.valueOf(documents.getNumFound());


        for (SolrDocument solrDocument : documents) {

            Collection<String> fieldNames = solrDocument.getFieldNames();

            for (String fieldName : fieldNames) {
                System.out.print(solrDocument.get(fieldName) + "\t");

            }
            System.out.println();

        }
        //把id存入ids  并在solr上删除
        List<String>ids=new ArrayList<>();
        for(int i=0;i<documents.size();i++){
            System.out.println(documents.get(i).getFieldValue("id"));
            ids.add(documents.get(i).getFieldValue("id").toString());
            System.out.println(ids.get(i).toString());

        }
        client.deleteById(ids);
        client.commit();



}

    @Override
    public Map<String, Integer> getSuggestQuestions(String word) throws Exception {
        return null;
    }


    public static void main(String[] args) throws Exception {
        /*//测试DocsManagerImpl的add方法
        List<String> questionsString=new ArrayList<>();


        for (int i = 0; i < 10; i++) {
            questionsString.add(new String("亿信华晨怎么样？" + i));
        }
        DocsManagerImpl docsManager=new DocsManagerImpl();
        docsManager.addDocs(questionsString,2);*/

        //测试deleteByAid
        DocsManagerImpl docsManager=new DocsManagerImpl();
        docsManager.deleteDocsByAid(2);
    }
}
