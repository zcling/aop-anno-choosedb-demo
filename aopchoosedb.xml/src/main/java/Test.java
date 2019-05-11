import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;

import java.util.*;

/**
 * Created by zcl on 2019-01-05.
 * Comparable是排序接口，若一个类实现了Comparable接口，就意味着“该类支持排序”。
 * 而Comparator是比较器，我们若需要控制某个类的次序，可以建立一个“该类的比较器”来进行排序。
 * <p>
 * 　　Comparable相当于“内部比较器”，而Comparator相当于“外部比较器”。
 * <p>
 * 　　两种方法各有优劣， 用Comparable 简单， 只要实现Comparable 接口的对象直接就成为一个可以比较的对象，但是需要修改源代码。
 * 用Comparator 的好处是不需要修改源代码， 而是另外实现一个比较器， 当某个自定义的对象需要作比较的时候，
 * 把比较器和对象一起传递过去就可以比大小了， 并且在Comparator 里面用户可以自己实现复杂的可以通用的逻辑，
 * 使其可以匹配一些比较简单的对象，那样就可以节省很多重复劳动了。
 */
public class Test {
    public static void main(String[] args) {

        /**
         * 第一种比较方式
         */
        User[] users = new User[]{new User(1), new User(3), new User(2)};
        Arrays.sort(users);
        for (User user : users) {
            System.out.println(user.getGrade());
        }
        /**
         * 第二种比较方式
         */
        System.out.println("-------------------------------------");
        Arrays.sort(users, new compareTest());
        for (User user : users) {
            System.out.println(user.getGrade());
        }
        /**
         * lambda 表达式方式打印
         *
         * */
        System.out.println("-------------------------------------");
        List<User> list = Arrays.asList(users);
        list.forEach((player) -> System.out.print(player.getGrade() + "; "));

        Collections.sort(list, (User user1, User user2) -> (user1.getGrade() - user2.getGrade()));
        list.forEach((user -> System.out.println(user.getGrade())));
    }
}

class User implements Comparable {
    private String name;
    private Integer grade;

    User(Integer grade) {
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public int compareTo(Object o) {
        User o1 = (User) o;
        //return this.getGrade() > o1.getGrade() ? 1 : this.getGrade() < o1.getGrade() ? -1 : 0;
        return this.getGrade() - o1.getGrade();
    }
}

class compareTest implements Comparator {

    public int compare(Object o1, Object o2) {
        User user1 = (User) o1;
        User user2 = (User) o2;
        return -(user1.getGrade() - user2.getGrade());
    }
}
