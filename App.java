package Snake;
/**
 * ��ͼ����
 * @author HOU
 *������ʾ���汳������
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;

public class App {
/**
 * չʾ����
 */
	private Background b;
	Controller controller;
public void init(){
	JFrame jf=new JFrame("�ɭ�汾-̰����");
	b=new Background( View.width,View.height);//����
	View v=new View(b);//��ʼ������
	v.init();
	v.getJPanel().setPreferredSize(new Dimension(View.height,View.width));//���ô�С
	controller=new Controller(b,true,v);
	Container c=jf.getContentPane();//����������
	jf.addKeyListener(controller);
	new Thread(controller).start();;
	c.add(v.getJPanel(), BorderLayout.CENTER);
	jf.setBackground(Color.BLACK);
	jf.setPreferredSize(new Dimension(View.width+10, View.height+10));
	jf.pack();//��Ӧ������Ļ
	jf.setResizable(false);
	jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	jf.setVisible(true);
}
public static void main(String[] args) {
	App myApp=new App();
	myApp.init();
}
}
