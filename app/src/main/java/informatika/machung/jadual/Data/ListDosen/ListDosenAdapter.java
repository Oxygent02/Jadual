package informatika.machung.jadual.Data.ListDosen;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import informatika.machung.jadual.R;

public class ListDosenAdapter extends RecyclerView.Adapter<ListDosenAdapter.CategoryViewHolder>{
    private Context context;
    private ArrayList<Dosen> listDosen;

    public ArrayList<Dosen> getListDosen() {
        return listDosen;
    }

    public void setListDosen(ArrayList<Dosen> listDosen) {
        this.listDosen = listDosen;
    }

    public ListDosenAdapter(Context context) {
        this.context = context;
    }

    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemRow = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_dosen, parent, false);
        return new CategoryViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(CategoryViewHolder holder, int position) {

        holder.tvName.setText(getListDosen().get(position).getName());
        holder.tvRemarks.setText(getListDosen().get(position).getRemarks());

        Glide.with(context)
                .load(getListDosen().get(position).getPhoto())
                .override(55, 55)
                .crossFade()
                .into(holder.imgPhoto);
    }

    @Override
    public int getItemCount() {
        return getListDosen().size();
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder{
        TextView tvName;
        TextView tvRemarks;
        ImageView imgPhoto;

        public CategoryViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView)itemView.findViewById(R.id.tv_item_name);
            tvRemarks = (TextView)itemView.findViewById(R.id.tv_item_remarks);
            imgPhoto = (ImageView)itemView.findViewById(R.id.img_item_photo);

        }
    }
}
