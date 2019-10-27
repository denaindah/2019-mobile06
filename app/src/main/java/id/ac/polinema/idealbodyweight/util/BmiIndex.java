package id.ac.polinema.idealbodyweight.util;

public class BmiIndex {
    private int weight;
    private int height;
    private float index;

    public BmiIndex(int height, int weight){
        this.weight = weight;
        this.height = height;
        this.index = calculate();
    }

    public float getIndex(){
        return index;
    }

    private float calculate() {
        float hasil = (float) (this.weight/Math.pow(this.height, 2));
        return hasil;
    }
}