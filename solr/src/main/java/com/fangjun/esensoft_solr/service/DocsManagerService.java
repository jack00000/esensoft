package com.fangjun.esensoft_solr.service;

import com.fangjun.esensoft_solr.impl.DocsManagerImpl;
import com.fangjun.esensoft_solr.solrInterface.DocsManager;

import java.util.List;

public class DocsManagerService {
    private DocsManagerImpl docsManagerImpl;

    public void addDocs(List<String> questions ,int aid) throws Exception {
        docsManagerImpl.addDocs(questions,aid);
    }
}
