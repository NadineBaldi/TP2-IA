package interfaz;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JTextField;

@SuppressWarnings("serial")
public class RoundJTextField extends JTextField{ 
	
	private Shape shape;
	
	public RoundJTextField(int size) {
		super(size);
		setOpaque(false);
	}
	
	protected void paintComponent(Graphics g) {
		g.setColor(getBackground());
		g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 40, 40);
		super.paintComponent(g);
	}
	
	protected void paintBorder(Graphics g) {
		g.setColor(new Color(244, 164, 96));
		g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 40, 40);
	}
	
	public boolean contains(int x, int y) {
		if (shape == null || !shape.getBounds().equals(getBounds())) {
			shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, 40, 40);
		}
		return shape.contains(x, y);
	}

}
