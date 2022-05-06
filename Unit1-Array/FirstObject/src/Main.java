public class Main {
    public static void main(String[] args) {
        newArray aArr = new newArray(200);

//        System.out.println(aArr.getCapacity());
        System.out.println(aArr.isEmpty());
//        aArr.arrayGrammar();


        for (int i = 0; i < 10; i++){
            aArr.addFirst(i);
        }
        System.out.println(aArr.toString());
        System.out.println(aArr.getFirst());
        System.out.println(aArr.getLast());

        aArr.set(5,1000);
        System.out.println(aArr.toString());
//        aArr.add(-1,24);
    }
}