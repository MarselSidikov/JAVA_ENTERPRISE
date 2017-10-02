import java.time.LocalDate;

/**
 * 02.10.2017
 * MessageLogImpl
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class MessageLogImpl implements  Message{
    private String text;

    public MessageLogImpl(String text) {
        this.text = text;
    }

    public String getText() {
        return LocalDate.now().toString() + " " + text;
    }
}
