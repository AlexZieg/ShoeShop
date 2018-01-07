package small_it.shoeshop.lists;


/**
 * Class for the structure of the small CardViews
 */
public class ItemSmallDescription {

    private String shoeName;
    private double oldPrice;
    private double newPrice;
    private int picResource;

    /**
     * Constructor for the ListView
     * @param shoeName Headline for the ShoeName
     * @param oldPrice old Price of the Shoe (not the reduced one)
     * @param newPrice new Price of the Shoe
     */
    public ItemSmallDescription(String shoeName, double oldPrice, double newPrice, int picResource){
        this.setShoeName(shoeName);
        this.setOldPrice(oldPrice);
        this.setNewPrice(newPrice);
        this.setPicResource(picResource);
    }

    /**
     * Getter and Setter Methods
     */
    public String getShoeName() {
        return shoeName;
    }

    private void setShoeName(String shoeName) {
        this.shoeName = shoeName;
    }

    public double getOldPrice() {
        return oldPrice;
    }

    private void setOldPrice(double oldPrice) {
        this.oldPrice = oldPrice;
    }

    public double getNewPrice() {
        return newPrice;
    }

    private void setNewPrice(double newPrice) {
        this.newPrice = newPrice;
    }

    public int getPicResource() {
        return picResource;
    }

    private void setPicResource(int picResource) {
        this.picResource = picResource;
    }
}
