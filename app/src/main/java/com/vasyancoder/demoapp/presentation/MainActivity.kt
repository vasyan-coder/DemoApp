package com.vasyancoder.demoapp.presentation

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.vasyancoder.demoapp.databinding.ActivityMainBinding
import com.vasyancoder.demoapp.presentation.state_holder.ErrorUiUiState
import com.vasyancoder.demoapp.presentation.state_holder.LoadingUiUiState
import com.vasyancoder.demoapp.presentation.state_holder.ResultSuccessUiUiState
import com.vasyancoder.demoapp.presentation.state_holder.adapter.GIfListAdapter
import com.vasyancoder.demoapp.presentation.state_holder.viewmodel.MainViewModel
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {


    private val viewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.getGifList()

//        viewModel.mainStateLd.observe(this) {
//            binding.progressBar.visibility = View.GONE
//            when (val state = viewModel.mainStateLd.value) {
//                is Loading -> {
//                    binding.progressBar.visibility = View.VISIBLE
//                }
//
//                is ResultSuccess -> {
//                    binding.gifList.adapter = GIfListAdapter(state.gifList)
//                }
//
//                is ErrorLoading -> {
//                    Log.d("myLogs", state.message)
//                }
//
//                else -> {}
//            }
//        }

        binding.buttonRefresh.setOnClickListener {
            viewModel.getGifList()
        }

        val adapter = GIfListAdapter()
        binding.gifList.adapter = adapter

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.mainState.collect {
                    binding.progressBar.visibility = View.GONE
                    binding.textViewError.visibility = View.GONE
                    binding.buttonRefresh.visibility = View.GONE
                    when (it) {
                        is LoadingUiUiState -> {
                            binding.progressBar.visibility = View.VISIBLE
                        }

                        is ResultSuccessUiUiState -> {
                            adapter.submitList(it.gifList)
                        }

                        is ErrorUiUiState -> {
                            binding.textViewError.text = it.message
                            binding.textViewError.visibility = View.VISIBLE
                            binding.buttonRefresh.visibility = View.VISIBLE
                        }
                    }
                }
            }
        }
    }
}