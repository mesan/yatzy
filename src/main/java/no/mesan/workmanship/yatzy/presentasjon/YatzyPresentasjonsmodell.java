package no.mesan.workmanship.yatzy.presentasjon;

import javax.swing.Action;

import com.jgoodies.binding.list.SelectionInList;
import com.jgoodies.binding.value.ComponentValueModel;

import no.mesan.workmanship.yatzy.annotations.Unntak;
import no.mesan.workmanship.yatzy.domene.Yatzykombinasjon;

@Unntak
public interface YatzyPresentasjonsmodell {
	SelectionInList<Yatzykombinasjon> kombinasjonModel();
	ComponentValueModel[] terningModeller();
	ComponentValueModel[] holdTerningModeller();
	ComponentValueModel kastTellerModel();
	ComponentValueModel poengsumModell();
	Action kastAction();
	Action nyRundeAction();
}
