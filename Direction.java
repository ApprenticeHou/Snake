package Snake;
/**
 * �ƶ��ķ������ö�ٵķ�ʽ������
 * @author DELL
 *�����ĸ�����
 */
public enum Direction {
	//�ĸ�����
	UP(0),
	DOWN(1),
	LEFT(2),
	RIGHT(3);
	//��ǰ����
	private final int direction;
	Direction(int i){
		this.direction=i;
	}
	//��ȡ����
	public int getDirection(){
		return direction;
	}
}
