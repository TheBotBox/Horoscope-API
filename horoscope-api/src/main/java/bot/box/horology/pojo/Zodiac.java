package bot.box.horology.pojo;

/**
 * Created by Barry Allen .
 * boxforbot@gmail.com
 */

public class Zodiac {

    private String horoscope, date, sunsign;

    public Zodiac(String horoscope, String duration, String sunsign) {
        this.horoscope = horoscope;
        this.date = duration;
        this.sunsign = sunsign;
    }

    public String getHoroscope() {
        return this.horoscope;
    }

    public String getDate() {
        return this.date;
    }

    public String getSunSign() {
        return this.sunsign;
    }

}


