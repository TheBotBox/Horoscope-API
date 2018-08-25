package bot.box.horology.delegate;

import bot.box.horology.pojo.Zodiac;

/**
 * Created by Barry Allen .
 * boxforbot@gmail.com
 */

public interface Response {
    void onResponseObtained(Zodiac zodiac);

    void onErrorObtained(String errormsg);
}
