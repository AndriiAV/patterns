package adapter;

public class AdapterApp {

	public static void main(String[] args) {
		VectorGraphicsInterface vectorGraphics = new VectorAdapterFromRaster();
		vectorGraphics.drawLine();
		vectorGraphics.drawSquare();
	}

}

interface VectorGraphicsInterface{
	void drawLine();
	void drawSquare();
}
class RasterGraphics{
	void drawRasterLine() {
		System.out.println("Draw line");
	};
	void drawRasterSquare() {
		System.out.println("Draw square");
	};
}

class VectorAdapterFromRaster extends RasterGraphics implements VectorGraphicsInterface{
	public void drawLine() {
		drawRasterLine();
	}
	public void drawSquare() {
		drawRasterSquare();
	}
}