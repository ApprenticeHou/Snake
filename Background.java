package Snake;
/**
 * �������
 * @author HOU
 *
 */
public class Background {
private int width;
private int height;
boolean[][] Has;//�����λ���Ƿ���ռ�ã���Ϊtrue������Ϊfalse
private Snake s;
private Node food;//ʳ��
public Background(int width,int height){
	this.width=width;
	this.height=height;
	Has=new boolean[width/17][height/17];//17�����������֮��ļ��
	firstSnake();
	food=createFood();
}
/**
 * ����ʳ��
 */
public Node createFood(){
	View.random=(int) (7*(Math.random()));
	int x=(int) (Math.random()*width)/17;
	int y=(int)(Math.random()*(height-110))/17+6;
	while(Has[x][y]==true){
		x=(int) (Math.random()*width)/17;
		y=(int)(Math.random()*(height-110))/17+6;
	}
	System.out.print("food"+"x"+x*17+"y"+y*17);
	return new Node(x,y);
}
/**
 * ��ʼ���ߣ���ʼλ��λ���м�ͬʱ��
 * @return ������
 */
private Snake firstSnake(){
	s=new Snake(width/34,height/34);
	Has[width/34][height/34]=true;
	System.out.println("��Ļ�ߴ�"+"��"+width+"��"+height);
	return s;
}
//�����ߵĳ�ʼ����,����
public static Direction curDirection=Direction.UP;
/**
 * �ı��ߵ��ƶ�����
 * @param newDirection�µķ���
 */
public void changeDirection(Direction newDirection){
	curDirection=newDirection;
}
/**
 * �ߵ��ƶ��ж��Ƿ������Ϸ
 * @return �Ƿ�����
 */
public boolean next(){
	Node last=s.body.getLast();
	if(s.move(food, curDirection)){//�Ե�ʳ������
		//����ͷ���������������ǽ��ʱ����
		if(Has[s.getHead().getX()][s.getHead().getY()]==true||s.getHead().getX()>=width/17||
				s.getHead().getY()>=height/17||s.getHead().getX()<0||s.getHead().getY()<5.5){
			if(Has[s.getHead().getX()][s.getHead().getY()]){
				System.out.println("����ԭ��1-1");
				System.out.println("����λ��"+"x"+s.getHead().getX()+"y"+s.getHead().getY());
			}
			else
				System.out.println("����ԭ��1-2");
			food=null;
			s=null;
			for(int x=0;x<width/17;x++)
				for(int y=0;y<height/17;y++){
					Has[x][y]=false;
				}
			return false;//����
		}
		Has[s.getHead().getX()][s.getHead().getY()]=true;//�ı�ͷ��״̬
		food=createFood();//ʳ��ı�
		return true;//����
	}
	else{//��û�гԵ�ʳ��
		Has[last.getX()][last.getY()]=false;//��ԭ��β��״̬�ı�
		//����ͷ���������������ǽ��ʱ����
				if(s.getHead().getX()>=width/17||s.getHead().getY()>=height/17||s.getHead().getX()<0||s.getHead().getY()<5.5
						||(Has[s.getHead().getX()][s.getHead().getY()])){
					/*if(Has[s.getHead().getX()][s.getHead().getY()]){
						System.out.println("����ԭ��2-1");
						System.out.println("����λ��"+"x"+s.getHead().getX()+"y"+s.getHead().getY());
						System.out.println("����ʳ��λ��"+"x"+food.getX()+"y"+food.getY());
					}
					else
						System.out.println("����ԭ��2-2");*/
					food=null;
					s=null;
					for(int x=0;x<width/17;x++)
						for(int y=0;y<height/17;y++){
							Has[x][y]=false;
						}
					return false;
				}
				Has[s.getHead().getX()][s.getHead().getY()]=true;//�ı�ͷ��״̬
				return true;
	}
}
/**
 * �õ���
 * @return ��
 */
public Snake getSnake(){
	return s;
}
/**
 * �õ�ʳ��
 * @return ����ʳ��
 */
public Node getFood(){
	return food;
}
}