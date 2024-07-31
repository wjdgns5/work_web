package com.tenco.Repo.temp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tenco.Repo.interfaces.temp.NoticeRepository;
import com.tenco.model.temp.NoticeDTO;
import com.tenco.util.DBUtil;

public class NoticeRepositoryImpl implements NoticeRepository{
			private static final String SELECT_NOTICE_ALL	=" select * from tb_notice order by created_time desc ";
			private static final String SELECT_NOTICE_ALL_5	=" select * from tb_notice order by created_time desc limit 5 ";
			private static final String SELECT_NOTICE_ALL_10	=" select * from tb_notice order by created_time desc limit 10 ";
			private static final String SELECT_NOTICE_BY_ID=" select * from tb_notice where id=? ";
			
			private static final String SELECT_NOTICE_BY_TITLE=" select * from tb_notice where title=? ";
			private static final String SELECT_NOTICE_COUNT_BY_TITLE=" select count(id) from tb_notice where title=? ";
			private static final String SELECT_NOTICE_BY_KEYWORD=" select * from tb_notice WHERE title LIKE '%?%' OR content LIKE '%?%' ";
			private static final String SELECT_NOTICE_COUNT_BY_KEYWORD=" select count(id) from tb_notice WHERE title LIKE '%?%' OR content LIKE '%?%' ";
			private static final String SELECT_NOTICE_BY_CONTENT=" select * from tb_notice WHERE  content LIKE '%?%' ";
			private static final String SELECT_NOTICE_COUNT_BY_CONTENT=" select count(id) from tb_notice WHERE  content LIKE '%?%' ";
			private static final String INSERT_NOTICE=" insert into notice_tb (category, title,  content, created_time)\r\n"
					+ "	values(?,?,?,?) ";
			private static final String UPDATE_ViEWS= " UPDATE tb_notice SET views = views + 1 WHERE id = ? ";
			private static final String UPDATE_NOTICE_BY_ID= " UPDATE tb_notice SET  category= ? or title=? or content=? or created_time=? WHERE id = ? ";
			private static final String DELETE_NOTICE_BY_ID= " DELETE FROM tb_notice WHERE id=? ";
	
			
			
			
			
			


