package com.example.testforeffectivemobile.presentation.screens.fragments.product

import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.testforeffectivemobile.R
import com.example.testforeffectivemobile.data.model.CapacityItem
import com.example.testforeffectivemobile.data.model.ColorItem
import com.example.testforeffectivemobile.data.model.ProductDetailData
import com.example.testforeffectivemobile.databinding.FragmentProductBinding
import com.example.testforeffectivemobile.presentation.screens.base.BaseFragment
import com.example.testforeffectivemobile.presentation.screens.fragments.product.adapter.*
import dagger.hilt.android.AndroidEntryPoint
import kotlin.math.abs

@AndroidEntryPoint
class ProductFragment : BaseFragment<ProductViewModel, FragmentProductBinding>(
    R.layout.fragment_product
) {
    override val viewModel: ProductViewModel by viewModels()
    override val binding by viewBinding(FragmentProductBinding::bind)

    private lateinit var productPreviewAdapter: ProductPreviewAdapter
    private lateinit var colorAdapter: ProductColorAdapter
    private lateinit var capacityAdapter: ProductCapacityAdapter

    override fun initialize() {
        super.initialize()


        binding.productToolbar.buttonBack.setOnClickListener {
            activity?.onBackPressed()
        }

        binding.productToolbar.toolbarAction.setOnClickListener {
            findNavController().navigate(R.id.action_productFragment_to_cartFragment)
        }

        binding.shopButton.setOnClickListener {
            binding.buttonViewColor.setCardBackgroundColor( requireContext().getColor(R.color.baseOrange))
            binding.buttonTextShop.setTextColor(requireContext().getColor(R.color.baseBlue))

            binding.buttonViewColorDetails.setCardBackgroundColor( requireContext().getColor(R.color.white))
            binding.buttonTextDetails.setTextColor(requireContext().getColor(R.color.textGray))

            binding.buttonViewColorFeatures.setCardBackgroundColor( requireContext().getColor(R.color.white))
            binding.buttonTextFeatures.setTextColor(requireContext().getColor(R.color.textGray))
        }

        binding.detailsButton.setOnClickListener {
            binding.buttonViewColor.setCardBackgroundColor( requireContext().getColor(R.color.white))
            binding.buttonTextShop.setTextColor(requireContext().getColor(R.color.textGray))

            binding.buttonViewColorDetails.setCardBackgroundColor( requireContext().getColor(R.color.baseOrange))
            binding.buttonTextDetails.setTextColor(requireContext().getColor(R.color.baseBlue))

            binding.buttonViewColorFeatures.setCardBackgroundColor( requireContext().getColor(R.color.white))
            binding.buttonTextFeatures.setTextColor(requireContext().getColor(R.color.textGray))
        }

        binding.featuresButton.setOnClickListener {
            binding.buttonViewColor.setCardBackgroundColor( requireContext().getColor(R.color.white))
            binding.buttonTextShop.setTextColor(requireContext().getColor(R.color.textGray))

            binding.buttonViewColorDetails.setCardBackgroundColor( requireContext().getColor(R.color.white))
            binding.buttonTextDetails.setTextColor(requireContext().getColor(R.color.textGray))

            binding.buttonViewColorFeatures.setCardBackgroundColor( requireContext().getColor(R.color.baseOrange))
            binding.buttonTextFeatures.setTextColor(requireContext().getColor(R.color.baseBlue))
        }


        binding.productToolbar.toolbarTitle.text = getString(R.string.product_detail)

        viewModel.signIn()
        initAdapters()
    }

    private fun initAdapters() {
        productPreviewAdapter = ProductPreviewAdapter()
        colorAdapter = ProductColorAdapter()
        capacityAdapter = ProductCapacityAdapter()
    }

    private fun initColor(list: List<ColorItem>) {
        colorAdapter.setData(list)
        colorAdapter.setListener(object : ProductColorVH.ProductColorListener{
            override fun onColorClick(color: String) {
                list.map { it.isActive = false }
                list.first { it.color == color }.isActive = true
                initColor(list)
            }

        })
        binding.colors.adapter = colorAdapter
    }

    private fun initCapacity(list: List<CapacityItem>) {
        capacityAdapter.setData(list)
        capacityAdapter.setListener(object: ProductCapacityVH.ProductCapacityListener{
            override fun onCapacityClick(capacity: String) {
                list.map{it.isActive = false}
                list.first { it.capacity == capacity }.isActive = true
                initCapacity(list)
            }

        })
        binding.capacities.adapter = capacityAdapter
    }

    private fun initCharacteristics(data: ProductDetailData) {
        binding.productDetailName.text = data.title
        binding.productProcessor.text = data.CPU
        binding.productCamera.text = data.camera
        binding.productSd.text = data.sd
        binding.productSsd.text = data.ssd

        binding.productPrice.text = String.format("$${data.price}.00")
        initColor(data.color)
        initCapacity(data.capacity)
    }

    private fun initProductPreview(items: List<String>) {
        productPreviewAdapter.setData(items)
        binding.productCarousel.adapter = productPreviewAdapter
        binding.productCarousel.clipToPadding = false
        binding.productCarousel.clipChildren = false
        binding.productCarousel.offscreenPageLimit = 3
        binding.productCarousel.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER

        var compositePageTransformer: CompositePageTransformer = CompositePageTransformer()
        compositePageTransformer.addTransformer(MarginPageTransformer(40))
        compositePageTransformer.addTransformer { page, position ->
            var r = 1 - abs(position)
            page.scaleY = 0.85f + r * 0.15f
        }

        binding.productCarousel.setPageTransformer(compositePageTransformer)
    }

    override fun setupSubscribers() {
        super.setupSubscribers()

        viewModel.productDetail.collectUIState(
            state = {
            },
            onError = {
                // Отобразить ошибку
                Toast.makeText(requireContext(), it, Toast.LENGTH_LONG).show()
            },
            onSuccess = {
                initProductPreview(it.images)
                var data = it
                data.color[0].isActive = true
                data.capacity[0].isActive = true
                initCharacteristics(data)
            }
        )
    }

}