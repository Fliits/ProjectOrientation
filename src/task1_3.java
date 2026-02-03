class task1_3 {
    public static class Customer {
        private int id;
        private long startTime;
        private long endTime;

        public Customer(int id) {
            this.id = id;
            this.startTime = System.currentTimeMillis();
            this.endTime = System.nanoTime();
        }

        public int getId() {
            return id;
        }

        public long getEndTime() {
            return endTime;
        }

        public long getStartTime() {
            return startTime;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setEndTime(long endTime) {
            this.endTime = endTime;
        }

        public void setStartTime(long startTime) {
            this.startTime = startTime;
        }

        public long timeSpent() {
            return endTime - startTime;
        }
    }
    public void main(String[] args) {
        int customerID = 1;

        Customer first = new Customer(customerID);
        customerID += 1;
        System.out.println("Time spent: " + first.timeSpent() + " s");

        Customer second = new Customer(customerID);
        customerID += 1;
        System.out.println("Time spent: " + second.timeSpent() + " s");
    }
}