package small_it.shoeshop.sales;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import small_it.shoeshop.MainActivity;
import small_it.shoeshop.R;
import small_it.shoeshop.adapter.SmallCards;
import small_it.shoeshop.lists.ItemFullDescription;
import small_it.shoeshop.lists.ItemSmallDescription;

/**
 * Class to display all the shoes for the children ;-)
 *
 * Later all of the three Classes ("Ladies", "Gentleman" and "Child") could merged together
 * ! Hardcoded Data !
 * As long as this app is in the Mockup status, most of the Data is Hardcoded
 * ! Hardcoded Data !
 */
public class Childs extends AppCompatActivity implements SmallCards.ClickListener, View.OnClickListener{

    private List<ItemSmallDescription> smallCards;
    private List<ItemFullDescription> fullCards;
    private int posi = 0;

    // Text of ShoeDescription
    TextView txtNewPrice, txtOldPrice, txtLDesc, txtHead, txtDes, txtSavings, txtArtNm;

    // All Sizes to deactivate the non available sizes
    CardView sizeOne, sizeTwo, sizeThree, sizeFour, sizeFive, sizeSix, sizeSeven, sizeEight, sizeNine, sizeTen;
    CardView[] cv;
    TextView txtSizeOne, txtSizeTwo, txtSizeThree, txtSizeFour, txtSizeFive, txtSizeSix, txtSizeSeven, txtSizeEight, txtSizeNine, txtSizeTen;
    TextView[] tv;

    // Images
    ImageView smallImageOne, smallImageTwo, smallImageFour, smallImageThree, mainImage;
    ImageView[] vws;
    Dialog dialog;

