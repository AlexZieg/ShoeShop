package small_it.shoeshop.lists;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import small_it.shoeshop.R;

/**
 * Class to setup the List for the Ladies Shoes
 * ! Hardcoded Data !
 * As long as this app is in the Mockup status, most of the Data is Hardcoded
 * ! Hardcoded Data !
 */
public class LadiesList {

    /**
     * Method to setup the Data into the for the List
     * ! Hardcoded Data !
     * @return List of the Data
     */
    public List<ItemSmallDescription> getSmallData(Context ctx){
        List<ItemSmallDescription> smallCards = new ArrayList<>();

        smallCards.add(new ItemSmallDescription(ctx.getString(R.string.shoeZeroFemaleName),
                Double.parseDouble(ctx.getString(R.string.shoeZeroFemaleNormPrice)),
                Double.parseDouble(ctx.getString(R.string.shoeZeroFemaleReducedPrice)), R.drawable.shoe_zero_main));
        smallCards.add(new ItemSmallDescription(ctx.getString(R.string.shoeOneFemaleName),
                Double.parseDouble(ctx.getString(R.string.shoeOneFemaleNormPrice)),
                Double.parseDouble(ctx.getString(R.string.shoeOneFemaleReducedPrice)), R.drawable.shoe_one_main));
        smallCards.add(new ItemSmallDescription(ctx.getString(R.string.shoeTwoFemaleName),
                Double.parseDouble(ctx.getString(R.string.shoeTwoFemaleNormPrice)),
                Double.parseDouble(ctx.getString(R.string.shoeTwoFemaleReducedPrice)), R.drawable.shoe_two_main));
        smallCards.add(new ItemSmallDescription(ctx.getString(R.string.shoeThreeFemaleName),
                Double.parseDouble(ctx.getString(R.string.shoeThreeFemaleNormPrice)),
                Double.parseDouble(ctx.getString(R.string.shoeThreeFemaleReducedPrice)), R.drawable.shoe_three_main));
        smallCards.add(new ItemSmallDescription(ctx.getString(R.string.shoeFourFemaleName),
                Double.parseDouble(ctx.getString(R.string.shoeFourFemaleNormPrice)),
                Double.parseDouble(ctx.getString(R.string.shoeFourFemaleReducedPrice)), R.drawable.shoe_four_main));
        smallCards.add(new ItemSmallDescription(ctx.getString(R.string.shoeFiveFemaleName),
                Double.parseDouble(ctx.getString(R.string.shoeFiveFemaleNormPrice)),
                Double.parseDouble(ctx.getString(R.string.shoeFiveFemaleReducedPrice)), R.drawable.shoe_five_main));
        smallCards.add(new ItemSmallDescription(ctx.getString(R.string.shoeSixFemaleName),
                Double.parseDouble(ctx.getString(R.string.shoeSixFemaleNormPrice)),
                Double.parseDouble(ctx.getString(R.string.shoeSixFemaleReducedPrice)), R.drawable.shoe_six_main));
        smallCards.add(new ItemSmallDescription(ctx.getString(R.string.shoeSevenFemaleName),
                Double.parseDouble(ctx.getString(R.string.shoeSevenFemaleNormPrice)),
                Double.parseDouble(ctx.getString(R.string.shoeSevenFemaleReducedPrice)), R.drawable.shoe_seven_main));
        smallCards.add(new ItemSmallDescription(ctx.getString(R.string.shoeEightFemaleName),
                Double.parseDouble(ctx.getString(R.string.shoeEightFemaleNormPrice)),
                Double.parseDouble(ctx.getString(R.string.shoeEightFemaleReducedPrice)), R.drawable.shoe_eight_main));
        smallCards.add(new ItemSmallDescription(ctx.getString(R.string.shoeNineFemaleName),
                Double.parseDouble(ctx.getString(R.string.shoeNineFemaleNormPrice)),
                Double.parseDouble(ctx.getString(R.string.shoeNineFemaleReducedPrice)), R.drawable.shoe_nine_main));
        
        return smallCards;
    }

