package com.kh.practice.anoboard.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.kh.practice.anoboard.model.dto.AnoBoardDto;
import com.kh.practice.anoboard.model.vo.AnoBoard;
import com.kh.practice.util.page.PageInfo;

@Mapper
public interface AnoBoardMapper {

	@Insert("""
				INSERT
				  INTO
				       ANO_BOARD
				       (
				       BOARD_NO
				     , USER_NAME
				     , USER_PWD
				     , TITLE
				     , CONTENT
				     , FILE_URL
				       )
				VALUES
				       (
				       ABN_SEQ.NEXTVAL
				     , #{userName}
				     , #{userPwd}
				     , #{title}
				     , #{content}
				     , #{fileUrl}
				       )      
			""")
	int save(AnoBoard board);
	
	@Select("""
				SELECT
				       BOARD_NO
				     , USER_NAME
				     , TITLE
				     , VIEW_COUNT
				     , CREATE_DATE
				     , MODIFY_DATE
				 FROM
				       ANO_BOARD
				WHERE
				       STATUS = 'Y'       
				ORDER
				   BY
				       BOARD_NO DESC  
			    OFFSET #{offset} ROWS FETCH NEXT #{boardLimit} ROWS ONLY
			""")
	List<AnoBoardDto> findAll(PageInfo pi);  // 페이징처리 참고
	
	@Select("""
				SELECT
				       BOARD_NO
				     , USER_NAME
				     , USER_PWD
				     , TITLE
				     , CONTENT
				     , FILE_URL
				     , VIEW_COUNT
				     , CREATE_DATE
				     , MODIFY_DATE
				     , STATUS
				  FROM
				       ANO_BOARD
				 WHERE
				       STATUS = 'Y'
				   AND
				       BOARD_NO = #{boardNo}            
			""")
	AnoBoardDto findByBoardNo(Long boardNo);

	@Select("""
				SELECT
				       COUNT(*)
				  FROM
				       ANO_BOARD
				 WHERE 
				       STATUS ='Y'   
			""")
	int countTotal();
	
	@Select("""
			SELECT
			       COUNT(*)
			  FROM
			       ANO_BOARD
			 WHERE 
			       STATUS ='Y'  
			   AND
			       BOARD_NO = #{boardNo}
		""")
	int checkByBoardNo(Long boardNo);

	@Update("""
				UPDATE
				       ANO_BOARD
				   SET
				       VIEW_COUNT = VIEW_COUNT + 1
				 WHERE
				       STATUS = 'Y'
				   AND
				       BOARD_NO = #{boardNo}             
			""")
	int increaseCount(Long boardNo);
	
}
