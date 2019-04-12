package js.arrays;

public class MyArray {

    private int size = 10;
    private int[] arr = new int[this.size];

    public MyArray() {
        for( int elem : this.arr){
            elem = 0;
        }
    }

    public MyArray(int[] inputArr) {
        int l = inputArr.length;
        this.arr = new int[l];

        for(int i = 0; i < l; i++){
            this.arr[i] = inputArr[i];
        }

        this.size = l;
    }

    public void print(){
        for(int i = 0; i < this.size; i++){
            System.out.print(this.arr[i] + " ");
        }
        System.out.println();
    }

    //find(int toFind) - returns index of number given as parameter/ -1
    public int find(int toFind){
        for(int i = 0; i < this.size; i++){
            if(toFind == this.arr[i]){
                return i;
            }
        }
        return -1;
    }

    //pick(int i) - returns number at given index
    public int pick(int i){
        if(i < 0 || i >= this.size){
            throw new ArrayIndexOutOfBoundsException("Incorrect index number.");
        } else{
            return this.arr[i];
        }
    }

    //push(int toPush) - pushes given number into array
    public void push(int toPush){
        if(this.arr.length == this.size){
            int[] newArray = new int[2 * this.arr.length];
            for(int i = 0; i < this.size; i++){
                newArray[i] = this.arr[i];
            }
            newArray[this.size] = toPush;
            this.arr = newArray;
            this.size++;
        } else{
            this.arr[this.size] = toPush;
            this.size++;
        }
    }

    //pop() - returns last element and then removes it from array
    public int pop(){
        if(this.size == 0){
            throw new RuntimeException("Array is empty. Operation incorrect.");
        }
        int result = this.arr[this.size - 1];
        this.arr[--this.size] = 0;
        if(this.size <= 0.25 * this.arr.length){
            int[] newArr = new int[this.arr.length / 2];
            for(int i = 0; i < this.size; i++){
                newArr[i] = this.arr[i];
            }
            this.arr = newArr;
        }
        return result;
    }

    //insert(int index, int toInsert) - inserts given number into given index
    public void insert(int index, int toInsert){
        if(index < 0 || index >= this.size){
            throw new IndexOutOfBoundsException("Index number out of array bounds.");
        }else if(this.size == this.arr.length){
            this.push(0);
            this.size--;

        }
        for(int i = this.size; i > index; i--){
            this.arr[i] = this.arr[i-1];
        }
        this.arr[index] = toInsert;
        this.size++;
    }

    //shift() - removes first element of array and returns it
    public int shift(){
        if(this.size == 0){
            throw new RuntimeException("Array is empty. Operation incorrect.");
        }
        int result = this.arr[0];
        this.size--;
        if(this.size <= 0.25 * this.arr.length){
            int[] newArr = new int[this.arr.length / 2];
            for(int i = 0; i < this.size; i++){
                newArr[i] = this.arr[i+1];
            }
            this.arr = newArr;
        } else{
            for(int i = 0; i < this.size; i++){
                this.arr[i] = this.arr[i+1];
            }
        }
        return result;
    }


}
