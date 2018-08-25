# Horoscope-API
Simple Java API to get the horoscope according to the sunsign

#  Contents 
<ul>
<li>Features </li>
<li>Implementation </li>
<li>API Usage </li>
<li>To-dos </li>
<li>License </li>
</ul>

# Features
<ul>
<li>Get Horoscope based on sunsign for all the zodiacs</li>
<li>Get Horoscope for today, weekly, monthly & yearly</li>
</ul>

# Implementation 
Library is available on JCenter, simply add the following line in your app `build.gradle` 
```
implementation'the.bot.box:horoscope-api:{latest-version}'
```  
where `{latest-version}` corresponds to latest published version <a href='https://bintray.com/boxbotbarry/maven/horoscope-api/_latestVersion'><img src='https://api.bintray.com/packages/boxbotbarry/maven/horoscope-api/images/download.svg'></a>  



# API Usage  
To request for any horoscope, simply call,
```
Horoscope hGemini = new Horoscope.Zodiac(mContext)
                        .requestSunSign(SUNSIGN.GEMINI) 

```
and also, don't forget to request for duration of horoscope simultaneously i.e TODAY, WEEKLY, MONTHLY, YEARLY  
request for it like below,  
```
Horoscope hGemini = new Horoscope.Zodiac(mContext)
                        .requestSunSign(SUNSIGN.GEMINI).
                          .requestDuration((DURATION.TODAY)

```
therefore, the final request will may seem like the one below,  
```
Horoscope hGemini = new Horoscope.Zodiac(MainActivity.this)
                        .requestSunSign(SUNSIGN.GEMINI)
                           .requestDuration(DURATION.TODAY)
                            .showLoader(true)                            
                              .isDebuggable(true)
                               .fetchHoroscope();
```  
<b> Mandatory Functions</b>  
`requestSunSign(SUNSIGN)`   
Get all the zodiacs from `SUNSIGN.ARIES` `SUNSIGN.TAURUS` `SUNSIGN.GEMINI` `SUNSIGN.CANCER` ...  `SUNSIGN.PISCES`  

`requestDuration(DURATION)`  
Get duration from `DURATION.TODAY` `DURATION.TOMORROW` `DURATION.WEEK` `DURATION.YEAR`

<b> Not calling above two function will throw IllegalArgumentExcetion() </b>

<b> Optional Functions</b>  
`showLoader(boolean)` - pass `true` in param to displays a loader when fetching horoscope from server, by default its disable.   
`isDebuggable(boolean)` - pass `true` to enable library logs & exception printStackTrace() or else they are disabled

calling both the above function is totally optional and default value for both is `false`  

<b> Handling Response </b>
```
 HorologyController cGemini = new HorologyController(new Response() {
                        @Override
                        public void onResponseObtained(Zodiac zodiac) {
                           String horoscope = zodiac.getHoroscope();
                           String sunsign = zodiac.getSunSign();
                           String date = getDate();
                        }

                        @Override
                        public void onErrorObtained(String errormsg) {
                                                   }
                    });
                    cGemini.requestConstellations(hGemini);

```  
where, `String horoscpe` is the response from the server correspoding to the sunsign requested;  
`String sunsign` is the same sunsign for which request has been made;  
`String date` is the duration for which request has been made.  

<b> In case of no internet connection, callback will come in `onErrorObtained()` with errormsg  "No internet connection"


#   To-Do's
<ul>
<li>Facts About a Sunsign  </li>
<li>Practical Side of a Sunsign  </li>
<li>Astrological Perspective of a Sunsign</li>
</ul>

#   License
