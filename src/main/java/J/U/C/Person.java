package J.U.C;

/**
 * @author shiming.li
 * @version $ v1.0 19-3-28 $
 */
public class Person {
        private String name;
        private int age;

        public static Person newPerson(String name, int age) {
            Person person = new Person();
            person.setAge(age);
            person.setName(name);
            return person;
        }

        void modifyName(String name){
            this.setName(name);
        }

        void modifyAge(int age){
            this.setAge(age);
        }

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

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
}
