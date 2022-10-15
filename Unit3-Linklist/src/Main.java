public class Main {
    public static void main(String[] args) {

        Linklist list = new Linklist<Integer>();
        for(int i = 0 ; i < 10 ; i ++){
            list.add(i,i);
//            list.addFirst(i);
        }
        System.out.println(list.toString());
        list.add(3,100);
        System.out.println(list.toString());

        list.remove(10);
        System.out.println(list.toString());
        list.removeFirst();
        System.out.println(list.toString());


        list.set(8,-99);
        System.out.println(list.toString());

        list.setLast(21);
        list.setFirst(81);
        System.out.println(list.toString());

        System.out.println(list.contain(81) + " " + list.toString());


        System.out.println(list.get(5));
        System.out.println(list.getFirst());
        System.out.println(list.getLast());
    }
}