	@Override
	public List<NoticeDTO> SelectNoitceAll() {
		List<NoticeDTO> noticeList=new ArrayList<>();
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SELECT_NOTICE_ALL)){
			ResultSet rs = pstmt.executeQuery();
			System.out.println("noticeAll 받음");
			while (rs.next()) {
				noticeList.add(NoticeDTO.builder()
						.id(rs.getInt("id"))
						.category(rs.getString("category"))
						.title(rs.getString("title"))
						.content(rs.getString("content"))
						.createdTime(rs.getTimestamp("created_time"))
						.views(rs.getInt("views"))
						.build());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return noticeList;
	}

	@Override
	public List<NoticeDTO> SelectNoitceAll5() {
		List<NoticeDTO> noticeList=new ArrayList<>();
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SELECT_NOTICE_ALL_5)){
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				noticeList.add(NoticeDTO.builder()
						.id(rs.getInt("id"))
						.category(rs.getString("category"))
						.title(rs.getString("title"))
						.content(rs.getString("content"))
						.createdTime(rs.getTimestamp("created_time"))
						.views(rs.getInt("views"))
						.build());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return noticeList;
	}

	@Override
	public void InsertNotice(NoticeDTO dto) {
		try (Connection conn=DBUtil.getConnection()){
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt=conn.prepareStatement(INSERT_NOTICE)){
				pstmt.setString(1, dto.getCategory());
				pstmt.setString(2, dto.getTitle());
				pstmt.setString(3, dto.getContent());
				pstmt.setTimestamp(1, dto.getCreatedTime());
				pstmt.executeUpdate();
				
				conn.commit();
			} catch (Exception e) {
				conn.rollback();
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}



	@Override
	public void updateNoticeById(NoticeDTO noticeDTO,int id) {
		try (Connection conn=DBUtil.getConnection()){
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt=conn.prepareStatement(UPDATE_NOTICE_BY_ID)){
				pstmt.setString(1, noticeDTO.getCategory());
				pstmt.setString(2, noticeDTO.getTitle());
				pstmt.setString(3, noticeDTO.getContent());
				pstmt.setTimestamp(4, noticeDTO.getCreatedTime());
				pstmt.setInt(5, noticeDTO.getId());
				pstmt.executeUpdate();
				
				conn.commit();
			} catch (Exception e) {
				conn.rollback();
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


	@Override
	public void deleteNoticeById(int id) {
		try (Connection conn=DBUtil.getConnection()){
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt=conn.prepareStatement(DELETE_NOTICE_BY_ID)){
				pstmt.setInt(1, id);
				pstmt.executeUpdate();
				conn.commit();
			} catch (Exception e) {
				conn.rollback();
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void updateViews(int id) {
		try (Connection conn=DBUtil.getConnection()){
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt=conn.prepareStatement(UPDATE_ViEWS)){
				pstmt.setInt(1, id);
				pstmt.executeUpdate();		
				conn.commit();
			} catch (Exception e) {
				conn.rollback();
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public int selectNoticeCountByKeyword(String keyword) {
		int count = 0;
		
		try(Connection conn = DBUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(SELECT_NOTICE_COUNT_BY_KEYWORD)) {
				pstmt.setString(1, keyword);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt("count(id)");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(" keyword Count : " + count);
		return count;
	
	}


	@Override
	public List<NoticeDTO> SelectNoticeById(int id) {
		List<NoticeDTO> noticeList=new ArrayList<>();
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SELECT_NOTICE_BY_CONTENT)){
				pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				noticeList.add(NoticeDTO.builder()
						.id(rs.getInt("id"))
						.category(rs.getString("category"))
						.title(rs.getString("title"))
						.content(rs.getString("content"))
						.createdTime(rs.getTimestamp("created_time"))
						.views(rs.getInt("views"))
						.build());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return noticeList;
	}

	@Override
	public List<NoticeDTO> SelectNoticeByTitle(String title) {
		List<NoticeDTO> noticeList=new ArrayList<>();
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SELECT_NOTICE_BY_CONTENT)){
				pstmt.setString(1, title);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				noticeList.add(NoticeDTO.builder()
						.id(rs.getInt("id"))
						.category(rs.getString("category"))
						.title(rs.getString("title"))
						.content(rs.getString("content"))
						.createdTime(rs.getTimestamp("created_time"))
						.views(rs.getInt("views"))
						.build());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return noticeList;
	}

	@Override
	public List<NoticeDTO> SelectNoticeByContent(String content) {
		List<NoticeDTO> noticeList=new ArrayList<>();
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SELECT_NOTICE_BY_CONTENT)){
				pstmt.setString(1, content);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				noticeList.add(NoticeDTO.builder()
						.id(rs.getInt("id"))
						.category(rs.getString("category"))
						.title(rs.getString("title"))
						.content(rs.getString("content"))
						.createdTime(rs.getTimestamp("created_time"))
						.views(rs.getInt("views"))
						.build());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return noticeList;
	}

	@Override
	public List<NoticeDTO> SelectNoticeByKeyword(String keyword) {
		List<NoticeDTO> noticeList=new ArrayList<>();
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SELECT_NOTICE_BY_KEYWORD)){
				pstmt.setString(1, keyword);
				pstmt.setString(2, keyword);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				noticeList.add(NoticeDTO.builder()
						.id(rs.getInt("id"))
						.category(rs.getString("category"))
						.title(rs.getString("title"))
						.content(rs.getString("content"))
						.createdTime(rs.getTimestamp("created_time"))
						.views(rs.getInt("views"))
						.build());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return noticeList;
	}

	@Override
	public int selectNoticeCountByContent(String content) {
		int count = 0;
		
		try(Connection conn = DBUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(SELECT_NOTICE_COUNT_BY_CONTENT)) {
			
			ResultSet rs = pstmt.executeQuery();
			pstmt.setString(1, content);
			if(rs.next()) {
				count = rs.getInt("count(id)");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(" content Count : " + count);
		return count;
	
	}

	@Override
	public int selectNoticeCountByTitle(String title) {
		int count = 0;
		
		try(Connection conn = DBUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(SELECT_NOTICE_COUNT_BY_TITLE)) {
			pstmt.setString(1, title);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt("count(id)");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(" title Count : " + count);
		return count;
	
	}

}
