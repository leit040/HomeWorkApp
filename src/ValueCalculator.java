public class ValueCalculator {

    private float[] set;
    private int setCount;
    private int setHalfCount;

    public ValueCalculator(int setCount) {
        this.setCount = setCount;
        this.setHalfCount = setCount / 2;
        this.set = new float[setCount];
    }

    void run() throws InterruptedException {
        long start = System.currentTimeMillis();
        float[] firstHalfSet = new float[this.setHalfCount];
        float[] secondHalfSet = new float[this.setHalfCount];
        for (int i = 0; i < setCount; i++) {
            this.set[i] = 1;
        }
        System.arraycopy(this.set, 0 , firstHalfSet, 0, setHalfCount);
        System.arraycopy(this.set, setHalfCount -1 , secondHalfSet, 0, setHalfCount);

        MyThread thread1 = new MyThread(firstHalfSet);
        MyThread thread2 = new MyThread(secondHalfSet);

        thread1.start();
        thread2.start();
        thread1.join();
        thread1.join();

        System.arraycopy(firstHalfSet,0,this.set,0,this.setHalfCount);
        System.arraycopy(secondHalfSet,0,this.set,this.setHalfCount-1,this.setHalfCount);

        long end = System.currentTimeMillis();

        //for check
        System.out.printf("end of first part:%f \n",firstHalfSet[setHalfCount-2]);
        System.out.printf("end of second part:%f \n",secondHalfSet[setHalfCount-2]);

        System.out.printf("It's take a %d milliseconds",end - start);
    }


}