    /**
     * Method to setup the Full Data for the Items
     * @param ctx the Actual Context
     * @param smallCards List of the small Cards
     * @return full List Description
     */
    public List<ItemFullDescription> getFullData(Context ctx, List<ItemSmallDescription> smallCards){
        List <ItemFullDescription> fullCards = new ArrayList<>();

        int[] shoeOne = {smallCards.get(0).getPicResource(), R.drawable.shoe_zero_small_one, R.drawable.shoe_zero_small_two, R.drawable.shoe_zero_small_three};
        double[] sizes = {4.5,5,5.5,6.5,7,7.5};
        fullCards.add(new ItemFullDescription(
                smallCards.get(0).getShoeName(),
                smallCards.get(0).getOldPrice(),
                smallCards.get(0).getNewPrice(),
                Integer.parseInt(ctx.getString(R.string.shoeZeroFemaleArtNumber)),
                smallCards.get(0).getPicResource(),
                shoeOne,
                3.4f,
                ctx.getString(R.string.shoeZeroFemaleDescriptionLong),
                ctx.getString(R.string.shoeZeroFemaleList),
                sizes
        ));
        shoeOne = new int[]{smallCards.get(1).getPicResource(), R.drawable.shoe_one_small_one, R.drawable.shoe_one_small_two};
        sizes = new double[]{36,37,38,39,40,41};
        fullCards.add(new ItemFullDescription(
                smallCards.get(1).getShoeName(),
                smallCards.get(1).getOldPrice(),
                smallCards.get(1).getNewPrice(),
                Integer.parseInt(ctx.getString(R.string.shoeOneFemaleArtNumber)),
                smallCards.get(1).getPicResource(),
                shoeOne,
                3.4f,
                ctx.getString(R.string.shoeOneFemaleDescriptionLong),
                ctx.getString(R.string.shoeOneFemaleList),
                sizes
        ));
        shoeOne = new int[]{smallCards.get(2).getPicResource(), R.drawable.shoe_two_small_one, R.drawable.shoe_two_small_two, R.drawable.shoe_two_small_three};
        sizes = new double[]{37.5,38,38.5,40};
        fullCards.add(new ItemFullDescription(
                smallCards.get(2).getShoeName(),
                smallCards.get(2).getOldPrice(),
                smallCards.get(2).getNewPrice(),
                Integer.parseInt(ctx.getString(R.string.shoeTwoFemaleArtNumber)),
                smallCards.get(2).getPicResource(),
                shoeOne,
                4.3f,
                ctx.getString(R.string.shoeTwoFemaleDescriptionLong),
                ctx.getString(R.string.shoeTwoFemaleList),
                sizes
        ));
        shoeOne = new int[]{smallCards.get(3).getPicResource(), R.drawable.shoe_three_small_one, R.drawable.shoe_three_small_two, R.drawable.shoe_three_small_three};
        sizes = new double[]{37,38,39.5,40,41,42};
        fullCards.add(new ItemFullDescription(
                smallCards.get(3).getShoeName(),
                smallCards.get(3).getOldPrice(),
                smallCards.get(3).getNewPrice(),
                Integer.parseInt(ctx.getString(R.string.shoeThreeFemaleArtNumber)),
                smallCards.get(3).getPicResource(),
                shoeOne,
                5f,
                ctx.getString(R.string.shoeThreeFemaleDescriptionLong),
                ctx.getString(R.string.shoeThreeFemaleList),
                sizes
        ));
        shoeOne = new int[]{smallCards.get(4).getPicResource(), R.drawable.shoe_four_small_one, R.drawable.shoe_four_small_two, R.drawable.shoe_four_small_three};
        sizes = new double[]{40.5,41,42,42.5,43};
        fullCards.add(new ItemFullDescription(
                smallCards.get(4).getShoeName(),
                smallCards.get(4).getOldPrice(),
                smallCards.get(4).getNewPrice(),
                Integer.parseInt(ctx.getString(R.string.shoeFourFemaleArtNumber)),
                smallCards.get(4).getPicResource(),
                shoeOne,
                4.7f,
                ctx.getString(R.string.shoeFourFemaleDescriptionLong),
                ctx.getString(R.string.shoeFourFemaleList),
                sizes
        ));
        shoeOne = new int[]{smallCards.get(5).getPicResource(), R.drawable.shoe_five_small_one, R.drawable.shoe_five_small_two};
        sizes = new double[]{3.5,4,4.5,5,5.5,6,6.5,7,7.5};
        fullCards.add(new ItemFullDescription(
                smallCards.get(5).getShoeName(),
                smallCards.get(5).getOldPrice(),
                smallCards.get(5).getNewPrice(),
                Integer.parseInt(ctx.getString(R.string.shoeFiveFemaleArtNumber)),
                smallCards.get(5).getPicResource(),
                shoeOne,
                3.8f,
                ctx.getString(R.string.shoeFiveFemaleDescriptionLong),
                ctx.getString(R.string.shoeFiveFemaleList),
                sizes
        ));
        shoeOne = new int[]{smallCards.get(6).getPicResource(), R.drawable.shoe_six_small_one, R.drawable.shoe_six_small_two, R.drawable.shoe_six_small_three};
        sizes = new double[]{36,37,38,39,40,41};
        fullCards.add(new ItemFullDescription(
                smallCards.get(6).getShoeName(),
                smallCards.get(6).getOldPrice(),
                smallCards.get(6).getNewPrice(),
                Integer.parseInt(ctx.getString(R.string.shoeSixFemaleArtNumber)),
                smallCards.get(6).getPicResource(),
                shoeOne,
                3.8f,
                ctx.getString(R.string.shoeSixFemaleDescriptionLong),
                ctx.getString(R.string.shoeSixFemaleList),
                sizes
        ));
        shoeOne = new int[]{smallCards.get(7).getPicResource(), R.drawable.shoe_seven_small_one, R.drawable.shoe_seven_small_two, R.drawable.shoe_seven_small_three};
        sizes = new double[]{36,37,37.5,38,38.5,39,40,40.5,41,42};
        fullCards.add(new ItemFullDescription(
                smallCards.get(7).getShoeName(),
                smallCards.get(7).getOldPrice(),
                smallCards.get(7).getNewPrice(),
                Integer.parseInt(ctx.getString(R.string.shoeSevenFemaleArtNumber)),
                smallCards.get(7).getPicResource(),
                shoeOne,
                4.3f,
                ctx.getString(R.string.shoeSevenFemaleDescriptionLong),
                ctx.getString(R.string.shoeSevenFemaleList),
                sizes
        ));
        shoeOne = new int[]{smallCards.get(8).getPicResource(), R.drawable.shoe_eight_small_one, R.drawable.shoe_eight_small_two, R.drawable.shoe_eight_small_three};
        sizes = new double[]{37,38,40};
        fullCards.add(new ItemFullDescription(
                smallCards.get(8).getShoeName(),
                smallCards.get(8).getOldPrice(),
                smallCards.get(8).getNewPrice(),
                Integer.parseInt(ctx.getString(R.string.shoeEightFemaleArtNumber)),
                smallCards.get(8).getPicResource(),
                shoeOne,
                4.3f,
                ctx.getString(R.string.shoeEightFemaleDescriptionLong),
                ctx.getString(R.string.shoeEightFemaleList),
                sizes
        ));
        shoeOne = new int[]{smallCards.get(9).getPicResource(), R.drawable.shoe_nine_small_one, R.drawable.shoe_nine_small_two, R.drawable.shoe_nine_small_three};
        sizes = new double[]{36,37,38,39,40,41,42};
        fullCards.add(new ItemFullDescription(
                smallCards.get(9).getShoeName(),
                smallCards.get(9).getOldPrice(),
                smallCards.get(9).getNewPrice(),
                Integer.parseInt(ctx.getString(R.string.shoeNineFemaleArtNumber)),
                smallCards.get(9).getPicResource(),
                shoeOne,
                5f,
                ctx.getString(R.string.shoeNineFemaleDescriptionLong),
                ctx.getString(R.string.shoeNineFemaleList),
                sizes
        ));
        return fullCards;
    }
}
