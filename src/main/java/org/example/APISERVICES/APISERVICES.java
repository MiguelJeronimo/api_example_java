package org.example.APISERVICES;

import org.example.model.ResponseTokent;
import org.example.model.client;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface APISERVICES {
    ///token"
    //metodos para hacer la peticion a retrofit enviandole la data requerida
    //En este caso le enviaremos un header y un body
    @POST("token")
    Call<ResponseTokent> getTokenPost(@Header("Content-Type") String header, @Body client client);
}
