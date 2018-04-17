package postpc.yonz.ex1;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MessagesAdapter extends ArrayAdapter<Message> {

    private final Activity context;
    private final ArrayList<Message> messages;

    public MessagesAdapter(Activity context,
                           ArrayList<Message> messages) {
        super(context, R.layout.message_layout, messages);
        this.context = context;
        this.messages = messages;

    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.message_layout, null, true);
        TextView sender = (TextView) rowView.findViewById(R.id.message_sender);
        TextView content = (TextView) rowView.findViewById(R.id.message_content);
        TextView timeStamp = (TextView) rowView.findViewById(R.id.message_time);

        sender.setText(messages.get(messages.size() - 1).getSender());
        content.setText(messages.get(messages.size() - 1).getContent());
        timeStamp.setText(messages.get(messages.size() - 1).getTimestamp());

        return rowView;
    }
}
