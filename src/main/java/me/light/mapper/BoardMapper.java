package me.light.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

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
	
	void updateReplyCnt(@Param("bno") Long bno, @Param("amount") int amount);
	// amount: 새로추가 되는 댓글 혹은 삭제되는 댓글의 수 
}
