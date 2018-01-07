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
import small_it.shoeshop.lists.LadiesList;

/**
 * Class to display all the shoes for the ladies ;-)
 *
 * Later all of the three Classes ("Ladies", "Gentleman" and "Child") could merged together
 *
 * ! Hardcoded Data!
 * As long as this app is in the Mockup status, most of the Data is Hardcoded
 * ! Hardcoded Data !
 */
public class Ladies extends AppCompatActivity implements SmallCards.ClickListener, View.OnClickListener{

    private List<ItemFullDescription> fullCards;

    // Text of ShoeDescription
    TextView txtNewPrice, txtOldPrice, txtLDesc, txtHead, txtDes, txtSavings, txtArtNm;

    // All Sizes to deactivate the non available sizes
    CardView sizeOne, sizeTwo, sizeThree, sizeFour, sizeFive, sizeSix, sizeSeven, sizeEight, sizeNine, sizeTen;
    CardView[] cv;
    TextView txtSizeOne, txtSizeTwo, txtSizeThree, txtSizeFour, txtSizeFive, txtSizeSix, txtSizeSeven, txtSizeEight, txtSizeNine, txtSizeTen;
    TextView[] tv;

    // Images
    ImageView smallImageOne, smallImageTwo, smallImageFour, smallImageThree, mainImage;
    ImageButton flagGerman, flagUS;
    ImageView[] vws;
    Dialog dialog;

    // Buttons and Rating
    Button btnService, btnDamen, btnHerren, btnKinder;
    RatingBar rBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.shop_scene);

        // Prepare the data to display
        List<ItemSmallDescription> smallCards = new ArrayList<>();
        fullCards = new ArrayList<>();
        smallCards.addAll(new LadiesList().getSmallData(this));
        fullCards.addAll(new LadiesList().getFullData(this, smallCards));

        RecyclerView cards = (RecyclerView) findViewById(R.id.rvCards);
        SmallCards adapterCards = new SmallCards(this, smallCards);
        adapterCards.setClickListener(this);
        cards.setAdapter(adapterCards);

        LinearLayoutManager llm = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        cards.setLayoutManager(llm);

        // Setup the GUI for the App
        initializeViews();
        setupViews();

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

        // Language
        flagGerman = (ImageButton) findViewById(R.id.btnGerman);
        flagUS = (ImageButton) findViewById(R.id.btnUK);
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

        flagUS.setOnClickListener(this);
        flagGerman.setOnClickListener(this);
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
     * Method to handle the Clicks of each Shopping Card
     * @param view view of the Card
     * @param position position of the Card
     */
    @Override
    public void itemClicked(View view, int position) {
        if(view.getId() == R.id.idSmallImage){
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
            Toast.makeText(this, "Coming Soon", Toast.LENGTH_SHORT).show();
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
        if(view.getId() == R.id.btnGerman){
           Toast.makeText(this, "Coming soon", Toast.LENGTH_LONG).show();
        }
        if(view.getId() == R.id.btnUK){
            Toast.makeText(this, "Coming soon", Toast.LENGTH_LONG).show();
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
        if(dialog.getWindow() != null) {
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
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
            String toPlace = full.get(posi).getSize()[y] + "";
            tv[y].setText(toPlace);
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
