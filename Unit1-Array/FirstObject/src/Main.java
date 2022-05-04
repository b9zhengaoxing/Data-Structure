public class Main {
    public static void main(String[] args) {
        newArray aArr = new newArray(200);

//        System.out.println(aArr.getCapacity());
//        System.out.println(aArr.isEmpty());
//        aArr.arrayGrammar();

        for (int i = 0; i < 100; i++){
            aArr.addFirst(i);
        }
        aArr.add(-1,24);
    }
}