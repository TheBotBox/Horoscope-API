package bot.box.horology.hanshake;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import bot.box.horology.api.Horoscope;
import bot.box.horology.delegate.Response;
import bot.box.horology.encode.Crypto;
import bot.box.horology.pojo.Zodiac;

/**
 * Created by Barry Allen .
 * boxforbot@gmail.com
 */

public class HorologyController implements Response {

    private Response response;
    private HorologyClient client;

    private static String GET_BASE_URL = "29772f5d038a1359ec9984beb3a0c57db88f435ca56ffc026c91fd429f5cb94052f1bd96e885427c56035da1168c58ae";

    public HorologyController(Response mResponse) {
        if (mResponse != null)
            this.response = mResponse;
        else
            throw new IllegalStateException("Activity must imeplement bot.box.horology.delegate.Response");
        this.client = new HorologyClient(mResponse);
    }

    public void requestConstellations(Horoscope mObject) {
        if (mObject != null && mObject instanceof Horoscope) {
            if (isConnected(mObject.getContext())) {
                try {
                    this.client.requestHoroscope(new String(new Crypto(mObject.isDebuggable()).decrypt(GET_BASE_URL)) + mObject.getDate() + "/" + mObject.getHoroscope(), mObject);
                } catch (Exception e) {
                    if (mObject.isDebuggable())
                        e.printStackTrace();
                }
            } else {
                onErrorObtained("No Internet Connection");
            }
        } else
            throw new IllegalArgumentException("Only not null object of bot.box.horology.api.Horoscope is a valid argument");
    }

    @Override
    public void onResponseObtained(Zodiac response) {
        this.response.onResponseObtained(response);
    }

    @Override
    public void onErrorObtained(String errormsg) {
        this.response.onErrorObtained(errormsg);
    }


    private boolean isConnected(Context c) {
        boolean haveConnectedWifi = false;
        boolean haveConnectedMobile = false;

        ConnectivityManager cm = (ConnectivityManager) c.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo[] netInfo = cm.getAllNetworkInfo();
        for (NetworkInfo ni : netInfo) {
            if (ni.getTypeName().equalsIgnoreCase("WIFI"))
                if (ni.isConnected())
                    haveConnectedWifi = true;
            if (ni.getTypeName().equalsIgnoreCase("MOBILE"))
                if (ni.isConnected())
                    haveConnectedMobile = true;
        }
        return haveConnectedWifi || haveConnectedMobile;
    }
}
