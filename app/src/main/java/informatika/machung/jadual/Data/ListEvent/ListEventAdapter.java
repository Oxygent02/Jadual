package informatika.machung.jadual.Data.ListEvent;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import informatika.machung.jadual.R;

public class ListEventAdapter extends RecyclerView.Adapter<ListEventAdapter.CategoryViewHolder>{
    private Context context;
    private ArrayList<Event> listEvent;

    public ArrayList<Event> getListEvent() {
        return listEvent;
    }

    public void setListEvent(ArrayList<Event> listEvent) {
        this.listEvent = listEvent;
    }

    public ListEventAdapter(Context context) {
        this.context = context;
    }

    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemRow = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_event, parent, false);
        return new CategoryViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(CategoryViewHolder holder, int position) {

        holder.eventName.setText(getListEvent().get(position).getEvent_name());
        holder.eventTime.setText(getListEvent().get(position).getEvent_time());
        holder.eventDesc.setText("\"" +getListEvent().get(position).getEvent_desc() + "\"");
        holder.eventDesc.setTypeface(null, Typeface.ITALIC);

        //check if desc null
        if (holder.eventDesc.getText().equals("\"\"")){
            holder.eventDesc.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return getListEvent().size();
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder{
        TextView eventName;
        TextView eventTime;
        TextView eventDesc;

        public CategoryViewHolder(View itemView) {
            super(itemView);
            eventName = itemView.findViewById(R.id.tv_event_name);
            eventTime = itemView.findViewById(R.id.tv_event_time);
            eventDesc = itemView.findViewById(R.id.tv_event_desc);
        }
    }
}
