/**
 * 02.10.2017
 * MessageRendererStandardOutImpl
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class MessageRendererStandardOutImpl implements MessageRenderer {
    private Message message;

    public MessageRendererStandardOutImpl(Message message) {
        this.message = message;
    }

    public void render() {
        System.out.println(message.getText());
    }
}
