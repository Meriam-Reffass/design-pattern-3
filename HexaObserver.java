package casestudy;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings({ "deprecation", "serial" })
public class HexaObserver  extends JFrame implements Observer, ActionListener  {
	private Subject subject;
	private JLabel label = new JLabel("Sate Octal Value : Undefined");
	private JPanel labelPanel = new JPanel();
	private JPanel buttonPanel = new JPanel();
	private JPanel emptyPanel = new JPanel();
	private JButton subscribe = new JButton("Subscribe-Me");
	private JButton unsubscribe = new JButton("Unsubscribe-Me");
	
	public HexaObserver(Subject subject) {
		// TODO Auto-generated constructor stub
		super("Welcome to the Hexa Observer!");
		this.subject=subject;
		this.setLayout(new FlowLayout());
		labelPanel.setLayout(new FlowLayout());
		buttonPanel.setLayout(new FlowLayout());
		labelPanel.add(label);
		buttonPanel.add(subscribe);
		buttonPanel.add(unsubscribe);
		emptyPanel.setPreferredSize(new Dimension(300,150));
		subscribe.addActionListener(this);
		unsubscribe.addActionListener(this);
		this.add(labelPanel);
		this.add(emptyPanel);
		this.add(buttonPanel);
		this.subscribe.setEnabled(true);
		this.unsubscribe.setEnabled(false);
		this.setSize(300,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	
	

	public JLabel getLabel() {
		return label;
	}
	
	public void setLabel(JLabel label) {
		this.label = label;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==subscribe) {
			this.subject.addObserver(this);
			this.subscribe.setEnabled(false);
			this.unsubscribe.setEnabled(true);
		}
		else if (e.getSource()==unsubscribe) {
			this.subject.deleteObserver(this);
			this.getLabel().setText("State Hexa Value : Undefined");
			this.subscribe.setEnabled(true);
			this.unsubscribe.setEnabled(false);
			

		}
	}




	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		this.getLabel().setText("State Hexa Value : " + Integer.toHexString(((Subject)o).getState()));

	}
}
