package postpc.yonz.ex1;



import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MessageInputFragment.InputListener{

    ListView messagesListView;
    ArrayList<Message> messages;
    MessagesAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        messages = new ArrayList<>();
        adapter = new
                MessagesAdapter(this, messages);
        messagesListView= findViewById(R.id.messagesListView);
        messagesListView.setAdapter(adapter);
        messagesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "hi", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void sendMessage(String sender, String message) {
        Message messageToAdd = new Message(sender, message);
        messages.add(messages.size(), messageToAdd);
        adapter.notifyDataSetChanged();
    }
}