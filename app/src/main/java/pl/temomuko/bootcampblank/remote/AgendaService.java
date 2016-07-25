package pl.temomuko.bootcampblank.remote;

import pl.temomuko.bootcampblank.model.DaysArray;
import retrofit2.Call;
import retrofit2.http.GET;

public interface AgendaService {

    @GET("schedule.json")
    Call<DaysArray> getAgenda();

}
