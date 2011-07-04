package no.mesan.workmanship.yatzy.brett.spill;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import no.mesan.workmanship.yatzy.brett.Plassering;
import no.mesan.workmanship.yatzy.domene.Kast;
import no.mesan.workmanship.yatzy.domene.Poeng;
import no.mesan.workmanship.yatzy.domene.YatzyBrett;
import no.mesan.workmanship.yatzy.domene.Yatzykombinasjon;

public class FlestPoengPlassering implements Plassering {
    protected final Map<Yatzykombinasjon, Poeng> poeng= new HashMap<Yatzykombinasjon, Poeng>();

    @Override
    public Yatzykombinasjon velgPlassering(final YatzyBrett yatzyBrett, final Kast kast) {
        sjekkAlle(yatzyBrett, kast);
        rescore();
        return finnBeste((Yatzykombinasjon) null, new Poeng(-1), new LinkedList<Yatzykombinasjon>(this.poeng.keySet()));
    }

    protected void rescore() { return; }

    private Yatzykombinasjon finnBeste(final Yatzykombinasjon bestHittil, final Poeng maxScore, final List<Yatzykombinasjon> rest) {
        if ( rest.size() < 1 ) return bestHittil;
        final Yatzykombinasjon yatzykombinasjon= rest.get(0);
        final Poeng poengDenne= this.poeng.get(yatzykombinasjon);
        final List<Yatzykombinasjon> subList= rest.subList(1, rest.size());
        if ( poengDenne.compareTo(maxScore) >= 0 ) {
            return finnBeste(yatzykombinasjon, poengDenne, subList);
        }
        return finnBeste(bestHittil, maxScore, subList);
    }

    private void sjekkAlle(final YatzyBrett yatzyBrett, final Kast kast) {
        this.poeng.clear();
        for (final Yatzykombinasjon yatzykombinasjon : Yatzykombinasjon.values()) {
            if ( !yatzyBrett.har(yatzykombinasjon) ) sjekk(yatzykombinasjon, kast);
        }
    }

    private void sjekk(final Yatzykombinasjon yatzykombinasjon, final Kast kast) {
        this.poeng.put(yatzykombinasjon, yatzykombinasjon.beregnPoengForKast(kast));
    }
}
