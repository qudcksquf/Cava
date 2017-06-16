package playable;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

import playable.component.*;

public class Status1 extends JPanel {
	private Engine equippedEngine;
	private Engine storedEngine;
	private JLabel equippedLabel;
	private JLabel storedLabel;
	private JLabel confuseLabel;
	private JLabel lblBooster;
	private JLabel boosterLabel;
	private JLabel lblSpeed;
	private JLabel speedLabel;

	public Status1() {

		JLabel lblEquipped = new JLabel("Equipped");

		JLabel lblStored = new JLabel("Stored");

		equippedEngine = new BasicEngine();

		equippedLabel = new JLabel("BasicEngine");

		storedLabel = new JLabel("Empty");

		confuseLabel = new JLabel("Confused!");
		confuseLabel.setVisible(false);
		
		lblBooster = new JLabel("Booster");
		
		boosterLabel = new JLabel("Off");
		
		lblSpeed = new JLabel("Speed");
		
		speedLabel = new JLabel("13");
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(20)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(confuseLabel)
						.addComponent(boosterLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblStored)
						.addComponent(storedLabel)
						.addComponent(lblSpeed)
						.addComponent(speedLabel)
						.addComponent(equippedLabel)
						.addComponent(lblEquipped)
						.addComponent(lblBooster, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblEquipped)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(equippedLabel)
					.addGap(22)
					.addComponent(lblStored)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(storedLabel)
					.addGap(18)
					.addComponent(lblSpeed)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(speedLabel)
					.addGap(26)
					.addComponent(lblBooster)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(boosterLabel)
					.addGap(31)
					.addComponent(confuseLabel)
					.addContainerGap(49, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}

	public JLabel getEquippedLabel() {
		return equippedLabel;
	}

	public void setEquippedLabel(JLabel equippedLabel) {
		this.equippedLabel = equippedLabel;
	}

	public JLabel getStoredLabel() {
		return storedLabel;
	}

	public void setStoredLabel(JLabel storedLabel) {
		this.storedLabel = storedLabel;
	}

	public Engine getEquippedEngine() {
		return equippedEngine;
	}

	public void setEquippedEngine(Engine equippedEngine) {
		this.equippedEngine = equippedEngine;
	}

	public Engine getStoredEngine() {
		return storedEngine;
	}

	public void setStoredEngine(Engine storedEngine) {
		this.storedEngine = storedEngine;
	}

	public JLabel getConfuseLabel() {
		return confuseLabel;
	}

	public void setConfuseLabel(JLabel confuseLabel) {
		this.confuseLabel = confuseLabel;
	}

	public JLabel getBoosterLabel() {
		return boosterLabel;
	}

	public JLabel getSpeedLabel() {
		return speedLabel;
	}

	public void setBoosterLabel(JLabel boosterLabel) {
		this.boosterLabel = boosterLabel;
	}

	public void setSpeedLabel(JLabel speedLabel) {
		this.speedLabel = speedLabel;
	}	
}
