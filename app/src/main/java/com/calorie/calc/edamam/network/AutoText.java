package com.calorie.calc.edamam.network;

import android.content.Context;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AutoText extends Recipient{
    String APP_KEY_FOOD = "3fb0249a92fd83b77bb0f3e57d62a8e8";
    String APP_ID_FOOD = "df7288a0";
    private Callback<List<String>> callback;
    AutoTextResult autoTextResult;


    public AutoText(Context context,AutoTextResult autoTextResult) {
        super(context);
        this.autoTextResult=autoTextResult;
    }

    @Override
    protected void setCallBack() {
        callback = new Callback<List<String>>() {
            @Override
            public void onResponse(Call<List<String>> call, Response<List<String>> response) {

                 if(response.isSuccessful())
                 {
                     autoTextResult.getList(response.body());
                 }

            }

            @Override
            public void onFailure(Call<List<String>> call, Throwable t) {
                System.out.println("callback AutoText "+t.toString());
            }
        };
    }

    public void getText(String text) {
        retrofitInterface.getAutoText(APP_ID_FOOD,APP_KEY_FOOD,text,"10").enqueue(callback);
    }
    @Override
    protected void onNetwork() {

    }
  public   interface AutoTextResult
    {
        void getList(List<String> list);
    }
}
