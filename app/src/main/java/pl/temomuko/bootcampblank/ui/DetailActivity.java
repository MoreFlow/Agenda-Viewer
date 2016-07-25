package pl.temomuko.bootcampblank.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import pl.temomuko.bootcampblank.R;

public class DetailActivity extends AppCompatActivity {

    @BindView(R.id.detail_name)
    TextView nameTextView;

    @BindView(R.id.detail_topic)
    TextView topicTextView;

    @BindView(R.id.detail_app)
    TextView appTextView;

    @BindView(R.id.detail_plan)
    TextView planTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        consumeIntent();
    }

    public void consumeIntent() {
        Intent intent = getIntent();
        nameTextView.setText(intent.getStringExtra("name"));
        topicTextView.setText(String.format("Temat: %s", intent.getStringExtra("topic")));
        appTextView.setText(String.format("Nazwa aplikacji: %s", intent.getStringExtra("app")));
        planTextView.setText(intent.getStringExtra("plan"));
    }
}
