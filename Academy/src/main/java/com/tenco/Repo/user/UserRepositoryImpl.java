package com.tenco.Repo.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.tenco.Repo.interfaces.user.UserRepository;
import com.tenco.model.user.UserDTO;
import com.tenco.util.DBUtil;

public class UserRepositoryImpl implements UserRepository{

	@Override
	public UserDTO userLogin(int id, String password) {
		//TODO - sql 작성
		String commonSql = " SELECT id,permission_level FROM tb_user where id = ? and password = ? ";
		String sqlStudent = " SELECT * FROM tb_student where id = ? ";
		String sqlProfessor = " SELECT * FROM tb_professor where id = ? ";
		String sqlStaff = " SELECT * FROM tb_staff where id = ? ";
		UserDTO verifiedUser = null;
		
		String tempSql = null;
		int tempId = 0;
		int tempPL=0;
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(commonSql)){
			pstmt.setInt(1, id);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {

				tempId = rs.getInt("id");
				tempPL = rs.getInt("permission_level");
				if(tempPL == 1) {
					tempSql = sqlStudent;
					verifiedUser = checkStudent(conn,tempSql,tempId,tempPL);
				}else if(tempPL == 2) {
					tempSql = sqlProfessor;
					verifiedUser = checkCommon(conn,tempSql,tempId,tempPL);
				}else if(tempPL == 3) {
					tempSql = sqlStaff;
					verifiedUser = checkCommon(conn,tempSql,tempId,tempPL);
				}else {
					//TODO handle exception
				}
				System.out.println(tempPL);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//System.out.println(verifiedUser.toString()+" /UserRepositoryImpl");
		return verifiedUser;
	}

	private UserDTO checkCommon(Connection conn,String tempSql, int tempId, int tempPL) {

		
		UserDTO verifiedUser = null;
		try (PreparedStatement pstmt2 = conn.prepareStatement(tempSql)){
			pstmt2.setInt(1, tempId);
			ResultSet rs2 = pstmt2.executeQuery();
			if (rs2.next()) {
				verifiedUser = UserDTO.builder()
							.id(tempId)
							.permissionLevel(tempPL)
							.name(rs2.getString("name"))
							.birth(rs2.getString("birth_date"))
							.gender(rs2.getString("gender"))
							.address(rs2.getString("address"))
							.phoneNum(rs2.getString("tel"))
							.email(rs2.getString("email"))
							.build();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return verifiedUser;
		
	}

	private UserDTO checkStudent(Connection conn, String tempSql,int tempId, int tempPL) {
		UserDTO verifiedUser = null;
		try (PreparedStatement pstmt2 = conn.prepareStatement(tempSql)){
			pstmt2.setInt(1, tempId);
			ResultSet rs2 = pstmt2.executeQuery();
			if (rs2.next()) {
				verifiedUser = UserDTO.builder()
							.id(tempId)
							.permissionLevel(tempPL)
							.name(rs2.getString("name"))
							.birth(rs2.getString("birth_date"))
							.gender(rs2.getString("gender"))
							.address(rs2.getString("address"))
							.phoneNum(rs2.getString("tel"))
							.email(rs2.getString("email"))
							.build();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return verifiedUser;
		
		
	}

}
