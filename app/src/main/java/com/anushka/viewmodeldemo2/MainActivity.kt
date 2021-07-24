package com.anushka.viewmodeldemo2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.anushka.viewmodeldemo2.databinding.ActivityMainBinding

/**
 * 안드로이드 DataBinding을 사용하여 양방향 통신 예제입니다.
 */
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel
    private lateinit var viewModelFactory: MainActivityViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main) //dataBinding 객체 생성
        viewModelFactory = MainActivityViewModelFactory(125) // viewModel의 생성자를 위한 factory생성
        viewModel = ViewModelProvider(this,viewModelFactory).get(MainActivityViewModel::class.java) //viewModel 생성
        binding.myViewModel = viewModel // layout에서 data를 받기위하여 viewModel을 넣어줍니다.
        binding.lifecycleOwner = this //lifecycleOwner은 안드로이드 생명주기의 소유주를 지정해주는 것으로서 LiveData를 위한 생명주기 소유주를 넣어줍니다.

    }
}
