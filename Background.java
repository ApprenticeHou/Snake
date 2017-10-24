package Snake;
/**
 * 背景面板
 * @author HOU
 *
 */
public class Background {
private int width;
private int height;
boolean[][] Has;//代表此位置是否被蛇占用，是为true，否则为false
private Snake s;
private Node food;//食物
public Background(int width,int height){
	this.width=width;
	this.height=height;
	Has=new boolean[width/17][height/17];//17代表的是蛇身之间的间距
	firstSnake();
	food=createFood();
}
/**
 * 创建食物
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
 * 初始化蛇，开始位置位于中间同时将
 * @return 返回蛇
 */
private Snake firstSnake(){
	s=new Snake(width/34,height/34);
	Has[width/34][height/34]=true;
	System.out.println("屏幕尺寸"+"宽"+width+"高"+height);
	return s;
}
//设置蛇的初始方向,向上
public static Direction curDirection=Direction.UP;
/**
 * 改变蛇的移动方向
 * @param newDirection新的方向
 */
public void changeDirection(Direction newDirection){
	curDirection=newDirection;
}
/**
 * 蛇的移动判断是否结束游戏
 * @return 是否死亡
 */
public boolean next(){
	Node last=s.body.getLast();
	if(s.move(food, curDirection)){//吃到食物的情况
		//当蛇头碰到蛇身或者碰到墙壁时死亡
		if(Has[s.getHead().getX()][s.getHead().getY()]==true||s.getHead().getX()>=width/17||
				s.getHead().getY()>=height/17||s.getHead().getX()<0||s.getHead().getY()<5.5){
			if(Has[s.getHead().getX()][s.getHead().getY()]){
				System.out.println("死亡原因1-1");
				System.out.println("死亡位置"+"x"+s.getHead().getX()+"y"+s.getHead().getY());
			}
			else
				System.out.println("死亡原因1-2");
			food=null;
			s=null;
			for(int x=0;x<width/17;x++)
				for(int y=0;y<height/17;y++){
					Has[x][y]=false;
				}
			return false;//死亡
		}
		Has[s.getHead().getX()][s.getHead().getY()]=true;//改变头部状态
		food=createFood();//食物改变
		return true;//活着
	}
	else{//蛇没有吃到食物
		Has[last.getX()][last.getY()]=false;//将原来尾部状态改变
		//当蛇头碰到蛇身或者碰到墙壁时死亡
				if(s.getHead().getX()>=width/17||s.getHead().getY()>=height/17||s.getHead().getX()<0||s.getHead().getY()<5.5
						||(Has[s.getHead().getX()][s.getHead().getY()])){
					/*if(Has[s.getHead().getX()][s.getHead().getY()]){
						System.out.println("死亡原因2-1");
						System.out.println("死亡位置"+"x"+s.getHead().getX()+"y"+s.getHead().getY());
						System.out.println("死亡食物位置"+"x"+food.getX()+"y"+food.getY());
					}
					else
						System.out.println("死亡原因2-2");*/
					food=null;
					s=null;
					for(int x=0;x<width/17;x++)
						for(int y=0;y<height/17;y++){
							Has[x][y]=false;
						}
					return false;
				}
				Has[s.getHead().getX()][s.getHead().getY()]=true;//改变头部状态
				return true;
	}
}
/**
 * 得到蛇
 * @return 蛇
 */
public Snake getSnake(){
	return s;
}
/**
 * 得到食物
 * @return 返回食物
 */
public Node getFood(){
	return food;
}
}