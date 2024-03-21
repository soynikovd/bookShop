package BookShop.models;

public class Order {
    private int id;
    private int employeeId;
    private int customerId;

    private int[] books;

    public void setId(int id) {
        this.id = id;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setBooks(int[] books) {
        this.books = books;
    }

    public int getId() {
        return id;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int[] getBooks() {
        return books;
    }

    public Order(int id, int employeeId, int customerId, int[] books) {
        this.id = id;
        this.employeeId = employeeId;
        this.customerId = customerId;
        this.books = books;
    }
}
