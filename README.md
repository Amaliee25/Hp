[![](https://jitpack.io/v/flaviokreis/slack-android-api.svg)](https://jitpack.io/#flaviokreis/slack-android-api)

# slack-android-api

slack-android-api is a library to integrate Android project to [Slack Api](https://api.slack.com).

## Usage

Add it in your root build.gradle at the end of repositories:
```gradle
allprojects {
	repositories {
	            ...
		maven { url "https://jitpack.io" }
	}
}
```

Add the dependency:
```gradle
dependencies {
	compile 'com.github.flaviokreis:slack-android-api:0.2.1'
}
```

Add internet permission in AndroidManifest:
```java
<uses-permission android:name="android.permission.INTERNET" />
```

Call the SlackWebApiAsync using the Oauth token:
```java
SlackWebApiAsync async = SlackWebApiAsync.getService("TOKEN");
```

Call Slack Web Api methods:
```java
async.api().test(new Callback<ApiTestResponse>() {
            @Override
            public void onResponse(Call<ApiTestResponse> call, Response<ApiTestResponse> response) {
                        if(response.isSuccessful()){
                                    //Add your code here
                        }
            }

            @Override
            public void onFailure(Call<ApiTestResponse> call, Throwable t) {
                //Ops !!
            }
        });
```

### Version 0.2.0 (Alpha)
Changed Web Api structure to call methods;<br />

### Version 0.1 (Alpha)
Created Library;<br />
Added Slack Web Api methods;<br />


## Future

- Support RTM; 
- Utils to formmating Slack texts;
- Support Emoji;

## Developed by

Flavio Kreis - [flaviokreis@gmail.com](mailto:flaviokreis@gmail.com)

## Lisence

```
The MIT License (MIT)

Copyright (c) 2016 Flávio Kreis

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
