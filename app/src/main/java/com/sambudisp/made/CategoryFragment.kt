package com.sambudisp.made


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_category.*


class CategoryFragment : Fragment() {

    companion object {
        val EXTRA_NAME = "extra_name"
        val EXTRA_STOCK = "extra_stock"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_category_lifestyle.setOnClickListener { view ->
            /*val mBundle = Bundle()
            mBundle.putString(EXTRA_NAME, "Lifestyle")
            mBundle.putLong(EXTRA_STOCK, 7)*/
            val toDetailCategoryFragment = CategoryFragmentDirections.actionCategoryFragmentToDetailCategoryFragment()
            toDetailCategoryFragment.name = "Namanya"
            toDetailCategoryFragment.stock = 8
            //view.findNavController().navigate(R.id.action_categoryFragment_to_detailCategoryFragment, mBundle)
            view.findNavController().navigate(toDetailCategoryFragment)
        }
    }


}
