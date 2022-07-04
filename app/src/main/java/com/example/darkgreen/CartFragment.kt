package com.example.darkgreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.darkgreen.adapter.ProductAdapter
import com.example.darkgreen.model.Product
import com.example.darkgreen.model.ProductCategory

class CartFragment : Fragment(){

    lateinit var recyclerCart: RecyclerView
    lateinit var  arrayCart: List<Product>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (arguments!=null){
            arrayCart = (arguments?.getSerializable("CATEGORY") as ProductCategory).products

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_product, container,false)

        recyclerCart = view.findViewById(R.id.rv_cart)

        val adapterProduct = ProductAdapter(emptyList(), requireContext())

        recyclerCart.adapter = adapterProduct
        recyclerCart.layoutManager = LinearLayoutManager(requireContext(),RecyclerView.VERTICAL,false)

        return view

    }

}