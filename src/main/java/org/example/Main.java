package org.example;

import org.example.APISERVICES.APISERVICES;
import org.example.model.ResponseTokent;
import org.example.model.client;
import org.example.retrofit.IntancesRetrofit;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/*
* CONSUMIR UNA API CON EL METODO POST Y CON HEADERS
*
* */
public class Main {
    public static void main(String[] args) {
        String url = "https://apigwkong-desa.frd.org.mx:8443/banco/spei/nr/v1/login/oauth2/";
        //instanciar el obajeto del modelo del body
        client client = new client();
        //Headers
        String header = "application/json";
        //Body
        client.setClient_id("ytPZAa2u9X8rHgH1LdzJVWA4W7PpyPu2");
        client.setClient_secret("Mexico123");
        client.setGrant_type("password");
        client.setProvision_key("s7VRCKVyuGmkUoehRestCTC3OFtDYDxo");
        client.setAuthenticated_userid("BANCO-SPEI-NR-LOGIN");
        client.setScope("READ");
        //crear el pool de hilos
        Executor executor = Executors.newFixedThreadPool(1);
        //Aqui ejecutas las tareas asincronas en cada uno de los hilos
        executor.execute(() -> ObtenerToken(client,url,header));

    }
    //en este metodo haremos la llamada al api, pero puedes hacerla donde tu quieras :)
    public static void ObtenerToken(client client, String url, String header){
        //instanciar la Clase retrofit
        IntancesRetrofit retrofit = new IntancesRetrofit();
        APISERVICES apiservices = retrofit.getRetrofit(url).create(APISERVICES.class);
        Call<ResponseTokent> call = apiservices.getTokenPost(header,client);
        //DENTRO DE ESTE METODO SUCEDE LA MAGIA CHAVALES :)
        call.enqueue(new Callback<ResponseTokent>() {
            @Override
            public void onResponse(Call<ResponseTokent> call, Response<ResponseTokent> response) {
                //validamos si la respuesta es ok
                if (response.isSuccessful()){
                    ResponseTokent responseTokent = response.body();
                    System.out.println("refresh_token: "+responseTokent.getRefresh_token());
                    System.out.println("token_type: "+responseTokent.getToken_type());
                    System.out.println("access_token: "+responseTokent.getAccess_token());
                    System.out.println("expires_in: "+responseTokent.getExpires_in());
                }
            }

            @Override
            public void onFailure(Call<ResponseTokent> call, Throwable t) {
                System.out.println(t.getMessage());
            }
        });

    }
}