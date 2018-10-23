package com.fangjun.esensoft_solr;

import com.fangjun.esensoft_solr.impl.DocsManagerImpl;
import com.fangjun.esensoft_solr.pojo.Question;
import com.fangjun.esensoft_solr.service.DocsManagerService;
import com.fangjun.esensoft_solr.solrInterface.DocsManager;
import com.fangjun.esensoft_solr.util.QuestionUtil;
import com.fangjun.esensoft_solr.util.SolrUtil;

import java.util.ArrayList;
import java.util.List;

public class TestSolr {


    public static void main(String arg[]) throws Exception{
        List<Question> questions = QuestionUtil.file2list("/home/demo/Documents/idea_project/solr/src/main/java/com/fangjun/esensoft_solr/robot.txt");
        SolrUtil.batchSaveOrUpdate(questions);




    }
}
