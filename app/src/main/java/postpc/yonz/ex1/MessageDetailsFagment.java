package postpc.yonz.ex1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class MessageDetailsFagment extends Fragment {


    Button deleteButton;
    TextView sender, date;
    boolean isDeleted = false;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.message_details_fragment,
                container, false);

        deleteButton = view.findViewById(R.id.message_detailed_detele);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isDeleted = true;
            }
        });

        sender = view.findViewById(R.id.message_detailed_sender);
        sender.setText(getArguments().getString("sender"));

        date = view.findViewById(R.id.message_detailed_date);
        date.setText(getArguments().getString("date"));

        return view;
    }
}
