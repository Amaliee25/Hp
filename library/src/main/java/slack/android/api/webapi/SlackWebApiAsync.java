package slack.android.api.webapi;

import android.support.annotation.NonNull;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Implement Slack Web Api. Use Retrofit to do it.
 */
public class SlackWebApiAsync {
    private SlackWebApiInterface service;
    private final String token;

    private static Map<String, SlackWebApiAsync> INSTANCES = new HashMap<>();

    private final SlackPartApi          mApi;
    private final SlackPartAuth         mAuth;
    private final SlackPartBots         mBots;
    private final SlackPartChannels     mChannels;
    private final SlackPartChat         mChat;
    private final SlackPartDnd          mDnd;
    private final SlackPartEmoji        mEmoji;
    private final SlackPartFiles        mFiles;
    private final SlackPartGroups       mGroups;
    private final SlackPartIm           mIm;
    private final SlackPartMpim         mMpim;
    private final SlackPartOauth        mOauth;
    private final SlackPartPins         mPins;
    private final SlackPartReactions    mReactions;
    private final SlackPartReminders    mReminders;
    private final SlackPartRtm          mRtm;
    private final SlackPartSearch       mSearch;
    private final SlackPartStars        mStars;
    private final SlackPartTeam         mTeam;
    private final SlackPartUsergroups   mUsergroups;
    private final SlackPartUsers        mUsers;

    private HttpLoggingInterceptor mInterceptor;

    public static SlackWebApiAsync getService(@NonNull String authToken){
        if(!INSTANCES.containsKey(authToken)){
            SlackWebApiAsync async = new SlackWebApiAsync(authToken);
            INSTANCES.put(authToken, async);
        }
        return INSTANCES.get(authToken);
    }

    public SlackWebApiAsync(@NonNull final String authToken) {
        token = authToken;
        mInterceptor = new HttpLoggingInterceptor();
        mInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.interceptors().add(mInterceptor);
        builder.interceptors().add(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                if (request.url().toString().startsWith(SlackWebApiConstants.SLACK_BASE_WEB_API_URL)) {
                    HttpUrl url = request.url().newBuilder().addQueryParameter("token", authToken).build();
                    request = request.newBuilder().url(url).build();
                }
                return chain.proceed(request);
            }
        });
        Retrofit retrofit = new Retrofit.Builder().baseUrl(SlackWebApiConstants.SLACK_BASE_WEB_API_URL).client(builder.build())
                .addConverterFactory(GsonConverterFactory.create()).build();

        service = retrofit.create(SlackWebApiInterface.class);

        mApi        = new SlackPartApi(service);
        mAuth       = new SlackPartAuth(service);
        mBots       = new SlackPartBots(service);
        mChannels   = new SlackPartChannels(service);
        mChat       = new SlackPartChat(service);
        mDnd        = new SlackPartDnd(service);
        mEmoji      = new SlackPartEmoji(service);
        mFiles      = new SlackPartFiles(service);
        mGroups     = new SlackPartGroups(service);
        mIm         = new SlackPartIm(service);
        mMpim       = new SlackPartMpim(service);
        mOauth      = new SlackPartOauth(service);
        mPins       = new SlackPartPins(service);
        mReactions  = new SlackPartReactions(service);
        mReminders  = new SlackPartReminders(service);
        mRtm        = new SlackPartRtm(service);
        mSearch     = new SlackPartSearch(service);
        mStars      = new SlackPartStars(service);
        mTeam       = new SlackPartTeam(service);
        mUsergroups = new SlackPartUsergroups(service);
        mUsers      = new SlackPartUsers(service);
    }

    public SlackPartApi api(){
        return mApi;
    }

    public SlackPartAuth auth(){
        return mAuth;
    }

    public SlackPartBots bots(){
        return mBots;
    }

    public SlackPartChannels channels(){
        return mChannels;
    }

    public SlackPartChat chat(){
        return mChat;
    }

    public SlackPartDnd dnd(){
        return mDnd;
    }

    public SlackPartEmoji emoji(){
        return mEmoji;
    }

    public SlackPartFiles files(){
        return mFiles;
    }

    public SlackPartGroups groups(){
        return mGroups;
    }

    public SlackPartIm im(){
        return mIm;
    }

    public SlackPartMpim mpim(){
        return mMpim;
    }

    public SlackPartOauth oauth(){
        return mOauth;
    }

    public SlackPartPins pins(){
        return mPins;
    }

    public SlackPartReactions reactions(){
        return mReactions;
    }

    public SlackPartReminders reminders(){
        return mReminders;
    }

    public SlackPartRtm rtm(){
        return mRtm;
    }

    public SlackPartSearch search(){
        return mSearch;
    }

    public SlackPartStars stars(){
        return mStars;
    }

    public SlackPartTeam team(){
        return mTeam;
    }

    public SlackPartUsergroups usergroups(){
        return mUsergroups;
    }

    public SlackPartUsers users(){
        return mUsers;
    }
}
