public class Student {
    private String name;
    private int score;

    public Student(String aName,int aScore){
        name = aName;
        score = aScore;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Student Name:%s Score:%d \n",name,score));

        return res.toString();
    }
}
