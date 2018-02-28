package pk.getsub.www.getsub.history;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import pk.getsub.www.getsub.R;

/**
 * Created by hp on 1/24/2018.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private Context context;
    private String[] data;
    private ArrayList<UserHistory> userData;

    public MyAdapter(Context context , ArrayList<UserHistory> userData){
        this.context = context;
        this.userData = userData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recviewdata, parent , false);
        MyViewHolder vh = new MyViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.firstName.setText(userData.get(position).getOrder());
        holder.lastName.setText(userData.get(position).getAddress());
    }

    @Override
    public int getItemCount() {
        return userData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView firstName;
        private TextView lastName;
        public MyViewHolder(View itemView) {
            super(itemView);
            firstName = itemView.findViewById(R.id.txt_first_name);
            lastName = itemView.findViewById(R.id.txt_las_name);

        }
    }

}
