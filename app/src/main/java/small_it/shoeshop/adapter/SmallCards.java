package small_it.shoeshop.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Locale;

import small_it.shoeshop.R;
import small_it.shoeshop.lists.ItemSmallDescription;

/**
 * Class to setup the Recycler List View
 */
public class SmallCards extends RecyclerView.Adapter<SmallCards.ViewHolder>{

    private List<ItemSmallDescription> smallItems;
    private LayoutInflater inflater;
    private ClickListener click;
    private View view;

    public SmallCards(Context context, List<ItemSmallDescription> smallItems) {
        inflater = LayoutInflater.from(context);
        this.smallItems = smallItems;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = inflater.inflate(R.layout.card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ItemSmallDescription current = smallItems.get(position);
        holder.txtOld.setText(DecimalFormat.getCurrencyInstance(Locale.GERMANY).format(current.getOldPrice()));
        holder.txtNew.setText(DecimalFormat.getCurrencyInstance(Locale.GERMANY).format(current.getNewPrice()));
        holder.txtHead.setText(current.getShoeName());

        holder.imageSmall.setImageResource(current.getPicResource());
    }

    /**
     * Class to setup the Views within the Recycler View
     */
    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView txtOld, txtNew, txtHead;
        ImageView imageSmall;

        /**
         * Constructor of the internal Class
         * @param itemView .
         */
        ViewHolder(View itemView) {
            super(itemView);
            // Setup the Views
            txtHead = (TextView) itemView.findViewById(R.id.txtHeadline);
            txtNew = (TextView) itemView.findViewById(R.id.txtNewPrice);
            txtOld = (TextView) itemView.findViewById(R.id.txtOldPrice);
            imageSmall = (ImageView) itemView.findViewById(R.id.idSmallImage);

            // Change the Views input
            //txtNew.setTextColor(ContextCompat.getColor( R.color.colorAccent));
            txtOld.setPaintFlags(txtOld.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

            // Make the image Clickable
            imageSmall.setOnClickListener(this);

        }

        /**
         * Method to handle the click on an item of the Recycler View
         * @param view View of the clicked item
         */
        @Override
        public void onClick(View view) {
            click.itemClicked(view, getAdapterPosition());
        }
    }

    /**
     * Interface of the Click Listener
     */
    public interface ClickListener{
        void itemClicked (View view, int position);
    }


    /*
     * Getter and Setter Methods
     */
    public void setClickListener(ClickListener click){
        this.click = click;
    }

    @Override
    public int getItemCount() {
        return smallItems.size();
    }
}
