package no.mesan.workmanship.yatzy.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface Unntak {
    String value() default "Ikke i henhold";
}
