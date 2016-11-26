package rocks.nkh.samplcardswithpull;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Field;
import java.util.List;

/**
 * Created by nkh on 11/26/16.
 */
public class RVAdapter extends RecyclerView.Adapter<RVAdapter.MatchViewHolder>{

    List<Match> matches;
    Context context;
    RVAdapter(List<Match> matches, Context context){
        this.matches = matches;
        this.context = context;
    }



    public int getIconId(String channelName) {
        return this.context.getResources().getIdentifier(
                "img_" + channelName, "drawable", this.context.getPackageName());
    }

    @Override
    public MatchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false);
        MatchViewHolder pvh = new MatchViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(MatchViewHolder holder, int position) {
        holder.channelName.setText(matches.get(position).channelName);
        holder.eventText.setText(matches.get(position).eventText);
        Log.d("nkh", "String res is: " + "img_" + matches.get(position).channelName);
        holder.channelLogo.setImageResource(getIconId(matches.get(position).channelName));
    }

    @Override
    public int getItemCount() {
        return matches.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public static class MatchViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView channelName;
        TextView eventText;
        ImageView channelLogo;

        MatchViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            channelName = (TextView)itemView.findViewById(R.id.matchName);
            eventText = (TextView)itemView.findViewById(R.id.eventText);
            channelLogo = (ImageView)itemView.findViewById(R.id.channelLogo);
        }
    }

}