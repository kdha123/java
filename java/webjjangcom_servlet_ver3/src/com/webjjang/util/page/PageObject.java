/**
 * 페이지 처리를 위한 객체
 * - 페이지 처리
 * 작성일: 2019-11-28
 * 작성자: 김동현
 */
package com.webjjang.util.page;

public class PageObject {

	// --------------java 부분의 페이지 처리를 위한 변수
	// 현재 페이지
	private int page;
	// 한 페이지의 표시할 데이터의 갯수
	private int perPageNum;
	// 시작번호
	private int startRow;
	// 끝 번호
	private int endRow;

	// -------------jsp에서 사용할 페이지처리 변수
	// 전체 데이터의 갯수 - dao에서 count(*) -> service에서 데이터를 셋팅.
	private int totalRow; 
	// 전체 페이지 - totalRow 데이터가 들어오면 자동으로 계산하도록 한다. setTotalRow() 작성
	private int totalPage;
	// 하단 부분의 페이지링크 부분(pagination)에 나타날 페이지의 개수 -> perGroupPageNum
	private int perGroupPageNum;
	// 페이지 그룹에 나타나는 처음과 끝 페이지 - 현재 페이지에 따라 다르게 설정된다.
	// totalPage가 나오면 계산할 수 있다. - totalPage가 25면 endPage가 30으로 셋팅되는 경우가 발생할 수 있기때문이다.
	//							- endPage가 totalPage를 넘는 경우는 endPage를 totalPage로 변경
	private int startPage;
	private int endPage;
	
	//------------검색에 필요한 데이터변수--------
	private String key;
	private String word;
	
	
	
	
	// 기본 값을 셋팅하기 위한 기본 생성자
	public PageObject() {
		// 페이지: 1, perPageNum: 10(개발자가 정한다.)
		this(1, 10);
//		this.page = 1;
//		this.perPageNum = 10;
	}

	// 생성자에서 생성자를 호출하는 방식
	// 현재 페이지와 한 페이지당 표시하는 데이터의 갯수를 전달받아서 처리한다.
	public PageObject(int page, int perPageNum) {
		
		this(page, perPageNum, 10);
		
	}
	
		
	public PageObject(int page, int perPageNum, int perGroupPageNum) {
		
		this.page = page;
		this.perPageNum = perPageNum;
		this.perGroupPageNum = perGroupPageNum;
	

		// 현재 페이지의 시작 줄번호 구하기
		// 시작 줄번호 = 이전페이지의 갯수를 넘긴 다음 번호 : (page-1)*perPageNum + 1
		this.startRow = (page - 1) * perPageNum + 1;
		// 끝 줄번호 = 시작 줄번호에다가 한 페이지당 표시하는 데이터의 갯수를 더하면 다음 페이지의 시작번호가 되는데
		// 여기서 -1해주면 현재 페이지의 마지막 번호가 된다. startRow + perPageNum - 1
		this.endRow = this.startRow + perPageNum - 1;
//		this.endRow = page*perPageNum; 위의 문장과 같다.

	}

	public int getPage() {
		return page;
	}

	// 리스트 표시 요청이 있을 때마다 새로운 pageObject 객체가 새로 생성이 되므로 처리하는 동안에는 변경되지 않는다.
	// 생성자에서 데이터를 처리하도록 작성한다.
//	public void setPage(int page) {
//		this.page = page;
//	}

	public int getPerPageNum() {
		return perPageNum;
	}

	public int getStartRow() {
		return startRow;
	}

	public int getEndRow() {
		return endRow;
	}

	
	public int getTotalRow() {
		return totalRow;
	}
	
	public int getTotalPage() {
		return totalPage;
	}
	

	public int getStartPage() {
		return startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word.trim();
	}

	//데이터 확인용
	@Override
	public String toString() {
		return "PageObject [page=" + page + ", perPageNum=" + perPageNum + ", startRow=" + startRow + ", endRow="
				+ endRow + ", totalRow=" + totalRow + ", totalPage=" + totalPage + ", perGroupPageNum="
				+ perGroupPageNum + ", startPage=" + startPage + ", endPage=" + endPage + ", key=" + key + ", word="
				+ word + "]";
	}

	// 전체 데이터의 갯수가 정해지면 전체 페이지를 구할 수 있다.
	// 전체 페이지가 구해지면 리스트 화면 하단부분 페이지네이션에 시작 페이지와 끝 페이지를 계산할 수 있다.
	public void setTotalRow(int totalRow) {
		this.totalRow = totalRow;
		this.totalPage = (totalRow - 1) / perPageNum + 1;
		//시작페이지
		this.startPage = (page - 1) / perGroupPageNum * perGroupPageNum + 1;
		// 끝페이지 계산
		this.endPage = startPage + perGroupPageNum - 1;
		// 끝페이지가 전체 페이지보다 큰 경우 조정을 해야한다.
		if(endPage>totalPage)
			this.endPage = totalPage;
	}

	

	// page 문자열과 perPageNum 문자열을 받아서 객체를 생성해주는 메소드
	public static PageObject getInstance(String strPage, String strPerPageNum) {
		PageObject pageObject = null;
		// 처음 게시판으로 들어오거나 페이지 데이터가 넘어오지않으면 1페이지로 간주한다. : 기본생성자 사용
		if (strPage == null || strPage.equals("")) {
			pageObject = new PageObject(); // page = 1, perPageNum = 10
		} else {
			int page = Integer.parseInt(strPage);
			// 한 페이지당 데이터의 갯수가 넘어오지 않는 경우 처리 10으로 셋팅
			if (strPerPageNum == null || strPerPageNum.equals("")) {
				strPerPageNum = "10";
			}
			int perPageNum = Integer.parseInt(strPerPageNum);
			pageObject = new PageObject(page, perPageNum);
		}
		
		System.out.println("PageObject.getInstance().pageObject:" + pageObject);
		
		return pageObject;
	}

}
