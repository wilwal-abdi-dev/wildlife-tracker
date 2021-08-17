import org.sql2o.Connection;

public class Endangered extends Animal {

    public String health;
    public String age;
    public static final String ANIMAL_TYPE = "Endangered";
    public Endangered(String name, String health, String age) {
        super(name);
        if (name.equals("") || health.equals("") || age.equals("")){
            throw new IllegalArgumentException("Please enter all input fields.");
        }
        this.health = health;
        this.age = age;
        type = ANIMAL_TYPE;
    }
    public String getHealth() {
        return health;
    }

    public String getAge() {
        return age;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public void setAge(String age) {
        this.age = age;
    }
    @Override
    public boolean equals(Object otherEndangeredAnimal) {
        if (otherEndangeredAnimal instanceof Endangered) {
            Endangered newEndangeredAnimal = (Endangered) otherEndangeredAnimal;
            return (this.getName().equals(newEndangeredAnimal.getName()));
        }

        return false;

    }
    @Override
    public void save() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO endangered (name, health, age, type) VALUES (:name, :health, :age, :type)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name", name)
                    .addParameter("health", health)
                    .addParameter("age", age)
                    .addParameter("type", type)
                    .executeUpdate()
                    .getKey();
        }
    }
    public static Endangered find(int id) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM endangered WHERE id = :id";
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .throwOnMappingFailure(false)
                    .executeAndFetchFirst(Endangered.class);
        }
    }
    @Override
    public void update() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "UPDATE animals SET name = :name, health = :health, age = :age WHERE id = :id";
            con.createQuery(sql)
                    .addParameter("name", name)
                    .addParameter("health", health)
                    .addParameter("age", age)
                    .addParameter("id", id)
                    .executeUpdate();
        }
    }


}
