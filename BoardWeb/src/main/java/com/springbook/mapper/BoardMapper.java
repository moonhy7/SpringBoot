package com.springbook.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.springbook.vo.BoardFileVO;
import com.springbook.vo.BoardVO;

@Mapper
public interface BoardMapper {
	//CRUD ����� �޼ҵ� ����
		//�� ���
		void insertBoard(BoardVO vo);
		
		//�� ����
		void updateBoard(BoardVO vo);
		
		//�� ����
		void deleteBoard(BoardVO vo);
		
		//�� �� ��ȸ
		BoardVO getBoard(BoardVO vo);
		
		//�� ��� ��ȸ
		List<BoardVO> getBoardList(BoardVO vo);
		
		int selectBoardCount(BoardVO vo);
		
		//�� ��� �� ��� �� �Ϸù�ȣ ȹ��
		int getBoardSeq();
		
		//��� ���� ����Ʈ ���
		void insertBoardFileList(BoardFileVO vo);
		
		//���ϸ�� ����
		List<BoardFileVO> getBoardFileList(int seq);
		
		//���� ����
		void deleteFile(BoardFileVO vo);
		
		//�Խñ� ������ �ش� �Խñ��� ÷������ ����
		void deleteFileList(int seq);
}
