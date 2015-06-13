package no.mesan.workmanship.yatzy;

import javax.swing.*;

import no.mesan.workmanship.yatzy.beregning.Beregner;
import no.mesan.workmanship.yatzy.presentasjon.YatzyPresentasjonsmodellImpl;
import no.mesan.workmanship.yatzy.view.YatzyPanel;

class Yatzy {
    private Yatzy() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        final JFrame frame = new JFrame("Yatzy");
        frame.setContentPane(new YatzyPanel(new YatzyPresentasjonsmodellImpl(new Beregner())));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Yatzy();
    }
}
