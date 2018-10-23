package com.fangjun.esensoft_solr.pojo;

import org.apache.solr.client.solrj.beans.Field;

public class Question {
    @Field
    int id;
    @Field
    int aid;
    @Field
    String question;

    @Override
    public String toString() {
        return "Product [id=" + id + ", aid=" + aid + ", question=" + question  + "]";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
