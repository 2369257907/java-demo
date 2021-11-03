import java.io.Serializable;

/**
 * zhangsan
 *
 * @author guoheng
 * @date 2021/11/03
 */
public class ZhangSan implements Serializable {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ZhangSan(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "ZhangSan{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
