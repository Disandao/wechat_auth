package com.gaoshuhang.dao.impl;


import com.gaoshuhang.dao.UserDao;
import com.gaoshuhang.domain.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import javax.servlet.ServletException;


import com.gaoshuhang.utils.getc;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class UserDaoImpl implements UserDao
{
	Connection con =null;
	@Override
	public int insertUser(User user)
	{
		int i = 0;
		try {
			con = getc.getConnection();
			
		    String sql = "insert into user (user_id,open_id,phone_num,deleted) values(?,?,?,1)";
		    PreparedStatement pstmt=null;
		    pstmt = con.prepareStatement(sql);
		    pstmt.setLong(1, 0);
		    pstmt.setString(2, user.getUserOpenId());
		    pstmt.setString(3, user.getPhoneNum());
		    i = pstmt.executeUpdate();
		    pstmt.close();
		    con.close();
		        
		} catch (SQLException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
		return i;
		  
	}

	@Override
	public int deleteUser(String userOpenId)
	{
		int i = 0;
		try {
			con = getc.getConnection();	
		    String sql = "delete from user where open_id='" + userOpenId + "'";
		    PreparedStatement pstmt;
		    pstmt = (PreparedStatement) con.prepareStatement(sql);
		    i = pstmt.executeUpdate();
		    System.out.println("resutl: " + i);
		    pstmt.close();
		    con.close();
		} catch (SQLException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
	    return i;
	}

	@Override
	public int updateUser(String userOpenId, User user)
	{
		int i = 0;
		try {
			con = getc.getConnection();	
			String sql = "update user set open_id='" + user.getUserOpenId() + "', phone_num='" + user.getPhoneNum() +  "', deleted='" + user.getDeleted()+"' where open_id='"+userOpenId+"'";
		    PreparedStatement pstmt;
		    pstmt = (PreparedStatement) con.prepareStatement(sql);
		    i = pstmt.executeUpdate();
		    System.out.println("resutl: " + i);
		    pstmt.close();
		    con.close();
		} catch (SQLException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
	    return i;
	}

	@Override
	public User queryUserById(String userOpenId)
	{
		User user=null;
		try {
			con = getc.getConnection();	
			String sql = "select * from user where open_id='"+userOpenId+"'";
		    PreparedStatement pstmt=null;
		    pstmt = con.prepareStatement(sql);
		    ResultSet rs = pstmt.executeQuery();
		    try {
		        while (rs.next()) {
		        	  user=new User();
		        	 user.setUserOpenId(rs.getString(2));
		        	 user.setUserId(Long.valueOf(rs.getString(1)));
		        	 user.setPhoneNum(rs.getString(3));
		        	 user.setDeleted(Integer.valueOf(rs.getString(4)));
		            
		        }
		    } catch (SQLException ex) {
		    }
		    pstmt.close();
		    con.close();
		} catch (SQLException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
		return user;
	}

	@Override
	public User queryUserByPhoneNum(String phoneNum)
	{
		User user=null;
		try {
			con = getc.getConnection();
			String sql = "select * from user where phone_num='"+phoneNum+"'";
			PreparedStatement pstmt=null;
		    pstmt = con.prepareStatement(sql);
		    ResultSet rs = pstmt.executeQuery();
		    try {
		        while (rs.next()) {
		        	  user=new User();
		        	 user.setUserOpenId(rs.getString(2));
		        	 user.setUserId(Long.valueOf(rs.getString(1)));
		        	 user.setPhoneNum(rs.getString(3));
		        	 user.setDeleted(Integer.valueOf(rs.getString(4)));
		            
		        }
		    } catch (SQLException ex) {
		    }
		    pstmt.close();
		    con.close();
		} catch (SQLException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
		return user;
	}

	@Override
	public List<User> queryUserList()
	{
		User user=null;
		List<User> users = new ArrayList();
		try {
			con = getc.getConnection();	
			String sql = "select * from user";
			PreparedStatement pstmt=null;
		    pstmt = con.prepareStatement(sql);
		    ResultSet rs = pstmt.executeQuery();
		    try {
		        while (rs.next()) {
		        	  user=new User();
		        	 user.setUserOpenId(rs.getString(2));
		        	 user.setUserId(Long.valueOf(rs.getString(1)));
		        	 user.setPhoneNum(rs.getString(3));
		        	 user.setDeleted(Integer.valueOf(rs.getString(4)));
		            users.add(user);
		        }
		    } catch (SQLException ex) {
		    }
		    pstmt.close();
		    con.close();
		} catch (SQLException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
		return users;
	}

	@Override
	public List<User> queryUserListByPage(int startPage, int pageSize)
	{
		User user=null;
		List<User> users = new ArrayList();
		String sql = "select * from user order by user_id asc limit ?,?";
		try {
			con = getc.getConnection();	
			
		    PreparedStatement ps;
		    ps = (PreparedStatement) con.prepareStatement(sql);
		    ps.setInt(1, (startPage - 1) * pageSize); // 对SQL语句中的第1个参数赋值
            ps.setInt(2, pageSize); // 对SQL语句中的第2个参数赋值
            ResultSet rs = (ResultSet) ps.executeQuery(); // 执行查询操作
            while (rs.next()) { // 光标向后移动，并判断是否有效
            	user=new User(); // 实例化BookBean
            	user.setUserOpenId(rs.getString(2));
	        	 user.setUserId(Long.valueOf(rs.getString(1)));
	        	 user.setPhoneNum(rs.getString(3));
	        	 user.setDeleted(Integer.valueOf(rs.getString(4)));
	            users.add(user);
            }
		    
		    ps.close();
		    con.close();
		} catch (SQLException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
		return users;
	}
}
