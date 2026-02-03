import java.util.ArrayList;
import java.util.LinkedList;

public class task1_5 {
    public static class ServicePoint{
        public static int averageServiceTime = 0;
        LinkedList<task1_3.Customer> list = new LinkedList<>();

        public ServicePoint(LinkedList<task1_3.Customer> list){
            this.list = list;
        }

        public void addToQueue(task1_3.Customer a){
            this.list.addFirst(a);
        }

        public void removeFromQueue(){
            this.list.removeLast();
        }

        public void serve() throws InterruptedException {
            boolean serving = false;
            while (!this.list.isEmpty()) {
                serving = true;
                task1_3.Customer customer = this.list.get(this.list.size() - 1);
                int sleeptime = (int) Math.random();
                averageServiceTime += sleeptime;

                try {
                    Thread.sleep(sleeptime);  // 1000 ms = 1s
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                removeFromQueue();
                System.out.println("Service took " + customer.getStartTime() + sleeptime + " s");
                serving = false;
            }
        }
    }
    public static class CustomerGenerator{
        private int customers;

        public CustomerGenerator (ServicePoint sp, int nroOfCustomers){
            LinkedList<task1_3.Customer> list = new LinkedList<>();
            this.customers = nroOfCustomers;
            for (int i = 0; i < this.customers;i++){
                task1_3.Customer customer = new task1_3.Customer(i);
                sp.addToQueue(customer);
            }
        }


    }
    public class program{
        public static void main() throws InterruptedException {
            LinkedList<task1_3.Customer> list = new LinkedList<>();
            ServicePoint sp = new ServicePoint(list);
            CustomerGenerator customerGenerator = new CustomerGenerator(sp, 3);

            sp.serve();
            sp.averageServiceTime = sp.averageServiceTime/3;
            System.out.println("average service time " + sp.averageServiceTime);
        }
    }
}
