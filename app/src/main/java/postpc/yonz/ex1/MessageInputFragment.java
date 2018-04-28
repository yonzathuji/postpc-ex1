package postpc.yonz.ex1;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class MessageInputFragment extends Fragment {

    Button sendButton;
    EditText input;

    InputListener activityCommander;

    public interface InputListener
    {
        public void sendMessage(String sender, String message);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try
        {
            activityCommander = (InputListener) activity;
        }
        catch (ClassCastException e)
        {
            throw new ClassCastException(activity.toString());
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.message_input_fragment,
                container, false);

        input = view.findViewById(R.id.message_input);

        sendButton = view.findViewById(R.id.send_message_button);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activityCommander.sendMessage("Yoni", input.getText().toString());
                input.setText("");
            }
        });

        input = view.findViewById(R.id.message_input);

        return view;
    }
}
