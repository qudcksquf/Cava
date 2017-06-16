package playable;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;

public class Status2 extends JPanel{

	private JProgressBar oilgaugePB = new JProgressBar();
	private JProgressBar hpPB = new JProgressBar();
	private JProgressBar delayPB = new JProgressBar();
	private JProgressBar skillDelayPB = new JProgressBar();

	private JLabel lblOilGauge = new JLabel("Oil Gauge");
	private JLabel lblHp = new JLabel("HP");
	private JLabel lblBooterDelay = new JLabel("Booter Delay");
	private JLabel lblSkillDelay = new JLabel("Skill delay");

	public Status2() {
		oilgaugePB.setForeground(Color.ORANGE);
		oilgaugePB.setMaximum(450);
		oilgaugePB.setValue(450);
		hpPB.setMaximum(200);
		hpPB.setForeground(Color.RED);
		hpPB.setValue(200);
		delayPB.setMaximum(1000);
		
		lblSkillDelay.setVisible(false);
		skillDelayPB.setVisible(false);
		
		delayPB.setForeground(Color.GREEN);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(74)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(oilgaugePB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblOilGauge))
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(hpPB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblHp))
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(delayPB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblBooterDelay))
					.addPreferredGap(ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblSkillDelay)
						.addComponent(skillDelayPB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		skillDelayPB.setMaximum(3000);
		skillDelayPB.setValue(0);
		skillDelayPB.setForeground(Color.PINK);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblOilGauge)
						.addComponent(lblHp)
						.addComponent(lblBooterDelay)
						.addComponent(lblSkillDelay))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(oilgaugePB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(hpPB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(delayPB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(skillDelayPB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		setLayout(groupLayout);
	}

	public JProgressBar getOilgauge() {
		return oilgaugePB;
	}

	public void setOilgauge(JProgressBar oilgauge) {
		this.oilgaugePB = oilgauge;
	}

	public JProgressBar getHp() {
		return hpPB;
	}

	public void setHp(JProgressBar hp) {
		this.hpPB = hp;
	}

	public JProgressBar getSkillDelay() {
		return skillDelayPB;
	}

	public void setSkillDelay(JProgressBar skillDelay) {
		this.skillDelayPB = skillDelay;
	}	
	
	public JLabel getLblSkillDelay() {
		return lblSkillDelay;
	}

	public void setLblSkillDelay(JLabel lblSkillDelay) {
		this.lblSkillDelay = lblSkillDelay;
	}
	public JProgressBar getDelayPB() {
		return delayPB;
	}

	public void setDelayPB(JProgressBar delayPB) {
		this.delayPB = delayPB;
	}
}
