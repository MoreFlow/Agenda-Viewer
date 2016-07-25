package pl.temomuko.bootcampblank.ui;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import pl.temomuko.bootcampblank.R;
import pl.temomuko.bootcampblank.model.DaysArray;
import pl.temomuko.bootcampblank.remote.APIManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    ProgressDialog progress;
    DaysArray daysArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        loadDays();
    }

    private void setupRecyclerView() {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new DaysAdapter(this, daysArray));
    }

    private void loadDays() {
        progress = new ProgressDialog(this);
        progress.setTitle("Loading");
        progress.setMessage("Wait while loading...");
        progress.show();
        APIManager.getInstance().getService().getAgenda().enqueue(new Callback<DaysArray>() {
            @Override
            public void onResponse(Call<DaysArray> call, Response<DaysArray> response) {
                progress.dismiss();
                daysArray = handleResponse(response);
                setupRecyclerView();
            }

            @Override
            public void onFailure(Call<DaysArray> call, Throwable t) {
                progress.dismiss();
                Toast.makeText(MainActivity.this, "API Call Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private DaysArray handleResponse(Response<DaysArray> response) {
        if (response.body() != null) {
            return response.body();
        } else {
            Toast.makeText(this, "Response body is empty!", Toast.LENGTH_SHORT).show();
            return null;
        }
    }

}
