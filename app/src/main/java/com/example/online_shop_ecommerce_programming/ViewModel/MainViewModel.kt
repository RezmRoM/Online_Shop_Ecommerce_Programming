package com.example.online_shop_ecommerce_programming.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.online_shop_ecommerce_programming.Model.CategoryModel
import com.example.online_shop_ecommerce_programming.Model.ItemsModel
import com.example.online_shop_ecommerce_programming.Model.SliderModel
import com.example.online_shop_ecommerce_programming.Network.SupabaseClientProvider
import io.github.jan.supabase.postgrest.from
import kotlinx.coroutines.launch

class MainViewModel() : ViewModel() {

    private val supabase = SupabaseClientProvider.client

    private val _category = MutableLiveData<MutableList<CategoryModel>>()
    private val _banner = MutableLiveData<List<SliderModel>>()
    private val _recommended = MutableLiveData<MutableList<ItemsModel>>()

    val banners: LiveData<List<SliderModel>> = _banner
    val categories: LiveData<MutableList<CategoryModel>> = _category
    val recommended: LiveData<MutableList<ItemsModel>> = _recommended

    fun loadFiltered(id: String) {
        viewModelScope.launch {
            try {
                val results = supabase.from("items").select {
                    filter {
                        eq("category_id", id)
                    }
                }.decodeList<ItemsModel>()
                _recommended.postValue(results.toMutableList())
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun loadRecommended() {
        viewModelScope.launch {
            try {
                val results = supabase.from("items").select {
                    filter {
                        eq("show_recommended", true)
                    }
                }.decodeList<ItemsModel>()
                _recommended.postValue(results.toMutableList())
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun loadBanners() {
        viewModelScope.launch {
            try {
                val results = supabase.from("banners").select().decodeList<SliderModel>()
                _banner.postValue(results)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun loadCategory() {
        viewModelScope.launch {
            try {
                val results = supabase.from("categories").select().decodeList<CategoryModel>()
                _category.postValue(results.toMutableList())
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
