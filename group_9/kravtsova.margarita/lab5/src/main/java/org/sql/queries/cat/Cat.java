package org.sql.queries.cat;

import org.sql.queries.annotations.PrimaryKey;
import org.sql.queries.annotations.TableSQL;

@TableSQL(nameTable = "Cats")
public class Cat {
    @PrimaryKey
    private final Integer idCat;
    private String name;
    private final Gender gender; //1 - женский, 2 - мужской
    private Integer age;
    private final CatBreeds breed;
    private Boolean fertility;
    private Boolean hasMaster;
    public Cat(Integer idCat, String name, Gender gender, Integer age, CatBreeds breed, Boolean fertility, Boolean hasMaster) {
        this.idCat = idCat;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.breed = breed;
        this.fertility = fertility;
        this.hasMaster = hasMaster;
    }
    public Integer getIdCat() {
        return idCat;
    }
    public String getName() {
        return name;
    }
    public Gender getGender() {
        return gender;
    }
    public Integer getAge() {
        return age;
    }
    public CatBreeds getBreed() {
        return breed;
    }
    public Boolean getFertility() {
        return fertility;
    }
    public Boolean getHasMaster() {
        return hasMaster;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public void setFertility(Boolean fertility) {
        this.fertility = fertility;
    }
    public void setHasMaster(Boolean hasMaster) {
        this.hasMaster = hasMaster;
    }
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Cat cat = (Cat) object;

        if(idCat.equals(cat.idCat)) return false;
        if (gender != cat.gender) return false;
        if (age.equals(cat.age)) return false;
        if (!name.equals(cat.name)) return false;
        if (breed != cat.breed) return false;
        if (!fertility.equals(cat.fertility)) return false;
        return hasMaster.equals(cat.hasMaster);
    }
    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + idCat.hashCode();
        result = 31 * result + gender.hashCode();
        result = 31 * result + age.hashCode();
        result = 31 * result + breed.hashCode();
        result = 31 * result + fertility.hashCode();
        result = 31 * result + hasMaster.hashCode();
        return result;
    }
    @Override
    public String toString() {
        return "Cat{" +
                "idCat=" + idCat +
                ", name='" + name + '\'' +
                ", sex=" + gender +
                ", age=" + age +
                ", breed=" + breed +
                ", fertility=" + fertility +
                ", hasMaster=" + hasMaster +
                '}';
    }
}
