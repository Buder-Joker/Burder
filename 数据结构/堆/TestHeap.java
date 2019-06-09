package dataStruct;

public class TestHeap {
    public static void main(String[] args) {
        //int[] num = new int[]{62,41,30,28,16,22,13,19,17,15};
        Integer[] num = new Integer[]{19,41,16,15,30,22,13,62,17,28};
        Heap<Integer> heap = new Heap<Integer>(num);

        //heap.heaptly(num);
        System.out.print(heap+" ");
       /* for(int i:num){
            heap.add(i);
        }
        heap.add(52);
        */
        /*while (!heap.isEmpty()) {
            System.out.print(heap.removeMax() + " ");
        }*/
        //System.out.print(heap);
        //System.out.println(heap.replace(26));
        //System.out.println(heap.findMax());


    }
}
