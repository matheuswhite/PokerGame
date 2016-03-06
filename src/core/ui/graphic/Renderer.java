package core.ui.graphic;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import core.ui.UI_Element;

public class Renderer{
	private List<UI_Element> _listOfUI_Elements;
	private Shell _shell;
	private Display _display;
	
	public Renderer() {
		_listOfUI_Elements = new LinkedList<UI_Element>();
		_display = new Display();
		_shell = new Shell(_display);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		_shell.setMaximized(false);
		_shell.setSize((int)(screenSize.getWidth() / 1.7075), (int)(screenSize.getHeight() / 1.536));
		_shell.setLocation((int)(screenSize.getWidth()/2 - _shell.getSize().x/2), (int)(screenSize.getHeight()/2 - _shell.getSize().y/2));
		_shell.setText("PokerGame");
	}
	
	private void update(UI_Element graphic) {
		
		for (UI_Element graphic2 : _listOfUI_Elements) {
			if (graphic2.getLayer() >= graphic.getLayer())
				graphic2.draw(this);
		}
	}
	
	private void updateMultiple(List<UI_Element> listOfUI_Elements) {
		
		UI_Element updateParam = listOfUI_Elements.get(0);
		for (UI_Element graphic : listOfUI_Elements) {
			if (graphic.getLayer() < updateParam.getLayer())
				updateParam = graphic;
		}
		
		update(updateParam);
	}
	
	public Shell getShell() {
		return _shell;
	}
	
	public Display getDisplay() {
		return _display;
	}
	
	public void createUI_Element(UI_Element graphic) {
		_listOfUI_Elements.add(graphic);
		_listOfUI_Elements.sort(UI_Element.UI_ElementLayerComparator);
		
		update(graphic);
	}
	
	public void createMultipleUI_Elements(List<UI_Element> listOfUI_Elements) {
		_listOfUI_Elements.addAll(listOfUI_Elements);
		_listOfUI_Elements.sort(UI_Element.UI_ElementLayerComparator);
		
		updateMultiple(listOfUI_Elements);
	}
	
	public void deleteUI_Element(UI_Element graphic) {
		_listOfUI_Elements.remove(graphic);
		
		update(graphic);
	}
	
	public void deleteMultiplesUI_Elements(List<UI_Element> listOfUI_Elements) {
		_listOfUI_Elements.removeAll(listOfUI_Elements);
		
		updateMultiple(listOfUI_Elements);
	}

	public void updateUI_Element(UI_Element oldUI_Element, UI_Element newUI_Element) {
		_listOfUI_Elements.remove(oldUI_Element);
		_listOfUI_Elements.add(newUI_Element);
		_listOfUI_Elements.sort(UI_Element.UI_ElementLayerComparator);
		
		update(newUI_Element);
	}
	
	public void updateMultiplesUI_Elements(List<UI_Element> listOfOldUI_Elements, List<UI_Element> listOfNewUI_Elements) {
		_listOfUI_Elements.removeAll(listOfOldUI_Elements);
		_listOfUI_Elements.addAll(listOfNewUI_Elements);
		_listOfUI_Elements.sort(UI_Element.UI_ElementLayerComparator);
		
		updateMultiple(listOfNewUI_Elements);
	}
}
