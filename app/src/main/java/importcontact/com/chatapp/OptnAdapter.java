package importcontact.com.chatapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.List;

/**
 * Created by VS-2 on 11/20/2017.
 */

public class OptnAdapter extends RecyclerView.Adapter<OptnAdapter.MyViewHolder> {

    private List<String> moviesList;
    AsyncResult<String> asyncResult_selectedCategory;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public Button title;

        public MyViewHolder(View view) {
            super(view);
            title = (Button) view.findViewById(R.id.option_button);
        }
    }


    public OptnAdapter(List<String> moviesList,AsyncResult<String> asyncResult_selectedCategory) {
        this.moviesList = moviesList;
        this.asyncResult_selectedCategory=asyncResult_selectedCategory;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.button_list, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        final String movie = moviesList.get(position);
        holder.title.setText(movie);
        holder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                asyncResult_selectedCategory.success(moviesList.get(position));
            }
        });

    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}