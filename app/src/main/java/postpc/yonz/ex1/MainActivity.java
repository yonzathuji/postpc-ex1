package postpc.yonz.ex1;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView messagesListView;
    ArrayList<Message> messages;
    MessagesAdapter adapter;

    Button sendButton;

    EditText textBox;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        messages = new ArrayList<>();

        adapter = new
                MessagesAdapter(MainActivity.this, messages);
        messagesListView=(ListView)findViewById(R.id.messagesListView);
        messagesListView.setAdapter(adapter);

        textBox = (EditText)findViewById(R.id.inputText);

        sendButton = (Button)findViewById(R.id.sendButton);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addMessage();
            }
        });

    }

    private void addMessage()
    {
        Message messageToAdd = new Message("yoni", textBox.getText().toString());
        messages.add(messageToAdd);
        adapter.notifyDataSetChanged();

    }
}