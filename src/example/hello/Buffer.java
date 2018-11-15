package example.hello;

import java.util.ArrayList;

public class Buffer {
    public Buffer() {
        this.messages = new ArrayList<>();
    }

    private ArrayList<Message> messages;

    public void insert(Message message) {
        this.messages.add(message);
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }
}
