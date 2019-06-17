package com.itcast.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

@SuppressWarnings("serial")
public class FruitHomePage extends JFrame implements FruitView {
	public JLabel pictureLabel;
	public JButton startButton = new JButton("进入系统");

	@Override
	public void init() {
		// TODO Auto-generated method stub
		startButton.setBounds(280, 360, 100, 50);
		StartButtonActionListener startButtonActionListener = new StartButtonActionListener();
		startButtonActionListener.setFruitHomePage(this);
		startButton.addActionListener(startButtonActionListener);
		pictureLabel = new JLabel(new ImageIcon("src/com/itcast/view/fruit03.jpg"));
		pictureLabel.setBounds(90, 40, 500, 289);
		this.add(startButton);
		this.add(pictureLabel);
		this.setLayout(null);
		this.setResizable(false);

	}

	public FruitHomePage() {
		init();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(frameLocationX, frameLocationY, frameSizeX, frameSizeY);
		this.setTitle("水果超市");
	}
}

//开始按钮的动作事件
class StartButtonActionListener implements ActionListener {
	public FruitHomePage fruitHomePage;
	public void setFruitHomePage(FruitHomePage fruitHomePage) {
		this.fruitHomePage = fruitHomePage;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		fruitHomePage.setVisible(false);
		fruitHomePage.dispose();
		new FruitMainPage().setVisible(true);
	}

}
