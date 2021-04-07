package reflection.RMI;

import java.io.Serializable;

public class Person implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    

    private String name;
    private Integer age;
    
    public Person(){}

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    };


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    

}
