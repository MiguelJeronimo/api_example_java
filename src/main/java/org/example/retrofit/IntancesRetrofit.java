package org.example.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class IntancesRetrofit {
    public Retrofit retrofit = null;
    public Retrofit getRetrofit(String url){
        if(retrofit==null){
            retrofit = new Retrofit.Builder().
                    baseUrl(url)
                    //para traerme data de la api en texto plano
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
