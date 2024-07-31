package com.tenco.Repo.interfaces.temp;

import java.util.List;

import com.tenco.model.temp.NoticeDTO;

public interface NoticeRepository {

	List<NoticeDTO> SelectNoticeById(int id);
	List<NoticeDTO> SelectNoticeByTitle(String title);
	List<NoticeDTO> SelectNoticeByContent(String content);
	List<NoticeDTO> SelectNoticeByKeyword(String keyword);
	List<NoticeDTO> SelectNoitceAll();
	List<NoticeDTO> SelectNoitceAll5();
	void InsertNotice(NoticeDTO noticeDTO);
	void updateNoticeById(NoticeDTO noticeDTO,int id);
	void deleteNoticeById(int id);
	int selectNoticeCountByKeyword(String keyword);
	int selectNoticeCountByContent(String content);
	int selectNoticeCountByTitle(String title);
	void updateViews(int id);
	
}

