package com.gaoshuhang.test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.gaoshuhang.dao.UserDao;
import com.gaoshuhang.dao.impl.UserDaoImpl;
import com.gaoshuhang.domain.User;
import com.gaoshuhang.utils.getc;

public class TestUserDao
{
	@SuppressWarnings("deprecation")
	public static void main(String[] args){
		Connection con =null;
		con = getc.getConnection();
		System.out.println("Please input the number:");
		Scanner scan = new Scanner(System.in);
		String read = scan.nextLine();
		switch(read)
		{
			case "1":
			{
				System.out.println("Please input the PNO:");
				Scanner scan1 = new Scanner(System.in);
				String PNO = scan1.nextLine();
				String sql = "select essn from works_on where pno='"+PNO+"'";
				 PreparedStatement pstmt=null;
				 try {
					pstmt = con.prepareStatement(sql);
					ResultSet rs = pstmt.executeQuery();
					while (rs.next()) {
			        	  System.out.println(rs.getString(1));
			        }
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			case "2":
			{
				System.out.println("Please input the PNAME:");
				Scanner scan1 = new Scanner(System.in);
				String PNAME = scan1.nextLine();
				String sql = "select ename from project,employee,works_on where \r"
							+"works_on.essn=employee.essn and works_on.pno=project.pno \r"
							+"and pname='"+PNAME+"'";
				 PreparedStatement pstmt=null;
				 try {
					pstmt = con.prepareStatement(sql);
					ResultSet rs = pstmt.executeQuery();
					while (rs.next()) {
			        	  System.out.println(rs.getString(1));
			        }
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			case "3":
			{
				System.out.println("Please input the DNAME:");
				Scanner scan1 = new Scanner(System.in);
				String DNAME = scan1.nextLine();
				String sql = "select ename,address from employee,department where \r"
							+"department.dno=employee.dno and department.dname='"+DNAME+"'";
				 PreparedStatement pstmt=null;
				 try {
					pstmt = con.prepareStatement(sql);
					ResultSet rs = pstmt.executeQuery();
					while (rs.next()) {
			        	  System.out.println(rs.getString(1)+"\t"+rs.getString(2));
			        }
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			case "4":
			{
				System.out.println("Please input the DNAME:");
				Scanner scan1 = new Scanner(System.in);
				String DNAME = scan1.nextLine();
				System.out.println("Please input the SALARY:");
				Scanner scan2 = new Scanner(System.in);
				String SALARY = scan2.nextLine();
				String sql = "select ename,address from employee,department where \r"
							+"department.dno=employee.dno and department.dname='"+DNAME+"'\r"
							+"and employee.salary<'"+SALARY+"'";
				 PreparedStatement pstmt=null;
				 try {
					pstmt = con.prepareStatement(sql);
					ResultSet rs = pstmt.executeQuery();
					while (rs.next()) {
						 System.out.println(rs.getString(1)+"\t"+rs.getString(2));
			        }
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			case "5":
			{
				System.out.println("Please input the PNO:");
				Scanner scan1 = new Scanner(System.in);
				String PNO = scan1.nextLine();
				String sql = "select ename from employee where essn not in \r"
							+"(select essn from works_on where pno='"+PNO+"')";
				 PreparedStatement pstmt=null;
				 try {
					pstmt = con.prepareStatement(sql);
					ResultSet rs = pstmt.executeQuery();
					while (rs.next()) {
			        	  System.out.println(rs.getString(1));
			        }
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			case "6":
			{
				System.out.println("Please input the ENAME:");
				Scanner scan1 = new Scanner(System.in);
				String ENAME = scan1.nextLine();
				String sql = "select ename,department.dname from employee,department where \r"
							+"superssn=(select essn from employee where ename='"+ENAME+"') \r"
							+"and employee.dno=department.dno";
				 PreparedStatement pstmt=null;
				 try {
					pstmt = con.prepareStatement(sql);
					ResultSet rs = pstmt.executeQuery();
					while (rs.next()) {
						 System.out.println(rs.getString(1)+"\t"+rs.getString(2));
			        }
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			case "7":
			{
				System.out.println("Please input the PNO1:");
				Scanner scan1 = new Scanner(System.in);
				String PNO1 = scan1.nextLine();
				System.out.println("Please input the PNO2:");
				Scanner scan2 = new Scanner(System.in);
				String PNO2 = scan2.nextLine();
				String sql = "select essn  from employee where essn in \r"
							+"(select essn from works_on where pno='"+PNO1+"' \r"
							+"and essn in (select essn from works_on where pno='"+PNO2+"'))";
				 PreparedStatement pstmt=null;
				 try {
					pstmt = con.prepareStatement(sql);
					ResultSet rs = pstmt.executeQuery();
					while (rs.next()) {
			        	  System.out.println(rs.getString(1));
			        }
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			case "8":
			{
				System.out.println("Please input the SALARY:");
				Scanner scan1 = new Scanner(System.in);
				String SALARY = scan1.nextLine();
				String sql = "select dname from employee,department where \r"
							+"employee.dno=department.dno group by employee.dno \r"
							+"having avg(salary)<'"+SALARY+"'";
				 PreparedStatement pstmt=null;
				 try {
					pstmt = con.prepareStatement(sql);
					ResultSet rs = pstmt.executeQuery();
					while (rs.next()) {
			        	  System.out.println(rs.getString(1));
			        }
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			case "9":
			{
				System.out.println("Please input the N:");
				Scanner scan1 = new Scanner(System.in);
				String N = scan1.nextLine();
				System.out.println("Please input the HOURS:");
				Scanner scan2 = new Scanner(System.in);
				String HOURS = scan2.nextLine();
				String sql = "select employee.ename from employee where \r"
							+"essn in (select essn from works_on group by \r"
							+"essn having count(*)>='"+N+"' and sum(hours)<='"+HOURS+"')";
				 PreparedStatement pstmt=null;
				 try {
					pstmt = con.prepareStatement(sql);
					ResultSet rs = pstmt.executeQuery();
					while (rs.next()) {
			        	  System.out.println(rs.getString(1));
			        }
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			
		}
		
		
		
		
		
		/*User user =new User();
		user.setUserOpenId("13456");
		user.setPhoneNum("55555");
		user.setDeleted(0);
		UserDao userd = new UserDaoImpl();
		//userd.insertUser(user);
		//userd.deleteUser("1231");
		//userd.updateUser("123444", user);
		//user = userd.queryUserById("134562");
		//user = userd.queryUserByPhoneNum("666777");
		List<User> users = new ArrayList();
		users = userd.queryUserList();
		 Iterator it1 = users.iterator();
	        while(it1.hasNext()){
	        	user = (User) it1.next();
	            System.out.println(user.getPhoneNum()+"|"+user.getUserOpenId()+"|"+user.getUserId());
	        }
*/	
	}
}
