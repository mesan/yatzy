package no.mesan.workmanship.yatzy.beregning.score;

import no.mesan.workmanship.yatzy.beregning.KastBeregner;
import no.mesan.workmanship.yatzy.domene.Kast;
import no.mesan.workmanship.yatzy.domene.Poeng;
import no.mesan.workmanship.yatzy.domene.TerningPoeng;
import no.mesan.workmanship.yatzy.poeng.SpesialPoeng;

public abstract class PoengNLike implements KastBeregner {

    public static final KastBeregner P_PAR= new PoengNLike() {
        @Override public Poeng beregnPoengForKast(final Kast kast) {
            return kalkuler(2, SjekkLike.bestePar(kast));
        } };
    public static final KastBeregner P_3_LIKE= new PoengNLike() {
        @Override public Poeng beregnPoengForKast(final Kast kast) {
            return kalkuler(3, SjekkLike.trippel(kast));
        } };
    public static final KastBeregner P_4_LIKE= new PoengNLike() {
        @Override public Poeng beregnPoengForKast(final Kast kast) {
            return kalkuler(4, SjekkLike.kvadruppel(kast));
        } };
    public static final KastBeregner P_YATZY= new PoengNLike() {
        @Override public Poeng beregnPoengForKast(final Kast kast) {
            final TerningPoeng yatzy= SjekkLike.yatzy(kast);
            return yatzy==null? Poeng.NULL_POENG : SpesialPoeng.YATZY_POENG.poeng;
        } };
    public static final KastBeregner P_2_PAR= new PoengNLike() {
        @Override public Poeng beregnPoengForKast(final Kast kast) {
            final Par2Resultat par2= SjekkLike.toPar(kast);
            return (par2==null)? Poeng.NULL_POENG : par2.sum();
        } };
    public static final KastBeregner P_HUS= new PoengNLike() {
        @Override public Poeng beregnPoengForKast(final Kast kast) {
            final HusResultat hus= SjekkLike.hus(kast);
            return (hus==null)? Poeng.NULL_POENG : hus.sum();
        } };

    private static Poeng kalkuler(final int n, final TerningPoeng verdi) {
        if ( verdi==null ) return Poeng.NULL_POENG;
        return new Poeng(verdi.score*n);
    }
}
