package app;

class Employee implements Comparable<Employee>{
    int id;
    String name;
    String position;

    public Employee(int id, String name, String position) {
        this.id = id;
        this.name = name;
        this.position = position;
    }

    @Override
    public int compareTo(Employee other) {
        return Integer.compare(this.id, other.id);
    }
    
    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", name='" + name + '\'' + ", position='" + position + '\'' + '}';
    }
}