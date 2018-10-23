package com.fangjun.esensoft_solr.solrInterface;

import java.util.List;
import java.util.Map;

/**
 * 索引管理器
 * 
 * @author esen
 *
 */
public interface DocsManager {
	/**
	 * 添加一个索引
	 * 
	 * @param questions 不同的答案可以有多种问法 
	 * @param aid 答案的id
	 * @throws Exception
	 */
	public void addDocs(List<String> questions, int aid) throws Exception;

	/**
	 * 更新这个问题的索引
	 * 
	 * @param questions 不同的答案可以有多种问法 
	 * @param aid 答案的id
	 * @throws Exception
	 */
	public void updateDocs(List<String> questions, int aid) throws Exception;

	/**
	 * 根据答案id去删除索引,删除问题时要调用此方法删除这个答案和它的所有问题
	 * 
	 * @param aid
	 * @throws Exception
	 */
	public void deleteDocsByAid(int aid) throws Exception;

	/**
	 * 根据关键词，查找此关键词对应的问题和答案返回给前端
	 * 
	 * @param word 短语
	 * @return
	 * @throws Exception
	 */
	public Map<String, Integer> getSuggestQuestions(String word) throws Exception;

}