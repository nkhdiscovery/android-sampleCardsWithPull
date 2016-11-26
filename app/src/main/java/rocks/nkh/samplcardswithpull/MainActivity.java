package rocks.nkh.samplcardswithpull;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Match> mathces;
    private void initializeData(){
        mathces = new ArrayList<>();
        mathces.add(new Match("3", "iran folan", R.drawable.img_3));
        mathces.add(new Match("sport", "usa folan", R.drawable.img_sport));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView rv = (RecyclerView)findViewById(R.id.rv);
        rv.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this.getApplicationContext());
        rv.setLayoutManager(llm);
        this.initializeData();
        RVAdapter adapter = new RVAdapter(this.mathces, this.getApplicationContext());
        rv.setAdapter(adapter);
    }

}
