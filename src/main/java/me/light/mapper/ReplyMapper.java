package me.light.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import me.light.domain.Criteria;
import me.light.domain.ReplyVO;

public interface ReplyMapper {

	int insert(ReplyVO vo);
	
	ReplyVO read(Long rno);
	
	int delete(Long rno);
	
	int update(ReplyVO reply);
	
	List<ReplyVO> getListWithPaging( // 파라미터가 2개이상인 경우 xml 에 바인딩하기 위해 어노테이션을 추가한다. 
			@Param("cri") Criteria cri, @Param("bno") Long bno );
}
