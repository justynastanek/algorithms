package js.arrays;

public class Main {
    public static void main(String[] args) {

        int[] testArr = {1,2,3,4,5,6,7,8,9,10};
        MyArray x = new MyArray(testArr);

        x.print();
        System.out.println(x.find(11));
        System.out.println(x.find(6));
        System.out.println(x.pick(2));

        x.push(11);
        x.print();
        x.push(12);
        x.print();

        x.pop();
        x.print();
        x.pop();
        x.print();

        x.insert(0, 0);
        x.print();
    }
}
