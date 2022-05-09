public class Main {
    public static void main(String[] args) {

        //基本封装验证
        BasicArray aArr = new BasicArray(200);

//        System.out.println(aArr.getCapacity());
//        System.out.println(aArr.isEmpty());
//        aArr.arrayGrammar();

        for (int i = 0; i < 10; i++)
            aArr.addFirst(i);

        System.out.println(aArr.toString());

        //Set/Get O(1)
        aArr.set(5,1000);
//        System.out.println(aArr.getFirst());
//        System.out.println(aArr.getLast());
//        System.out.println(aArr.get(3));
//        System.out.println(aArr.toString());
//        System.out.println(aArr.getIndex(1000));
//        aArr.add(-1,24);

        //add remove O(n)
        aArr.add(7,10);
        System.out.println(aArr.toString());

        System.out.println(aArr.remove(5));
        System.out.println(aArr.toString());

        System.out.println(aArr.removeLast());
        System.out.println(aArr.toString());
    }
}