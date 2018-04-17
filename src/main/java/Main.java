import java.util.Iterator;

/**
 * Created by andrii on 13.08.17.
 */
public class Main {

    public static void main(String[] args) {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<Integer>();
        list.add(1);
//        list.add(2);
        for (int i = 0; i < 100; i++) {
            list.add((int)(Math.random() * 1000));
        }
//        list.add(1000);
//        print(list);
//        System.out.println(list.getLast() + " " + list.getFirst() + " " + list.get(list.size()-1));
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

//    static void print(SimpleLinkedList list){
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }
//        System.out.println("List size is: " + list.size());
//    }
}
