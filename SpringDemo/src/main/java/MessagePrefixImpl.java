/**
 * 02.10.2017
 * MessagePrefixImpl
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class MessagePrefixImpl implements Message {
    private String message;
    private String prefix;

    public MessagePrefixImpl(String message, String prefix) {
        this.message = message;
        this.prefix = prefix;
    }

    public String getText() {
        return prefix + message;
    }
}
