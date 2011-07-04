package no.mesan.workmanship.yatzy;

import javax.swing.JFrame;
import javax.swing.UIManager;

import no.mesan.workmanship.yatzy.beregning.score.Beregner;
import no.mesan.workmanship.yatzy.presentasjon.YatzyPresentasjonsmodellImpl;
import no.mesan.workmanship.yatzy.view.YatzyPanel;

public class Yatzy {
	public Yatzy() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (final Exception e) {
			e.printStackTrace();
		}

		final JFrame frame = new JFrame("Yatzy");
		frame.setContentPane(new YatzyPanel(new YatzyPresentasjonsmodellImpl(new Beregner())));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	};

	public static void main(final String[] args) {
		new Yatzy();
	}
}
