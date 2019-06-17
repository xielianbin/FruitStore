package com.itcast.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import com.itcast.dao.DBConnection;
import com.itcast.dao.SelectResultSet;
import com.itcast.server.AddButtonServer;
import com.itcast.server.DeleteButtonServer;
import com.itcast.server.UpdateButtonServer;

@SuppressWarnings("serial")
public class FruitMainPage extends JFrame implements FruitView {
	private JLabel titleLabel = new JLabel("水果列表");
	private JTable table;
	private JScrollPane scrollPane;
	private JPanel informationPanel = new JPanel(); // 水果信息面板容器
	private JPanel addPanel = new JPanel(); // 添加水果面板
	private JPanel updatePanel = new JPanel(); // 修改水果面板
	private JPanel deletePanel = new JPanel(); // 删除水果面板
	private JLabel idLabel = new JLabel("水果编号");
	private JLabel nameLabel = new JLabel("水果名称");
	private JLabel priceLabel = new JLabel("水果单价");
	private JLabel unitLabel = new JLabel("水果单位");
	public JTextField addIdField = new JTextField();
	public JTextField addNameField = new JTextField();
	public JTextField addPriceField = new JTextField();
	public JTextField addUnitField = new JTextField();
	public JTextField updatIdField = new JTextField();
	public JTextField updatNameField = new JTextField();
	public JTextField updatPriceField = new JTextField();
	public JTextField updatUnitField = new JTextField();
	public JTextField deleteIdField = new JTextField();
	private JButton addButton = new JButton("添加水果");
	private JButton updateButton = new JButton("修改水果");
	private JButton deleteButton = new JButton("删除水果");
	private final int WIDTH = 90; // 面板内每个组件的宽度
	private final int OFFSET = 40; // 面板内每个组件的偏移量
	private final int PANEL_HEIGTH_OFFSET = 30;

	// 表格初始化
	public void tableInit() {
		String queryTable = "select * from fruit";
		DBConnection connection = new DBConnection();
		String[][] tableData = new SelectResultSet().selectResultSet(queryTable, connection.getConnection());
		String[] tableHead = { "水果编号", "水果名称", "水果单价", "水果单位" };
		// TableModel dataModel=new DefaultTableModel();
		table = new JTable(tableData, tableHead);
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		titleLabel.setBounds(280, 10, 100, 30);
		// table面板容器
		tableInit();
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(30, 40, 610, 250);
		// 信息面板的组件的布局
		idLabel.setBounds(0, 0, WIDTH, 30);
		nameLabel.setBounds(WIDTH * 1 + OFFSET * 1, 0, WIDTH, 30);
		priceLabel.setBounds(WIDTH * 2 + OFFSET * 2, 0, WIDTH, 30);
		unitLabel.setBounds(WIDTH * 3 + OFFSET * 3, 0, WIDTH, 30);
		// 添加面板的组件的布局
		addIdField.setBounds(0, 0, WIDTH, 25);
		addNameField.setBounds(WIDTH * 1 + OFFSET * 1, 0, WIDTH, 25);
		addPriceField.setBounds(WIDTH * 2 + OFFSET * 2, 0, WIDTH, 25);
		addUnitField.setBounds(WIDTH * 3 + OFFSET * 3, 0, WIDTH, 25);
		addButton.setBounds(WIDTH * 4 + OFFSET * 4, 0, WIDTH, 25);
		 AddButtonServer addButtonAction=new AddButtonServer();
		 addButtonAction.setFruitMainPage(this);
		addButton.addActionListener(addButtonAction);
		// 修改面板的组件的布局
		updatIdField.setBounds(0, 0, WIDTH, 25);
		updatNameField.setBounds(WIDTH * 1 + OFFSET * 1, 0, WIDTH, 25);
		updatPriceField.setBounds(WIDTH * 2 + OFFSET * 2, 0, WIDTH, 25);
		updatUnitField.setBounds(WIDTH * 3 + OFFSET * 3, 0, WIDTH, 25);
		updateButton.setBounds(WIDTH * 4 + OFFSET * 4, 0, WIDTH, 25);
		UpdateButtonServer updateAction=new UpdateButtonServer();
		updateAction.setFruitMainPage(this);
		updateButton.addActionListener(updateAction);
		// 删除面板的组件布局
		deleteIdField.setBounds(0, 0, WIDTH, 25);
		deleteButton.setBounds(WIDTH * 4 + OFFSET * 4, 0, WIDTH, 25);
		DeleteButtonServer deleteAction=new DeleteButtonServer();
		deleteAction.setFruitMainPage(this);
		deleteButton.addActionListener(deleteAction);
		// 设置面板布局方式
		informationPanel.setLayout(null);
		addPanel.setLayout(null);
		updatePanel.setLayout(null);
		deletePanel.setLayout(null);
		// 添加信息面板的组件
		informationPanel.add(idLabel);
		informationPanel.add(nameLabel);
		informationPanel.add(priceLabel);
		informationPanel.add(unitLabel);
		// 添加添加面板的组件
		addPanel.add(addIdField);
		addPanel.add(addNameField);
		addPanel.add(addPriceField);
		addPanel.add(addUnitField);
		addPanel.add(addButton);
		// 添加修改面板的组件
		updatePanel.add(updatIdField);
		updatePanel.add(updatNameField);
		updatePanel.add(updatPriceField);
		updatePanel.add(updatUnitField);
		updatePanel.add(updateButton);
		// 添加删除面板的组件
		deletePanel.add(deleteIdField);
		deletePanel.add(deleteButton);

		informationPanel.setBounds(30, 298, 610, 30);
		addPanel.setBounds(30, 300 + PANEL_HEIGTH_OFFSET, 610, 25);
		updatePanel.setBounds(30, 300 + PANEL_HEIGTH_OFFSET * 2, 610, 25);
		deletePanel.setBounds(30, 300 + PANEL_HEIGTH_OFFSET * 3, 610, 25);
		this.add(titleLabel);
		this.add(scrollPane);
		this.add(informationPanel);
		this.add(addPanel);
		this.add(updatePanel);
		this.add(deletePanel);
		this.setLayout(null);
	}

	public FruitMainPage() {

		init();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(frameLocationX, frameLocationY, frameSizeX, frameSizeY);
		this.setTitle("超市货物管理");
		this.setResizable(false);
	}

}
