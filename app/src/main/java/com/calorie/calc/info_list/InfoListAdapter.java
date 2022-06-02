package com.calorie.calc.info_list;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.calorie.calc.data.BodySizeItem;
import com.calorie.calc.data.ExerciseItem;
import com.calorie.calc.data.MiniItem;
import com.calorie.calc.fragments.recipe.diet.DietMainPageType;
import com.calorie.calc.fragments.recipe.holders.recipeholders.Ingredient;
import com.calorie.calc.fragments.recipe.holders.recipeholders.Nutrient;
import com.calorie.calc.fragments.recipe.holders.recipeholders.RecipeAndLinksItem;
import com.calorie.calc.info_list.holder.BodySizeHolder;
import com.calorie.calc.info_list.holder.DietCheckboxHolder;
import com.calorie.calc.info_list.holder.DietHolder;
import com.calorie.calc.info_list.holder.EnergyHolder;
import com.calorie.calc.info_list.holder.ExerciseHolder;
import com.calorie.calc.info_list.holder.FallbackViewHolder;
import com.calorie.calc.info_list.holder.FragmentHolder;
import com.calorie.calc.info_list.holder.IngredientHolder;
import com.calorie.calc.info_list.holder.MiniItemHolder;
import com.calorie.calc.info_list.holder.NutrientMainHolder;
import com.calorie.calc.info_list.holder.NutrientScrollingHolder;
import com.calorie.calc.info_list.holder.ProductEditHolder;
import com.calorie.calc.info_list.holder.ProductHolder;
import com.calorie.calc.info_list.holder.RecipeHorizontalMiniItemHolder;
import com.calorie.calc.info_list.holder.RecipeLikedItemHolder;
import com.calorie.calc.info_list.holder.RecipeTrackerHolder;
import com.calorie.calc.utils.OnClickGesture;

import java.util.ArrayList;
import java.util.List;

