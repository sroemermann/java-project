package guitarStore;

import java.awt.EventQueue;

public class Main {
	
	static ShoppingCart cart = new ShoppingCart();
	static GuitarOrderingFrame frame;

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new GuitarOrderingFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}