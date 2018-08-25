package bot.box.horology.api;

import android.content.Context;

import bot.box.horology.annotation.DURATION;
import bot.box.horology.annotation.SUNSIGN;


/**
 * Created by Barry Allen .
 * boxforbot@gmail.com
 */

public class Horoscope {


    private String horoscope;
    private String date;
    private boolean showLoader, isDebuggable;
    private Context mContext;

    private Horoscope(Zodiac z) {
        this.horoscope = z.sunsign;
        this.date = z.duration;
        this.showLoader = z.isShowLoader;
        this.mContext = z.mContext;
        this.isDebuggable = z.isDebuggable;
    }

    public String getHoroscope() {
        return this.horoscope;
    }

    public String getDate() {
        return this.date;
    }

    public boolean isShowLoader() {
        return this.showLoader;
    }

    public Context getContext() {
        return this.mContext;
    }

    public boolean isDebuggable() {
        return this.isDebuggable;
    }

    public static class Zodiac {
        private String sunsign, duration;
        private boolean isShowLoader = false, isDebuggable = false;
        private Context mContext;

        public Zodiac(Context mContext) {
            this.mContext = mContext;
        }

        public Zodiac requestSunSign(@SUNSIGN.ANNOTE_SUNSIGN String mSunSign) {
            this.sunsign = mSunSign;
            return this;
        }

        public Zodiac requestDuration(@DURATION.ANNOTE_DURATION String mDuration) {
            this.duration = mDuration;
            return this;
        }

        public Zodiac showLoader(boolean isShowLoader) {
            this.isShowLoader = isShowLoader;
            return this;
        }

        public Zodiac isDebuggable(boolean isDebuggable) {
            this.isDebuggable = isDebuggable;
            return this;
        }


        public Horoscope fetchHoroscope() {
            Horoscope h = new Horoscope(this);
            if (this.sunsign.isEmpty())
                throw new IllegalStateException("No sunsign selected.Mandatory to request for sunsign e.g. requestSunSign(SUNSIGN.GEMINI)");
            if (this.duration.isEmpty())
                throw new IllegalStateException("No duration selected.Mandatory to request for duration e.g requestDuration(DURATION.TODAY)");
            return h;
        }

    }

}
