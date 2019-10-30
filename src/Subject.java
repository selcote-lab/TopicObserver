import java.util.ArrayList;
import java.util.List;


interface Subject {
    public void register(Observer obj);
    public void unregister(Observer ob);
    public void notifyObservers();
    public Object getUpdate(Observer obj);
}

class MyTopic implements Subject {
    private List<Observer> observers;
    private String message;
    private boolean changed;

    public MyTopic() {
        this.observers = new ArrayList<Observer>();
    }

    @Override
    public void register(Observer obj) {
        if (obj == null) throw new NullPointerException("Null Observer");

        if (!this.observers.contains(obj)) this.observers.add(obj);
    }

    @Override
    public void unregister(Observer obj) {
        this.observers.remove(obj);
    }

    @Override
    public void notifyObservers() {
        List<Observer> localObservers = null;

        if(!changed) return;

        localObservers = new ArrayList<>(this.observers);
        changed = false;

        for (Observer obj : localObservers) {
            obj.update();
        }
    }

    @Override
    public Object getUpdate(Observer obj) {
        return this.message;
    }

    public void postMessage(String msg) {
        System.out.println("We have updated the topic: " + msg);
        this.message = msg;
        this.changed = true;
        this.notifyObservers();
    }
}
