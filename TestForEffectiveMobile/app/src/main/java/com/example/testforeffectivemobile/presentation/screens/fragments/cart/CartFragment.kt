package com.example.testforeffectivemobile.presentation.screens.fragments.cart

import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Toast
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.testforeffectivemobile.R
import com.example.testforeffectivemobile.core.setImage
import com.example.testforeffectivemobile.data.model.Basket
import com.example.testforeffectivemobile.data.model.CartData
import com.example.testforeffectivemobile.databinding.FragmentCartBinding
import com.example.testforeffectivemobile.presentation.screens.base.BaseFragment
import com.example.testforeffectivemobile.presentation.screens.fragments.cart.adapter.CartProductAdapter
import com.example.testforeffectivemobile.presentation.screens.fragments.cart.view_holder.ProductCartVH
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CartFragment : BaseFragment<CartViewModel, FragmentCartBinding>(
    R.layout.fragment_cart
) {

    override val viewModel: CartViewModel by viewModels()
    override val binding by viewBinding(FragmentCartBinding::bind)

    private lateinit var productAdapter : CartProductAdapter

    override fun initialize() {
        super.initialize()

        initAdapter()

        viewModel.getCartData()

        binding.cartToolbar.toolbarTitle.visibility = GONE
        binding.cartToolbar.actionText.apply {
            visibility = VISIBLE
            text = getString(R.string.add_address)
        }
        binding.cartToolbar.actionImage.setImageDrawable(requireContext().getDrawable(R.drawable.ic_locate))

        binding.cartToolbar.buttonBack.setOnClickListener {
            activity?.onBackPressed()
        }
    }

    private fun initAdapter(){
        productAdapter = CartProductAdapter()
    }

    private fun initCartInfo(data: CartData){
        binding.total.text = String.format("$${data.total} us")
        binding.delivery.text = data.delivery
    }

    private fun initProducts(list: List<Basket>){
        productAdapter.setData(list)
        productAdapter.setListener(object : ProductCartVH.ProductCartListener{
            override fun plus(id: Int) {
                list.first { it.id == id }.count++
                initProducts(list)
            }

            override fun minus(id: Int) {
                list.first { it.id == id }.count--
                initProducts(list)
            }

        })
        binding.products.adapter = productAdapter
    }

    override fun setupSubscribers() {
        super.setupSubscribers()

        viewModel.cartData.collectUIState(
            onError = {
                // Отобразить ошибку
                Toast.makeText(requireContext(), it, Toast.LENGTH_LONG).show()
            },
            onSuccess = {
                initProducts(it.basket)
                initCartInfo(it)
            }
        )

    }

}