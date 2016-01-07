package no.mesan.workmanship.yatzy.beregning.score;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import no.mesan.workmanship.yatzy.annotations.*;
import no.mesan.workmanship.yatzy.domene.Terning;
import no.mesan.workmanship.yatzy.domene.TerningPoeng;

@Immutable
final class ResultatSett implements Iterable<TerningPoeng> {
    private final Map<TerningPoeng, Integer> map= new HashMap<>();

    private ResultatSett() {
        for (final TerningPoeng poeng : TerningPoeng.values()) this.map.put(poeng, 0);
    }

    ResultatSett(final Iterable<Terning> kast) {
        this();
        for (final Terning terning : kast) {
            final TerningPoeng key= terning.verdi();
            this.map.put(key, this.map.get(key) +1);
        }
    }

    private ResultatSett(final Map<TerningPoeng, Integer> copy) {
        this.map.putAll(copy);
    }

    final int count(final TerningPoeng poeng) {
        for (final TerningPoeng terning : this) {
            if ( terning.equals(poeng) ) return this.map.get(terning);
        }
        return 0;
    }

    final ResultatSett bruk(final TerningPoeng terning, final int antall) {
        this.map.put(terning, this.map.get(terning) - antall);
        return new ResultatSett(this.map);
    }

    @Override
    public final Iterator<TerningPoeng> iterator() {
        final Set<TerningPoeng> keySet= this.map.keySet();
        return keySet.iterator();
    }
}