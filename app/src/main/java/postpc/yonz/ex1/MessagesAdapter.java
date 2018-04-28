package postpc.yonz.ex1;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;

public class MessagesAdapter extends ArrayAdapter<Message> {


    public MessagesAdapter(Context context,
                           ArrayList<Message> messages) {
        super(context, 0, messages);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Message message = getItem(position);

        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            view = inflater.inflate(R.layout.message_item_layout, parent, false);
        }

        TextView senderTv =  view.findViewById(R.id.message_sender);
        TextView contentTv =  view.findViewById(R.id.message_content);
        TextView timeStampTv =  view.findViewById(R.id.message_time);
        senderTv.setText(message.getSender());
        contentTv.setText(message.getContent());
        timeStampTv.setText(message.getTimestamp());

        return view;
    }
}
