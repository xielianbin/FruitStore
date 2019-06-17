package com.itcast.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	Connection connection = null;

	// 获取连接对象
	public Connection getConnection() {
		try {
			// 1.加载数据库驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 2.获取数据库连接
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test2019?"
					+ "useUnicode=true&characterEncoding=utf8&" + "useSSL=false&serverTimezone=Hongkong", "root",
					"117411");
			// 3.通过Statement对象创建Connection连接对象
		} catch (Exception e) {

		}
		return connection;
	}

	

}
