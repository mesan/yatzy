package no.mesan.workmanship.yatzy.beregning;

import no.mesan.workmanship.yatzy.domene.Kast;
import no.mesan.workmanship.yatzy.domene.Poeng;

/** Klasse som er i stand til å sette poeng på et gitt kast i <i>sin</i> kontekst. */
@FunctionalInterface
public interface KastBeregner {

    /**
     * Sett poeng på et gitt kast,  poengsummen vil avhenge av hvilken
     * linje det skal skrives på.
     *
     * @param kast Terningene
     * @return Resultatet
     */
    Poeng beregnPoengForKast(Kast kast);
}
