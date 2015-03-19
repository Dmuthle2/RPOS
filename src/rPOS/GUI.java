package rPOS;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

public class GUI {

	private Shell shell;
	String title = "Raspberry Point of Sale";
	
	
	public GUI(Display display){
		shell = new Shell(display);
		shell.setText(title);
		
		testButton();
		
		shell.setSize(1024, 768);
		shell.setLocation(300,300);
		shell.open();
		
		while(!shell.isDisposed()){
			if(!display.readAndDispatch()){
				display.sleep(); 
			}
		}
	}
	
	private void testButton() {
		Button button1 = new Button(shell, SWT.PUSH);
		button1.setText("Login");
		button1.setBounds(20,20,80,30);
		button1.addListener(SWT.Selection, new Listener(){
			public void handleEvent(Event e){
				switch(e.type){
				case SWT.Selection:
					System.out.println("Button Pressed");
					break;
				}
			}
		});
	}

	public static void main(String[] args) {
		Display display = new Display();
		new GUI(display);
		display.dispose();
		
	}

}