public class InfoListAdapter <T> extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private static final String TAG = InfoListAdapter.class.getSimpleName();
    private static final boolean DEBUG = false;

    private static final int HEADER_TYPE = 0;
    private static final int FOOTER_TYPE = 1;

    private static final int RECIPE_HORIZONTAL_MINI_HOLDER_TYPE = 0x100;
    private static final int RECIPE_VERTICAL_BIG_HOLDER_TYPE = 0x101;
    private static final int RECIPE_VERTICAL_BIG_LIKED_HOLDER_TYPE = 0x102;
    private static final int DIET_HOLDER_TYPE = 0x103;
    private static final int ENERGY_HOLDER_TYPE = 0x104;
    private static final int INGREDIENT_HOLDER_TYPE = 0x105;
    private static final int NUTRIENT_SCROLL_HOLDER_TYPE = 0x106;
    private static final int DIET_CHECKBOX_HOLDER_TYPE = 0x107;
    private static final int PRODUCT_HOLDER_TYPE = 0x108;
    private static final int PRODUCT_EDIT_HOLDER_TYPE = 0x109;
    private static final int FRAGMENT_HOLDER_TYPE = 0x110;
    private static final int MINI_HOLDER_TYPE = 0x111;
    private static final int BODYSIZE_HOLDER_TYPE = 0x112;
    private static final int EXERCISE_HOLDER_TYPE = 0x113;
    private static final int RECIPE_TRACKER_HOLDER_TYPE = 0x114;
    private static final int NUTRIENT_MAIN_HOLDER_TYPE = 0x115;

    private boolean isNutrient=false;
    private boolean isNutrientMainType=true;

    private boolean isMiniItem=false;
    private boolean isProductFragment=false;
    private boolean isProductEditType=false;
    private final InfoItemBuilder infoItemBuilder;
    private final ArrayList<T> infoItemList;

    private boolean useRecipeHorizontalItem =false;
    private boolean useRecipeLikedItem =false;
    private boolean useBigVariant=false;
    private boolean useMiniVariant = false;
    private boolean useGridVariant = false;
    private boolean useTrackerVariant = false;
    private boolean showFooter = false;
    private View header = null;
    private View footer = null;

    public void setUseRecipeHorizontalItem(boolean useRecipeHorizontalItem) {
        this.useRecipeHorizontalItem = useRecipeHorizontalItem;
    }

    public void setUseTrackerVariant(boolean useTrackerVariant) {
        this.useTrackerVariant = useTrackerVariant;
    }

    public boolean isNutrientMainType() {
        return isNutrientMainType;
    }

    public void setNutrientMainType(boolean nutrientMainType) {
        isNutrientMainType = nutrientMainType;
    }

    public void setMiniItem(boolean miniItem) {
        isMiniItem = miniItem;
    }

    public boolean isNutrient() {
        return isNutrient;
    }

    public void setNutrient(boolean nutrient) {
        isNutrient = nutrient;
    }

    public void setUseBigVariant(boolean useBigVariant) {
        this.useBigVariant = useBigVariant;
    }

    public InfoListAdapter(final Context context) {

        infoItemBuilder = new InfoItemBuilder<T>(context);
        infoItemList = new ArrayList<>();
    }

    public void setOnItemSelectedListener(final OnClickGesture<T> listener) {
        infoItemBuilder.setOnRecipeClickListener(listener);
    }





    public void setHeader(final View header) {
        final boolean changed = header != this.header;
        this.header = header;
        if (changed) {
            notifyDataSetChanged();
        }
    }

    public void setFooter(final View footer) {
         final boolean changed = footer != this.footer;

        this.footer = footer;
      // if (changed) {
         //  notifyItemChanged(getItemCount());
          notifyDataSetChanged();
      //  }
       // this.footer = view;
    }

    public void showFooter(final boolean show) {

        if (show == showFooter) {
            return;
        }

        showFooter = show;
        if (show) {
            notifyItemInserted(sizeConsideringHeaderOffset());
        } else {
            notifyItemRemoved(sizeConsideringHeaderOffset());
        }
    }

    private int sizeConsideringHeaderOffset() {

        final int i = infoItemList.size() + (header != null ? 1 : 0);

        return i;
    }

    public ArrayList<T> getItemsList() {
        return infoItemList;
    }

    @Override
    public int getItemCount() {
        int count = infoItemList.size();
        if (header != null) {
            count++;
        }
        if (footer != null && showFooter) {
            count++;
        }

        if (DEBUG) {
            Log.d(TAG, "getItemCount() called with: "
                    + "count = " + count + ", infoItemList.size() = " + infoItemList.size() + ", "
                    + "header = " + header + ", footer = " + footer + ", "
                    + "showFooter = " + showFooter);
        }
        if(roll) return 1;
        return count;
    }
    boolean roll=false;

    public void setRoll(boolean roll) {
        this.roll = roll;
    }

    public boolean isRoll() {
        return roll;
    }

    @Override
    public int getItemViewType(int position) {
        if (DEBUG) {
            Log.d(TAG, "getItemViewType() called with: position = [" + position + "]");
        }

        if (header != null && position == 0) {
            return HEADER_TYPE;
        } else if (header != null) {
            position--;
        }
        if (footer != null && position == infoItemList.size() && showFooter) {
            return FOOTER_TYPE;
        }

        if(infoItemList.get(position) instanceof RecipeAndLinksItem){
        return useTrackerVariant? RECIPE_TRACKER_HOLDER_TYPE: useRecipeHorizontalItem ? RECIPE_HORIZONTAL_MINI_HOLDER_TYPE: useRecipeLikedItem? RECIPE_VERTICAL_BIG_LIKED_HOLDER_TYPE
                :RECIPE_VERTICAL_BIG_HOLDER_TYPE;}

        if(infoItemList.get(position) instanceof DietMainPageType)
        {
            return DIET_HOLDER_TYPE;

        }
        if(infoItemList.get(position) instanceof Nutrient )
        {
            return isNutrient?
                    isNutrientMainType?
                    NUTRIENT_MAIN_HOLDER_TYPE:NUTRIENT_SCROLL_HOLDER_TYPE:
                    ENERGY_HOLDER_TYPE;

        }
        if(infoItemList.get(position) instanceof Ingredient)
        {

           return isProductFragment ? PRODUCT_HOLDER_TYPE :isProductEditType ? PRODUCT_EDIT_HOLDER_TYPE: INGREDIENT_HOLDER_TYPE;

        }
        if(infoItemList.get(position) instanceof String)
        {
            return DIET_CHECKBOX_HOLDER_TYPE;

        }
        if(infoItemList.get(position) instanceof Fragment)
        {
            return FRAGMENT_HOLDER_TYPE;

        }
        if(infoItemList.get(position) instanceof MiniItem)
        {


          if(isMiniItem)return MINI_HOLDER_TYPE;

           if( infoItemList.get(position) instanceof ExerciseItem)
               return EXERCISE_HOLDER_TYPE;

            if( infoItemList.get(position) instanceof BodySizeItem)
                return BODYSIZE_HOLDER_TYPE;

        }




         return 55;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull final ViewGroup parent,
                                                      final int type) {
        if (DEBUG) {
            Log.d(TAG, "onCreateViewHolder() called with: "
                    + "parent = [" + parent + "], type = [" + type + "]");
        }
        switch (type) {
            case RECIPE_VERTICAL_BIG_HOLDER_TYPE:
                return new RecipeLikedItemHolder(infoItemBuilder,parent);
            case RECIPE_HORIZONTAL_MINI_HOLDER_TYPE:
                return new RecipeHorizontalMiniItemHolder(infoItemBuilder,parent);
            case RECIPE_VERTICAL_BIG_LIKED_HOLDER_TYPE:
                return new RecipeLikedItemHolder(infoItemBuilder,parent);
            case DIET_HOLDER_TYPE: return new DietHolder(infoItemBuilder,parent);
            case ENERGY_HOLDER_TYPE: return new EnergyHolder(infoItemBuilder,parent);
            case INGREDIENT_HOLDER_TYPE: return new IngredientHolder(infoItemBuilder,parent);
            case PRODUCT_EDIT_HOLDER_TYPE: return new ProductEditHolder(infoItemBuilder,parent);
            case PRODUCT_HOLDER_TYPE: return new ProductHolder(infoItemBuilder,parent);

            case NUTRIENT_SCROLL_HOLDER_TYPE: return new NutrientScrollingHolder(infoItemBuilder,parent);
            case NUTRIENT_MAIN_HOLDER_TYPE: return new NutrientMainHolder(infoItemBuilder,parent);
            case DIET_CHECKBOX_HOLDER_TYPE:return new DietCheckboxHolder(infoItemBuilder,parent);
            case FRAGMENT_HOLDER_TYPE:return new FragmentHolder(infoItemBuilder,parent);
            case MINI_HOLDER_TYPE:return new MiniItemHolder(infoItemBuilder,parent);
            case EXERCISE_HOLDER_TYPE:return new ExerciseHolder(infoItemBuilder,parent);
            case BODYSIZE_HOLDER_TYPE:return new BodySizeHolder(infoItemBuilder,parent);
            case RECIPE_TRACKER_HOLDER_TYPE:return new RecipeTrackerHolder(infoItemBuilder,parent);

            case HEADER_TYPE:
                return new HFHolder(header);
            case FOOTER_TYPE:
                return new HFHolder(footer);


            default:
                return new FallbackViewHolder(new View(parent.getContext()));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, int position) {
        if (DEBUG) {
            Log.d(TAG, "onBindViewHolder() called with: "
                    + "holder = [" + holder.getClass().getSimpleName() + "], "
                    + "position = [" + position + "]");
        }
        if (holder instanceof InfoItemHolder) {
            // If header isn't null, offset the items by -1
            if (header != null) {
                position--;
            }

            ((InfoItemHolder) holder).updateFromItem(infoItemList.get(position),position );
        } else if (holder instanceof HFHolder && position == 0 && header != null) {
            ((HFHolder) holder).view = header;
        } else if (holder instanceof HFHolder && position == sizeConsideringHeaderOffset()
                && footer != null && showFooter) {
            ((HFHolder) holder).view = footer;
        }
    }
    public boolean isProductFragment() {
        return isProductFragment;
    }

    public void setProductFragment(boolean productFragment) {
        isProductFragment = productFragment;
    }
    public void addInfoItemList(@Nullable final List<? extends T> data) {
        if (data == null) {
            return;
        }
        final int offsetStart = sizeConsideringHeaderOffset();
        infoItemList.addAll(data);
        notifyItemRangeInserted(offsetStart, data.size());
        if (footer != null && showFooter) {
            final int footerNow = sizeConsideringHeaderOffset();
            notifyItemMoved(offsetStart, footerNow);
        }
    }
    public void setInfoItemList(@Nullable final List<? extends T> data) {
        if (data == null) {
            return;
        }

        infoItemList.clear();
        infoItemList.addAll(data);
        notifyDataSetChanged();
    }

    public boolean isProductEditType() {
        return isProductEditType;
    }

    public void setProductEditType(boolean productEditType) {
        isProductEditType = productEditType;
    }

    public void deleteItemFromItemList(T item)
    {
        if(item!=null &&!infoItemList.isEmpty())
        {

            if(infoItemList.contains(item))
            {
                int index= infoItemList.indexOf(item);
                index = index+(header != null ? 1 : 0);
                infoItemList.remove(item);
                notifyItemRemoved(index);


            }
        }

    }
    public int findItemPosition(T item)
    {
        if(item!=null &&!infoItemList.isEmpty())
        {
            if(infoItemList.contains(item)) {
                int index = infoItemList.indexOf(item);
                return  index + (header != null ? 1 : 0);
            }

        }

        return -1;
    }

    public void modifyItemToItemList(T item,int position)
    {
        if(item!=null&&!infoItemList.isEmpty())
        {
            infoItemList.set(position,item);
            notifyItemChanged(position);



        }

    }
    public void addItemToItemList(T item,int position)
    {
        if(item!=null )
        {
            infoItemList.add(position,item);
            int index = infoItemList.indexOf(item);
            index=  index + (header != null ? 1 : 0);
            notifyItemInserted(index);


        }

    }
    public void clearStreamItemList() {
        if (infoItemList.isEmpty()) {
            return;
        }
        infoItemList.clear();
        notifyDataSetChanged();
    }

/*    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, final int position,
                                 @NonNull final List<Object> payloads) {
  *//*      if (!payloads.isEmpty() && holder instanceof InfoItemHolder) {
            for (final Object payload : payloads) {
                if (payload instanceof StreamStateEntity) {
                    ((InfoItemHolder) holder).updateState(infoItemList
                            .get(header == null ? position : position - 1) );
                } else if (payload instanceof Boolean) {
                    ((InfoItemHolder) holder).updateState(infoItemList
                            .get(header == null ? position : position - 1) );
                }
            }
        } else {*//*
        //    onBindViewHolder(holder, position);
       // }
    }*/

    public GridLayoutManager.SpanSizeLookup getSpanSizeLookup(final int spanCount) {
        return new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(final int position) {
                final int type = getItemViewType(position);
                return type == HEADER_TYPE || type == FOOTER_TYPE ? spanCount : 1;
            }
        };
    }

    public static class HFHolder extends RecyclerView.ViewHolder {
        public View view;

        HFHolder(final View v) {
            super(v);
            view = v;
        }
    }
}