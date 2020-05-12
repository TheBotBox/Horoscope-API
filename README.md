# Horoscope-API. [![Tweet](https://img.shields.io/twitter/url/http/shields.io.svg?style=social)](https://twitter.com/intent/tweet?text=&via=the_botbox&hashtags=API,HOROSCOPE,android)
Simple Java API to get the horoscope according to the sunsign.

![alt tag](https://user-images.githubusercontent.com/41512314/44621973-720cbe80-a8cd-11e8-80b3-a24b711dd1f4.png)
  

#  Contents 
**[Features](#features)**  
**[Implementation](#implementation)**   
**[API Usage](#api-usage)**  
**[To-dos](#to-dos)**   
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
                           String date = zodiac.getDate();
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
<li>Conversion to kotlin  </li>  
<li>Facts About a Sunsign  </li>
<li>Practical Side of a Sunsign  </li>
<li>Astrological Perspective of a Sunsign</li>
</ul>
  
# Credits  
This java library is working on top of [Horoscope-API](https://github.com/tapasweni-pathak/Horoscope-API) by [Tapasweni Pathak](https://github.com/tapaswenipathak)   


#   License  
![alt tag](https://img.shields.io/github/license/mashape/apistatus.svg)  
```
Copyright (c) 2020 TheBotBox

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated 
documentation files (the "Software"), to deal in the Software without restriction, including without
limitation the rights to use, copy, 
modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to 
whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions 
of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED 
TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL 
THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF 
CONTRACT, TORT OR OTHERWISE,ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS 
IN THE SOFTWARE.
```

[ ![](https://img.shields.io/badge/Say%20Thanks-!-1EAEDB.svg) ](https://saythanks.io/to/boxforbot%40gmail.com)


