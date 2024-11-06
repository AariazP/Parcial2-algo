package divideAndConquer;

public class MultiplicacionRusa {


    public static void main(String[] args) {
        MultiplicacionRusa rusa = new MultiplicacionRusa();
        System.out.println(rusa.multiplicar(3,2));
    }

    public int multiplicar(int a, int b){

        if(a==0) return 0;
        else if (a%2==0) return multiplicar(a/2, b*2);
        else return b+multiplicar(a/2, b*2);
    }

}
