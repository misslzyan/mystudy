package cn.dwd.copy;

/**
 * 描述:浅拷贝的一个解析
 * Object 的clone方法是一个浅拷贝
 * Created by xiaoyanzi on 16/4/27.
 */
public class ShallowCopy {

    public static void main(String[] args) throws CloneNotSupportedException{
        ShallowCopy s = new ShallowCopy();

        Teacher t1 = s.new Teacher("zhangsan",1);

        Student s1 = s.new Student("lisi",2,t1);

        Teacher t2 = (Teacher)t1.clone();

        Student s2 = (Student)s1.clone();

        s2.t.name="wangwu";
        s2.t.age=3;
        s2.name="s2";
        s2.age = 66;
        System.out.println(s2.name+","+s2.age+","+s2.t.name+","+s2.t.age);
        System.out.println(s1.name+","+s1.age+","+s1.t.name+","+s1.t.age);
        System.out.println(t1);
        System.out.println(t2);
        System.out.println(s1.t);
        System.out.println(s2.t);
    }




  class Teacher implements Cloneable{
        private String name;
        private int age;

      public Teacher(String name , int age){
          this.name = name;
          this.age = age;
      }

      @Override
      protected Object clone() throws CloneNotSupportedException {
          return super.clone();
      }
  }

    class Student implements Cloneable{
        private String name;
        private int age;
        private Teacher t;

        public Student(String name , int age,Teacher t){
            this.name = name;
            this.age = age;
            this.t = t;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }
}