    // Buttons and Rating
    Button btnService, btnDamen, btnHerren, btnKinder;
    RatingBar rBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.shop_scene);

        RecyclerView cards = (RecyclerView) findViewById(R.id.rvCards);
        SmallCards adapterCards = new SmallCards(this, getData());
        adapterCards.setClickListener(this);
        cards.setAdapter(adapterCards);

        LinearLayoutManager llm = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        cards.setLayoutManager(llm);

        // Setup the GUI for the App
        initializeViews();
        setupViews();

        // Setup the Data for the App
        getFullData();

        // Set the starting point
        mainImage.setTag(fullCards.get(0).getImageResource());
        changeItem(fullCards, 0);
    }


    /**
     * Method to initialize the Views in the Activity
     */
    private void initializeViews(){
        // Shoe Price
        txtNewPrice = (TextView) findViewById(R.id.txtNewPriceFull);
        txtOldPrice = (TextView) findViewById(R.id.txtOldPriceFull);
        txtSavings  = (TextView) findViewById(R.id.txtSavings);

        // Shoe Description
        txtDes  = (TextView) findViewById(R.id.txtDescription);
        txtLDesc = (TextView) findViewById(R.id.txtListDescription);
        txtHead  = (TextView) findViewById(R.id.txtHeadline);
        txtArtNm = (TextView) findViewById(R.id.txtArtNmb);

        // Shoe Sizes
        sizeOne = (CardView) findViewById(R.id.cOne);
        txtSizeOne = (TextView) findViewById(R.id.txtSOne);
        sizeTwo = (CardView) findViewById(R.id.cTwo);
        txtSizeTwo = (TextView) findViewById(R.id.txtSTwo);
        sizeThree = (CardView) findViewById(R.id.cThree);
        txtSizeThree = (TextView) findViewById(R.id.txtSThree);
        sizeFour = (CardView) findViewById(R.id.cFour);
        txtSizeFour = (TextView) findViewById(R.id.txtSFour);
        sizeFive = (CardView) findViewById(R.id.cFive);
        txtSizeFive = (TextView) findViewById(R.id.txtSFive);
        sizeSix = (CardView) findViewById(R.id.cSix);
        txtSizeSix = (TextView) findViewById(R.id.txtSSix);
        sizeSeven = (CardView) findViewById(R.id.cSeven);
        txtSizeSeven = (TextView) findViewById(R.id.txtSSeven);
        sizeEight = (CardView) findViewById(R.id.cEight);
        txtSizeEight = (TextView) findViewById(R.id.txtSEight);
        sizeNine = (CardView) findViewById(R.id.cNine);
        txtSizeNine = (TextView) findViewById(R.id.txtSNine);
        sizeTen = (CardView) findViewById(R.id.cTen);
        txtSizeTen = (TextView) findViewById(R.id.txtSTen);

        cv = new CardView[]{sizeOne, sizeTwo, sizeThree, sizeFour, sizeFive, sizeSix, sizeSeven, sizeEight, sizeNine, sizeTen};
        tv = new TextView[]{txtSizeOne, txtSizeTwo, txtSizeThree, txtSizeFour, txtSizeFive, txtSizeSix, txtSizeSeven, txtSizeEight, txtSizeNine, txtSizeTen};

        // Images
        smallImageOne = (ImageView) findViewById(R.id.imgSmallOne);
        smallImageTwo = (ImageView) findViewById(R.id.imgSmallTwo);
        smallImageThree = (ImageView) findViewById(R.id.imgSmallThree);
        smallImageFour = (ImageView) findViewById(R.id.imgSmallFour);
        mainImage = (ImageView) findViewById(R.id.imgMainShoe);
        vws = new ImageView[]{smallImageOne, smallImageTwo, smallImageThree, smallImageFour};

        // Service
        btnService = (Button) findViewById(R.id.btnService);
        btnDamen = (Button) findViewById(R.id.btnDamen);
        btnHerren = (Button) findViewById(R.id.btnHerren);
        btnKinder = (Button) findViewById(R.id.btnKinder);
        rBar = (RatingBar) findViewById(R.id.rBar);
    }

    /**
     * Method to change the Style of the Views and give them abilities (Clickable e.g.)
     */
    private void setupViews(){
        txtOldPrice.setPaintFlags(txtOldPrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        txtNewPrice.setTextColor(ContextCompat.getColor(this, R.color.colorAccent));

        btnService.setOnClickListener(this);
        btnDamen.setOnClickListener(this);
        btnHerren.setOnClickListener(this);
        btnKinder.setOnClickListener(this);
        mainImage.setOnClickListener(this);
        smallImageOne.setOnClickListener(this);
        smallImageTwo.setOnClickListener(this);
        smallImageThree.setOnClickListener(this);
        smallImageFour.setOnClickListener(this);
    }

    /**
     * Method to change the size of the thumbnail Images according to the screen size
     * @param hasFocus Focus of the screen
     */
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        smallImageOne.setLayoutParams(new LinearLayout.LayoutParams(smallImageOne.getWidth(), smallImageOne.getWidth()));
        smallImageTwo.setLayoutParams(new LinearLayout.LayoutParams(smallImageTwo.getWidth(), smallImageTwo.getWidth()));
        smallImageThree.setLayoutParams(new LinearLayout.LayoutParams(smallImageThree.getWidth(), smallImageThree.getWidth()));
        smallImageFour.setLayoutParams(new LinearLayout.LayoutParams(smallImageFour.getWidth(), smallImageFour.getWidth()));
    }

    /**
     * Method to setup the Data into the for the List
     * ! Hardcoded !
     * @return List of the Data
     */
    private List<ItemSmallDescription> getData() {
        smallCards = new ArrayList<>();
        // Korrekte Daten
        smallCards.add(new ItemSmallDescription(getResources().getString(R.string.shoeZeroFemaleName),
                Double.parseDouble(getResources().getString(R.string.shoeZeroFemaleNormPrice)),
                Double.parseDouble(getResources().getString(R.string.shoeZeroFemaleReducedPrice)), R.drawable.shoe_zero_main));
        smallCards.add(new ItemSmallDescription(getResources().getString(R.string.shoeOneFemaleName),
                Double.parseDouble(getResources().getString(R.string.shoeOneFemaleNormPrice)),
                Double.parseDouble(getResources().getString(R.string.shoeOneFemaleReducedPrice)), R.drawable.shoe_one_main));
        smallCards.add(new ItemSmallDescription(getResources().getString(R.string.shoeTwoFemaleName),
                Double.parseDouble(getResources().getString(R.string.shoeTwoFemaleNormPrice)),
                Double.parseDouble(getResources().getString(R.string.shoeTwoFemaleReducedPrice)), R.drawable.shoe_two_main));
        smallCards.add(new ItemSmallDescription(getResources().getString(R.string.shoeThreeFemaleName),
                Double.parseDouble(getResources().getString(R.string.shoeThreeFemaleNormPrice)),
                Double.parseDouble(getResources().getString(R.string.shoeThreeFemaleReducedPrice)), R.drawable.shoe_three_main));
        smallCards.add(new ItemSmallDescription(getResources().getString(R.string.shoeFourFemaleName),
                Double.parseDouble(getResources().getString(R.string.shoeFourFemaleNormPrice)),
                Double.parseDouble(getResources().getString(R.string.shoeFourFemaleReducedPrice)), R.drawable.shoe_four_main));
        smallCards.add(new ItemSmallDescription(getResources().getString(R.string.shoeFiveFemaleName),
                Double.parseDouble(getResources().getString(R.string.shoeFiveFemaleNormPrice)),
                Double.parseDouble(getResources().getString(R.string.shoeFiveFemaleReducedPrice)), R.drawable.shoe_five_main));
        smallCards.add(new ItemSmallDescription(getResources().getString(R.string.shoeSixFemaleName),
                Double.parseDouble(getResources().getString(R.string.shoeSixFemaleNormPrice)),
                Double.parseDouble(getResources().getString(R.string.shoeSixFemaleReducedPrice)), R.drawable.shoe_six_main));
        smallCards.add(new ItemSmallDescription(getResources().getString(R.string.shoeSevenFemaleName),
                Double.parseDouble(getResources().getString(R.string.shoeSevenFemaleNormPrice)),
                Double.parseDouble(getResources().getString(R.string.shoeSevenFemaleReducedPrice)), R.drawable.shoe_seven_main));
        smallCards.add(new ItemSmallDescription(getResources().getString(R.string.shoeEightFemaleName),
                Double.parseDouble(getResources().getString(R.string.shoeEightFemaleNormPrice)),
                Double.parseDouble(getResources().getString(R.string.shoeEightFemaleReducedPrice)), R.drawable.shoe_eight_main));
        smallCards.add(new ItemSmallDescription(getResources().getString(R.string.shoeNineFemaleName),
                Double.parseDouble(getResources().getString(R.string.shoeNineFemaleNormPrice)),
                Double.parseDouble(getResources().getString(R.string.shoeNineFemaleReducedPrice)), R.drawable.shoe_nine_main));

        return smallCards;
    }

    /**
     * Method to handle the Clicks of each Shopping Card
     * @param view view of the Card
     * @param position position of the Card
     */
    @Override
    public void itemClicked(View view, int position) {
        if(view.getId() == R.id.idSmallImage){
            posi = position;
            changeItem(fullCards, position);
        }
    }

    /**
     * Method to handle the click of each Button / ImageButton
     * @param view View of the Button
     */
    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnService || view.getId() == R.id.btnHerren || view.getId() == R.id.btnKinder){
            Toast.makeText(this, getString(R.string.comingSoon), Toast.LENGTH_SHORT).show();
        }
        // Links
        if (view.getId() == R.id.btnDamen){
            startActivity(new Intent(this, MainActivity.class));
        }

        // Images
        if (view.getId() == R.id.imgSmallOne){
            mainImage.setImageResource(getDrawableId(smallImageOne));
            mainImage.setTag(getDrawableId(smallImageOne));
        }
        if (view.getId() == R.id.imgSmallTwo){
            mainImage.setImageResource(getDrawableId(smallImageTwo));
            mainImage.setTag(getDrawableId(smallImageTwo));
        }

        if (view.getId() == R.id.imgSmallThree){
            mainImage.setImageResource(getDrawableId(smallImageThree));
            mainImage.setTag(getDrawableId(smallImageThree));
        }

        if (view.getId() == R.id.imgSmallFour){
            mainImage.setImageResource(getDrawableId(smallImageFour));
            mainImage.setTag(getDrawableId(smallImageFour));
        }
        if(view.getId() == R.id.imgMainShoe){
            showPopUp(getDrawableId(mainImage));
        }
    }

    /**
     * Method to display a Large Version of the Image
     */
    private void showPopUp(int imageResource){
        dialog = new Dialog(this);
        dialog.setContentView(R.layout.popup);

        // set the custom dialog components - text, image and button
        ImageButton close = (ImageButton) dialog.findViewById(R.id.btnClose);
        ImageView popUp = (ImageView) dialog.findViewById(R.id.popupImage);
        popUp.setImageResource(imageResource);

        // Close Button
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        dialog.show();
    }

    /**
     * Method to get the ID of an Image
     * @param iv searched Image View
     * @return integer of the resource ID
     */
    private int getDrawableId(ImageView iv) {
        return (Integer) iv.getTag();
    }

    /**
     * Method to initialize the Data for the detailed Shoe Card
     *
     * ! Hardcoded !
     * Change the Method later to a connected Database.
     * ! Hardcoded !
     *
     * @return a List of the Items which displays the full data
     */
    public List<ItemFullDescription> getFullData(){
        fullCards = new ArrayList<>();

        int[] shoeOne = {smallCards.get(0).getPicResource(), R.drawable.shoe_zero_small_one, R.drawable.shoe_zero_small_two, R.drawable.shoe_zero_small_three};
        double[] sizes = {4.5,5,5.5,6.5,7,7.5};
        fullCards.add(new ItemFullDescription(
                smallCards.get(0).getShoeName(),
                smallCards.get(0).getOldPrice(),
                smallCards.get(0).getNewPrice(),
                Integer.parseInt(getString(R.string.shoeZeroFemaleArtNumber)),
                smallCards.get(0).getPicResource(),
                shoeOne,
                3.4f,
                getString(R.string.shoeZeroFemaleDescriptionLong),
                getString(R.string.shoeZeroFemaleList),
                sizes
        ));
        shoeOne = new int[]{smallCards.get(1).getPicResource(), R.drawable.shoe_one_small_one, R.drawable.shoe_one_small_two};
        sizes = new double[]{36,37,38,39,40,41};
        fullCards.add(new ItemFullDescription(
                smallCards.get(1).getShoeName(),
                smallCards.get(1).getOldPrice(),
                smallCards.get(1).getNewPrice(),
                Integer.parseInt(getString(R.string.shoeOneFemaleArtNumber)),
                smallCards.get(1).getPicResource(),
                shoeOne,
                3.4f,
                getString(R.string.shoeOneFemaleDescriptionLong),
                getString(R.string.shoeOneFemaleList),
                sizes
        ));
        shoeOne = new int[]{smallCards.get(2).getPicResource(), R.drawable.shoe_two_small_one, R.drawable.shoe_two_small_two, R.drawable.shoe_two_small_three};
        sizes = new double[]{37.5,38,38.5,40};
        fullCards.add(new ItemFullDescription(
                smallCards.get(2).getShoeName(),
                smallCards.get(2).getOldPrice(),
                smallCards.get(2).getNewPrice(),
                Integer.parseInt(getString(R.string.shoeTwoFemaleArtNumber)),
                smallCards.get(2).getPicResource(),
                shoeOne,
                4.3f,
                getString(R.string.shoeTwoFemaleDescriptionLong),
                getString(R.string.shoeTwoFemaleList),
                sizes
        ));
        shoeOne = new int[]{smallCards.get(3).getPicResource(), R.drawable.shoe_three_small_one, R.drawable.shoe_three_small_two, R.drawable.shoe_three_small_three};
        sizes = new double[]{37,38,39.5,40,41,42};
        fullCards.add(new ItemFullDescription(
                smallCards.get(3).getShoeName(),
                smallCards.get(3).getOldPrice(),
                smallCards.get(3).getNewPrice(),
                Integer.parseInt(getString(R.string.shoeThreeFemaleArtNumber)),
                smallCards.get(3).getPicResource(),
                shoeOne,
                5f,
                getString(R.string.shoeThreeFemaleDescriptionLong),
                getString(R.string.shoeThreeFemaleList),
                sizes
        ));
        shoeOne = new int[]{smallCards.get(4).getPicResource(), R.drawable.shoe_four_small_one, R.drawable.shoe_four_small_two, R.drawable.shoe_four_small_three};
        sizes = new double[]{40.5,41,42,42.5,43};
        fullCards.add(new ItemFullDescription(
                smallCards.get(4).getShoeName(),
                smallCards.get(4).getOldPrice(),
                smallCards.get(4).getNewPrice(),
                Integer.parseInt(getString(R.string.shoeFourFemaleArtNumber)),
                smallCards.get(4).getPicResource(),
                shoeOne,
                4.7f,
                getString(R.string.shoeFourFemaleDescriptionLong),
                getString(R.string.shoeFourFemaleList),
                sizes
        ));
        shoeOne = new int[]{smallCards.get(5).getPicResource(), R.drawable.shoe_five_small_one, R.drawable.shoe_five_small_two};
        sizes = new double[]{3.5,4,4.5,5,5.5,6,6.5,7,7.5};
        fullCards.add(new ItemFullDescription(
                smallCards.get(5).getShoeName(),
                smallCards.get(5).getOldPrice(),
                smallCards.get(5).getNewPrice(),
                Integer.parseInt(getString(R.string.shoeFiveFemaleArtNumber)),
                smallCards.get(5).getPicResource(),
                shoeOne,
                3.8f,
                getString(R.string.shoeFiveFemaleDescriptionLong),
                getString(R.string.shoeFiveFemaleList),
                sizes
        ));
        shoeOne = new int[]{smallCards.get(6).getPicResource(), R.drawable.shoe_six_small_one, R.drawable.shoe_six_small_two, R.drawable.shoe_six_small_three};
        sizes = new double[]{36,37,38,39,40,41};
        fullCards.add(new ItemFullDescription(
                smallCards.get(6).getShoeName(),
                smallCards.get(6).getOldPrice(),
                smallCards.get(6).getNewPrice(),
                Integer.parseInt(getString(R.string.shoeSixFemaleArtNumber)),
                smallCards.get(6).getPicResource(),
                shoeOne,
                3.8f,
                getString(R.string.shoeSixFemaleDescriptionLong),
                getString(R.string.shoeSixFemaleList),
                sizes
        ));
        shoeOne = new int[]{smallCards.get(7).getPicResource(), R.drawable.shoe_seven_small_one, R.drawable.shoe_seven_small_two, R.drawable.shoe_seven_small_three};
        sizes = new double[]{36,37,37.5,38,38.5,39,40,40.5,41,42};
        fullCards.add(new ItemFullDescription(
                smallCards.get(7).getShoeName(),
                smallCards.get(7).getOldPrice(),
                smallCards.get(7).getNewPrice(),
                Integer.parseInt(getString(R.string.shoeSevenFemaleArtNumber)),
                smallCards.get(7).getPicResource(),
                shoeOne,
                4.3f,
                getString(R.string.shoeSevenFemaleDescriptionLong),
                getString(R.string.shoeSevenFemaleList),
                sizes
        ));
        shoeOne = new int[]{smallCards.get(8).getPicResource(), R.drawable.shoe_eight_small_one, R.drawable.shoe_eight_small_two, R.drawable.shoe_eight_small_three};
        sizes = new double[]{37,38,40};
        fullCards.add(new ItemFullDescription(
                smallCards.get(8).getShoeName(),
                smallCards.get(8).getOldPrice(),
                smallCards.get(8).getNewPrice(),
                Integer.parseInt(getString(R.string.shoeEightFemaleArtNumber)),
                smallCards.get(8).getPicResource(),
                shoeOne,
                4.3f,
                getString(R.string.shoeEightFemaleDescriptionLong),
                getString(R.string.shoeEightFemaleList),
                sizes
        ));
        shoeOne = new int[]{smallCards.get(9).getPicResource(), R.drawable.shoe_nine_small_one, R.drawable.shoe_nine_small_two, R.drawable.shoe_nine_small_three};
        sizes = new double[]{36,37,38,39,40,41,42};
        fullCards.add(new ItemFullDescription(
                smallCards.get(9).getShoeName(),
                smallCards.get(9).getOldPrice(),
                smallCards.get(9).getNewPrice(),
                Integer.parseInt(getString(R.string.shoeNineFemaleArtNumber)),
                smallCards.get(9).getPicResource(),
                shoeOne,
                5f,
                getString(R.string.shoeNineFemaleDescriptionLong),
                getString(R.string.shoeNineFemaleList),
                sizes
        ));
        return fullCards;
    }

    /**
     * Method to change the Data
     */
    private void changeItem(List<ItemFullDescription> full, int posi){
        // Images
        mainImage.setImageResource(full.get(posi).getImageResource());
        mainImage.setTag(full.get(posi).getImageResource());
        int length = full.get(posi).getSmallImageResource().length;
        for (int i = 0; i < length; i++){
            vws[i].setImageResource(full.get(posi).getSmallImageResource()[i]);
            vws[i].setTag(full.get(posi).getSmallImageResource()[i]);
        }
        for (int j = length; j < 4; j++){
            vws[j].setVisibility(View.GONE);
        }

        // Description
        txtHead.setText(full.get(posi).getItemName());
        txtDes.setText(full.get(posi).getArtDescription());
        txtLDesc.setText(full.get(posi).getArtExtDescription());
        txtArtNm.setText(getString(R.string.artNum)+ " " + full.get(posi).getArtNumber());

        // Price
        //double percent = 100 - (full.get(posi).getReducedPrice()/full.get(posi).getNormPrice() * 100);
        //BigDecimal orm = new BigDecimal(percent);

        txtOldPrice.setText(DecimalFormat.getCurrencyInstance(Locale.GERMANY).format(full.get(posi).getNormPrice()));
        txtNewPrice.setText(DecimalFormat.getCurrencyInstance(Locale.GERMANY).format(full.get(posi).getReducedPrice()));
        txtSavings.setText(getString(R.string.savings) + " " + DecimalFormat.getCurrencyInstance(Locale.GERMANY).format(full.get(posi).getNormPrice() - full.get(posi).getReducedPrice()));
        rBar.setRating(full.get(posi).getRating());

        // Sizes
        makeAllVisible();
        // Set the CardView for the sizes
        for (int k = full.get(posi).getSize().length; k < 10; k++){
            cv[k].setVisibility(View.INVISIBLE);
        }

        // Set the sizes
        for (int y = 0; y < full.get(posi).getSize().length; y++){
            tv[y].setText(full.get(posi).getSize()[y] + "");
        }
    }

    /**
     * Method to make all the sizes available
     */
    private void makeAllVisible() {
        sizeOne.setVisibility(View.VISIBLE);
        sizeTwo.setVisibility(View.VISIBLE);
        sizeThree.setVisibility(View.VISIBLE);
        sizeFour.setVisibility(View.VISIBLE);
        sizeFive.setVisibility(View.VISIBLE);
        sizeSix.setVisibility(View.VISIBLE);
        sizeSeven.setVisibility(View.VISIBLE);
        sizeEight.setVisibility(View.VISIBLE);
        sizeNine.setVisibility(View.VISIBLE);
        sizeTen.setVisibility(View.VISIBLE);
    }

}
