package com.yunkouan.common.page;

import java.util.List;

/**
 * 分页用公共类
 * 
 * @author lify
 *
 * @param <T>
 */
public class Page<T> {
	private int pageSize;// 页面显示条数
	private int totalPage;// 总页数
	private int currentPage = 1;// 当前页

	private int nextPage;// 下一页
	private int previousPage;// 前一页

	private boolean hasNext;// 是否有下一页
	private boolean hasPrevious;// 是否有前一页

	private int firstResult;// 开始索引
	private int totalItems;// 数据库总记录数
	private List<T> list;// 当前显示记录

	// 总记录、每页显示的记录、当前页
	public Page(int totalItems, int pageSize, int currentPage) {
		this.pageSize = pageSize;
		this.totalItems = totalItems;
		this.currentPage = currentPage;

		if (totalItems < 1) {
			return;
		}

		// 先算出总页数
		this.totalPage = (totalItems + pageSize - 1) / pageSize;

		if (totalPage == 0) { // pageSize==1
			return;
		}

		// (-1 代表) 最后一页
		if (this.currentPage == -1) {
			this.currentPage = this.totalPage;
		}

		// 如果指定的页码小于 1, 置页码为第一页
		if (this.currentPage < 1) {
			this.currentPage = 1;
		}

		// 如果指定的页码大于总页数, 置页码为最后一页
		if (this.currentPage > this.totalPage) {
			this.currentPage = this.totalPage;
		}

		this.nextPage = currentPage + 1;
		this.previousPage = currentPage - 1;

		this.hasNext = (this.currentPage < this.totalPage);
		this.hasPrevious = (this.currentPage > 1);

		// 本页第一条记录的索引(从 0 开始)
		this.firstResult = (this.currentPage - 1) * pageSize;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	public int getPreviousPage() {
		return previousPage;
	}

	public void setPreviousPage(int previousPage) {
		this.previousPage = previousPage;
	}

	public boolean isHasNext() {
		return hasNext;
	}

	public void setHasNext(boolean hasNext) {
		this.hasNext = hasNext;
	}

	public boolean isHasPrevious() {
		return hasPrevious;
	}

	public void setHasPrevious(boolean hasPrevious) {
		this.hasPrevious = hasPrevious;
	}

	public int getFirstResult() {
		return firstResult;
	}

	public void setFirstResult(int firstResult) {
		this.firstResult = firstResult;
	}

	public int getTotalItems() {
		return totalItems;
	}

	public void setTotalItems(int totalItems) {
		this.totalItems = totalItems;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "Page [pageSize=" + pageSize + ", totalPage=" + totalPage
				+ ", currentPage=" + currentPage + ", nextPage=" + nextPage
				+ ", previousPage=" + previousPage + ", hasNext=" + hasNext
				+ ", hasPrevious=" + hasPrevious + ", firstResult="
				+ firstResult + ", totalItems=" + totalItems + ", list=" + list
				+ "]";
	}

}
