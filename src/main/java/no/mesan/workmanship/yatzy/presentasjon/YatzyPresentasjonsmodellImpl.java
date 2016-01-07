package no.mesan.workmanship.yatzy.presentasjon;

import javax.swing.*;
import java.awt.event.ActionEvent;

import com.jgoodies.binding.list.SelectionInList;
import com.jgoodies.binding.value.ComponentValueModel;
import com.jgoodies.binding.value.ValueHolder;
import no.mesan.workmanship.yatzy.annotations.Unntak;
import no.mesan.workmanship.yatzy.beregning.YatzyBeregner;
import no.mesan.workmanship.yatzy.domene.Kast;
import no.mesan.workmanship.yatzy.domene.Terning;
import no.mesan.workmanship.yatzy.domene.TerningPoeng;
import no.mesan.workmanship.yatzy.domene.Yatzykombinasjon;

@Unntak("Blåser i presentasjonskoden - her gjelder ingen av reglene")
public class YatzyPresentasjonsmodellImpl implements YatzyPresentasjonsmodell {
    private final YatzyBeregner yatzyBeregner;

    private SelectionInList<Yatzykombinasjon> kombinasjonerModel;
    private ComponentValueModel[] terningModeller;
    private ComponentValueModel[] holdTerningModeller;
    private ComponentValueModel valgtKombinasjonModell;
    private ComponentValueModel poengsumModell;
    private ComponentValueModel kastTellerModell;
    private Action kastAction;
    private Action nyRundeAction;

    public YatzyPresentasjonsmodellImpl(final YatzyBeregner yatzyBeregner) {
        this.yatzyBeregner = yatzyBeregner;
        initModell();
        initActions();
        nyRunde();
    }

    private void initModell() {
        this.valgtKombinasjonModell = new ComponentValueModel(new ValueHolder());
        this.kombinasjonerModel = new SelectionInList<>(Yatzykombinasjon.values());
        this.kombinasjonerModel.setSelectionHolder(this.valgtKombinasjonModell);
        this.valgtKombinasjonModell.setValue(Yatzykombinasjon.ENERE);
        this.terningModeller = new ComponentValueModel[5];
        this.holdTerningModeller = new ComponentValueModel[5];

        for(int i=0; i<5; i++) {
            this.terningModeller[i] = new ComponentValueModel(new ValueHolder(randKast()));
            this.terningModeller[i].setEditable(false);
            this.holdTerningModeller[i] = new ComponentValueModel(new ValueHolder(Boolean.FALSE));
        }

        this.poengsumModell = new ComponentValueModel(new ValueHolder(0));
        this.poengsumModell.setEditable(false);
        this.kastTellerModell = new ComponentValueModel(new ValueHolder(0));
        this.kastTellerModell.setEditable(false);
    }

    @SuppressWarnings("serial")
    private void initActions() {
        this.kastAction = new AbstractAction("Kast") {
            @Override
            public void actionPerformed(final ActionEvent arg0) {
                kastTerninger();
            }
        };

        this.nyRundeAction = new AbstractAction("Ny runde") {
            @Override
            public void actionPerformed(final ActionEvent arg0) {
                nyRunde();
            }
        };

        this.kombinasjonerModel.addPropertyChangeListener("selection", arg0 -> beregnProengsum());
    }

    @Override
    public ComponentValueModel kastTellerModel() {
        return this.kastTellerModell;
    }

    @Override
    public ComponentValueModel[] holdTerningModeller() {
        return this.holdTerningModeller;
    }

    @Override
    public Action kastAction() {
        return this.kastAction;
    }

    @Override
    public SelectionInList<Yatzykombinasjon> kombinasjonModel() {
        return this.kombinasjonerModel;
    }

    @Override
    public Action nyRundeAction() {
        return this.nyRundeAction;
    }

    @Override
    public ComponentValueModel[] terningModeller() {
        return this.terningModeller;
    }

    @Override
    public ComponentValueModel poengsumModell() {
        return this.poengsumModell;
    }

    private void kastTerninger() {
        kastAktiveTerninger();
        beregnProengsum();

        if(hentAntallKast() == 2) {
            this.kastAction.setEnabled(false);
            this.nyRundeAction.setEnabled(true);
        }

        this.kastTellerModell.setEnabled(true);
        this.valgtKombinasjonModell.setEnabled(true);
        this.poengsumModell.setEnabled(true);

        laasHoldteTerninger();
        inkrementerKastTeller();
    }

    private void nyRunde() {
        nullstillHoldmodeller();
        nullstillTerninger();
        nullstillKastTeller();
        nullstillPoengsum();

        this.kastAction.setEnabled(true);
        this.nyRundeAction.setEnabled(false);
        this.kastTellerModell.setEnabled(false);
        this.valgtKombinasjonModell.setEnabled(false);
        this.poengsumModell.setEnabled(false);
    }

    private void beregnProengsum() {
        final Integer[] terninger = hentTerninger();
        final Terning[] ekteTerninger= new Terning[Kast.ANTALL_TERNINGER];
        for (int i= 0; i < terninger.length; i++) {
            ekteTerninger[i]= new Terning(TerningPoeng.int2terning(terninger[i]));
        }
        final Kast kast= new Kast(ekteTerninger);
        final Yatzykombinasjon valgtKombinasjon = this.kombinasjonerModel.getSelection();
        final Integer nyPoengsum = this.yatzyBeregner.beregnPoengsum(valgtKombinasjon, kast);
        this.poengsumModell.setValue(nyPoengsum);
    }

    private Integer randKast() {
        return (int) Math.ceil(Math.random() * 6);
    }

    private Integer[] hentTerninger() {
        final Integer[] terninger = new Integer[5];
        for(int i=0; i<terninger.length; i++) {
            terninger[i] = (Integer)this.terningModeller[i].getValue();
        }
        return terninger;
    }

    private void laasHoldteTerninger() {
        for(final ComponentValueModel holdModell : this.holdTerningModeller) {
            holdModell.setEnabled(true);
        }
    }

    private void nullstillPoengsum() {
        this.poengsumModell.setValue(0);
    }

    private void kastAktiveTerninger() {
        for(int i=0; i<5; i++) {
            if(this.holdTerningModeller[i].getValue().equals(Boolean.FALSE)) {
                this.terningModeller[i].setValue(randKast());
            }
        }
    }

    private void nullstillTerninger() {
        for(final ComponentValueModel terningModel : this.terningModeller) {
            terningModel.setValue(null);
        }
    }

    private void nullstillHoldmodeller() {
        for(final ComponentValueModel holdModell : this.holdTerningModeller) {
            holdModell.setValue(Boolean.FALSE);
            holdModell.setEnabled(false);
        }
    }

    private void nullstillKastTeller() {
        this.kastTellerModell.setValue(0);
    }

    private void inkrementerKastTeller() {
        this.kastTellerModell.setValue((Integer)this.kastTellerModell.getValue() + 1);
    }

    private Integer hentAntallKast() {
        return (Integer)this.kastTellerModell.getValue();
    }
}
