package core.ui;

import java.util.Comparator;

import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Label;

import core.ui.graphic.Renderer;

public abstract class UI_Element {

	protected int _layer;
	protected Rectangle _bounds;
	protected Label _label;
	
	public UI_Element(int layer, Rectangle bounds) {
		_layer = layer;
		_bounds = bounds;
	}
	
	public int getLayer() {
		return _layer;
	}
	
	public Rectangle getBounds() {
		return _bounds;
	}

	public abstract void draw(Renderer renderer);
	
	public static Comparator<UI_Element> UI_ElementLayerComparator = 
			new Comparator<UI_Element>() {

		@Override
		public int compare(UI_Element o1, UI_Element o2) {
			
			return o1.getLayer() - o2.getLayer();
		}
	};
}
