package com.mishelk.mvvm_project.utilities

import com.mishelk.mvvm_project.data.FakeDatabase
import com.mishelk.mvvm_project.data.QuoteRepository
import com.mishelk.mvvm_project.ui.quotes.QuotesViewModelFactory

object InjectorUtils {

    fun provideQuotesViewModelFactory(): QuotesViewModelFactory {
        val quoteRepository = QuoteRepository.getInstance(FakeDatabase.getInstance().quoteDao)
        return QuotesViewModelFactory(quoteRepository)
    }
}