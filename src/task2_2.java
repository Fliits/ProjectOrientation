import java.sql.Time;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class task2_2 {
    public enum EventType{
        arrival, exit
    }
    class Event implements Comparable<Event>{
        private int eventTime;
        EventType eventType;

        public Event (int time, EventType type){
            this.eventTime = time;
            this.eventType = type;
        }

        public int compareTo(Event e) {
            return this.eventTime-e.eventTime;
        }
    }
    class EventList{
        PriorityQueue<Event> list = new PriorityQueue<>();

        public PriorityQueue<Event> getList() {
            return list;
        }

        public void removeFirst() {
            this.list.poll();
        }
    }
    public void main(String[] args){
        int nOfEvents = 5;

        EventList eventList = new EventList();

        for (int i = 0; i<nOfEvents;i++){
            if (i % 2 == 0) {
                Event event = new Event((int) (i+Math.random()*100), EventType.arrival);
                eventList.list.add(event);
            } else {
                Event event = new Event((int) (i+Math.random()*100), EventType.exit);
                eventList.list.add(event);
            }
        }

        eventList.removeFirst();

        ArrayList<Event> arrangedList = new ArrayList();
        while (0 < eventList.list.size()){
            Event eka = eventList.list.poll();
            arrangedList.add(eka);
        }
        arrangedList.sort(Event::compareTo);
        for (int i = 0; i<arrangedList.size();i++) {
            System.out.println(arrangedList.get(i) + " " + arrangedList.get(i).eventTime + " " + arrangedList.get(i).eventType);
        }
    }
}
