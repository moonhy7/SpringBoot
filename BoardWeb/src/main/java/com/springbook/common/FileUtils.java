package com.springbook.common;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.springbook.vo.BoardFileVO;


public class FileUtils {
	public List<BoardFileVO> parseFileInfo(int seq, HttpServletRequest request, 
			MultipartHttpServletRequest mhsr) throws IOException {
		if(ObjectUtils.isEmpty(mhsr)) {
			return null;
		}
		
		List<BoardFileVO> fileList = new ArrayList<BoardFileVO>();
		
		
		//������ ���� ��� ���
		String root_path = request.getSession().getServletContext().getRealPath("/");
		String attach_path = "/upload/";
		
		//�� ����� ������ ������ ���� ����
		File file = new File(root_path + attach_path);
		if(file.exists() == false) {
			file.mkdir();
		}
		
		//���� �̸����� iterator�� ����
		Iterator<String> iterator = mhsr.getFileNames();
		
		while(iterator.hasNext()) {
			//���ϸ����� ���� ����Ʈ ��������
			List<MultipartFile> list = mhsr.getFiles(iterator.next());
			
			//���� ����Ʈ ���� ��ŭ ������ ���� ����Ʈ�� ����ְ� ����
			for(MultipartFile mf : list) {
				if(mf.getSize() > 0) {
					BoardFileVO boardFile = new BoardFileVO();
					boardFile.setSeq(seq);
					boardFile.setFileSize(mf.getSize());
					boardFile.setOriginalFileName(mf.getOriginalFilename());
					boardFile.setFilePath(root_path + attach_path);
					fileList.add(boardFile);

					file = new File(root_path + attach_path + mf.getOriginalFilename());
					mf.transferTo(file);
				} else {
					fileList = null;
				}
			}
		}
		return fileList;
	}
}
