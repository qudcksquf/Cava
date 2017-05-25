package objects;
import java.awt.Image;
import java.awt.image.*;

abstract public class Things {
	// 위치 정보
	private int x;
	private int y;
	
	// 이미지
	private Image image;
	
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		if(image == null)
			this.image = image;
		else {
			// exception handling
			System.out.println("Image Load Error!");
		}
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
	abstract void copy(Things input); // 딥카피, Polymorphism 활용 instanceof 로 캐스팅 꼭 해줄것.
}
