package com.example.inmubles2020.ui.request;

import android.util.Log;

import com.example.inmubles2020.ui.Usuario;
import com.example.inmubles2020.ui.perfiles.Propietario;
import com.example.inmubles2020.ui.propiedades.Inmuebles;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public class ApiClient {
    private static final String PATH="http://192.168.0.15:45455/api/";
    private static  MyApiInterface myApiInteface;
    private static String accessToken=null;


    public static MyApiInterface getMyApiClient(){


        Gson gson = new GsonBuilder().setLenient().create();

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(PATH)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        myApiInteface=retrofit.create(MyApiInterface.class);
        Log.d("salida",retrofit.baseUrl().toString());
        return myApiInteface;
    }

    public interface MyApiInterface {

        @POST("propietarios/login")
        Call<String> login(@Body Usuario user);

        @GET("propietarios")
        Call<Propietario> obtenerDatos(@Header("Authorization")String token);

        @PUT("propietarios")
        Call<Propietario> actualizar(@Header("Authorization")String token,@Body Propietario p);

        @GET("Inmuebles")
        Call<List<Inmuebles>> listarInmuebles(@Header("Authorization") String token);

        @GET("Inmuebles/{id}")
        Call<Inmuebles> obtenerDatosInmueble(@Header("Authorization") String token,@Path("id")int id);

       // @FormUrlEncoded
        @PUT("Inmuebles/{id}")
        Call<Inmuebles> actualizarInmueble(@Header("Authorization") String token, @Path("id") int id, @Body Inmuebles inmueble);

        @POST("Inmuebles")
        Call<Inmuebles> guardarInmueble(@Header("Authorization") String token, @Body Inmuebles inmueble);

        @DELETE("Inmuebles/{id}")
        Call<Inmuebles> bajaInmueble(@Header("Authorization")String token,@Path("id")int id);
    }

}

