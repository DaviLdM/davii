class Consumer implements Runnable {
    public static final int STOP = -1;

    private final Buffer buffer;
    private final int sleepTime;
    private final int id;

    public Consumer(int id, Buffer buffer, int sleepTime) {
        this.id = id;
        this.buffer = buffer;
        this.sleepTime = sleepTime;
    }

    @Override
    public void run() {
        try {
            while (true) {
                int item = buffer.remove();

                if (item == STOP) {
                    System.out.println("Consumer " + id + " recebeu STOP e vai encerrar.");
                    break;
                }

                System.out.println("Consumer " + id + " consumed item " + item);
                Thread.sleep(sleepTime);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Consumer " + id + " finalizou.");
    }
}
