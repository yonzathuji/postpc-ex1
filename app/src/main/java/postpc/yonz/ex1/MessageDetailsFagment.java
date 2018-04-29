package postpc.yonz.ex1;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class MessageDetailsFagment extends DialogFragment {


    Button deleteButton;
    TextView sender, timeStamp;
    private int messagePosition;

    DeleteListener activityCommander;

    public interface DeleteListener
    {
        public void deleteMessage(int poisition);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            activityCommander = (DeleteListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString());
        }
    }

    public MessageDetailsFagment(){}

    public static MessageDetailsFagment newInstance(Message message, int position) {
        MessageDetailsFagment fragment = new MessageDetailsFagment();

        Bundle args = new Bundle();
        args.putString("sender", message.getSender());
        args.putString("timeStamp", message.getDetailedTimeStamp());
        args.putInt("position", position);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getDialog().setCanceledOnTouchOutside(true);

        return inflater.inflate(R.layout.message_details_fragment,
                container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        messagePosition = getArguments().getInt("position");

        sender = view.findViewById(R.id.message_detailed_sender);
        sender.setText(getArguments().getString("sender"));
        timeStamp = view.findViewById(R.id.message_detailed_date);
        timeStamp.setText(getArguments().getString("timeStamp"));

        deleteButton = view.findViewById(R.id.message_detailed_detele);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activityCommander.deleteMessage(messagePosition);
                getDialog().cancel();
            }
        });

        getDialog().getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
    }

}
