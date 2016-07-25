package pl.temomuko.bootcampblank.model;

public class Day {

    private String topic;

    private String app;

    private String plan;

    private String name;

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ClassPojo [topic = " + topic + ", app = " + app + ", plan = " + plan + ", name = " + name + "]";
    }
}
