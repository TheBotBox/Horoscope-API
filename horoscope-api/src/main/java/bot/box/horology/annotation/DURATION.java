package bot.box.horology.annotation;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Barry Allen .
 * boxforbot@gmail.com
 */

public class DURATION {
    @Retention(RetentionPolicy.SOURCE)
    @StringDef({TODAY, TOMORROW, WEEK, YEAR})

    public @interface ANNOTE_DURATION {
    }

    public static final String TODAY = "today", TOMORROW = "week", WEEK = "month", YEAR = "year";

}
