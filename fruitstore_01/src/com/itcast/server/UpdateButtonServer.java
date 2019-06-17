package com.itcast.server;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.itcast.dao.DBConnection;
import com.itcast.dao.UpdateResultSet;
import com.itcast.pojo.FruitDB;
import com.itcast.view.FruitMainPage;

public class UpdateButtonServer implements ActionListener{
	FruitMainPage fruitMainPage;	//创建一个主界面对象

	public void setFruitMainPage(FruitMainPage fruitMainPage) {
		this.fruitMainPage = fruitMainPage;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		FruitDB fruitDB = new FruitDB();	//新建一个pojo持久化类对象
		fruitDB.setId(Integer.parseInt(fruitMainPage.updatIdField.getText()));
		fruitDB.setName(fruitMainPage.updatNameField.getText());
		fruitDB.setPrice(Double.parseDouble(fruitMainPage.updatPriceField.getText()));
		fruitDB.setUnit(fruitMainPage.updatUnitField.getText());
		DBConnection connection = new DBConnection();	//建立数据库连接
		new UpdateResultSet(fruitDB, connection.getConnection());	//进行添加操作
		fruitMainPage.setVisible(false);
		fruitMainPage.dispose();
		new FruitMainPage().setVisible(true);
	}
}
