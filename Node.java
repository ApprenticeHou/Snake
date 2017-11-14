package Snake;
/**
 * 蛇身的节点
 * @author DELL
 *定义当前节点的位置
 */
public class Node {
private int x;//x坐标
private int y;//y坐标
public Node(int x,int y){
	this.x=x;
	this.y=y;
}
//得到x坐标
public int getX(){
	return x;
}
//得到y坐标
public int getY(){
	return y;
}
}
