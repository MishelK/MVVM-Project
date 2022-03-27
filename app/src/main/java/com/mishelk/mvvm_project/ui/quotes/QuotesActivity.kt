package com.mishelk.mvvm_project.ui.quotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.mishelk.mvvm_project.R
import com.mishelk.mvvm_project.data.Quote
import com.mishelk.mvvm_project.utilities.InjectorUtils
import kotlinx.android.synthetic.main.activity_quotes.*
import java.lang.StringBuilder

class QuotesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quotes)
        initializeUi()
    }

    private fun initializeUi() {
        val quotesViewModelFactory = InjectorUtils.provideQuotesViewModelFactory()
        val quotesViewModel = ViewModelProvider(this, quotesViewModelFactory).get(QuotesViewModel::class.java)
        
        quotesViewModel.getQuotes().observe(this, Observer { quotes ->
            val stringBuilder = StringBuilder()
            quotes.forEach { quote ->
                stringBuilder.append("$quote\n\n")
            }
            textView_quotes.text = stringBuilder.toString()
        })

        button_add_quote.setOnClickListener {
            val quote = Quote(editText_quote.text.toString(), editText_author.text.toString())
            quotesViewModel.addQuote(quote)
            editText_quote.setText("")
            editText_author.setText("")
        }
    }
}