package com.trillon.camp.common.paging;



public class Paging {

	private int currentPage; // 현재 페이지
	private int total; // 전체 게시물
	private int cntPerPage; // 페이지당 게시물 수
	private int blockCnt; // 하단에 표시될 페이지 블록 개수
	private String sortColumn; // 정렬기준
	private String sortDirection; // 정렬 방향

	private int prevPage;
	private int nextPage;
	private int lastPage;

	private int blockStart;
	private int blockEnd;

	private int start;

	private Paging(Builder builder) {
		this.currentPage = builder.currentPage;
		this.total = builder.total;
		this.cntPerPage = builder.cntPerPage;
		this.blockCnt = builder.blockCnt;
		this.sortColumn = builder.sortColumn;
		this.sortDirection = builder.sortDirection;

		this.start = (currentPage - 1) * cntPerPage;
		this.prevPage = currentPage <= 1 ? 1 : currentPage - 1;
		this.lastPage = (total - 1) / cntPerPage + 1;
		this.nextPage = currentPage >= lastPage ? currentPage : currentPage + 1;

//		5n + 1 
//		5 = blockCnt;
//		n = ((page-1)/blockCnt)
//		5n + 1 =  ((page-1)/blockCnt) * blockCnt + 1 
		this.blockStart = ((currentPage - 1) / blockCnt) * blockCnt + 1;
		this.blockEnd = blockStart + blockCnt > lastPage ? lastPage : blockStart + blockCnt - 1;
	}

	public String getSortColumn() {
		return sortColumn;
	}

	public String getSortDirection() {
		return sortDirection;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public int getTotal() {
		return total;
	}

	public int getBlockCnt() {
		return blockCnt;
	}

	public int getPrevPage() {
		return prevPage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public int getLastPage() {
		return lastPage;
	}

	public int getBlockStart() {
		return blockStart;
	}

	public int getBlockEnd() {
		return blockEnd;
	}

	public int getCntPerPage() {
		return cntPerPage;
	}

	public int getStart() {
		return start;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {
		private int currentPage; // 현재 페이지
		private int total; // 전체 게시물
		private int cntPerPage; // 페이지당 게시물 수
		private int blockCnt; // 하단에 표시될 페이지 블록 개수
		private String sortColumn = "create_date"; // 정렬기준
		private String sortDirection = "desc"; // 정렬 방향

		public Builder sortColumn(String sortColumn) {
			this.sortColumn = sortColumn;
			return this;
		}

		public Builder sortDirection(String sortDirection) {
			this.sortDirection = sortDirection;
			return this;
		}

		public Builder currentPage(int currentPage) {
			this.currentPage = currentPage;
			return this;
		}

		public Builder total(int total) {
			this.total = total;
			return this;
		}

		public Builder cntPerPage(int cntPerPage) {
			this.cntPerPage = cntPerPage;
			return this;
		}

		public Builder blockCnt(int blockCnt) {
			this.blockCnt = blockCnt;
			return this;
		}

		public Paging build() {
			return new Paging(this);
		}

	}

}
