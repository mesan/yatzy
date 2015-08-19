package no.mesan.workmanship.yatzy.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface Mangel {
    String value() default "Ikke løst";
}
