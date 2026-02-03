import java.util.ArrayList;
import java.util.LinkedList;

class task1_4 {

    public void main(String[] args){
        LinkedList<task1_3.Customer> list = new LinkedList<>();

        int customerID = 1;

        task1_3.Customer first = new task1_3.Customer(customerID);
        customerID += 1;

        task1_3.Customer second = new task1_3.Customer(customerID);
        customerID += 1;

        list.addFirst(first);
        list.addFirst(second);
        for (task1_3.Customer value : list) {
            System.out.println(value.getId());
        }
        System.out.println();
        list.removeLast();
        for (task1_3.Customer customer : list) {
            System.out.println(customer.getId());
        }
        System.out.println();
        System.out.println("Time spent by " + first.getId() + ": " + second.timeSpent() + " s");
    }
}
