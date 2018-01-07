package small_it.shoeshop.lists;


/**
 * Class for the article List
 */
public class ItemFullDescription {


    private String itemName;
    private double normPrice;
    private double reducedPrice;
    private int artNumber;
    private int imageResource;
    private int[] smallImageResource;
    private double[] size;
    private float rating;
    private String artDescription;
    private String artExtDescription;


    /**
     * Constructor which setup all the Variables for the big View
     *
     * @param itemName            Headline and the Item Name
     * @param normPrice           The regular Price
     * @param reducedPrice        The reduced Price
     * @param artNumber           The Article Number of the Product
     * @param imageResource      The Main Image
     * @param smallImageResource The 4 Thumbnails
     * @param rating              The rating of the Shoe
     * @param artDescription      A Small description of the Shoe
     * @param artExtDescription   An Enumeration Description of the Shoe
     * @param size                The availible Sizes of the Shoe
     */
    public ItemFullDescription(String itemName, double normPrice, double reducedPrice, int artNumber,
                               int imageResource, int[] smallImageResource, float rating, String artDescription,
                               String artExtDescription, double[] size) {

        this.itemName = itemName;
        this.artDescription = artDescription;
        this.artExtDescription = artExtDescription;
        this.rating = rating;
        this.size = size;
        this.normPrice = normPrice;
        this.reducedPrice = reducedPrice;
        this.artNumber = artNumber;
        this.imageResource = imageResource;
        this.smallImageResource = smallImageResource.clone();
    }
    //

    /******
     *
     *  The getter's for all the variables in this Class
     *
     *******/
    //
    public double getNormPrice() {
        return normPrice;
    }

    public double getReducedPrice() {
        return reducedPrice;
    }

    public int getArtNumber() {
        return artNumber;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getItemName() {
        return itemName;
    }

    public int[] getSmallImageResource() {
        return smallImageResource;
    }

    public double[] getSize() {
        return size;
    }

    public float getRating() {
        return rating;
    }

    public String getArtDescription() {
        return artDescription;
    }

    public String getArtExtDescription() {
        return artExtDescription;
    }
}
