package com.mishelk.mvvm_project.ui.quotes

import androidx.lifecycle.ViewModel
import com.mishelk.mvvm_project.data.Quote
import com.mishelk.mvvm_project.data.QuoteRepository

class QuotesViewModel(private val quoteRepository: QuoteRepository)
    : ViewModel() {

    fun getQuotes() = quoteRepository.getQuotes()

    fun addQuote(quote: Quote) = quoteRepository.addQuote(quote)
}