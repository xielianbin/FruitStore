package com.itcast.dao;

import java.sql.SQLException;
import com.itcast.pojo.FruitDB;

public class UpdateResultSet {
	public UpdateResultSet(FruitDB fruitId,  java.sql.Connection connection) {
		java.sql.PreparedStatement preparedStatement=null;
		String updateSQL="update fruit set name=?,price=?,unit=? where id=?";
		try {
			preparedStatement=connection.prepareStatement(updateSQL);
			preparedStatement.setString(1, fruitId.getName());
			preparedStatement.setDouble(2, fruitId.getPrice());
			preparedStatement.setString(3, fruitId.getUnit());
			preparedStatement.setInt(4, fruitId.getId());
			int check=preparedStatement.executeUpdate();
			if (check != 0)
				System.out.println("------------数据修改成功!------------");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("------------数据修改失败!------------");
		} finally {
			new DBReplease(preparedStatement, connection);
			System.out.println("数据库资源关闭成功!");
		}
	}
}
