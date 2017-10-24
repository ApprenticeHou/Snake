package Snake;
/**
 * 移动的方向采用枚举的方式来代表
 * @author DELL
 *共有四个方向
 */
public enum Direction {
	//四个方向
	UP(0),
	DOWN(1),
	LEFT(2),
	RIGHT(3);
	//当前方向
	private final int direction;
	Direction(int i){
		this.direction=i;
	}
	//获取方向
	public int getDirection(){
		return direction;
	}
}
