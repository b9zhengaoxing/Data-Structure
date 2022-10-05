public class Main {
    public static void main(String[] args) {

        Linklist list = new Linklist<Integer>();
        for(int i = 0 ; i < 20 ; i ++){
            list.addFirst(i);
        }
        System.out.println(list.toString());

        list.add(3,100);
        System.out.println(list.toString());

        list.delete(20);
        System.out.println(list.toString());

        list.deleteFirst();
        System.out.println(list.toString());

        System.out.println(list.get(10));
    }
}