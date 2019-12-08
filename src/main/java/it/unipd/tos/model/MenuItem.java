//Daniel James Tronca 1168535
package it.unipd.tos.model;
public class MenuItem {
public enum ItemType {
PANINO, FRITTO, BEVANDA
}
ItemType type=ItemType.PANINO;
String name;
double price=10;
public MenuItem() {
}
public double getPrice() {
return this.price;
}
public String getType() {
return type.name().toString();
}
public void setPrice(double x) {
price=x;
}
public void setType(ItemType x) {
this.type=x;
}
}