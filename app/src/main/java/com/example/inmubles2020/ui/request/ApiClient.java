package com.example.inmubles2020.ui.request;

import android.util.Log;

import com.example.inmubles2020.ui.perfiles.Propietarios;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public class ApiClient {
    private static final String PATH="http://www.secsanluis.com.ar/servicios/varios/bungalows/model/";
    private static  MyApiInterface myApiInteface;
    private static String accessToken=null;


    public static MyApiInterface getMyApiClient(){


        Gson gson = new GsonBuilder().setLenient().create();
        OkHttpClient.Builder client = new OkHttpClient.Builder();

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(PATH)
                .client(client.build())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        myApiInteface=retrofit.create(MyApiInterface.class);
        Log.d("salida",retrofit.baseUrl().toString());
        return myApiInteface;
    }





    public interface MyApiInterface {
        @POST("propietarios/login")
        Call<String> login(@Query("Correo")String usuario, @Query("Clave")String clave);

        @GET("propietarios")
        Call<Propietarios> obtenerDatos(@Header("Authorization")String token);

        @FormUrlEncoded
        @PUT("propietario/{id}")
        Call<Propietarios> actualizar(@Header("Authorization")String token, @Path("id") int groupId,@Field("Dni") int dni, @Field("Nombre")String nombre, @Field("Apellido") String apellido, @Field("Telefono")String telefono, @Field("Mail")String mail, @Field("Clave")String clave, @Field("Borrado") int borrado);

        // propietarioId-dni-nombre-apellido-telefono-mail-password-borrado


        // @GET("propietario")
        //Call<Propietario> leer(@Header("Authorization")String token);

        // @FormUrlEncoded
        // @PUT("propietario/{id}")
        //Call<Propietario> actualizar(@Header("Authorization")String token, @Path("id") int groupId, @Field("Nombre")String nombre,@Field("Apellido") String apellido,@Field("Dni") int dni,@Field("Correo")String correo,@Field("Clave")String clave,@Field("EstadoPropietario") int estado,@Field("Telefono")long telefono);
        // @GET("test")
        // Call<Data> leer();

        //listarClientes.php
        //@GET("listarClientes.php")
        //Call<List<Cliente>> getClientes();

        //@GET("insertarClientes.php")
        //Call<Cliente> createCliente(@Query("dni") int dni, @Query("apellido") String apellido, @Query("nombre") String nombre);
    }

}

