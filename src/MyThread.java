public class MyThread extends Thread{

    private final float[] workArray;

    public MyThread(float[] array){
        this.workArray = array;
    }

    public void run() {
    int ArrayL = this.workArray.length;
    for(int i = 0;i<ArrayL;i++){
        this.workArray[i] = this.mathAction(this.workArray[i]);
       // System.out.println(this.getName()+": "+i+": "+this.workArray[i]);
    }

    }

    private float mathAction(float value ){
        return  (float)(value * Math.sin(0.2f + value / 5) * Math.cos(0.2f + value / 5) * Math.cos(0.4f + value / 2));
    }

}
