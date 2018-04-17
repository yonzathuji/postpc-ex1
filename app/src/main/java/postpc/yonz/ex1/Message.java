package postpc.yonz.ex1;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Message {


    private String sender, content, timestamp;

    public Message(String sender, String content)
    {
        this.sender = sender;
        this.content = content;

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

        this.timestamp = sdf.format(cal.getTime());
    }

    public String getSender() {
        return sender;
    }

    public String getContent() {
        return content;
    }

    public String getTimestamp() {
        return timestamp;
    }

}
