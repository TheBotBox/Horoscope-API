package bot.box.horology.hanshake;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import bot.box.horology.annotation.DURATION;
import bot.box.horology.api.Horoscope;
import bot.box.horology.delegate.Response;
import bot.box.horology.pojo.Zodiac;

/**
 * Created by Barry Allen .
 * boxforbot@gmail.com
 */

public class HorologyClient {

    private Response mResponse;


    public HorologyClient(Response mResponse) {
        if (mResponse != null)
            this.mResponse = mResponse;
        else
            throw new IllegalStateException("Activity must imeplement bot.box.horology.delegate.Response");
    }

    public void requestHoroscope(String url, Horoscope mHoroscope) {
        new HoroscopeTask(mHoroscope).execute(url);
    }

    private class HoroscopeTask extends AsyncTask<String, Void, String> {
        private Horoscope mHoroscope;
        private ProgressDialog dialog;

        public HoroscopeTask(Horoscope mHoroscope) {
            this.mHoroscope = mHoroscope;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            if (mHoroscope.isShowLoader()) {
                dialog = new ProgressDialog((Activity) mHoroscope.getContext());
                dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                dialog.setTitle("Fetching...");
                dialog.show();
            }
        }

        @Override
        protected String doInBackground(String... param) {
            StringBuilder sb = new StringBuilder();
            try {
                URL url = new URL(param[0]);

                BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
                String str = null;
                while ((str = in.readLine()) != null) {
                    sb.append(str + "\n");
                }
                in.close();
            } catch (final MalformedURLException e) {
                if (mHoroscope.isDebuggable())
                    e.printStackTrace();

                ((Activity) mHoroscope.getContext()).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mResponse.onErrorObtained("" + e);
                    }
                });
            } catch (final IOException e) {
                if (mHoroscope.isDebuggable())
                    e.printStackTrace();

                ((Activity) mHoroscope.getContext()).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mResponse.onErrorObtained("" + e + " " + "Check the requestDuration() & requestSunSign() params carefully");
                    }
                });
            }
            return sb.toString();
        }

        @Override
        protected void onPostExecute(String json) {
            super.onPostExecute(json);
            if (json != null && !json.isEmpty()) {
                try {
                    System.out.println("checking duration " + mHoroscope.getDate());

                    JSONObject object = new JSONObject(json);

                    String horoscope = object.getString("horoscope");
                    String sunsign = object.getString("sunsign");
                    String date = "";
                    switch (mHoroscope.getDate()) {
                        case DURATION.TODAY:
                            date = object.getString("date");
                            break;

                        case DURATION.WEEK:
                            date = object.getString(DURATION.WEEK);
                            break;

                        case DURATION.MONTH:
                            date = object.getString(DURATION.MONTH);
                            break;

                        case DURATION.YEAR:
                            date = object.getString(DURATION.YEAR);
                            break;
                    }


                    Zodiac zodiac = new Zodiac(horoscope, date, sunsign);

                    mResponse.onResponseObtained(zodiac);

                    if (mHoroscope.isShowLoader()) {
                        if (dialog != null && dialog.isShowing()) {
                            dialog.dismiss();
                            dialog = null;
                        }
                    }
                } catch (JSONException e) {
                    mResponse.onErrorObtained("" + e);

                    if (mHoroscope.isDebuggable())
                        e.printStackTrace();

                    if (mHoroscope.isShowLoader()) {
                        if (dialog != null && dialog.isShowing()) {
                            dialog.dismiss();
                            dialog = null;
                        }
                    }
                }
            }
        }
    }
}
