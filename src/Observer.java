interface Observer {
    public void update();
    public void setSubject(Subject sub);
}

class MyTopicSubscriber implements Observer {
    private String name;
    private Subject topic;

    public MyTopicSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void update() {
        String msg = (String) this.topic.getUpdate(this);

        if(msg == null)
            System.out.println(this.name + " : No new message");
        else
            System.out.println(this.name + " : Consuming message ::" + msg);
    }

    @Override
    public void setSubject(Subject sub) {
        this.topic = sub;
    }
}
