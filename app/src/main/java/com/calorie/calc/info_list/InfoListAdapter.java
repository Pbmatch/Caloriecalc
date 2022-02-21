package com.calorie.calc.info_list;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.calorie.calc.edamam.holders.recipeholders.RecipeAndLinks;
import com.calorie.calc.info_list.holder.FallbackViewHolder;
import com.calorie.calc.info_list.holder.InfoItemHolder;
import com.calorie.calc.info_list.holder.RecipeHorizontalMiniItemHolder;
import com.calorie.calc.info_list.holder.RecipeItemHolder;
import com.calorie.calc.info_list.holder.RecipeLikedItemHolder;
import com.calorie.calc.utils.OnClickGesture;

import java.util.ArrayList;
import java.util.List;

public class InfoListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private static final String TAG = InfoListAdapter.class.getSimpleName();
    private static final boolean DEBUG = false;

    private static final int HEADER_TYPE = 0;
    private static final int FOOTER_TYPE = 1;

    private static final int RECIPE_HORIZONTAL_MINI_HOLDER_TYPE = 0x100;
    private static final int RECIPE_VERTICAL_BIG_HOLDER_TYPE = 0x101;
    private static final int RECIPE_VERTICAL_BIG_LIKED_HOLDER_TYPE = 0x102;


    private final InfoItemBuilder infoItemBuilder;
    private final ArrayList<RecipeAndLinks> infoItemList;

    private boolean useRecipeHorizontalItem =false;
    private boolean useRecipeLikedItem =false;
    private boolean useBigVariant=false;
    private boolean useMiniVariant = false;
    private boolean useGridVariant = false;
    private boolean showFooter = false;
    private View header = null;
    private View footer = null;

    public void setUseRecipeHorizontalItem(boolean useRecipeHorizontalItem) {
        this.useRecipeHorizontalItem = useRecipeHorizontalItem;
    }

    public void setUseBigVariant(boolean useBigVariant) {
        this.useBigVariant = useBigVariant;
    }

    public InfoListAdapter(final Context context) {

        infoItemBuilder = new InfoItemBuilder(context);
        infoItemList = new ArrayList<>();
    }

    public void setOnStreamSelectedListener(final OnClickGesture<RecipeAndLinks> listener) {
        infoItemBuilder.setOnRecipeClickListener(listener);
    }




    public void addInfoItemList(@Nullable final List<? extends RecipeAndLinks> data) {
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
    public void setInfoItemList(@Nullable final List<? extends RecipeAndLinks> data) {
        if (data == null) {
            return;
        }

        infoItemList.clear();
        infoItemList.addAll(data);
        notifyDataSetChanged();
    }

    public void deleteItemFromItemList(RecipeAndLinks item)
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
    public int findItemPosition(RecipeAndLinks item)
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

    public void modifyItemToItemList(RecipeAndLinks item,int position)
    {
        if(item!=null&&!infoItemList.isEmpty())
        {
            infoItemList.set(position,item);
            notifyItemChanged(position);



        }

    }
    public void addItemToItemList(RecipeAndLinks item,int position)
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

    public void setHeader(final View header) {
        final boolean changed = header != this.header;
        this.header = header;
        if (changed) {
            notifyDataSetChanged();
        }
    }

    public void setFooter(final View view) {
        this.footer = view;
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

    public ArrayList<RecipeAndLinks> getItemsList() {
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
        return count;
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

        return useRecipeHorizontalItem ? RECIPE_HORIZONTAL_MINI_HOLDER_TYPE: useRecipeLikedItem? RECIPE_VERTICAL_BIG_LIKED_HOLDER_TYPE
                :RECIPE_VERTICAL_BIG_HOLDER_TYPE;




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
                return new RecipeItemHolder(infoItemBuilder,parent);
            case RECIPE_HORIZONTAL_MINI_HOLDER_TYPE:
                return new RecipeHorizontalMiniItemHolder(infoItemBuilder,parent);
            case RECIPE_VERTICAL_BIG_LIKED_HOLDER_TYPE:
                return new RecipeLikedItemHolder(infoItemBuilder,parent);

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

            ((InfoItemHolder) holder).updateFromItem(infoItemList.get(position) );
        } else if (holder instanceof HFHolder && position == 0 && header != null) {
            ((HFHolder) holder).view = header;
        } else if (holder instanceof HFHolder && position == sizeConsideringHeaderOffset()
                && footer != null && showFooter) {
            ((HFHolder) holder).view = footer;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, final int position,
                                 @NonNull final List<Object> payloads) {
  /*      if (!payloads.isEmpty() && holder instanceof InfoItemHolder) {
            for (final Object payload : payloads) {
                if (payload instanceof StreamStateEntity) {
                    ((InfoItemHolder) holder).updateState(infoItemList
                            .get(header == null ? position : position - 1) );
                } else if (payload instanceof Boolean) {
                    ((InfoItemHolder) holder).updateState(infoItemList
                            .get(header == null ? position : position - 1) );
                }
            }
        } else {*/
            onBindViewHolder(holder, position);
       // }
    }

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