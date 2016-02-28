package core.ui.graphic;

import java.util.Comparator;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Label;

public abstract class Graphic {
	private long _id;
	protected short _layer;
	protected Rectangle _bounds;
	protected Label _label;
	
	public Graphic(long id, short layer, Rectangle bounds) {
		_id = id;
		_layer = layer;
		_bounds = bounds;
	}
	
	public long getId() {
		return _id;
	}
	
	public short getLayer() {
		return _layer;
	}
	
	public Rectangle getBounds() {
		return _bounds;
	}

	public abstract void draw(Renderer renderer);
	
	public static Comparator<Graphic> GraphicLayerComparator = 
			new Comparator<Graphic>() {

		@Override
		public int compare(Graphic o1, Graphic o2) {
			
			return o1.getLayer() - o2.getLayer();
		}
	};
}
