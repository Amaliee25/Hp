# slack-android-api

slack-android-api is a library to integrate Android project to [Slack Api](https://api.slack.com).

## Alpha 1
Add Slack Web Api methods; (in progress):

|Methods                            |Status      |
|-----------------------------------|-----------:|
|api                                |OK          |
|auth                               |OK          |
|bots                               |OK          |
|channels                           |OK          |
|chat                               |OK          |
|dnd (Do Not Disturb)               |OK          |
|emoji                              |OK          |
|files.comments                     |OK          |
|files                              |In progress |
|group (team's private channels)    |OK          |
|im (direct messages)               |OK          |
|mipm (multiparty direct messages)  |OK          |
|oauth                              |In progress |
|pins                               |OK          |
|reactions                          |OK          |
|reminders                          |OK          |
|rtm                                |In progress |
|search                             |Coming soon |
|stars                              |Coming soon |
|team                               |Coming soon |
|usergroups                         |Coming soon |
|usergroups.users                   |Coming soon |
|users                              |Coming soon |
|users.profile                      |Coming soon |
|team.profile                       |Coming soon |
|team.profile                       |Coming soon |


## Usage

Add internet permission in AndroidManifest
```java
<uses-permission android:name="android.permission.INTERNET" />
```

Call the SlackWebApiAsync
```java
SlackWebApiAsync.getService("YOUR_TOKEN").getApiTest(new ApiTestParams(), new Callback<ApiTestResponse>() {
    @Override
    public void onResponse(Call<ApiTestResponse> call, Response<ApiTestResponse> response) {
        if(response.isSuccessful()){
            Log.d(TAG, "Server response: " + response.message());
        }
    }

    @Override
    public void onFailure(Call<ApiTestResponse> call, Throwable t) {
        //Ops !!
    }
});
```


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
