package Transaction.nullable;

import org.springframework.lang.Nullable;

public class User {
   @Nullable
   private String id;
   private String name;
   private String gender;

    public User(String id, String name, String gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }

    public User() {
    }
    @Nullable
    public String getId() {
        return id;
    }

    public void setId(@Nullable String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
