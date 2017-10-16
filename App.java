package Snake;
/**
 * 视图部分
 * @author HOU
 *用来显示界面背景和蛇
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;

public class App {
/**
 * 展示界面
 */
	private Background b;
	Controller controller;
public void init(){
	JFrame jf=new JFrame("侯汉森版本-贪吃蛇");
	b=new Background( View.width,View.height);//背景
	View v=new View(b);//初始化背景
	v.init();
	v.getJPanel().setPreferredSize(new Dimension(View.height,View.width));//设置大小
	controller=new Controller(b,true,v);
	Container c=jf.getContentPane();//用于添加组件
	jf.addKeyListener(controller);
	new Thread(controller).start();;
	c.add(v.getJPanel(), BorderLayout.CENTER);
	jf.setBackground(Color.BLACK);
	jf.setPreferredSize(new Dimension(View.width+10, View.height+10));
	jf.pack();//适应电脑屏幕
	jf.setResizable(false);
	jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	jf.setVisible(true);
}
public static void main(String[] args) {
	App myApp=new App();
	myApp.init();
}
}
