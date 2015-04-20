package adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ogangi.messangi.demomaterial.R;

import java.util.ArrayList;

import models.Notification;

public class inboxAdapter extends RecyclerView.Adapter<inboxAdapter.ViewHolder> {
    private ArrayList<Notification> mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        protected TextView vTitle;
        protected TextView vSummary;
        protected TextView vDate;

        public ViewHolder(View v) {
            super(v);
            vTitle =  (TextView) v.findViewById(R.id.title);
            vSummary = (TextView)  v.findViewById(R.id.summary);
            vDate = (TextView)  v.findViewById(R.id.date);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public inboxAdapter(ArrayList<Notification> myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.inbox_item, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        Notification message = mDataset.get(position);
        holder.vTitle.setText(message.getTitle());
        holder.vSummary.setText(message.getContent());
        holder.vDate.setText(message.getReceivedDate());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }


}
