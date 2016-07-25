package pl.temomuko.bootcampblank.ui;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import pl.temomuko.bootcampblank.R;
import pl.temomuko.bootcampblank.model.Day;
import pl.temomuko.bootcampblank.model.DaysArray;

public class DaysAdapter extends RecyclerView.Adapter<DaysAdapter.ViewHolder> {

    List<Day> dayList;
    Context context;

    public DaysAdapter(Context context, DaysArray array) {
        this.context = context;
        dayList = new ArrayList<>(Arrays.asList(array.getDays()));
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.day_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final Day day = dayList.get(position);
        setHolderData(holder, day);
        holder.dayCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("name", day.getName());
                intent.putExtra("topic", day.getTopic());
                intent.putExtra("app", day.getApp());
                intent.putExtra("plan", day.getPlan());
                context.startActivity(intent);
            }
        });
    }

    public void setHolderData(ViewHolder holder, Day day) {
        holder.dayTextView.setText(day.getName());
        holder.topicTextView.setText(day.getTopic());
    }

    @Override
    public int getItemCount() {
        return dayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.day_card_view)
        CardView dayCardView;

        @BindView(R.id.label_day)
        TextView dayTextView;

        @BindView(R.id.label_topic)
        TextView topicTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}