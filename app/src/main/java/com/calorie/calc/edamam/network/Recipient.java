package com.calorie.calc.edamam.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;

import retrofit2.Retrofit;


public abstract class Recipient {

    protected final Context context;
    private final String BASEURL = "https://api.edamam.com/api/";
    public IRetrofitInterface retrofitInterface;
    private final Retrofit retrofit;
    protected final int CODE_OK=200;
    protected boolean callBackOk=false;


    public Recipient(Context context) {
        this.context = context;
        retrofit = RetrofitClient.getInstance(BASEURL);
        retrofitInterface = retrofit.create(IRetrofitInterface.class);
        setCallBack();

    }

    protected boolean connectOk() {
        ConnectivityManager cm =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            cm.addDefaultNetworkActiveListener(new ConnectivityManager.OnNetworkActiveListener() {
                @Override
                public void onNetworkActive() {
                    onNetwork();
                }

            });
        }
        return (activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting());

    }

    protected abstract void setCallBack();
    protected abstract void onNetwork();


}
