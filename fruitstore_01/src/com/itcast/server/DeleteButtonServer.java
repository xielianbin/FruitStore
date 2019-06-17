package com.itcast.server;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.itcast.dao.DBConnection;
import com.itcast.dao.DeleteResultSet;
import com.itcast.view.FruitMainPage;

public class DeleteButtonServer implements ActionListener{
	FruitMainPage fruitMainPage;	//创建一个主界面对象

	public void setFruitMainPage(FruitMainPage fruitMainPage) {
		this.fruitMainPage = fruitMainPage;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		int deleteId=Integer.parseInt(fruitMainPage.deleteIdField.getText());
		DBConnection connection = new DBConnection();	//建立数据库连接
		new DeleteResultSet(deleteId, connection.getConnection());	//进行添加操作
		fruitMainPage.setVisible(false);
		fruitMainPage.dispose();
		new FruitMainPage().setVisible(true);
	}
}
