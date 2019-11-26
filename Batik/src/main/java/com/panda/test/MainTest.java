package com.panda.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.panda.pojo.Request;
//import com.sun.tools.classfile.StackMap_attribute.stack_map_frame;

public class MainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getAll();
	}

	private static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
	private static final String SERVER_IP = "123.56.68.20";// 服务器IP地址
	private static final String DATABASE_NAME = "panda";// 连接到哪一个数据库
	private static final String USER_NAME = "root";// 用户名
	private static final String PASSWORD = "123456";// 密码

	public static Connection getConnection() {
		Connection conn = null;
		String jdbcUrl = "jdbc:mysql://" + SERVER_IP + ":3306/" + DATABASE_NAME
				+ "?serverTimezone=Asia/Shanghai&useSSL=true";
		try {
			Class.forName(DRIVER_CLASS);
			conn = DriverManager.getConnection(jdbcUrl, USER_NAME, PASSWORD);
		} catch (Exception e) {
			System.out.println("获取连接时，异常" + e.getMessage());
			conn = null;
		}
		return conn;
	}

	public static void closeAll(Connection conn, PreparedStatement pst, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (pst != null) {
				pst.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * @category 分页代码
	 * @return
	 */
    public static List<Request> getAll() {
        // 操作数据库，需要一个连接Connection
        Connection connection = getConnection();
        PreparedStatement prepareStatement = null;
        ResultSet resultSet = null;
        List<Request> loveInHeartList = new ArrayList();
             
        String sql_data = "select * from t_panda_request order by approvalStatus desc ";
        //String sql_recodeCount = "select count(1) as mycount from t_panda_request";
        
        sql_data += "limit ";	
        //sql_data += (myPage.getCurrentPage()-1)*myPage.getPerPageSize();
        sql_data += (4-1)*2;
        sql_data += ",";
        //sql_data += myPage.getPerPageSize();
        sql_data += 2;
        
        System.out.println("分页的SQL:"+sql_data);
        
        try {
            prepareStatement = connection.prepareStatement(sql_data);
            resultSet = prepareStatement.executeQuery();
            while (resultSet.next()) {
            	Request request = new Request();
            	request.setApprovalStatus(resultSet.getString("approvalStatus"));
//                l.setLname(resultSet.getString("lname"));
//                l.setLsex(resultSet.getString("lsex"));
//                l.setLtime(resultSet.getDate("ltime"));
//                l.setLmoney(resultSet.getFloat("lmoney"));
                loveInHeartList.add(request);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        closeAll(connection, prepareStatement, resultSet);

        System.out.println(JSON.toJSONString(loveInHeartList));
        return loveInHeartList;
    }

}
