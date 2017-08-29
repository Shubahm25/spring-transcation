package beans;

/**
 * Created by shubham on 7/6/17.
 */
public class AccountTranscation {
    private String sendername;
    private String recievername;

    public String getRecievername() {
        return recievername;
    }

    public void setRecievername(String recievername) {
        this.recievername = recievername;
    }

    public String getSendername() {

        return sendername;
    }

    public String setSendername(String sendername) {
        this.sendername = sendername;
        return sendername;
    }
}
