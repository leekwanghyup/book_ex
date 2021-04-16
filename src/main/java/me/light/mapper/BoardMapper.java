package me.light.mapper;

import java.util.List;

import me.light.domain.BoardVO;
import me.light.domain.Criteria;

public interface BoardMapper {
	
	List<BoardVO> getList();
	
	List<BoardVO> getListWithPaging(Criteria cri);
	
	void insert(BoardVO board);
	
	void insertSelectKey(BoardVO board);
	
	BoardVO read(Long bno); 
	
	int delete(Long bno);

	int update(BoardVO boardVO);
	
	int getTotalCount(Criteria cri); 
}
