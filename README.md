# Horoscope-API
Simple Java API to get the horoscope according to the sunsign

![alt tag](https://user-images.githubusercontent.com/41512314/44621973-720cbe80-a8cd-11e8-80b3-a24b711dd1f4.png)
  

#  Contents 
**[Features](#features)**  
**[Implementation](#implementation)**   
**[API Usage](#api-usage)**  
**[To-dos](#to-dos)**   
**[Get It On Play Store](#get-it-on-play-store)**    
**[Credits](#credits)**   
**[License](#license)**    

# Features
<ul>
<li>Get Horoscope based on sunsign</li>
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
Access all the zodiacs like this `SUNSIGN.ARIES` `SUNSIGN.TAURUS` `SUNSIGN.GEMINI` `SUNSIGN.CANCER` ...  `SUNSIGN.PISCES`  

`requestDuration(DURATION)`  
Access duration like this `DURATION.TODAY` `DURATION.TOMORROW` `DURATION.WEEK` `DURATION.YEAR`

<b> Not calling above two function will throw IllegalStateException() </b>

<b> Optional Functions</b>  
`showLoader(boolean)` - pass `true` in param to displays a loader when fetching horoscope from server, by default its disable.   
`isDebuggable(boolean)` - pass `true` to enable library logs & exception printStackTrace() or else they are disabled

calling both the above function is totally optional and default value for both is `false`  

<b> Handling Response </b>
```
Horoscope hGemini = new Horoscope.Zodiac(MainActivity.this)
                        .requestSunSign(SUNSIGN.GEMINI)
                           .requestDuration(DURATION.TODAY)
                            .showLoader(true)                            
                              .isDebuggable(true)
                               .fetchHoroscope();
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
`String date` is the same duration for which request has been made.  

<b> In case of no internet connection, callback will come in `onErrorObtained()` with errormsg  "No internet connection"


#   To-Dos
<ul>
<li>Facts About a Sunsign  </li>
<li>Practical Side of a Sunsign  </li>
<li>Astrological Perspective of a Sunsign</li>
</ul>
  
# Get It On Play Store
[![alt-tag](https://user-images.githubusercontent.com/41512314/44625833-9305fb80-a92f-11e8-8bd4-c2d513c2e9e4.png)](https://play.google.com/store/apps/details?id=bot.box.horology)
  
# Credits  
This java library is working on top of [Horoscope-API](https://github.com/tapasweni-pathak/Horoscope-API) by [Tapasweni Pathak](https://github.com/tapasweni-pathak/)


#   License  
![alt tag](https://img.shields.io/github/license/mashape/apistatus.svg)


