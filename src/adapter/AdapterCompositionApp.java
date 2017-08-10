package adapter;

public class AdapterCompositionApp {
	public static void main(String[] args) {
		VectorGraphicsInterfaceComposition vectorGraphicsComposition = new VectorAdapterFromRasterComposition();
		vectorGraphicsComposition.drawLine();
		vectorGraphicsComposition.drawSquare();	
	}	
}

interface VectorGraphicsInterfaceComposition{
	void drawLine();
	void drawSquare();
}

class RasterGraphicsComposition{
	void drawRasterLine() {
		System.out.println("Draw line");
	};
	void drawRasterSquare() {
		System.out.println("Draw square");
	};
}

class VectorAdapterFromRasterComposition implements VectorGraphicsInterfaceComposition{
	RasterGraphicsComposition raster = new RasterGraphicsComposition();
	
	public void drawLine() {
		raster.drawRasterLine();
	}
	public void drawSquare() {
		raster.drawRasterSquare();
	}
}