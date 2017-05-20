package com.gaoshuhang.dao.impl;

import com.gaoshuhang.dao.CourierDao;
import com.gaoshuhang.domain.Courier;
import com.gaoshuhang.domain.User;
import com.gaoshuhang.utils.getc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourierDaoImpl implements CourierDao
{
	Connection con =null;
	@Override
	public int insertCourier(Courier courier)
	{
		int i = 0;
		try {
			con = getc.getConnection();
			
		    String sql = "insert into courier (user_id,open_id,phone_num,name,card_id,deleted) values(?,?,?,?,?,1)";
		    PreparedStatement pstmt=null;
		    pstmt = con.prepareStatement(sql);
		    pstmt.setLong(1, 0);
		    pstmt.setString(2, courier.getOpenId());
		    pstmt.setString(3, courier.getPhoneNum());
		    pstmt.setString(4, courier.getName());
		    pstmt.setString(5, courier.getCardId());
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
	public int deleteCourier(String courierOpenId)
	{
		int i = 0;
		try {
			con = getc.getConnection();	
		    String sql = "delete from courier where open_id='" + courierOpenId + "'";
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
	public int updateCourier(String courierOpenId, Courier courier)
	{
		int i = 0;
		try {
			con = getc.getConnection();	
			String sql = "update courier set open_id='" + courier.getOpenId() + "', phone_num='" + courier.getPhoneNum() +  "', name='" + courier.getName()+"', card_id='" + courier.getCardId()+"', deleted='" + courier.getDeleted()+"' where open_id='"+courierOpenId+"'";
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
	public Courier queryCourierById(String courierOpenId)
	{
		Courier user=null;
		try {
			con = getc.getConnection();	
			String sql = "select * from courier where open_id='"+courierOpenId+"'";
		    PreparedStatement pstmt=null;
		    pstmt = con.prepareStatement(sql);
		    ResultSet rs = pstmt.executeQuery();
		    try {
		        while (rs.next()) {
		        	  user=new Courier();
		        	  user.setUserId(Long.valueOf(rs.getString(1)));
		        	 user.setOpenId(rs.getString(2));
		        	 user.setPhoneNum(rs.getString(3));
		        	 user.setName(rs.getString(4));
		        	 user.setCardId(rs.getString(5));
		        	 user.setDeleted(Integer.valueOf(rs.getString(6)));
		            
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
	public Courier queryCourierByPhoneNum(String phoneNum)
	{
		Courier user=null;
		try {
			con = getc.getConnection();	
			String sql = "select * from courier where phone_num='"+phoneNum+"'";
		    PreparedStatement pstmt=null;
		    pstmt = con.prepareStatement(sql);
		    ResultSet rs = pstmt.executeQuery();
		    try {
		        while (rs.next()) {
		        	  user=new Courier();
		        	  user.setUserId(Long.valueOf(rs.getString(1)));
		        	 user.setOpenId(rs.getString(2));
		        	 user.setPhoneNum(rs.getString(3));
		        	 user.setName(rs.getString(4));
		        	 user.setCardId(rs.getString(5));
		        	 user.setDeleted(Integer.valueOf(rs.getString(6)));
		            
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
	public List<Courier> queryCourierByName(String name)
	{
		Courier user=null;
		List<Courier> users = new ArrayList();
		try {
			con = getc.getConnection();	
			String sql = "select * from courier where name='"+name+"'";
		    PreparedStatement pstmt=null;
		    pstmt = con.prepareStatement(sql);
		    ResultSet rs = pstmt.executeQuery();
		    try {
		        while (rs.next()) {
		        	  user=new Courier();
		        	  user.setUserId(Long.valueOf(rs.getString(1)));
		        	 user.setOpenId(rs.getString(2));
		        	 user.setPhoneNum(rs.getString(3));
		        	 user.setName(rs.getString(4));
		        	 user.setCardId(rs.getString(5));
		        	 user.setDeleted(Integer.valueOf(rs.getString(6)));
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
	public List<Courier> queryCourierList()
	{
		Courier user=null;
		List<Courier> users = new ArrayList();
		try {
			con = getc.getConnection();	
			String sql = "select * from courier";
			PreparedStatement pstmt=null;
		    pstmt = con.prepareStatement(sql);
		    ResultSet rs = pstmt.executeQuery();
		    try {
		        while (rs.next()) {
		        	user=new Courier();
		        	  user.setUserId(Long.valueOf(rs.getString(1)));
		        	 user.setOpenId(rs.getString(2));
		        	 user.setPhoneNum(rs.getString(3));
		        	 user.setName(rs.getString(4));
		        	 user.setCardId(rs.getString(5));
		        	 user.setDeleted(Integer.valueOf(rs.getString(6)));
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
	public List<Courier> queryCourierListByPage(int startPage, int pageSize)
	{
		return null;
	}
}
