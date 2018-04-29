package postpc.yonz.ex1;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Message {


    private String sender, content;
    private Date timestamp;

    public Message(String sender, String content)
    {
        this.sender = sender;
        this.content = content;
        this.timestamp = new Date();
    }

    public String getSender() {
        return sender;
    }

    public String getContent() {
        return content;
    }

    public String getTimestamp() {
        SimpleDateFormat ft = new SimpleDateFormat ("hh:mm");
        return ft.format(timestamp);
    }

    public String getDetailedTimeStamp()
    {
        SimpleDateFormat ft = new SimpleDateFormat ("EEE, MMM d, hh:mm");
        return ft.format(timestamp);
    }

}
