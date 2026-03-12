package com.example.online_shop_ecommerce_programming.Network

import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.storage.Storage

object SupabaseClientProvider {
    val client: SupabaseClient = createSupabaseClient(
        supabaseUrl = "https://sqcdqdqgfonjzqnpwfrw.supabase.co",
        supabaseKey = "sb_publishable_WVEMJ2bQgKwXAtVVuVFmeA_EOBCXUK_"
    ) {
        install(Postgrest)
        install(Storage)
    }
}
