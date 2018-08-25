package bot.box.horology.annotation;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Barry Allen .
 * boxforbot@gmail.com
 */

public class SUNSIGN {
    @Retention(RetentionPolicy.SOURCE)
    @StringDef({ARIES, TAURUS, GEMINI, CANCER, LEO, VIRGO, LIBRA, SCORPIO, SAGITTARIUS, CAPRICORN, AQUARIUS, PISCES})

    public @interface ANNOTE_SUNSIGN {
    }

    public static final String ARIES = "ARIES", TAURUS = "TAURUS", GEMINI = "GEMINI", CANCER = "CANCER", LEO = "LEO", VIRGO = "VIRGO", LIBRA = "LIBRA", SCORPIO = "SCORPIO",
            SAGITTARIUS = "SAGITTARIUS", CAPRICORN = "CAPRICORN", AQUARIUS = "AQUARIUS", PISCES = "PISCES";

}
