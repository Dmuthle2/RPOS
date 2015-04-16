package rPOS;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class GUI {

	private Shell shell;
	String title = "Raspberry Point of Sale";
	PiOS pi = new PiOS();

	public GUI(Display display) {
		shell = new Shell(display);
		shell.setText(title);

		startMenu();

		shell.setSize(1024, 768);
		shell.setLocation(0,0);
		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	private void startMenu() {
		
		//Set up Keypad/Extra buttons
		drawKeypad();
		
		// Establish Buttons
		Button login = new Button(shell, SWT.PUSH);
		Button exit = new Button(shell, SWT.PUSH);

		// Set Text of Buttons
		login.setText("Login");
		exit.setText("Exit");

		// Set Bounds for Buttons
		login.setBounds(40, 20, 80, 60);
		exit.setBounds(40, 658, 80, 60);

		// exit button listener
		exit.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				switch (e.type) {
				case SWT.Selection:
					System.out.println("Exit Button Pressed");
					System.exit(0);
				}
			}
		});

		// Login Button Listener
		login.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				switch (e.type) {
				case SWT.Selection:
					System.out.println("Login Button Pressed");
					loginMenu();
					// pi.login();
					break;
				}
			}

			private void loginMenu() {

				String username;
				String password;

				// Declare Username and Password Field
				Text uName = new Text(shell, SWT.SINGLE);
				Text pAssword = new Text(shell, SWT.PASSWORD);
				Button loginButton = new Button(shell, SWT.PUSH);

				// Hopefully set Text Fields
				uName.setText("Enter Username");
				uName.setToolTipText("Enter Username");
				pAssword.setToolTipText("Enter Password");
				loginButton.setText("Submit");
				loginButton.setToolTipText("Submit Credentials");

				// Set Display Bounds
				uName.setBounds(((1024/2)-(150/2)), 768/4, 150, 30);
				pAssword.setBounds(((1024/2)-(150/2)), (768/4)+34, 150, 30);
				loginButton.setBounds(((1024/2)-(150/2))+150, (768/4), 80, 64);

				// Debug Statements Here
				uName.getText();
				pAssword.getText();

				loginButton.addListener(SWT.Selection, new Listener() {
					public void handleEvent(Event e) {
						switch (e.type) {
						case SWT.Selection:
							System.out.println("Submit Button Pressed");
							break;
						}
					}
				});

			}
		});
	}

	private void drawKeypad() {
		
		//set up buttons for keypad
		Button zero = new Button(shell, SWT.PUSH);
		Button one = new Button(shell, SWT.PUSH);
		Button two = new Button(shell, SWT.PUSH);
		Button three = new Button(shell, SWT.PUSH);
		Button four = new Button(shell, SWT.PUSH);
		Button five = new Button(shell, SWT.PUSH);
		Button six = new Button(shell, SWT.PUSH);
		Button seven = new Button(shell, SWT.PUSH);
		Button eight = new Button(shell, SWT.PUSH);
		Button nine = new Button(shell, SWT.PUSH);
		Button fSlash = new Button(shell, SWT.PUSH);
		Button star = new Button(shell, SWT.PUSH);
		Button minus = new Button(shell, SWT.PUSH);
		Button plus = new Button(shell, SWT.PUSH);
		Button dot = new Button(shell, SWT.PUSH);
		
		//Set up text for buttons
		zero.setText("0");
		one.setText("1");
		two.setText("2");
		three.setText("3");
		four.setText("4");
		five.setText("5");
		six.setText("6");
		seven.setText("7");
		eight.setText("8");
		nine.setText("9");
		fSlash.setText("/");
		star.setText("*");
		minus.setText("-");
		plus.setText("+");
		dot.setText(".");
		
		//set bounds for keypad buttons
		zero.setBounds(654, 658, 160, 60);
		one.setBounds(654, 598, 80, 60);
		four.setBounds(654, 538, 80, 60);
		seven.setBounds(654, 478, 80, 60);
		
		two.setBounds(734, 598, 80, 60);
		five.setBounds(734, 538, 80, 60);
		eight.setBounds(734, 478, 80, 60);
		fSlash.setBounds(734, 418, 80, 60);

		dot.setBounds(814, 658, 80, 60);
		three.setBounds(814, 598, 80, 60);
		six.setBounds(814, 538, 80, 60);
		nine.setBounds(814, 478, 80, 60);
		star.setBounds(814, 418, 80, 60);
		
		plus.setBounds(894, 478, 80, 120);
		minus.setBounds(894, 418, 80, 60);
		
		
		
		
		
	}

	public static void main(String[] args) {
		Display display = new Display();
		new GUI(display);
		display.dispose();

	}

}
