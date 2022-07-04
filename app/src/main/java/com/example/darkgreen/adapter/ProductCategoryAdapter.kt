package com.example.darkgreen.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.darkgreen.ProductCategoryFragment
import com.example.darkgreen.R
import com.example.darkgreen.model.ProductCategory
import java.util.*

class ProductCategoryAdapter(val list: List<ProductCategory>, val context: Context) : RecyclerView.Adapter<ProductCategoryAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_product_category, parent, false)
// guarda o icon e o title e retorna
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val category: ProductCategory = list [position]
        //jogando os dados da categoria dentro do viewholder
        holder.title.text = category.title
        holder.cardView.setOnClickListener{
            (context as ProductCategoryFragment.Callback).itemSelected(category)
        }
    }

    override fun getItemCount(): Int = list.size

    class ViewHolder(var itemView: View) :RecyclerView.ViewHolder(itemView){
        val icon: ImageView = itemView.findViewById(R.id.iv_category_icon)
        val title: TextView = itemView.findViewById(R.id.tv_category_title)
        val cardView: CardView = itemView.findViewById(R.id.cv_product_category)
    }
}