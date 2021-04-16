package me.light.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageDTO {
	private int startPage; 
	private int endPage; 
	private boolean prev; 
	private boolean next; 
	
	private int total; 
	private Criteria cri; 
	
	public PageDTO(Criteria cri, int total) {
		this.cri = cri; 
		this.total = total; 
		
		System.out.println("페이지 번호 : ****** : "+cri.getPageNum());
		this.endPage = (int) (Math.ceil(cri.getPageNum() / 10.0)) * 10; 
		this.startPage = this.endPage - 9; 
		
		int lastPage = (int)(Math.ceil(total*1.0)/cri.getAmount()); 
		
		if(lastPage < this.endPage) { // 마지막페이지가 계산된 마지막 페이지 보다 크면 
			this.endPage = lastPage; 
		}
		
		this.prev = this.startPage > 1; // 1페이지를 제외한 모든 페이지에서 prev 버튼 활성화 
		this.next = this.endPage < lastPage; // endPage가 실제제의 마지막 페이지보다 작으면 next 버튼 활성화 
	}
}
