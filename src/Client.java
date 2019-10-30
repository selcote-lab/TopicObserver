public class Client {
    public static void main(String[] args) {

        MyTopic topic = new MyTopic();

        Observer ob1 = new MyTopicSubscriber("Zouhaire");
        ob1.setSubject(topic);
        Observer ob2 = new MyTopicSubscriber("Ali");
        ob2.setSubject(topic);
        Observer ob3 = new MyTopicSubscriber("Jack");
        ob3.setSubject(topic);

        topic.register(ob1);
        topic.register(ob2);
        topic.register(ob3);

        topic.postMessage("Good news");

    }
}
