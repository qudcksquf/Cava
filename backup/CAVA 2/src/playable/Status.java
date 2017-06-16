package playable;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.SystemColor;

public class Status extends JPanel{

	private JProgressBar oilgauge = new JProgressBar();
	private JProgressBar hp = new JProgressBar();
	private JProgressBar delayPB = new JProgressBar();
	
	public JProgressBar getDelayPB() {
		return delayPB;
	}

	public void setDelayPB(JProgressBar delayPB) {
		this.delayPB = delayPB;
	}

	public Status() {
		oilgauge.setForeground(Color.ORANGE);
		oilgauge.setMaximum(450);
		oilgauge.setValue(450);
		hp.setMaximum(200);
		hp.setForeground(Color.RED);
		hp.setValue(200);
		delayPB.setMaximum(1000);
		
		JLabel lblOilGauge = new JLabel("Oil Gauge");
		
		
		JLabel lblHp = new JLabel("HP");
		
		JLabel lblDelay = new JLabel("Delay");
		
		delayPB.setForeground(Color.GREEN);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(175, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(oilgauge, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblOilGauge))
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(hp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblHp))
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDelay)
						.addComponent(delayPB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(81))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblOilGauge)
						.addComponent(lblHp)
						.addComponent(lblDelay))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(oilgauge, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(hp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(delayPB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		setLayout(groupLayout);
	}

	public JProgressBar getOilgauge() {
		return oilgauge;
	}

	public void setOilgauge(JProgressBar oilgauge) {
		this.oilgauge = oilgauge;
	}

	public JProgressBar getHp() {
		return hp;
	}

	public void setHp(JProgressBar hp) {
		this.hp = hp;
	}


}
