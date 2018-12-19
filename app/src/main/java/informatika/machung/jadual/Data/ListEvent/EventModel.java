package informatika.machung.jadual.Data.ListEvent;

public class EventModel {

    private String event_name;
    private String event_time;
    private String event_desc;

    public String getEvent_desc() { return event_desc; }

    public void setEvent_desc(String event_desc) { this.event_desc = event_desc; }

    public String getEvent_name() {
        return event_name;
    }

    public String getEvent_time() {
        return event_time;
    }

    public void setEvent_name(String event_name) {
        this.event_name = event_name;
    }

    public void setEvent_time(String event_time) {
        this.event_time = event_time;
    }
}
