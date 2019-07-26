public class Student {
    private String name;
    private int score;

    public Student(String studentName,int studentScore){
        name = studentName;
        score = studentScore;
    }

    @Override
    public String toString() {
        return String.format("Student(name:%s ,score:%d)",name,score);
    }

    public static void main(String[] args) {
        // write your code here

        Array<Student> arr = new Array<>();
        arr.addLast(new Student("LeeMing",100));
        arr.addLast(new Student("ZhangQiang",78));
        arr.addLast(new Student("ChenLong",42));
        arr.addLast(new Student("MaDong",98));

        System.out.println(arr);
    }
}
