/**
 * 02.10.2017
 * MessageRendererErrorOutputImpl
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class MessageRendererErrorOutputImpl implements MessageRenderer {
    private Message message;

    public MessageRendererErrorOutputImpl(Message message) {
        this.message = message;
    }

    public void render() {
        System.err.println(message.getText());
    }
}
