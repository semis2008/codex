package com.codex.controller.util;

/**
 * @ClassName: PageUtil
 * @Description: 分页处理
 * @author chenweina
 * @date 2015年6月11日 下午6:16:05
 * 
 */
public class PageUtil {
	private int totalCount; // 总条数
	private int pageSize; // 每页显示条数
	private int pageNo; // 当前页数
	private int nextPage; // 下一页
	private int pageEnd;
	private int pageStart;
	private int totalPages;

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	/**
	 * 返回总页数
	 * 
	 * @return
	 */
	public int getTotalPages() {
		if (totalCount % pageSize == 0) {
			totalPages = totalCount / pageSize;
		} else {
			totalPages = totalCount / pageSize + 1;
		}
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	/**
	 * 返回下一页页数
	 * 
	 * @return
	 */
	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	/**
	 * 是否有下一页
	 * 
	 * @return
	 */
	public String hasNextPage() {
		return pageNo < getTotalPages() ? "true" : "";
	}


	/**
	 * 获取一页数据的开始位置
	 * 
	 * @return
	 */
	public int getPageStart() {
		return pageStart;
	}

	public void setPageStart(int pageStart) {
		this.pageStart = pageStart;
	}


	/**
	 * 获取一页数据的结束位置
	 * 
	 * @return
	 */
	public int getPageEnd() {
		return pageEnd;
	}

	public void setPageEnd(int pageEnd) {
		this.pageEnd = pageEnd;
	}

}
