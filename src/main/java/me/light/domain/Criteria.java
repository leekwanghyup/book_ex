package me.light.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Criteria {
	private int pageNum; // 페이지 번호  
	private int amount;  // 한 페이지당 보여줄 게시물 수
	
	private String type; 
	private String keyword; 
	
	public Criteria() {
		this(1,10); // 기본값 : 1페이지 당 10개의 게시물  
	}

	public Criteria(int pageNum, int amount) {
		super();
		this.pageNum = pageNum;
		this.amount = amount;
	}
	
	public String[] getTypeArr() {
		return type == null ? new String[] {} : type.split(""); 
	}
}
