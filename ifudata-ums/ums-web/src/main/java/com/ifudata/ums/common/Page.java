package com.ifudata.ums.common;

import java.util.ArrayList;
import java.util.List;

public class Page<E> {
	private int pageRecord = 10;

	private int totalRecords;

	private int startIndex;



	private int endIndex;

	private int totalPage;

	private int currentPage;

	private List<E> totalList;

	public Page(List<E> totalList) {
		this.totalList = totalList;
		initPageObject();
	}

	private void initPageObject() {
		if (totalList == null)
			throw new RuntimeException("The data is null");

		this.totalRecords = totalList.size();
		this.totalPage = totalRecords / pageRecord;
		if (totalRecords % pageRecord != 0) {
			this.totalPage += 1;
		}
	}

	public List<E> getPage(int currentPage) {
		this.currentPage = currentPage;
		if (currentPage <= 0) {
			this.currentPage = 1;
		}

		if (currentPage > totalPage) {
			this.currentPage = totalPage;
		}

		return new ArrayList<E>(totalList.subList(getStartIndex(),
				getEndIndex()));
	}

	private int getStartIndex() {

		this.startIndex = (getCurrentPage() - 1) * this.pageRecord;
		if (startIndex > totalRecords) {
			startIndex = totalRecords;
		}

		if (startIndex < 0) {
			startIndex = 0;
		}

		return startIndex;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public int getEndIndex() {
		endIndex = getStartIndex() + this.pageRecord;

		if (endIndex < 0) {
			endIndex = 0;
		}

		if (endIndex < getStartIndex()) {
			endIndex = getStartIndex();
		}

		if (endIndex > this.totalRecords) {
			endIndex = this.totalRecords;
		}

		return endIndex;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public int getTotalRecords() {
		return totalRecords;
	}
	
	public int getPageRecord() {
		return pageRecord;
	}

	public void setPageRecord(int pageRecord) {
		this.pageRecord = pageRecord;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
}
