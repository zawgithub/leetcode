package IODemo.BIO;

import java.io.Serializable;

/**
 * @Author: zhaoanwei
 * @Date: 2020/9/16
 */
public class Message implements Serializable {

    private String content;

    public Message() {
    }

    public Message(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
