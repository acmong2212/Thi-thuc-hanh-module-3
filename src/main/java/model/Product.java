package model;


public class Product {
    private int idProduct;
    private String nameProduct;
    private double price;
    private int quantity;
    private String color;
    private String description;
    private String nameCategory;
    private int idCategory;

    public Product() {
    }

    public Product(int idProduct, String nameProduct, double price, int quantity, String color, String description, int idCategory) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.description = description;
        this.idCategory = idCategory;
    }

    public Product(int idProduct, String nameProduct, double price, int quantity, String color, String description, String nameCategory, int idCategory) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.description = description;
        this.nameCategory = nameCategory;
        this.idCategory = idCategory;
    }

    public Product(String name, double price, int quantity, String color, String description, int idCategory) {
        this.nameProduct = name;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.description = description;
        this.idCategory = idCategory;
    }


    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }
}
