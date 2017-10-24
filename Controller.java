package Snake;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controller implements KeyListener ,Runnable{
	private final Background b;//背景
	private boolean running;//是否继续
	private View v;
	private long time=200;
	public Controller(Background b,boolean running,View v){
		this.b=b;
		this.running=running;
		this.v=v;
	}
public void keyPressed(KeyEvent k){
	int key=k.getKeyCode();
	time=50;
	if(key==KeyEvent.VK_UP){
		b.changeDirection(Direction.UP);
	}
	if(key==KeyEvent.VK_DOWN){
		b.changeDirection(Direction.DOWN);
	}
	if(key==KeyEvent.VK_LEFT){
		b.changeDirection(Direction.LEFT);
	}
	if(key==KeyEvent.VK_RIGHT){
		b.changeDirection(Direction.RIGHT);
	}
	if(key==KeyEvent.VK_ESCAPE){
		System.exit(0);
	}
	if(key==KeyEvent.VK_SPACE){
		System.out.println("space");
		running=false;
	}
}
@Override
public void run() {
	// TODO 自动生成的方法存根
	while(running){
		try{
			Thread.sleep(time);
		}
		catch(InterruptedException e){
			System.exit(0);
		}
		running=b.next();
		if(running)
			v.draw();
		else{
			v.gameOver();
		}
	}
}
@Override
public void keyTyped(KeyEvent e) {
	// TODO 自动生成的方法存根
}
@Override
public void keyReleased(KeyEvent e) {
	// TODO 自动生成的方法存根
	time=200;
}
}
