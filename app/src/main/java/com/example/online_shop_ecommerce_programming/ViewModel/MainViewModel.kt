package com.example.online_shop_ecommerce_programming.ViewModel

import android.util.Log
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
    private val TAG = "MainViewModel"

    private val _category = MutableLiveData<MutableList<CategoryModel>>()
    private val _banner = MutableLiveData<List<SliderModel>>()
    private val _recommended = MutableLiveData<MutableList<ItemsModel>>()

    val banners: LiveData<List<SliderModel>> = _banner
    val categories: LiveData<MutableList<CategoryModel>> = _category
    val recommended: LiveData<MutableList<ItemsModel>> = _recommended

    fun loadFiltered(id: String) {
        viewModelScope.launch {
            try {
                Log.d(TAG, "Loading filtered items for category: $id")
                val results = supabase.from("items").select {
                    filter {
                        eq("category_id", id)
                    }
                }.decodeList<ItemsModel>()
                Log.d(TAG, "Loaded ${results.size} filtered items")
                _recommended.postValue(results.toMutableList())
            } catch (e: Exception) {
                Log.e(TAG, "Error loading filtered items", e)
            }
        }
    }

    fun loadRecommended() {
        viewModelScope.launch {
            try {
                Log.d(TAG, "Loading recommended items")
                val results = supabase.from("items").select {
                    filter {
                        eq("show_recommended", true)
                    }
                }.decodeList<ItemsModel>()
                Log.d(TAG, "Loaded ${results.size} recommended items")
                _recommended.postValue(results.toMutableList())
            } catch (e: Exception) {
                Log.e(TAG, "Error loading recommended items", e)
            }
        }
    }

    fun loadBanners() {
        viewModelScope.launch {
            try {
                Log.d(TAG, "Loading banners")
                val results = supabase.from("banners").select().decodeList<SliderModel>()
                Log.d(TAG, "Loaded ${results.size} banners")
                _banner.postValue(results)
            } catch (e: Exception) {
                Log.e(TAG, "Error loading banners", e)
            }
        }
    }

    fun loadCategory() {
        viewModelScope.launch {
            try {
                Log.d(TAG, "Loading categories")
                val results = supabase.from("categories").select().decodeList<CategoryModel>()
                Log.d(TAG, "Loaded ${results.size} categories")
                _category.postValue(results.toMutableList())
            } catch (e: Exception) {
                Log.e(TAG, "Error loading categories", e)
            }
        }
    }
}
