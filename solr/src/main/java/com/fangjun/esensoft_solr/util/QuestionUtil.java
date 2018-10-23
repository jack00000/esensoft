package com.fangjun.esensoft_solr.util;

import com.fangjun.esensoft_solr.pojo.Question;
import com.fangjun.test.how2j_solr.Product;
import org.apache.commons.io.FileUtils;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QuestionUtil {
    public static void main(String[] args) throws IOException, InterruptedException, AWTException {

        String fileName = "/home/demo/Documents/idea_project/solr/src/main/java/com/fangjun/esensoft_solr/robot.txt";

        java.util.List<Question> questions = file2list(fileName);

        System.out.println(questions.size());

    }

    public static java.util.List<Question> file2list(String fileName) throws IOException {
        File f = new File(fileName);
        java.util.List<String> lines = FileUtils.readLines(f,"UTF-8");
        List<Question> questions = new ArrayList<>();
        for (String line : lines) {
            List<Question> questions1 = line2question(line);
            Iterator<Question> it= questions1.iterator();
            while(it.hasNext()){
                    Question question = it.next();
                    questions.add(question);
                System.out.println(question.toString());
            }

        }
        return questions;
    }

    private static List<Question> line2question(String line) {

        String[] fields = line.split(",");
        for(int i=0;i<fields.length;i++) {
            System.out.println(fields[i]);
        }


        List<Question> questions=new ArrayList<>();
        for(int i=5;i<15;i++){
            Question q = new Question();
            q.setId(i-5);
            q.setAid(Integer.valueOf(fields[0]).intValue());
            q.setQuestion(fields[i]);
            questions.add(q);
        }



        return questions;
    }

}
