package com.example.testforeffectivemobile.presentation.screens.fragments.explorer


import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.core.view.MenuProvider
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.testforeffectivemobile.R
import com.example.testforeffectivemobile.data.model.BestSeller
import com.example.testforeffectivemobile.data.model.Category
import com.example.testforeffectivemobile.data.model.HomeStore
import com.example.testforeffectivemobile.databinding.FragmentExplorerBinding
import com.example.testforeffectivemobile.presentation.dialogs.filter.FilterDialog
import com.example.testforeffectivemobile.presentation.screens.base.BaseFragment
import com.example.testforeffectivemobile.presentation.screens.fragments.explorer.adapter.BestSellerAdapter
import com.example.testforeffectivemobile.presentation.screens.fragments.explorer.adapter.CategoryAdapter
import com.example.testforeffectivemobile.presentation.screens.fragments.explorer.adapter.HotSalesAdapter
import com.example.testforeffectivemobile.presentation.screens.fragments.explorer.view_holder.BestSellerVH
import com.example.testforeffectivemobile.presentation.screens.fragments.explorer.view_holder.CategoryVH
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ExplorerFragment : BaseFragment<ExplorerViewModel, FragmentExplorerBinding>(
    R.layout.fragment_explorer
) {

    override val viewModel: ExplorerViewModel by viewModels()
    override val binding by viewBinding(FragmentExplorerBinding::bind)


    private lateinit var categoryAdapter: CategoryAdapter
    private lateinit var hotSalesAdapter: HotSalesAdapter
    private lateinit var bestSellerAdapter: BestSellerAdapter

    override fun initialize() {
        super.initialize()

        initAdapters()

        binding.toolbarView.toolbar.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.menu_explorer, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {

                var bs = FilterDialog()
                bs.show(parentFragmentManager, FilterDialog.TAG)

                return true
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }


    private fun initAdapters() {
        categoryAdapter = CategoryAdapter()
        hotSalesAdapter = HotSalesAdapter()
        bestSellerAdapter = BestSellerAdapter()
    }

    private fun initCategories(list: List<Category>) {
        binding.categories.adapter = categoryAdapter
        categoryAdapter.setData(list)
        categoryAdapter.setListener(object : CategoryVH.CategoryListener {
            override fun click(id: Int) {
                list.map { it.active = false }
                list.first { it.id == id }.active = true
                initCategories(list)
            }

        })
    }

    private fun initHotSales(homeStore: List<HomeStore>) {
        binding.hotSales.adapter = hotSalesAdapter
        hotSalesAdapter.setData(homeStore)
    }

    private fun initBestSeller(bestSeller: List<BestSeller>) {
        binding.bestSellerRv.adapter = bestSellerAdapter
        binding.bestSellerRv.layoutManager = GridLayoutManager(context, 2)
        bestSellerAdapter.setData(bestSeller)
        bestSellerAdapter.setListener(object : BestSellerVH.BestSellerListener {
            override fun onClick(id: Int) {
                binding.root.findNavController()
                    .navigate(R.id.action_explorerFragment_to_productFragment)
            }

            override fun onFavoriteClick(id: Int) {
                bestSeller.first { it.id == id }.apply {
                    this.isFavorites = !this.isFavorites
                }
                initBestSeller(bestSeller)
            }

        })
    }

    override fun setupListeners() {
        viewModel.signIn()
    }

    override fun setupSubscribers() {
        viewModel.homeData.collectUIState(
            state = {},
            onError = {
                // Отобразить ошибку
                Toast.makeText(requireContext(), it, Toast.LENGTH_LONG).show()
            },
            onSuccess = {
                initBestSeller(it.bestSeller ?: listOf())
                initHotSales(it.homeStore ?: listOf())
            }
        )

        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.categories.collect {
                initCategories(it)
            }
        }
    }

}