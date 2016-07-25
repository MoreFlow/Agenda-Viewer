package pl.temomuko.bootcampblank.remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIManager {
//    public static final String BASE_URL = "https://bootcampagenda.firebaseio.com/";
    public static final String BASE_URL = "http://burno.ga/";

    private static APIManager instance;
    private AgendaService service;

    private APIManager() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(AgendaService.class);
    }

    public static APIManager getInstance() {
        if (instance == null) {
            instance = new APIManager();
        }
        return instance;
    }

    public AgendaService getService() {
        return service;
    }
}
