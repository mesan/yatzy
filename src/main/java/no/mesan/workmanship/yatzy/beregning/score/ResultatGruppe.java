package no.mesan.workmanship.yatzy.beregning.score;

import no.mesan.workmanship.yatzy.annotations.Immutable;
import no.mesan.workmanship.yatzy.domene.TerningPoeng;

@Immutable
class ResultatGruppe {
    final TerningPoeng beste;
    final ResultatSett rest;

    ResultatGruppe(final TerningPoeng beste,
                   final ResultatSett rest) {
        this.beste= beste;
        this.rest= rest;
    }
}
