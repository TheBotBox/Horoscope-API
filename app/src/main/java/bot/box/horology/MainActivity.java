package bot.box.horology;

import android.app.Dialog;
import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;

import bot.box.horology.annotation.DURATION;
import bot.box.horology.annotation.SUNSIGN;
import bot.box.horology.api.Horoscope;
import bot.box.horology.delegate.Response;
import bot.box.horology.hanshake.HorologyController;
import bot.box.horology.pojo.Zodiac;

public class MainActivity extends AppCompatActivity {

    private LinearLayout layoutAries, layoutTaurus, layoutGemini, layoutCancer, layoutLeo, layoutVirgo, layoutLibra,
            layoutScorpio, layoutSagittarius, layoutCapricorn, layoutAquarius, layoutPisces;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeViews();
    }

    private void initializeViews() {
        layoutAries = (LinearLayout) findViewById(R.id.layoutAries);
        layoutAries.setOnClickListener(onClickListener);
        layoutTaurus = (LinearLayout) findViewById(R.id.layoutTaurus);
        layoutTaurus.setOnClickListener(onClickListener);
        layoutGemini = (LinearLayout) findViewById(R.id.layoutGemini);
        layoutGemini.setOnClickListener(onClickListener);
        layoutCancer = (LinearLayout) findViewById(R.id.layoutCancer);
        layoutCancer.setOnClickListener(onClickListener);
        layoutLeo = (LinearLayout) findViewById(R.id.layoutLeo);
        layoutLeo.setOnClickListener(onClickListener);
        layoutVirgo = (LinearLayout) findViewById(R.id.layoutVirgo);
        layoutVirgo.setOnClickListener(onClickListener);
        layoutLibra = (LinearLayout) findViewById(R.id.layoutLibra);
        layoutLibra.setOnClickListener(onClickListener);
        layoutScorpio = (LinearLayout) findViewById(R.id.layoutScorpio);
        layoutScorpio.setOnClickListener(onClickListener);
        layoutSagittarius = (LinearLayout) findViewById(R.id.layoutSagittarius);
        layoutSagittarius.setOnClickListener(onClickListener);
        layoutCapricorn = (LinearLayout) findViewById(R.id.layoutCapricorn);
        layoutCapricorn.setOnClickListener(onClickListener);
        layoutAquarius = (LinearLayout) findViewById(R.id.layoutAquarius);
        layoutAquarius.setOnClickListener(onClickListener);
        layoutPisces = (LinearLayout) findViewById(R.id.layoutPisces);
        layoutPisces.setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.layoutAries:
                    System.out.println("here is the aries 01");
                    Horoscope hAries = new Horoscope.Zodiac(MainActivity.this)
                            .showLoader(true)
                            .requestSunSign(SUNSIGN.AQUARIUS).requestDuration(DURATION.TODAY).isDebuggable(true).fetchHoroscope();
                    HorologyController cAries = new HorologyController(new Response() {
                        @Override
                        public void onResponseObtained(Zodiac zodiac) {
                            System.out.println("here is the aries 02");
                            showHoroscopeDialog(zodiac, true, "");
                        }

                        @Override
                        public void onErrorObtained(String errormsg) {
                            System.out.println("here is the aries 03");
                            showHoroscopeDialog(null, false, errormsg);
                        }
                    });
                    cAries.requestConstellations(hAries);
                    break;

                case R.id.layoutTaurus:
                    Horoscope hTaurus = new Horoscope.Zodiac(MainActivity.this)
                            .requestSunSign(SUNSIGN.TAURUS).requestDuration(DURATION.TODAY).isDebuggable(true).fetchHoroscope();
                    HorologyController cTaurus = new HorologyController(new Response() {
                        @Override
                        public void onResponseObtained(Zodiac zodiac) {
                            showHoroscopeDialog(zodiac, true, "");
                        }

                        @Override
                        public void onErrorObtained(String errormsg) {
                            showHoroscopeDialog(null, false, errormsg);
                        }
                    });
                    cTaurus.requestConstellations(hTaurus);
                    break;


                case R.id.layoutGemini:
                    Horoscope hGemini = new Horoscope.Zodiac(MainActivity.this)
                            .requestSunSign(SUNSIGN.GEMINI).requestDuration(DURATION.TODAY).isDebuggable(true).fetchHoroscope();
                    HorologyController cGemini = new HorologyController(new Response() {
                        @Override
                        public void onResponseObtained(Zodiac zodiac) {
                            showHoroscopeDialog(zodiac, true, "");
                        }

                        @Override
                        public void onErrorObtained(String errormsg) {
                            showHoroscopeDialog(null, false, errormsg);
                        }
                    });
                    cGemini.requestConstellations(hGemini);
                    break;


                case R.id.layoutCancer:
                    Horoscope hCancer = new Horoscope.Zodiac(MainActivity.this)
                            .requestSunSign(SUNSIGN.CANCER).requestDuration(DURATION.TODAY).isDebuggable(true).fetchHoroscope();
                    HorologyController cCancer = new HorologyController(new Response() {
                        @Override
                        public void onResponseObtained(Zodiac zodiac) {
                            showHoroscopeDialog(zodiac, true, "");
                        }

                        @Override
                        public void onErrorObtained(String errormsg) {
                            showHoroscopeDialog(null, false, errormsg);
                        }
                    });
                    cCancer.requestConstellations(hCancer);
                    break;


                case R.id.layoutLeo:
                    Horoscope hLeo = new Horoscope.Zodiac(MainActivity.this)
                            .requestSunSign(SUNSIGN.LEO).requestDuration(DURATION.TODAY).isDebuggable(true).fetchHoroscope();
                    HorologyController cLeo = new HorologyController(new Response() {
                        @Override
                        public void onResponseObtained(Zodiac zodiac) {
                            showHoroscopeDialog(zodiac, true, "");
                        }

                        @Override
                        public void onErrorObtained(String errormsg) {
                            showHoroscopeDialog(null, false, errormsg);
                        }
                    });
                    cLeo.requestConstellations(hLeo);
                    break;


                case R.id.layoutVirgo:
                    Horoscope hVirgo = new Horoscope.Zodiac(MainActivity.this)
                            .requestSunSign(SUNSIGN.VIRGO).requestDuration(DURATION.TODAY).isDebuggable(true).fetchHoroscope();
                    HorologyController cVirgo = new HorologyController(new Response() {
                        @Override
                        public void onResponseObtained(Zodiac zodiac) {
                            showHoroscopeDialog(zodiac, true, "");
                        }

                        @Override
                        public void onErrorObtained(String errormsg) {
                            showHoroscopeDialog(null, false, errormsg);
                        }
                    });
                    cVirgo.requestConstellations(hVirgo);
                    break;


                case R.id.layoutLibra:
                    Horoscope hLibra = new Horoscope.Zodiac(MainActivity.this)
                            .requestSunSign(SUNSIGN.LIBRA).requestDuration(DURATION.TODAY).isDebuggable(true).fetchHoroscope();
                    HorologyController cLibra = new HorologyController(new Response() {
                        @Override
                        public void onResponseObtained(Zodiac zodiac) {
                            showHoroscopeDialog(zodiac, true, "");
                        }

                        @Override
                        public void onErrorObtained(String errormsg) {
                            showHoroscopeDialog(null, false, errormsg);
                        }
                    });
                    cLibra.requestConstellations(hLibra);
                    break;


                case R.id.layoutScorpio:
                    Horoscope hScorpio = new Horoscope.Zodiac(MainActivity.this)
                            .requestSunSign(SUNSIGN.SCORPIO).requestDuration(DURATION.TODAY).isDebuggable(true).fetchHoroscope();
                    HorologyController cScorpio = new HorologyController(new Response() {
                        @Override
                        public void onResponseObtained(Zodiac zodiac) {
                            showHoroscopeDialog(zodiac, true, "");
                        }

                        @Override
                        public void onErrorObtained(String errormsg) {
                            showHoroscopeDialog(null, false, errormsg);
                        }
                    });
                    cScorpio.requestConstellations(hScorpio);
                    break;


                case R.id.layoutSagittarius:
                    Horoscope hSagittarius = new Horoscope.Zodiac(MainActivity.this)
                            .requestSunSign(SUNSIGN.SAGITTARIUS).requestDuration(DURATION.TODAY).isDebuggable(true).fetchHoroscope();
                    HorologyController cSagittarius = new HorologyController(new Response() {
                        @Override
                        public void onResponseObtained(Zodiac zodiac) {
                            showHoroscopeDialog(zodiac, true, "");
                        }

                        @Override
                        public void onErrorObtained(String errormsg) {
                            showHoroscopeDialog(null, false, errormsg);
                        }
                    });
                    cSagittarius.requestConstellations(hSagittarius);
                    break;


                case R.id.layoutCapricorn:
                    Horoscope hCapricorn = new Horoscope.Zodiac(MainActivity.this)
                            .requestSunSign(SUNSIGN.CAPRICORN).requestDuration(DURATION.TODAY).isDebuggable(true).fetchHoroscope();
                    HorologyController cCapricorn = new HorologyController(new Response() {
                        @Override
                        public void onResponseObtained(Zodiac zodiac) {
                            showHoroscopeDialog(zodiac, true, "");
                        }

                        @Override
                        public void onErrorObtained(String errormsg) {
                            showHoroscopeDialog(null, false, errormsg);
                        }
                    });
                    cCapricorn.requestConstellations(hCapricorn);
                    break;


                case R.id.layoutAquarius:
                    Horoscope hAquarius = new Horoscope.Zodiac(MainActivity.this)
                            .requestSunSign(SUNSIGN.AQUARIUS).requestDuration(DURATION.TODAY).
                                    isDebuggable(true).fetchHoroscope();
                    HorologyController cAquarius = new HorologyController(new Response() {
                        @Override
                        public void onResponseObtained(Zodiac zodiac) {
                            showHoroscopeDialog(zodiac, true, "");
                        }

                        @Override
                        public void onErrorObtained(String errormsg) {
                            showHoroscopeDialog(null, false, errormsg);
                        }
                    });
                    cAquarius.requestConstellations(hAquarius);
                    break;


                case R.id.layoutPisces:
                    Horoscope hPisces = new Horoscope.Zodiac(MainActivity.this)
                            .requestSunSign(SUNSIGN.PISCES).requestDuration(DURATION.TODAY).isDebuggable(true).fetchHoroscope();
                    HorologyController cPisces = new HorologyController(new Response() {
                        @Override
                        public void onResponseObtained(Zodiac zodiac) {
                            showHoroscopeDialog(zodiac, true, "");
                        }

                        @Override
                        public void onErrorObtained(String errormsg) {
                            showHoroscopeDialog(null, false, errormsg);
                        }
                    });
                    cPisces.requestConstellations(hPisces);
                    break;

            }
        }
    };

    private void showHoroscopeDialog(Zodiac z, boolean isSuccsess, String errormsg) {

        final Dialog dialog = new Dialog(MainActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.custom_dialog);

        TextView title = (TextView) dialog.findViewById(R.id.title);
        TextView date = (TextView) dialog.findViewById(R.id.date);
        TextView body = (TextView) dialog.findViewById(R.id.body);

        if (isSuccsess) {
            title.setText(z.getSunSign());
            date.setText(z.getDate());
            body.setText(z.getHoroscope());
        } else {
            body.setText(errormsg);
        }
        dialog.show();

    }

}


