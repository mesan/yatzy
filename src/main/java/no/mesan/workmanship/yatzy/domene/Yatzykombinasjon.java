package no.mesan.workmanship.yatzy.domene;

import static no.mesan.workmanship.yatzy.beregning.score.PoengNLike.*;
import static no.mesan.workmanship.yatzy.beregning.score.PoengOverStreken.*;
import static no.mesan.workmanship.yatzy.beregning.score.PoengSjanse.*;
import static no.mesan.workmanship.yatzy.beregning.score.PoengStraights.*;
import static no.mesan.workmanship.yatzy.domene.Kast.ANTALL_TERNINGER;
import static no.mesan.workmanship.yatzy.domene.TerningPoeng.*;
import static no.mesan.workmanship.yatzy.poeng.SpesialPoeng.*;

import no.mesan.workmanship.yatzy.annotations.Immutable;
import no.mesan.workmanship.yatzy.beregning.KastBeregner;

@Immutable
public enum Yatzykombinasjon implements KastBeregner {
    ENERE(P_1, ANTALL_TERNINGER * EN.score, true),
    TOERE(P_2, ANTALL_TERNINGER * TO.score, true),
    TREERE(P_3, ANTALL_TERNINGER * TRE.score, true),
    FIRERE(P_4, ANTALL_TERNINGER * FIRE.score, true),
    FEMMERE(P_5, ANTALL_TERNINGER * FEM.score, true),
    SEKSERE(P_6, ANTALL_TERNINGER * SEKS.score, true),
    PAR(P_PAR, 2*SEKS.score, false),
    TRE_LIKE(P_3_LIKE, 3*SEKS.score, false),
    FIRE_LIKE(P_4_LIKE, 4*SEKS.score, false),
    TO_PAR(P_2_PAR, 4*SEKS.score, false),
    LITEN_STRAIGHT(P_LITEN_STRAIGHT, LITEN_STRAIGHT_POENG.poeng.asInt(), false),
    STOR_STRAIGHT(P_STOR_STRAIGHT, STOR_STRAIGHT_POENG.poeng.asInt(), false),
    HUS(P_HUS, ANTALL_TERNINGER*SEKS.score, false),
    SJANSE(P_SJANSE, ANTALL_TERNINGER*SEKS.score, false),
    YATZY(P_YATZY, YATZY_POENG.poeng.asInt(), false);

    final KastBeregner kastBeregner;
    private final Poeng max;
    private final boolean overStreken;

    private Yatzykombinasjon(final KastBeregner p, final int max, final boolean erOver) {
        this.kastBeregner= p;
        this.max= new Poeng(max);
        this.overStreken= erOver;
    }

    @Override public Poeng beregnPoengForKast(final Kast kast) { return this.kastBeregner.beregnPoengForKast(kast); }
    public Poeng maxPoeng() { return this.max; }
    public boolean overStreken() { return this.overStreken; }

    @Override
    public String toString() {
        return super.toString().substring(0, 1)
               + super.toString().substring(1).toLowerCase().replaceAll("_", " ");
    }
}
