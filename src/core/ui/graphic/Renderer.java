package core.ui.graphic;

import java.util.LinkedList;
import java.util.List;

public abstract class Renderer {
	private List<Graphic> _listOfGraphics;
	
	public Renderer() {
		_listOfGraphics = new LinkedList<Graphic>();
	}
	
	private void update(Graphic graphic) {
		
		for (Graphic graphic2 : _listOfGraphics) {
			if (graphic2.getLayer() >= graphic.getLayer())
				graphic2.draw();
		}
	}
	
	private void updateMultiple(List<Graphic> listOfGraphics) {
		
		Graphic updateParam = listOfGraphics.get(0);
		for (Graphic graphic : listOfGraphics) {
			if (graphic.getLayer() < updateParam.getLayer())
				updateParam = graphic;
		}
		
		update(updateParam);
	}
	
	public void createGraphic(Graphic graphic) {
		_listOfGraphics.add(graphic);
		_listOfGraphics.sort(Graphic.GraphicLayerComparator);
		
		update(graphic);
	}
	
	public void createMultipleGraphics(List<Graphic> listOfGraphics) {
		_listOfGraphics.addAll(listOfGraphics);
		_listOfGraphics.sort(Graphic.GraphicLayerComparator);
		
		updateMultiple(listOfGraphics);
	}
	
	public void deleteGraphic(Graphic graphic) {
		_listOfGraphics.remove(graphic);
		
		update(graphic);
	}
	
	public void deleteMultiplesGraphics(List<Graphic> listOfGraphics) {
		_listOfGraphics.removeAll(listOfGraphics);
		
		updateMultiple(listOfGraphics);
	}

	public void updateGraphic(Graphic oldGraphic, Graphic newGraphic) {
		_listOfGraphics.remove(oldGraphic);
		_listOfGraphics.add(newGraphic);
		_listOfGraphics.sort(Graphic.GraphicLayerComparator);
		
		update(newGraphic);
	}
	
	public void updateMultiplesGraphics(List<Graphic> listOfOldGraphics, List<Graphic> listOfNewGraphics) {
		_listOfGraphics.removeAll(listOfOldGraphics);
		_listOfGraphics.addAll(listOfNewGraphics);
		_listOfGraphics.sort(Graphic.GraphicLayerComparator);
		
		updateMultiple(listOfNewGraphics);
	}
}
